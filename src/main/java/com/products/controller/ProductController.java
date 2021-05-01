package com.products.controller;
/*-
 *#%L
 * product-service
 *#%L
 */

import com.products.api.ProductDto;
import com.products.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Controller product class in charge to handle all the product request.
 */
@RestController
public class ProductController {
    /**
     * Date time format for the request.
     */
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Product API path for request calls.
     */
    public static final String PRODUCT_API_PATH = "/products";

    /**
     * Product service class operations.
     */
    @Autowired
    private ProductService productService;

    /**
     * Get product data.
     *
     * @param dateAndTime fecha aplicacion.
     * @param productId   id product.
     * @param brandId     id brand.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = PRODUCT_API_PATH)
    public ResponseEntity<ProductDto> getProduct(
            @RequestParam("dateAndTime")
            @DateTimeFormat(pattern = DATE_TIME_FORMAT) @NonNull LocalDateTime dateAndTime,
            @RequestParam @NonNull final Integer productId,
            @RequestParam @NonNull final Integer brandId
    ) {
        return ResponseEntity.ok(productService.getProductData(dateAndTime, productId, brandId));
    }
}
