package com.example.laba5.repository;

import com.example.laba5.domain.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {
    @Query(value = "CALL insert_into_team(:new_name);", nativeQuery = true)
    void insertUsingProcedure(@Param("new_name") String name);

    @Query(value = "CALL insert_team_10_rows();", nativeQuery = true)
    void insert10Teams();
}
