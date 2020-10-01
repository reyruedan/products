package com.products.it.db;
/*-
 *#%L
 * product-service
 *#%L
 */
import org.springframework.util.StringUtils;

public abstract class AbstractCucumberSteps {

    protected String fileDescriptionToFileName(final String fileDescription, final String extension) {
        return (StringUtils.hasText(extension) && fileDescription.endsWith(extension))
                ? fileDescription
                : (fileDescription.toLowerCase().replace(' ', '-') + extension);
    }
}