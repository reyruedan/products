package com.products.it.context;
/*-
 *#%L
 * product-service
 *#%L
 */
import com.products.Application;
import cucumber.api.java.en.Given;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class TestSpringContext {

    @Given("there is an spring context")
    public void there_is_spring_context() {
    }
}
