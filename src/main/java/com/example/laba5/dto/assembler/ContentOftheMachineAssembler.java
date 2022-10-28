package com.example.laba5.dto.assembler;

import com.example.laba5.controller.ContentOfTheMachineController;
import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.example.laba5.dto.ContentOfTheMachineDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ContentOftheMachineAssembler implements RepresentationModelAssembler<ContentOfTheMachineEntity, ContentOfTheMachineDto> {
    @Override
    public ContentOfTheMachineDto toModel(ContentOfTheMachineEntity entity) {
        ContentOfTheMachineDto content = ContentOfTheMachineDto.builder()
                .id(entity.getId())
                .vending_machine_id(entity.getVendingMachineByVendingMachineId().getId())
                .quantity(entity.getQuantity())
                .productId(entity.getProductId().getId()).build();
        Link selfLink = linkTo(methodOn(ContentOfTheMachineController.class).getById(content.getId())).withSelfRel();
        content.add(selfLink);
        Link vendingM = linkTo(methodOn(ContentOfTheMachineController.class).getContentOFMachine(content.getId())).withSelfRel();
        content.add(vendingM);
        return content;
    }

    @Override
    public CollectionModel<ContentOfTheMachineDto> toCollectionModel(Iterable<? extends ContentOfTheMachineEntity> entities) {
        CollectionModel<ContentOfTheMachineDto> contentDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ContentOfTheMachineController.class).getAllContent()).withSelfRel();
        contentDto.add(selfLink);
        return contentDto;
    }
}
