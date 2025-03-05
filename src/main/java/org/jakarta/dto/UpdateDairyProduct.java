package org.jakarta.dto;

import java.time.LocalDate;

public record UpdateDairyProduct(String name, String description, String brand, double price, double weight) {
}
