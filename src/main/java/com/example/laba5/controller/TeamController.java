package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.TeamEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.TeamDto;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.dto.assembler.TeamAssembler;
import com.example.laba5.service.MoneyService;
import com.example.laba5.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService service;

    @Autowired
    TeamAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<TeamDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<TeamDto> addContent(@RequestBody TeamEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}
