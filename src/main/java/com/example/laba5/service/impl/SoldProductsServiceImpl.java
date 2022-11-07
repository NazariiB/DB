package com.example.laba5.service.impl;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.SoldProductsEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.MoneyRepository;
import com.example.laba5.repository.SoldProductRepository;
import com.example.laba5.service.SoldProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SoldProductsServiceImpl implements SoldProductsService {
    @Autowired
    SoldProductRepository repository;
    @Override
    public List<SoldProductsEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public SoldProductsEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public SoldProductsEntity create(SoldProductsEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, SoldProductsEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setId(entity.getId());
        item.setQuantity(entity.getQuantity());
        item.setTimeOfPurchase(entity.getTimeOfPurchase());
        item.setProductId(entity.getProductId());
        item.setVendingMachineByVendingMachineId(entity.getVendingMachineByVendingMachineId());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }

    @Override
    public List<SoldProductsEntity> findAllByVendingMachineByVendingMachineId(Integer id) {
        VendingMachineEntity machine = new VendingMachineEntity();
        machine.setId(id);
        return repository.findAllByVendingMachineByVendingMachineId(machine);
    }
}
