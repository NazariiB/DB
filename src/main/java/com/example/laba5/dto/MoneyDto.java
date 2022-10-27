package com.example.laba5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class MoneyDto extends RepresentationModel<MoneyDto> {
    private Integer id;
    private String date;
    private Integer amount_to_put;
    private Integer amount_to_earn;
    private Integer vending_machine_id;
    private Integer team_id;
}
