package com.products.ut.controller;

import com.products.api.BrandDto;
import com.products.api.IntervalTimeDto;
import com.products.api.PriceDto;
import com.products.api.ProductDto;
import com.products.controller.ProductController;
import com.products.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;

@SpringJUnitConfig
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    public void callProductControllerThenReturnAnyResponseAndServiceIsCalled() {
        Mockito.when(productService.getProductData(Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(getProduct());
        productController.getProduct(LocalDateTime.now(), 1, 1);
        Mockito.verify(productService, Mockito.times(1)).getProductData(Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void callProductControllerWrongFormatDateThenExceptionAndServiceNotCalled() {
        Assert.assertThrows(NullPointerException.class,
                () -> {
                    productController.getProduct(null, 1, 1);
                });
        Mockito.verify(productService, Mockito.times(0)).getProductData(Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void callProductControllerWrongBrandIdThenExceptionAndServiceNotCalled() {
        Assert.assertThrows(NullPointerException.class,
                () -> {
                    productController.getProduct(LocalDateTime.now(), null, 1);
                });
        Mockito.verify(productService, Mockito.times(0)).getProductData(Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    }

    @Test
    public void callProductControllerWrongProductIdThenExceptionAndServiceNotCalled() {
        Assert.assertThrows(NullPointerException.class,
                () -> {
                    productController.getProduct(LocalDateTime.now(), 1, null);
                });
        Mockito.verify(productService, Mockito.times(0)).getProductData(Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    }


    private ProductDto getProduct() {
        return ProductDto.builder().id(1).name("shirt")
                .brand(BrandDto.builder().id(1).name("Z").build()).
                        price(PriceDto.builder().price(12.0).priceList(2)
                                .period(IntervalTimeDto.builder().initDate(LocalDateTime.now().minusDays(10))
                                        .endDate(LocalDateTime.now().plusDays(3)).build()).build()).build();
    }
}
