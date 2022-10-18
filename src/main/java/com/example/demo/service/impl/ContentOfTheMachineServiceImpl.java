package com.example.demo.service.impl;

import com.example.demo.dao.ContentOfTheMachineDao;
import com.example.demo.dao.LoadedSnacksDao;
import com.example.demo.domain.ContentOfMachine;
import com.example.demo.domain.LoadedSnacks;
import com.example.demo.service.ContentOfTheMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentOfTheMachineServiceImpl implements ContentOfTheMachineService {
    @Autowired
    private ContentOfTheMachineDao elem;
    @Override
    public List<ContentOfMachine> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<ContentOfMachine> findById(Integer integer) {
        return elem.findById(integer);
    }

    @Override
    public int create(ContentOfMachine entity) {
        return elem.create(entity);
    }

    @Override
    public int update(Integer integer, ContentOfMachine entity) {
        return elem.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return elem.delete(integer);
    }
}
