package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Money {
    private Integer id;
    private String date;
    private Double amountToEarn;
    private Double amountToPut;
    private Integer vendingMachineId;
    private Integer teamId;
}
