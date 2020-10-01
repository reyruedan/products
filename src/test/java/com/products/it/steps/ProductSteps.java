package com.products.it.steps;
/*-
 *#%L
 * product-service
 *#%L
 */
import com.products.api.ProductDto;
import com.products.controller.ProductController;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class ProductSteps {

    private final String SERVER_URL = "http://localhost:";

    private ResponseEntity<ProductDto> productDtoResponseEntity;

    @LocalServerPort
    private int port;

    @When("^product controller call with params date (.*) brandId (.*) productId (.*)")
    public void callProductController(String date, Integer brandId, Integer productId) {
        RestTemplate restTemplate = new RestTemplate();
        URI url = URI.create(SERVER_URL + port + ProductController.PRODUCT_API_PATH + "?dateAndTime=" + date + "&brandId=" + brandId + "&productId=" + productId);
        RequestEntity en = new RequestEntity(HttpMethod.GET, url);
        productDtoResponseEntity = restTemplate.exchange(en, ProductDto.class);
    }

    @Then("^verify http status (.*)")
    public void checkHttpsStatus(int status) {
        Assert.assertEquals(status, productDtoResponseEntity.getStatusCode().value());
    }

    @And("^verify price (.*) listPrice (.*) startDate (.*) endDate (.*)")
    public void verifySeveralValues(Double price, Integer listPrice, String startDate, String endDate) {
        ProductDto productDto = productDtoResponseEntity.getBody();
        assert productDto != null;
        Assert.assertEquals(java.util.Optional.of(productDto.getPrice().getPrice()).get(), price);
        Assert.assertEquals(java.util.Optional.of(productDto.getPrice().getPriceList()).get(), listPrice);
        Assert.assertEquals(java.util.Optional.of(productDto.getPrice().getPeriod().getInitDate().toString()).get(), startDate);
        Assert.assertEquals(java.util.Optional.of(productDto.getPrice().getPeriod().getEndDate().toString()).get(), endDate);
    }
}
