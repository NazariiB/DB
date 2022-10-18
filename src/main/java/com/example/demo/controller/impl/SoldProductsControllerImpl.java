package com.example.demo.controller.impl;

import com.example.demo.controller.SoldProductsController;
import com.example.demo.domain.ContentOfMachine;
import com.example.demo.domain.SoldProducts;
import com.example.demo.service.ContentOfTheMachineService;
import com.example.demo.service.SoldProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldProductsControllerImpl implements SoldProductsController {
    @Autowired
    private SoldProductsService elem;
    @Override
    public List<SoldProducts> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<SoldProducts> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(SoldProducts entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, SoldProducts entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
