package com.example.demo.controller.impl;

import com.example.demo.controller.MoneyController;
import com.example.demo.dao.MoneyDao;
import com.example.demo.domain.Money;
import com.example.demo.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoneyControllerImpl implements MoneyController {
    @Autowired
    private MoneyService elem;
    @Override
    public List<Money> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<Money> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(Money entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, Money entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
