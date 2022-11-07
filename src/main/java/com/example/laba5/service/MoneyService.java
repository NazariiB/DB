package com.example.laba5.service;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.VendingMachineEntity;

import java.util.List;

public interface MoneyService extends GeneralService<MoneyEntity, Integer> {
    List<MoneyEntity> findAllByVendingMachineByVendingMachineId(Integer id);

    Integer sumMoney();
}
