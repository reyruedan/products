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
 * PriceDto class.
 */
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 5049829791070698395L;
    /**
     * price list value (Identificador de la tarifa de precios aplicable).
     */
    private Integer priceList;
    /**
     * period time (START_DATE, END_DATE).
     */
    private IntervalTimeDto period;

    /**
     * price value.
     */
    private double price;
}
