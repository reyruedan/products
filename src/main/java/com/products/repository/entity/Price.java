package com.products.repository.entity;
/*-
 *#%L
 * product-service
 *#%L
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Brand Entity table in database.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class Price {

    /**
     * id.
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * brand id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private Brand brand;

    /**
     * start date.
     */
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    /**
     * end date.
     */
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    /**
     * price list.
     */
    @Column(name = "PRICE_LIST")
    private Integer priceList;

    /**
     * product id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    /**
     * priority value.
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * price.
     */
    @Column(name = "PRICE")
    private Double price;

    /**
     * currency.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURR")
    private Currency curr;
}
