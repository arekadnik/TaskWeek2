package com.stadnik.arkadiusz.taskWeek2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> productList;


    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product("Apple", getRandomNumber()));
        productList.add(new Product("Pear", getRandomNumber()));
        productList.add(new Product("Pineapple", getRandomNumber()));
        productList.add(new Product("Melon", getRandomNumber()));
        productList.add(new Product("WaterMelon", getRandomNumber()));
    }

    public double getRandomNumber() {
        Random randomNumber = new Random();
        double randomPrice = randomNumber.nextDouble() * 3 + 1;
        return randomPrice;
    }

    public void printAllProducts() {
        productList.forEach(System.out::println);
    }

    public void addProduct(String productName, double price) {
        productList.add(new Product(productName, price));
    }

    public void PrintTotalPrice() {
        double sumPrice = 0;
        for (Product product : productList) {
            sumPrice = sumPrice + product.getPrice();
        }
        System.out.println(String.format("%.2f",sumPrice));
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "productList=" + productList +
                '}';
    }
}

