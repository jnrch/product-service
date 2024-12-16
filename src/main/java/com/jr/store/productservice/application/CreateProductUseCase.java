package com.jr.store.productservice.application;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.domain.service.CreateProductService;
import com.jr.store.productservice.ports.input.CreateProductInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase implements CreateProductInputPort{

    private static final Logger LOG = LoggerFactory.getLogger(CreateProductUseCase.class);

    private final CreateProductService createProductService;

    public CreateProductUseCase(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    public Product createProduct(Product product) {
        LOG.info("Creating product with code: {}", product);
        return createProductService.createProduct(product);
    }
}
