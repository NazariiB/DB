package com.example.demo.dao.impl;

import com.example.demo.dao.SoldProductDao;
import com.example.demo.domain.SoldProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SoldProductsDaoImpl implements SoldProductDao {
    String FIND_ALL = "SELECT * from sold_products";
    String FIND_BY_ID = "select * from sold_products where id=?";
    String UPDATE = "update sold_products set vendingMachine_id=?, product_id=?, quantity=?, time_of_purchase=? where id=?";
    String CREATE = "insert into sold_products (id, vendingMachine_id, product_id, quantity, time_of_purchase) values " +
            "(default, ?, ?, ?, ?)";
    String DELETE = "delete from sold_products where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SoldProducts> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(SoldProducts.class));
    }

    @Override
    public Optional<SoldProducts> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(SoldProducts.class), integer));
    }

    @Override
    public int create(SoldProducts l) {
        return jdbcTemplate.update(CREATE, l.getVendingMachine_id(), l.getProduct_id(), l.getQuantity(), l.getTime_of_purchase());
    }

    @Override
    public int update(Integer integer, SoldProducts l) {
        return jdbcTemplate.update(UPDATE, l.getVendingMachine_id(), l.getProduct_id(), l.getQuantity(), l.getTime_of_purchase(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
