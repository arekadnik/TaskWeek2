package com.stadnik.arkadiusz.taskWeek2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopStart {

    private ProductService productService;

    @Autowired
    public ShopStart(ProductService productService) {
        this.productService = productService;
    }
}
