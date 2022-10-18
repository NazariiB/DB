package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldProducts {
    private Integer id;
    private Integer vendingMachine_id;
    private Integer product_id;
    private Integer quantity;
    private String time_of_purchase;
}