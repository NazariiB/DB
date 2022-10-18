package com.example.demo.controller.impl;

import com.example.demo.controller.ReloadedSnacksMachineController;
import com.example.demo.dao.ReloadedSnacksDao;
import com.example.demo.domain.ReloadedSnackMachine;
import com.example.demo.service.ReloadingShacksMachinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReloadingSnackMachineControllerImpl implements ReloadedSnacksMachineController {
    @Autowired
    private ReloadingShacksMachinesService elem;
    @Override
    public List<ReloadedSnackMachine> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<ReloadedSnackMachine> findById(Integer id) {
        return elem.findById(id);
    }

    @Override
    public int create(ReloadedSnackMachine entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer id, ReloadedSnackMachine entity) {
        return elem.update(id, entity);
    }

    @Override
    public int delete(Integer id) {
        return elem.delete(id);
    }
}
