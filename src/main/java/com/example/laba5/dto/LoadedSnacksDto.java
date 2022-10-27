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
public class LoadedSnacksDto extends RepresentationModel<LoadedSnacksDto> {
    private Integer id;
    private Integer reloading_snack_machines_id;
    private Integer productId;
    private Integer quantity;
}
