package com.products.api;
/*-
 *#%L
 * product-service
 *#%L
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

/**
 * ProductDto class for response.
 */
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 5049820791070698345L;
    /**
     * Product id value.
     */
    private Integer id;

    /**
     * Product name.
     */
    private String name;

    /**
     * Brand info.
     */
    private BrandDto brand;

    /**
     * PriceDto info.
     */
    private PriceDto price;

}
