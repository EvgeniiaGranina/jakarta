package org.jakarta.dto;

import java.time.LocalDate;

public record CreateDairyProduct(String name, String description, LocalDate productionDate, String brand, double price, double weight) {

}
