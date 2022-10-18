package com.example.demo.controller.impl;

import com.example.demo.controller.ProductController;
import com.example.demo.domain.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductServiceImpl productSer;
    @Override
    public List<Product> findAll() {
        return productSer.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productSer.findById(id);
    }

    @Override
    public int create(Product product) {
        return productSer.create(product);
    }

    @Override
    public int update(Integer id, Product product) {
        return productSer.update(id, product);
    }

    @Override
    public int delete(Integer id) {
        return productSer.delete(id);
    }
}
