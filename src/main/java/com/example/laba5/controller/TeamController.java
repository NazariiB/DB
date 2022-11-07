package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody TeamEntity item, @PathVariable Integer id) {
        service.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new-procedure/{name}")
    public ResponseEntity<?> insertUsingProcedure(@PathVariable String name) {
        service.insertUsingProcedure(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/procedure")
    public ResponseEntity<?> insert10Rows() {
        service.insert10Rows();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
