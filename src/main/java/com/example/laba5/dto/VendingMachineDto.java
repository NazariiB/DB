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
public class VendingMachineDto extends RepresentationModel<VendingMachineDto> {
    private Integer id;
    private String vending_machine_model;
    private Integer max_amount_of_snacks;
    private String gps_cordinates;
    private Integer amount_of_snacks;
}
