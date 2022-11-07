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
public class ReloadingSnacksMachineDto extends RepresentationModel<ReloadingSnacksMachineDto> {
    private Integer id;
    private String time_reloading;
    private Integer vending_machine_id;
    private Integer team_id;
}
