package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.controller.SoldProductsController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.SoldProductsEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.SoldProductsDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class SoldProductsAssembler implements RepresentationModelAssembler<SoldProductsEntity, SoldProductsDto> {
    @Override
    public SoldProductsDto toModel(SoldProductsEntity entity) {
        SoldProductsDto item = SoldProductsDto.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .time_of_purchase(entity.getTimeOfPurchase())
                .product_id(entity.getProductId().getId())
                .vending_machine_id(entity.getVendingMachineByVendingMachineId().getId()).build();
        Link selfLink = linkTo(methodOn(SoldProductsController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        Link machines = linkTo(methodOn(SoldProductsController.class).getContentOFMachine(item.getId())).withSelfRel();
        item.add(machines);
        return item;
    }

    @Override
    public CollectionModel<SoldProductsDto> toCollectionModel(Iterable<? extends SoldProductsEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SoldProductsController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
