package com.stadnik.arkadiusz.taskWeek2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class ShopStart implements ProductInterface {

    ProductService productService;

    @Autowired
    public ShopStart(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void addProduct() {
        productService.addProduct("gyros", 15);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void printSumPrices() {
        double price = productService.PrintTotalPrice();
        System.out.println("Nett price " + String.format("%.2f", price));

    }
}
