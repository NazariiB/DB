package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.controller.WorkerController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.WorkerEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.WorkerDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class WorkerAssembler implements RepresentationModelAssembler<WorkerEntity, WorkerDto> {

    @Override
    public WorkerDto toModel(WorkerEntity entity) {
        var item = WorkerDto.builder()
                .idworkers(entity.getIdworkers())
                .name(entity.getName())
                .surname(entity.getSurname())
                .phone_number(entity.getPhoneNumber())
                .team_id(entity.getTeamByTeamId().getId())
                .position(entity.getPosition())
                .sallery(entity.getSallery())
                .build();
        Link selfLink = linkTo(methodOn(WorkerController.class).getById(item.getIdworkers())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<WorkerDto> toCollectionModel(Iterable<? extends WorkerEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(WorkerController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
