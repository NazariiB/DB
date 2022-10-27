package com.example.laba5.service.impl;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.exception.ItemNotFound;
import com.example.laba5.repository.ContentOfTheMachineRepositoru;
import com.example.laba5.service.ContentOfTheMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContentOfTheMachineServiceImpl implements ContentOfTheMachineService {
    @Autowired
    ContentOfTheMachineRepositoru content;

    @Override
    public List<ContentOfTheMachineEntity> findAllByVendingMachineByVendingMachineId(Integer id) {
        VendingMachineEntity machine = new VendingMachineEntity();
        machine.setId(id);
        return content.findAllByVendingMachineByVendingMachineId(machine);
    }

    @Override
    public List<ContentOfTheMachineEntity> findAll() {
        return content.findAll();
    }

    @Override
    public ContentOfTheMachineEntity findById(Integer integer) {
        return content.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
    }

    @Override
    @Transactional
    public ContentOfTheMachineEntity create(ContentOfTheMachineEntity entity) {
        content.save(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Integer integer, ContentOfTheMachineEntity entity) {
        ContentOfTheMachineEntity item = content.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        item.setProductId(entity.getProductId());
        item.setQuantity(entity.getQuantity());
        item.setVendingMachineByVendingMachineId(entity.getVendingMachineByVendingMachineId());
        content.save(item);
    }

    @Override
    public void delete(Integer integer) {
        ContentOfTheMachineEntity item = content.findById(integer).orElseThrow(() -> new ItemNotFound(integer));
        content.delete(item);
    }
}
