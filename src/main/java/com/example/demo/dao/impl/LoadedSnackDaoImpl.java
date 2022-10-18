package com.example.demo.dao.impl;

import com.example.demo.dao.LoadedSnacksDao;
import com.example.demo.domain.LoadedSnacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class LoadedSnackDaoImpl implements LoadedSnacksDao {
    String FIND_ALL = "SELECT * from loaded_snack";
    String FIND_BY_ID = "select * from loaded_snack where id=?";
    String UPDATE = "update loaded_snack set reloading_snack_machines_id=?, product_id=?, quantity=? where id=?";
    String CREATE = "insert into loaded_snack (reloading_snack_machines_id, product_id, quantity) values " +
            "(default, ?, ?, ?)";
    String DELETE = "delete from loaded_snack where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LoadedSnacks> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(LoadedSnacks.class));
    }

    @Override
    public Optional<LoadedSnacks> findById(Integer integer) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(LoadedSnacks.class), integer));
    }

    @Override
    public int create(LoadedSnacks l) {
        return jdbcTemplate.update(CREATE, l.getReloadingSnackMachineId(), l.getProductId(), l.getQuantity());
    }

    @Override
    public int update(Integer integer, LoadedSnacks l) {
        return jdbcTemplate.update(UPDATE, l.getReloadingSnackMachineId(), l.getProductId(), l.getQuantity(), integer);
    }

    @Override
    public int delete(Integer integer) {
        return jdbcTemplate.update(DELETE, integer);
    }
}
