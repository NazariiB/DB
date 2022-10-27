package com.example.laba5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation
public class SoldProductsDto extends RepresentationModel<SoldProductsDto> {
    private Integer id;
    private Integer quantity;
    private String time_of_purchase;
    private Integer vending_machine_id;
    private Integer product_id;
}
