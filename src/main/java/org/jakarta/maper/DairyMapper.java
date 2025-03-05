package org.jakarta.maper;

import org.jakarta.dto.CreateDairyProduct;
import org.jakarta.dto.DairyProductResponse;
import org.jakarta.entity.DairyProduct;

public class DairyMapper {

    public static DairyProductResponse map(DairyProduct dairyProduct) {
        return new DairyProductResponse(dairyProduct.getId(),
                        dairyProduct.getName(),
                        dairyProduct.getDescription(),
                dairyProduct.getProductionDate(),
                dairyProduct.getBrand(),
                dairyProduct.getPrice(),
                dairyProduct.getWeight());
    }

    public static DairyProduct map(CreateDairyProduct dairyProduct) {
        DairyProduct newDairyProduct = new DairyProduct();
        newDairyProduct.setName(dairyProduct.name());
        newDairyProduct.setDescription(dairyProduct.description());
        newDairyProduct.setProductionDate(dairyProduct.productionDate());
        newDairyProduct.setBrand(dairyProduct.brand());
        newDairyProduct.setPrice(dairyProduct.price());
        newDairyProduct.setWeight(dairyProduct.weight());
        return newDairyProduct;

    }
}
