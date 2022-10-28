package com.example.laba5.service;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.VendingMachineEntity;

import java.util.List;

public interface ContentOfTheMachineService extends GeneralService<ContentOfTheMachineEntity, Integer> {
    List<ContentOfTheMachineEntity> findAllByVendingMachineByVendingMachineId(Integer id);
}
