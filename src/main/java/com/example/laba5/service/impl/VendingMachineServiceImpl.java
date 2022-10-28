package com.example.laba5.service.impl;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.MoneyRepository;
import com.example.laba5.repository.VendingMachineRepository;
import com.example.laba5.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {
    @Autowired
    VendingMachineRepository repository;
    @Override
    public List<VendingMachineEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public VendingMachineEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public VendingMachineEntity create(VendingMachineEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, VendingMachineEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setId(entity.getId());
        item.setVendingMachineModel(entity.getVendingMachineModel());
        item.setMaxAmountOfSnacks(entity.getMaxAmountOfSnacks());
        item.setGpsCordinates(entity.getGpsCordinates());
        item.setMaxAmountOfSnacks(entity.getAmountOfSnacks());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }
}
