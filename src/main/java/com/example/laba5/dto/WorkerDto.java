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
public class WorkerDto extends RepresentationModel<WorkerDto> {
    private Integer idworkers;
    private String name;
    private String surname;
    private String phone_number;
    private Integer team_id;
    private String position;
    private String sallery;
}
