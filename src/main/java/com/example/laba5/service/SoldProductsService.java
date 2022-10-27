package com.example.laba5.service;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.SoldProductsEntity;
import com.example.laba5.domain.VendingMachineEntity;

import java.util.List;

public interface SoldProductsService extends GeneralService<SoldProductsEntity, Integer> {
    List<SoldProductsEntity> findAllByVendingMachineByVendingMachineId(Integer id);

}
