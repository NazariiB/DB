package com.example.demo.controller.impl;

import com.example.demo.controller.WorkerController;
import com.example.demo.domain.Worker;
import com.example.demo.service.impl.WorkerSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerControllerImpl implements WorkerController {
    @Autowired
    private WorkerSerImpl worSer;

    @Override
    public List<Worker> findAll() {
        return worSer.findAll();
    }

    @Override
    public Optional<Worker> findById(Integer id) {
        return worSer.findById(id);
    }

    @Override
    public int create(Worker worker) {
        return worSer.create(worker);
    }

    @Override
    public int update(Integer id, Worker worker) {
        return worSer.update(id, worker);
    }

    @Override
    public int delete(Integer id) {
        return worSer.delete(id);
    }
}
