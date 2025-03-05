package org.jakarta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.jakarta.entity.DairyProduct;

import java.time.LocalDate;

/**
 * DTO for {@link org.jakarta.entity.DairyProduct}
 */
public record DairyProductResponse(Long id, @NotBlank(message = "Title is mandatory") String name,
                                   @NotBlank(message = "Description is mandatory") String description,
                                   @NotNull(message = "Production date is mandatory") @PastOrPresent(message = "Production date must be in the past or present") LocalDate productionDate,
                                   @NotBlank(message = "Brand is mandatory") String brand,
                                   @Positive(message = "Price must be positive") double price,
                                   @Positive(message = "Weight must be positive") double weight) {

    public DairyProductResponse (DairyProduct dairyProduct) {
        this(dairyProduct.getId(), dairyProduct.getName(),
                dairyProduct.getDescription(),
                dairyProduct.getProductionDate(),
                dairyProduct.getBrand(),
                dairyProduct.getPrice(),
                dairyProduct.getWeight());
    }

    public static DairyProductResponse map(DairyProduct dairyProduct) {
        return new DairyProductResponse(dairyProduct.getId(),
                dairyProduct.getName(),
                dairyProduct.getDescription(),
                dairyProduct.getProductionDate(),
                dairyProduct.getBrand(),
                dairyProduct.getPrice(),
                dairyProduct.getWeight());
    }
}
