package com.products.repository;
/*-
 *#%L
 * product-service
 *#%L
 */

import com.products.repository.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

/**
 * Price Repository queries handler.
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {

    /**
     * Nota: esta era una opción, menos optima ya que luego había que quedarse con el mayor priority pero la bbdd
     * era la responsable del calculo de fechas, por otro lado devolvía un List que luego había que hacer stream
     * y luego de la operación anterior (max (priority)) y el findFirst (incluso al ser native query se podía hacer
     * lo del priority en la select, más carga sobre la bbdd).
     */
    @Query(value = "SELECT * FROM prices t where t.brand_id = :id and product_id = :productId and :date between t.start_date and t.end_date ", nativeQuery = true)
    List<Price> findByBrandIdAndProductId(final Integer id, final Integer productId, final LocalDateTime date);

    /**
     * Filter by brandId and productId.
     */
    @Query(value = "SELECT * FROM prices t where t.brand_id = :id and product_id = :productId ", nativeQuery = true)
    Stream<Price> findByBrandIdAndProductId(final Integer id, final Integer productId);

}
