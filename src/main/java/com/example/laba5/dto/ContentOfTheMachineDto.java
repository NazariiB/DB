package com.example.laba5.dto;

import com.example.laba5.domain.ContentOfTheMachineEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.jfr.Relational;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation
public class ContentOfTheMachineDto extends RepresentationModel<ContentOfTheMachineDto> {
    private Integer id;
    private Integer quantity;
    private Integer productId;
    private Integer vending_machine_id;
}
