package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.controller.ReloadingSnacksMachineController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ReloadingSnacksMachineEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.ReloadingSnacksMachineDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReloadingSnacksMachineAssembler implements RepresentationModelAssembler<ReloadingSnacksMachineEntity, ReloadingSnacksMachineDto> {
    @Override
    public ReloadingSnacksMachineDto toModel(ReloadingSnacksMachineEntity entity) {
        ReloadingSnacksMachineDto item = ReloadingSnacksMachineDto.builder()
                .id(entity.getId())
                .time_reloading(entity.getTimeReloading())
                .team_id(entity.getTeamByTeamId().getId())
                .vending_machine_id(entity.getVendingMachineByVendingMachineId().getId()).build();
        Link selfLink = linkTo(methodOn(ReloadingSnacksMachineController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<ReloadingSnacksMachineDto> toCollectionModel(Iterable<? extends ReloadingSnacksMachineEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ReloadingSnacksMachineController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
