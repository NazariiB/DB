package com.example.laba5.controller;

import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.domain.ReloadingSnacksMachineEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.ReloadingSnacksMachineDto;
import com.example.laba5.dto.assembler.MoneyAssembler;
import com.example.laba5.dto.assembler.ReloadingSnacksMachineAssembler;
import com.example.laba5.service.MoneyService;
import com.example.laba5.service.ReloadingSnacksMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reloading")
public class ReloadingSnacksMachineController {
    @Autowired
    ReloadingSnacksMachineService service;

    @Autowired
    ReloadingSnacksMachineAssembler assembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<ReloadingSnacksMachineDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ReloadingSnacksMachineDto> addContent(@RequestBody ReloadingSnacksMachineEntity entity) {
        var item = service.create(entity);
        var temp = assembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReloadingSnacksMachineDto> getById(@PathVariable Integer id) {
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
    public ResponseEntity<?> updateItem(@RequestBody ReloadingSnacksMachineEntity item, @PathVariable Integer id) {
        service.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
