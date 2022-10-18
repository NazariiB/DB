package com.example.demo.dao.impl;

import com.example.demo.dao.ContentOfTheMachineDao;
import com.example.demo.domain.ContentOfMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ContentOftheMachineDaoImpl implements ContentOfTheMachineDao {
    String FIND_ALL = "SELECT * from content_of_the_machine";
    String FIND_BY_ID = "select * from content_of_the_machine where id=?";
    String UPDATE = "update content_of_the_machine set vendingMachine_id=?, product_id=?, quantity=? where id=?";
    String CREATE = "insert into content_of_the_machine(id, vendingMachine_id, product_id, quantity) values " +
            "(default, ?, ?, ?)";
    String DELETE = "delete from content_of_the_machine where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ContentOfMachine> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ContentOfMachine.class));
    }

    @Override
    public Optional<ContentOfMachine> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(ContentOfMachine.class), integer));
    }

    @Override
    public int create(ContentOfMachine l) {
        return jdbcTemplate.update(CREATE, l.getVendingMachine_id(), l.getProductId(), l.getQuantity());
    }

    @Override
    public int update(Integer integer, ContentOfMachine l) {
        return jdbcTemplate.update(UPDATE, l.getVendingMachine_id(), l.getProductId(), l.getQuantity(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
