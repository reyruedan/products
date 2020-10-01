package com.products.service;
/*-
 *#%L
 * product-service
 *#%L
 */

import com.products.api.ProductDto;
import com.products.repository.PriceRepository;
import com.products.repository.entity.Price;
import com.products.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * Service product class in charge to handle product operations.
 */
@Slf4j
@Service
public class ProductService {

    /**
     * Price Repository to table.
     */
    @Autowired
    private PriceRepository priceRepository;
    /**
     * mapper To Product.
     */
    @Autowired
    private ProductMapper mapperToProduct;

    /**
     * Method in charge to retrieve products data.
     *
     * @param date      fecha aplicacion.
     * @param productId id product.
     * @param brandId   id brand.
     */
    @Transactional
    public ProductDto getProductData(final LocalDateTime date, final Integer productId, final Integer brandId) {
        log.info("getting productData method date {} productId {} brandId {}", date, productId, brandId);
        return priceRepository.findByBrandIdAndProductId(brandId, productId)
                .filter(i -> i.getStartDate().isBefore(date) && i.getEndDate().isAfter(date))
                .max(Comparator.comparing(Price::getPriority))
                .map(i -> mapperToProduct.mapperToProduct(i))
                .orElse(new ProductDto());
    }

}
