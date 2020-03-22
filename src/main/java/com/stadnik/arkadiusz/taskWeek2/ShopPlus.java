package com.stadnik.arkadiusz.taskWeek2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("plus")
@ConfigurationProperties(prefix = "tax")
public class ShopPlus extends ShopStart {

    private int vat;


    public ShopPlus(ProductService productService) {
        super(productService);
        addProduct();
    }

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void printSumPrices() {
        double priceWithTax = productService.PrintTotalPrice() * (1.0 + (vat / 100.0));
        System.out.println("Price with TAX " + String.format("%.2f", priceWithTax));
    }


    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }
}
