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
        double leftLimit = 5D;
        double rightLimit = 300D;
        double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
        return generatedDouble;
    }

    public void printAllProducts() {
        productList.forEach(System.out::println);
    }

    public void addProduct(String productName, double price) {
        productList.add(new Product(productName, price));
    }

    public double PrintTotalPrice() {
        double sumPrice = 0;
        for (Product product : productList) {
            sumPrice = sumPrice + product.getPrice();
        }
        return sumPrice;
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "productList=" + productList +
                '}';
    }
}

