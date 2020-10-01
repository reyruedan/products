package com.products.service.mapper;
/*-
 *#%L
 * product-service
 *#%L
 */

import com.products.api.BrandDto;
import com.products.api.IntervalTimeDto;
import com.products.api.PriceDto;
import com.products.api.ProductDto;
import com.products.repository.entity.Brand;
import com.products.repository.entity.Price;
import com.products.repository.entity.Product;
import org.springframework.stereotype.Component;

/**
 * Mapper Product class.
 */
@Component
public class ProductMapper {
    /**
     * Mapping from @{@link Price}. to ProductDto @{@link ProductDto}.
     *
     * @param data price
     * @return productDto
     */
    public ProductDto mapperToProduct(final Price data) {
        final Product product = data.getProduct();
        final Brand brand = data.getBrand();
        return ProductDto.builder().id(product.getId()).name(product.getDescription())
                .brand(BrandDto.builder().id(brand.getId()).name(brand.getDescription()).build())
                .price(PriceDto.builder().price(data.getPrice()).priceList(data.getPriceList())
                        .period(IntervalTimeDto.builder().initDate(data.getStartDate()).endDate(data.getEndDate()).build()).build()).build();
    }
}
