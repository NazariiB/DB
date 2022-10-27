package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.ProductDto;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.dto.assembler.ProductAssembler;
import com.example.laba5.service.MoneyService;
import com.example.laba5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    ProductAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<ProductDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ProductDto> addContent(@RequestBody ProductEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
}
