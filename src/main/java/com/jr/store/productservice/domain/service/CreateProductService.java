package com.jr.store.productservice.domain.service;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.output.CreateProductOutputPort;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {

    private final CreateProductOutputPort createProductOutputPort;

    public CreateProductService(CreateProductOutputPort createProductOutputPort) {
        this.createProductOutputPort = createProductOutputPort;
    }

    public Product createProduct(Product product) {
        return createProductOutputPort.save(product);
    }
}
