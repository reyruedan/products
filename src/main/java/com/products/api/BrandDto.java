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
 * BrandDto class content.
 */
public class BrandDto implements Serializable {

    private static final long serialVersionUID = 5049829791070698345L;
    /**
     * brand id.
     */
    private Integer id;

    /**
     * brand name.
     */
    private String name;
}
