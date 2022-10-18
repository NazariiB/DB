package com.example.demo.service.impl;

import com.example.demo.dao.VendingMachineDao;
import com.example.demo.domain.VendingMachine;
import com.example.demo.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {
    @Autowired
    private VendingMachineDao elem;
    @Override
    public List<VendingMachine> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<VendingMachine> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(VendingMachine entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, VendingMachine entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
