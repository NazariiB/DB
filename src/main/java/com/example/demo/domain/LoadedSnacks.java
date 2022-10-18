package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoadedSnacks {
    private Integer id;
    private Integer reloadingSnackMachineId;
    private Integer productId;
    private Integer quantity;
}
