package com.stadnik.arkadiusz.taskWeek2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("pro")
@ConfigurationProperties(prefix = "pro")
public class ShopPro implements ProductInterface {

    ProductService productService;
    private double vat;
    private double discount;

    @Autowired
    public ShopPro(ProductService productService) {
        this.productService = productService;
        addProduct();
    }

    @Override
    public void addProduct() {
        productService.addProduct("tacos", 121);
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void printSumPrices() {
        double priceWithTax = productService.PrintTotalPrice() * (1.0 + (vat / 100.0));
        double priceWithDiscount = priceWithTax *(1.0 -(discount/100.0));
        System.out.println("Price with TAX " + String.format("%.2f", priceWithTax));
        System.out.println("Price with Discount " + String.format("%.2f", priceWithDiscount));
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
