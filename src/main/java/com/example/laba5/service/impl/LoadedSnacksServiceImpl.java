package com.example.laba5.service.impl;

import com.example.laba5.domain.LoadedSnackEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.LoadedSnacksRepository;
import com.example.laba5.service.LoadedSnacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LoadedSnacksServiceImpl implements LoadedSnacksService {
    @Autowired
    LoadedSnacksRepository repository;
    @Override
    public List<LoadedSnackEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public LoadedSnackEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public LoadedSnackEntity create(LoadedSnackEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, LoadedSnackEntity entity) {
         var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
         item.setProductId(entity.getProductId());
         item.setQuantity(entity.getQuantity());
         item.setReloadingSnackMachinesId(entity.getReloadingSnackMachinesId());
         repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }
}
