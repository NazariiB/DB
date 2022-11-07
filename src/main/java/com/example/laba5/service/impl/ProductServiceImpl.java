package com.example.laba5.service.impl;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.MoneyRepository;
import com.example.laba5.repository.ProductRepository;
import com.example.laba5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;
    @Override
    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public ProductEntity create(ProductEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, ProductEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setId(entity.getId());
        item.setName(entity.getName());
        item.setPrice(entity.getPrice());
        item.setMass(entity.getMass());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }

    @Override
    @Transactional
    public void procedureCursor() {
        repository.procedureCursor();
    }
}
