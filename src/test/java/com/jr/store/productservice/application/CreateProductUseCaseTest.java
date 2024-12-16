package com.jr.store.productservice.application;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.domain.service.CreateProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateProductUseCaseTest {

    @Mock
    private CreateProductService createProductService;

    @InjectMocks
    private CreateProductUseCase createProductUseCase;

    @Test
    public void shouldCreateProduct() {
        Product product = new Product(null, "product_1", "product_description_1", 10.99);
        Product createdProduct = new Product(1L, "product_1", "product_description_1", 10.99);
        when(createProductService.createProduct(product)).thenReturn(createdProduct);

        Product result = createProductUseCase.createProduct(product);

        assertNotNull(result);
        assertEquals(createdProduct, result);

        verify(createProductService, times(1)).createProduct(product);
    }
}