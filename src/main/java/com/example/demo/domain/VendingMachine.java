package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendingMachine {
    private Integer id;
    private String vending_machine_model;
    private Integer max_amount_of_snacks;
    private String gps_cordinates;
    private Integer amount_of_snacks;
}
