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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Currency  table in database.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY")
public class Currency {

    /**
     * Currency id.
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * Currency description.
     */
    @Column(name = "description")
    private String description;
}
