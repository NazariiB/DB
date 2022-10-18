package com.example.demo.dao.impl;

import com.example.demo.dao.ReloadedSnacksDao;
import com.example.demo.domain.ReloadedSnackMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ReloadingSnacksMachineDaoImpl implements ReloadedSnacksDao {
    String FIND_ALL = "SELECT * from reloading_snacks_machine";
    String FIND_BY_ID = "select * from reloading_snacks_machine where id=?";
    String UPDATE = "update reloading_snacks_machine set time_reloading=?, vendingMachine_id=?, team_id=? where id=?";
    String CREATE = "insert into reloading_snacks_machine (id, time_reloading, vendingMachine_id, team_id) values " +
            "(default, ?, ?, ?)";
    String DELETE = "delete from reloading_snacks_machine where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ReloadedSnackMachine> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ReloadedSnackMachine.class));
    }

    @Override
    public Optional<ReloadedSnackMachine> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(ReloadedSnackMachine.class), integer));
    }

    @Override
    public int create(ReloadedSnackMachine l) {
        return jdbcTemplate.update(CREATE, l.getTimeReloading(), l.getVendingMachine(), l.getTeamId());
    }

    @Override
    public int update(Integer integer, ReloadedSnackMachine l) {
        return jdbcTemplate.update(UPDATE, l.getTimeReloading(), l.getVendingMachine(), l.getTeamId(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
