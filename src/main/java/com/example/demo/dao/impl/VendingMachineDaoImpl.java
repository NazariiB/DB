package com.example.demo.dao.impl;

import com.example.demo.dao.VendingMachineDao;
import com.example.demo.domain.VendingMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class VendingMachineDaoImpl implements VendingMachineDao {
    private final String FIND_ALL = "select * from vending_machine";
    private final String FIND_BY_ID = "select * from vending_machine where id=?";
    private final String CREATE = "insert into vending_machine(id, vending_machine_model, max_amount_of_snacks, gps_cordinates, amount_of_snacks) values " +
                "(default, ?, ?, ?, ?)";
    private final String DELETE = "delete from vending_machine where id=?";
    private final String UPDATE = "update vending_machine set vending_machine_model=?, max_amount_of_snacks=?, gps_cordinates=?, amount_of_snacks=? where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VendingMachine> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(VendingMachine.class));
    }

    @Override
    public Optional<VendingMachine> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(VendingMachine.class), integer));
    }

    @Override
    public int create(VendingMachine entity) {
        return jdbcTemplate.update(CREATE, entity.getVending_machine_model(), entity.getMax_amount_of_snacks(), entity.getGps_cordinates(), entity.getAmount_of_snacks());
    }

    @Override
    public int update(Integer integer, VendingMachine entity) {
        return jdbcTemplate.update(UPDATE, entity.getVending_machine_model(), entity.getMax_amount_of_snacks(), entity.getGps_cordinates(), entity.getAmount_of_snacks(), entity.getId());
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
