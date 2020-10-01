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
 * Price table in database.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BRAND")
public class Brand {

    /**
     * brand id.
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * brand description.
     */
    @Column(name = "description")
    private String description;
}
