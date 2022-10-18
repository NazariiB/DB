package com.example.demo.dao.impl;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TeamDaoImpl implements TeamDao {
    private final String FIND_ALL = "select * from team";
    private final String FIND_BY_ID = "select * from team where id=?";
    private final String UPDATE = "update team set name=? where id=?";
    private final String CREATE = "insert into team(id, name) values(default, ?)";
    private final String DELETE = "delete from team where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Team> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Team.class));
    }

    @Override
    public Optional<Team> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Team.class),   id));
    }

    @Override
    public int create(Team team) {
        return jdbcTemplate.update(CREATE, team.getName());
    }

    @Override
    public int update(Integer id, Team team) {
        return jdbcTemplate.update(UPDATE, team.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}

