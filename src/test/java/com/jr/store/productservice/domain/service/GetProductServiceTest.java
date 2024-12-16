package com.jr.store.productservice.domain.service;

import com.jr.store.productservice.domain.exceptions.ProductNotFoundException;
import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.output.GetProductOutputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductServiceTest {

    @Mock
    private GetProductOutputPort getProductOutputPort;

    @InjectMocks
    private GetProductService getProductService;

    @Test
    public void shouldGetProductById() {
        Long id = 1L;
        Product product = new Product(id, "Nombre", "Descripción", 10.99);
        when(getProductOutputPort.findById(id)).thenReturn(Optional.of(product));

        Product result = getProductService.getProductById(id);

        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenGetProductById() {
        Long id = 1L;
        when(getProductOutputPort.findById(id)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> getProductService.getProductById(id));
    }
}