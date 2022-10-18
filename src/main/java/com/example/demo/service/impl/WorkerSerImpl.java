package com.example.demo.service.impl;

import com.example.demo.dao.WorkerDao;
import com.example.demo.domain.Worker;
import com.example.demo.service.WorkerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerSerImpl implements WorkerSer {
    @Autowired
    private WorkerDao workerDao;

    @Override
    public List<Worker> findAll() {
        return workerDao.findAll();
    }

    @Override
    public Optional<Worker> findById(Integer id) {
        return workerDao.findById(id);
    }

    @Override
    public int create(Worker wor) {
        return workerDao.create(wor);
    }

    @Override
    public int update(Integer id, Worker wor) {
        return workerDao.update(id, wor);
    }

    @Override
    public int delete(Integer id) {
        return workerDao.delete(id);
    }
}
