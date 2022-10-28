package com.example.laba5.service.impl;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.MoneyRepository;
import com.example.laba5.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    MoneyRepository repository;
    @Override
    public List<MoneyEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MoneyEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public MoneyEntity create(MoneyEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, MoneyEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setDate(entity.getDate());
        item.setAmountToEarn(entity.getAmountToEarn());
        item.setAmountToPut(entity.getAmountToPut());
        item.setVendingMachineByVendingMachineId(entity.getVendingMachineByVendingMachineId());
        item.setTeamByTeamId(entity.getTeamByTeamId());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }

    @Override
    public List<MoneyEntity> findAllByVendingMachineByVendingMachineId(Integer id) {
        VendingMachineEntity machine = new VendingMachineEntity();
        machine.setId(id);
        return repository.findAllByVendingMachineByVendingMachineId(machine);
    }
}
