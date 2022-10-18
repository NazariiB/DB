package com.example.demo.service.impl;

import com.example.demo.dao.TeamDao;
import com.example.demo.dao.impl.TeamDaoImpl;
import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;
    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public Optional<Team> findById(Integer integer) {
        return teamDao.findById(integer);
    }

    @Override
    public int create(Team entity) {
        return teamDao.create(entity);
    }

    @Override
    public int update(Integer integer, Team entity) {
        return teamDao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return teamDao.delete(integer);
    }
}
