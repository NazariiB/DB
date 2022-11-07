package com.example.laba5.repository;

import com.example.laba5.domain.WorkerEntity;
import com.example.laba5.domain.WorkerPositionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerPositionRepository extends JpaRepository<WorkerPositionsEntity, Integer> {
}
