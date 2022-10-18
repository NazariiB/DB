package com.example.demo.dao.impl;

import com.example.demo.dao.MoneyDao;
import com.example.demo.domain.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MoneyDaoImpl implements MoneyDao {
    String FIND_ALL = "select * from money";
    String FIND_BY_ID = "select * from money where id=?";
    String CREATE = "insert into money(id, date, amount_to_earn, amount_to_put, vendingMachine_id, team_id) values "
            + "(default, ?, ?, ?, ?, ?)";
    String UPDATE = "update money set date=?, amount_to_earn=?, amount_to_put=?, vendingMachine_id=?, team_id=? where id=?";
    String DELETE = "delete from money where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Money> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Money.class));
    }

    @Override
    public Optional<Money> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Money.class), integer));
    }

    @Override
    public int create(Money m) {
        return jdbcTemplate.update(CREATE, m.getDate(), m.getAmountToEarn(), m.getAmountToPut(), m.getVendingMachineId(), m.getTeamId());
    }

    @Override
    public int update(Integer integer, Money m) {
        return jdbcTemplate.update(UPDATE, m.getDate(), m.getAmountToEarn(), m.getAmountToPut(), m.getVendingMachineId(), m.getTeamId(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
