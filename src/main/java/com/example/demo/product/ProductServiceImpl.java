package com.example.demo.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> findProducts() {
        Marker fruit = MarkerFactory.getMarker("Fruit");

        log.debug(fruit,"find products");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product A"));
        return products;
    }
}
