package org.jakarta.dto;

import java.time.LocalDate;

public class DairyProductResponse {

    private String name;
    private double price;
    private String description;
    private LocalDate productionDate;
    private String brand;
    private double weight;

    public DairyProductResponse() {}


    public DairyProductResponse(String name, double price, String description, LocalDate productionDate, String brand, double weight) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productionDate = productionDate;
        this.brand = brand;
        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
