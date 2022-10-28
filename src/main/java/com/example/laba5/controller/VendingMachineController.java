package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.VendingMachineDto;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.dto.assembler.VendingMachineAssembler;
import com.example.laba5.service.MoneyService;
import com.example.laba5.service.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machine")
public class VendingMachineController {
    @Autowired
    VendingMachineService service;

    @Autowired
    VendingMachineAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<VendingMachineDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<VendingMachineDto> addContent(@RequestBody VendingMachineEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendingMachineDto> getById(@PathVariable Integer id) {
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
    public ResponseEntity<?> updateItem(@RequestBody VendingMachineEntity item, @PathVariable Integer id) {
        service.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
