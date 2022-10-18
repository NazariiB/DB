package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContentOfMachine {
    private Integer id;
    private Integer vendingMachine_id;
    private Integer productId;
    private Integer quantity;
}
