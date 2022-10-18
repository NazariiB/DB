package com.example.demo.controller.impl;

import com.example.demo.controller.LoadedSnacksController;
import com.example.demo.dao.LoadedSnacksDao;
import com.example.demo.domain.LoadedSnacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadedSnacksControllerImpl implements LoadedSnacksController {
    @Autowired
    private LoadedSnacksDao elem;
    @Override
    public List<LoadedSnacks> findAll() {
        return elem.findAll();
    }

    @Override
    public Optional<LoadedSnacks> findById(Integer id) {
        return elem.findById(id);
    }

    @Override
    public int create(LoadedSnacks loadedSnacks) {
        return elem.create(loadedSnacks);
    }

    @Override
    public int update(Integer id, LoadedSnacks loadedSnacks) {
        return elem.update(id, loadedSnacks);
    }

    @Override
    public int delete(Integer id) {
        return elem.delete(id);
    }
}
