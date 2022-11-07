package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.domain.SoldProductsEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.SoldProductsDto;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.dto.assembler.SoldProductsAssembler;
import com.example.laba5.service.MoneyService;
import com.example.laba5.service.SoldProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sold-product")
public class SoldProductsController {
    @Autowired
    SoldProductsService service;

    @Autowired
    SoldProductsAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<SoldProductsDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<SoldProductsDto> addContent(@RequestBody SoldProductsEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldProductsDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/machine/{id}")
    public ResponseEntity<CollectionModel<SoldProductsDto>> getContentOFMachine(@PathVariable Integer id) {
        var content = service.findAllByVendingMachineByVendingMachineId(id);
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
//        service.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateItem(@RequestBody SoldProductsEntity item, @PathVariable Integer id) {
//        service.update(id, item);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
