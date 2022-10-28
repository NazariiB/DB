package com.example.laba5.service.impl;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ReloadingSnacksMachineEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.MoneyRepository;
import com.example.laba5.repository.ReloadingSnacksMachineRepository;
import com.example.laba5.service.ReloadingSnacksMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReloadingSnacksMachineServiceImpl implements ReloadingSnacksMachineService {
    @Autowired
    ReloadingSnacksMachineRepository repository;
    @Override
    public List<ReloadingSnacksMachineEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ReloadingSnacksMachineEntity findById(Integer integer) {
        return repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public ReloadingSnacksMachineEntity create(ReloadingSnacksMachineEntity entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, ReloadingSnacksMachineEntity entity) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setId(entity.getId());
        item.setTimeReloading(entity.getTimeReloading());
        item.setTeamByTeamId(entity.getTeamByTeamId());
        item.setVendingMachineByVendingMachineId(entity.getVendingMachineByVendingMachineId());
        repository.save(item);
    }

    @Override
    @Transactional
    public void delete(Integer integer) {
        var item = repository.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        repository.delete(item);
    }
}
