package com.example.laba5.service.impl;

import com.example.laba5.domain.WorkerEntity;
import com.example.laba5.domain.WorkerPositionsEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.WorkerPositionRepository;
import com.example.laba5.repository.WorkerRepository;
import com.example.laba5.service.WorkerPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkerPositionServiceImpl implements WorkerPositionService {
    @Autowired
    WorkerPositionRepository repository;
    @Override
    public List<WorkerPositionsEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public WorkerPositionsEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public WorkerPositionsEntity create(WorkerPositionsEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, WorkerPositionsEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setId(entity.getId());
        item.setPosition(entity.getPosition());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }
}
