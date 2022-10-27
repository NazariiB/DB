package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.controller.VendingMachineController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.VendingMachineEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.VendingMachineDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class VendingMachineAssembler implements RepresentationModelAssembler<VendingMachineEntity, VendingMachineDto> {
    @Override
    public VendingMachineDto toModel(VendingMachineEntity entity) {
        var item = VendingMachineDto.builder()
                .id(entity.getId())
                .vending_machine_model(entity.getVendingMachineModel())
                .max_amount_of_snacks(entity.getMaxAmountOfSnacks())
                .gps_cordinates(entity.getGpsCordinates())
                .amount_of_snacks(entity.getAmountOfSnacks()).build();
        Link selfLink = linkTo(methodOn(VendingMachineController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<VendingMachineDto> toCollectionModel(Iterable<? extends VendingMachineEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(VendingMachineController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
