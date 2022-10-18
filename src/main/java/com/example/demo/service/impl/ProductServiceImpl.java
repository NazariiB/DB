package com.example.demo.service.impl;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.impl.ProductImpl;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productImpl;
    @Override
    public List<Product> findAll() {
        return productImpl.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productImpl.findById(id);
    }

    @Override
    public int create(Product product) {
        return productImpl.create(product);
    }

    @Override
    public int update(Integer integer, Product entity) {
        return productImpl.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return productImpl.delete(integer);
    }
}
