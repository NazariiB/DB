package com.example.demo.dao.impl;

import com.example.demo.dao.WorkerDao;
import com.example.demo.domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class WorkerImpl implements WorkerDao {

    private static final String FIND_ALL = "select * from worker";
    private static final String CREATE = "insert into worker (idworkers, name, surname, phone_number, team_id, position, sallery) " +
            " values(default, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "update worker set name=?, surname=?, phone_number=?, team_id=?, position=?, sallery=?  where idworkers=?";
    private static final String FIND_BY_ID = "select * from worker where idworkers=?";
    private static  final String DELETE = "delete from worker where idworkers=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Worker> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Worker.class));
    }

    @Override
    public Optional<Worker> findById(Integer id) {
        Optional<Worker> worker;
        try {
            worker = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,  BeanPropertyRowMapper.newInstance(Worker.class), id));
        } catch (DataAccessException e) {
            worker = Optional.empty();
        }
        return worker;
    }

    @Override
    public int create(Worker wor) {
        return jdbcTemplate.update(CREATE, wor.getName(), wor.getSurname(), wor.getPhone_number(), wor.getTeam_id(), wor.getPosition(), wor.getSallery());
    }

    @Override
    public int update(Integer id, Worker wor) {
        return jdbcTemplate.update(UPDATE, wor.getName(), wor.getSurname(), wor.getPhone_number(), wor.getTeam_id(), wor.getPosition(), wor.getSallery(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
