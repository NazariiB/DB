package com.example.laba5.repository;

import com.example.laba5.domain.VendingMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendingMachineRepository extends JpaRepository<VendingMachineEntity, Integer> {


}
