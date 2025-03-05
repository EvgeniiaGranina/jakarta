package org.jakarta;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import org.jakarta.entity.DairyProduct;

@Repository
public interface DairyProductRepository extends CrudRepository<DairyProduct, Long> {
}
