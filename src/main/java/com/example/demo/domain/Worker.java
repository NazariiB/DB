package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {
    private Integer idWorkers;
    private String name;
    private String surname;
    private String phone_number;
    private Integer team_id;
    private String position;
    private String sallery;
}
