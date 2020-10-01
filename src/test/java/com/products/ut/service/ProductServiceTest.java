package com.products.ut.service;

import com.products.api.ProductDto;
import com.products.repository.PriceRepository;
import com.products.repository.entity.Price;
import com.products.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

@SpringJUnitConfig
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private PriceRepository priceRepository;

    //Añadir más test unitarios con resultados, sería volver a testear el codigo de los integrados.
    //no he añadido excepciones o un ExceptionHandler dado que estaba fuera del alcance.
    @Test
    public void callProductServiceBrandIdOrProductIdNotExistInDatabaseThenReturnEmpty() {
        Mockito.when(priceRepository.findByBrandIdAndProductId(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Stream.<Price>builder().build());
        ProductDto result = productService.getProductData(LocalDateTime.now(), 2, 2);
        Assert.assertTrue(Objects.isNull(result.getPrice()));
        Assert.assertTrue(Objects.isNull(result.getBrand()));
        Assert.assertTrue(Objects.isNull(result.getId()));
        Assert.assertTrue(Objects.isNull(result.getName()));
    }

}
