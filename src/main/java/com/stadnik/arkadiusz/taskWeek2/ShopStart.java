package com.stadnik.arkadiusz.taskWeek2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShopStart {

    ProductService productService;

    @Autowired
    public ShopStart(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(){
        productService.addProduct("Bannana",23);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printSumPrices(){
        productService.PrintTotalPrice();
    }
}
