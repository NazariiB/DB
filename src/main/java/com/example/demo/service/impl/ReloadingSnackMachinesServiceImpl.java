package com.example.demo.service.impl;

import com.example.demo.dao.ReloadedSnacksDao;
import com.example.demo.domain.ReloadedSnackMachine;
import com.example.demo.service.ReloadingShacksMachinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReloadingSnackMachinesServiceImpl implements ReloadingShacksMachinesService {
    @Autowired
    private ReloadedSnacksDao elem;
    @Override
    public List<ReloadedSnackMachine> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<ReloadedSnackMachine> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(ReloadedSnackMachine entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, ReloadedSnackMachine entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
