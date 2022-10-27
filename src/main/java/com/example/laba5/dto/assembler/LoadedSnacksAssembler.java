package com.example.laba5.dto.assembler;

import com.example.laba5.controller.ContentOfTheMachineController;
import com.example.laba5.domain.LoadedSnackEntity;
import com.example.laba5.dto.ContentOfTheMachineDto;
import com.example.laba5.dto.LoadedSnacksDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
public class LoadedSnacksAssembler implements RepresentationModelAssembler<LoadedSnackEntity, LoadedSnacksDto> {
    @Override
    public LoadedSnacksDto toModel(LoadedSnackEntity entity) {
        LoadedSnacksDto item = LoadedSnacksDto.builder()
                .id(entity.getId())
                .reloading_snack_machines_id(entity.getReloadingSnackMachinesId().getId())
                .quantity(entity.getQuantity())
                .productId(entity.getProductId().getId()).build();
        Link selfLink = linkTo(methodOn(ContentOfTheMachineController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        Link vendingM = linkTo(methodOn(ContentOfTheMachineController.class).getContentOFMachine(item.getId())).withSelfRel();
        item.add(vendingM);
        return item;
    }

    @Override
    public CollectionModel<LoadedSnacksDto> toCollectionModel(Iterable<? extends LoadedSnackEntity> entities) {
        CollectionModel<LoadedSnacksDto> item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ContentOfTheMachineController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
