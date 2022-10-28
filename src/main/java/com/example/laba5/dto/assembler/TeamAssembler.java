package com.example.laba5.dto.assembler;


import com.example.laba5.controller.TeamController;
import com.example.laba5.domain.TeamEntity;
import com.example.laba5.dto.TeamDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class TeamAssembler implements RepresentationModelAssembler<TeamEntity, TeamDto> {
    @Override
    public TeamDto toModel(TeamEntity entity) {
        TeamDto item = TeamDto.builder()
                .id(entity.getId())
                .name(entity.getName()).build();
        Link selfLink = linkTo(methodOn(TeamController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<TeamDto> toCollectionModel(Iterable<? extends TeamEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(TeamController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
