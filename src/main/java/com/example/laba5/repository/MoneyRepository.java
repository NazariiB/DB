package com.example.laba5.repository;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.VendingMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyRepository extends JpaRepository<MoneyEntity, Integer> {
    List<MoneyEntity> findAllByVendingMachineByVendingMachineId(VendingMachineEntity vendingMachineByVendingMachineId);
}
