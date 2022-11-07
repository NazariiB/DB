package com.example.laba5.service;

import com.example.laba5.domain.TeamEntity;

import javax.transaction.Transactional;

public interface TeamService extends GeneralService<TeamEntity, Integer> {
    void insertUsingProcedure(String name);

    void insert10Rows();

}
