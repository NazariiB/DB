package com.example.laba5.repository;

import com.example.laba5.domain.LoadedSnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadedSnacksRepository extends JpaRepository<LoadedSnackEntity, Integer> {
}
