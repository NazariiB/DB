package com.example.laba5.dto.assembler;

import com.example.laba5.controller.WorkerController;
import com.example.laba5.domain.WorkerEntity;
import com.example.laba5.domain.WorkerPositionsEntity;
import com.example.laba5.dto.WorkerDto;
import com.example.laba5.dto.WorkerPositionDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class WorkerPositionAssembler implements RepresentationModelAssembler<WorkerPositionsEntity, WorkerPositionDto> {
    @Override
    public WorkerPositionDto toModel(WorkerPositionsEntity entity) {
        var item = WorkerPositionDto.builder()
                .id(entity.getId())
                .position(entity.getPosition())
                .build();
        Link selfLink = linkTo(methodOn(WorkerController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<WorkerPositionDto> toCollectionModel(Iterable<? extends WorkerPositionsEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(WorkerController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
