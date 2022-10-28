package com.example.laba5.repository;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.SoldProductsEntity;
import com.example.laba5.domain.VendingMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentOfTheMachineRepositoru extends JpaRepository<ContentOfTheMachineEntity, Integer> {
    List<ContentOfTheMachineEntity> findAllByVendingMachineByVendingMachineId(VendingMachineEntity vendingMachineByVendingMachineId);
}