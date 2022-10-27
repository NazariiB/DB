package com.example.laba5.controller;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.domain.LoadedSnackEntity;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.dto.ContentOfTheMachineDto;
import com.example.laba5.dto.LoadedSnacksDto;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.assembler.LoadedSnacksAssembler;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.service.LoadedSnacksService;
import com.example.laba5.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired
    MoneyService service;

    @Autowired
    MoneyAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<MoneyDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<MoneyDto> addContent(@RequestBody MoneyEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoneyDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/machine/{id}")
    public ResponseEntity<CollectionModel<MoneyDto>> getContentOFMachine(@PathVariable Integer id) {
        var content = service.findAllByVendingMachineByVendingMachineId(id);
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}
