package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.dto.LoadedSnacksDto;
import com.example.laba5.dto.MoneyDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class MoneyAssembler implements RepresentationModelAssembler<MoneyEntity, MoneyDto> {
    @Override
    public MoneyDto toModel(MoneyEntity entity) {
        MoneyDto item = MoneyDto.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .amount_to_earn(entity.getAmountToEarn())
                .amount_to_put(entity.getAmountToPut())
                .vending_machine_id(entity.getVendingMachineByVendingMachineId().getId())
                .team_id(entity.getTeamByTeamId().getId()).build();
        Link selfLink = linkTo(methodOn(MoneyController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        Link machines = linkTo(methodOn(MoneyController.class).getContentOFMachine(item.getId())).withSelfRel();
        item.add(machines);
        return item;
    }

    @Override
    public CollectionModel<MoneyDto> toCollectionModel(Iterable<? extends MoneyEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(MoneyController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
