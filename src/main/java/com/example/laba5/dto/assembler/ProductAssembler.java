package com.example.laba5.dto.assembler;

import com.example.laba5.controller.MoneyController;
import com.example.laba5.controller.ProductController;
import com.example.laba5.domain.MoneyEntity;
import com.example.laba5.domain.ProductEntity;
import com.example.laba5.dto.MoneyDto;
import com.example.laba5.dto.ProductDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductAssembler implements RepresentationModelAssembler<ProductEntity, ProductDto> {
    @Override
    public ProductDto toModel(ProductEntity entity) {
        ProductDto item = ProductDto.builder()
                .id(entity.getId())
                .mass(entity.getMass())
                .name(entity.getName())
                .price(entity.getPrice()).build();
        Link selfLink = linkTo(methodOn(ProductController.class).getById(item.getId())).withSelfRel();
        item.add(selfLink);
        return item;
    }

    @Override
    public CollectionModel<ProductDto> toCollectionModel(Iterable<? extends ProductEntity> entities) {
        var item = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ProductController.class).getAllContent()).withSelfRel();
        item.add(selfLink);
        return item;
    }
}
