package com.example.demo.dao.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ProductImpl implements ProductDao {
    private final String FIND_ALL = "select * from product";
    private final String CREATE = "insert into product (id, name, price, mass, companie_name) values (default, ?, ?, ?, ?)";
    private final String UPDATE = "update product set name=?, price=?, mass=?, companie_name=? where id=?";
    private final String FIND_BY_ID = "select * from product where id=?";
    private final String DELETE = "delete from product where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Product.class), id));
    }

    @Override
    public int create(Product pro) {
        return jdbcTemplate.update(CREATE, pro.getName(), pro.getPrice(), pro.getMass(), pro.getCompanieName());
    }

    @Override
    public int update(Integer id, Product pro) {
        return jdbcTemplate.update(UPDATE, pro.getName(), pro.getPrice(), pro.getMass(), pro.getCompanieName(), pro.getId());
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
