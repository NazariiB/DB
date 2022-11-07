package com.example.laba5.repository;

import com.example.laba5.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query(value = "CALL proc_cursor();", nativeQuery = true)
    void procedureCursor();

}
