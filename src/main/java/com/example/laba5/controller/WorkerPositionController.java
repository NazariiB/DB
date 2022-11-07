package com.example.laba5.controller;

import com.example.laba5.dto.WorkerDto;
import com.example.laba5.dto.WorkerPositionDto;
import com.example.laba5.dto.assembler.WorkerAssembler;
import com.example.laba5.dto.assembler.WorkerPositionAssembler;
import com.example.laba5.service.WorkerPositionService;
import com.example.laba5.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worker-position")
public class WorkerPositionController {
    @Autowired
    WorkerPositionService service;

    @Autowired
    WorkerPositionAssembler assembler;


    @GetMapping("/all")
    public ResponseEntity<CollectionModel<WorkerPositionDto>> getAllContent() {
        var content = service.findAll();
        var temp = assembler.toCollectionModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerPositionDto> getById(@PathVariable Integer id) {
        var content = service.findById(id);
        var temp = assembler.toModel(content);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

}
