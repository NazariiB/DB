package com.example.laba5.controller;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.LoadedSnackEntity;
import com.example.laba5.dto.ContentOfTheMachineDto;
import com.example.laba5.dto.LoadedSnacksDto;
import com.example.laba5.dto.assembler.LoadedSnacksAssembler;
import com.example.laba5.service.LoadedSnacksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaded")
public class LoadedSnacksController {
    @Autowired
    LoadedSnacksService service;

    @Autowired
    LoadedSnacksAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<LoadedSnacksDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<LoadedSnacksDto> addContent(@RequestBody LoadedSnackEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadedSnacksDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}