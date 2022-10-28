package com.example.laba5.service.impl;

import com.example.laba5.domain.WorkerEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.WorkerRepository;
import com.example.laba5.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    WorkerRepository repository;
    @Override
    public List<WorkerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public WorkerEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public WorkerEntity create(WorkerEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, WorkerEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setIdworkers(entity.getIdworkers());
        item.setName(entity.getName());
        item.setSurname(entity.getSurname());
        item.setPhoneNumber(entity.getPhoneNumber());
        item.setTeamByTeamId(entity.getTeamByTeamId());
        item.setPosition(entity.getPosition());
        item.setSallery(entity.getSallery());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }
}
