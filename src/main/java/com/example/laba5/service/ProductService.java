package com.example.laba5.service;

import com.example.laba5.domain.ProductEntity;

public interface ProductService extends GeneralService<ProductEntity, Integer> {
    void procedureCursor();
}
