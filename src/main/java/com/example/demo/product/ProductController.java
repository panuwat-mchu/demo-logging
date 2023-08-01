package com.example.demo.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    public static final String METADATA = "metadata";
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> list(){
        log.debug("list product");

        List<Product> products = productService.findProducts();

        MDC.put(METADATA,products.toString());
        log.info("Found {} product(s)",products.size());
        MDC.remove(METADATA);

        return ResponseEntity.ok(products);
    }
}
