package com.jr.store.productservice.application;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.domain.service.GetProductService;
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
class GetProductUseCaseTest {

    @Mock
    private GetProductService getProductService;

    @InjectMocks
    private GetProductUseCase getProductUseCase;

    @Test
    public void shouldGetProductById() {
        Long id = 1L;
        Product product = new Product(id, "product_1", "product_description_1", 10.99);
        when(getProductService.getProductById(id)).thenReturn(product);

        Product result = getProductUseCase.getProduct(id);

        assertNotNull(result);
        assertEquals(product, result);

        verify(getProductService, times(1)).getProductById(id);
    }
}