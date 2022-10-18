package com.example.demo.controller.impl;

import com.example.demo.controller.TeamController;
import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamControllerImpl implements TeamController {
    @Autowired
    private TeamService teamService;

    @Override
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @Override
    public Optional<Team> findById(Integer id) {
        return teamService.findById(id);
    }

    @Override
    public int create(Team team) {
        return teamService.create(team);
    }

    @Override
    public int update(Integer id, Team team) {
        return teamService.update(id, team);
    }

    @Override
    public int delete(Integer id) {
        return teamService.delete(id);
    }
}
