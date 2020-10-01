package com.products.api;
/*-
 *#%L
 * product-service
 *#%L
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * Interval Time class for response.
 */
public class IntervalTimeDto implements Serializable {

    private static final long serialVersionUID = -917299091691899777L;
    /**
     * initDate value (START_DATE).
     */
    private LocalDateTime initDate;
    /**
     * endDate value (END_DATE).
     */
    private LocalDateTime endDate;
}
