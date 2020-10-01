package com.products.it;
/*-
 *#%L
 * product-service
 *#%L
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = {"src/test/resources/features"}, glue = "com.products.it")
public class CucumberTest {
}
