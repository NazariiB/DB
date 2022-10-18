package com.example.demo.service.impl;

import com.example.demo.dao.LoadedSnacksDao;
import com.example.demo.dao.MoneyDao;
import com.example.demo.domain.LoadedSnacks;
import com.example.demo.domain.Money;
import com.example.demo.service.LoadedSnacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadedSnacksServiceImpl implements LoadedSnacksService {
    @Autowired
    private LoadedSnacksDao elem;
    @Override
    public List<LoadedSnacks> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<LoadedSnacks> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(LoadedSnacks entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, LoadedSnacks entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
