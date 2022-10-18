package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReloadedSnackMachine {
    private Integer id;
    private String timeReloading;
    private Integer vendingMachine;
    private Integer teamId;
}
