package com.jr.store.productservice.domain.service;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.output.CreateProductOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductServiceTest {

    @Mock
    private CreateProductOutputPort createProductOutputPort;

    @InjectMocks
    private CreateProductService createProductService;

    @Test
    void testCreateProduct() {
        Product product = new Product(1L, "Test Product", "Test Description", 100.0);
        when(createProductOutputPort.save(product)).thenReturn(product);

        Product result = createProductService.createProduct(product);

        assertNotNull(result);
        assertEquals(product, result);
    }
}