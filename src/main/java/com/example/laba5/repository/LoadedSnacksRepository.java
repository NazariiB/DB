package com.example.laba5.repository;

import com.example.laba5.domain.LoadedSnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadedSnacksRepository extends JpaRepository<LoadedSnackEntity, Integer> {
    @Query(value = "CALL insert_loaded_snack(:vending_machine_id, :product_name);", nativeQuery = true)
    void insertByProcedure(@Param("vending_machine_id") Integer id, @Param("product_name") String name);
}
