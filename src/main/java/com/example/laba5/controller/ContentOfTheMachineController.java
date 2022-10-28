package com.example.laba5.controller;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.dto.ContentOfTheMachineDto;
import com.example.laba5.dto.assembler.ContentOftheMachineAssembler;
import com.example.laba5.service.ContentOfTheMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping(value = "/content")
public class ContentOfTheMachineController {
    @Autowired
    ContentOfTheMachineService contentService;
    @Autowired
    ContentOftheMachineAssembler contentAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<ContentOfTheMachineDto>> getAllContent() {
        List<ContentOfTheMachineEntity> content = contentService.findAll();
        CollectionModel<ContentOfTheMachineDto> temp = contentAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ContentOfTheMachineDto> addContent(@RequestBody ContentOfTheMachineEntity entity) {
        System.out.println("starrttttt");
        System.out.println(entity);
        ContentOfTheMachineEntity item = contentService.create(entity);
        ContentOfTheMachineDto temp = contentAssembler.toModel(item);
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentOfTheMachineDto> getById(@PathVariable Integer id) {
        ContentOfTheMachineEntity content = contentService.findById(id);
        ContentOfTheMachineDto temp = contentAssembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/machine/{id}")
    public ResponseEntity<CollectionModel<ContentOfTheMachineDto>> getContentOFMachine(@PathVariable Integer id) {
        List<ContentOfTheMachineEntity> content = contentService.findAllByVendingMachineByVendingMachineId(id);
        CollectionModel<ContentOfTheMachineDto> temp = contentAssembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Integer id) {
        contentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@RequestBody ContentOfTheMachineEntity item, @PathVariable Integer id) {
        contentService.update(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
