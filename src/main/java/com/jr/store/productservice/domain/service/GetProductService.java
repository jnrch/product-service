package com.jr.store.productservice.domain.service;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.domain.exceptions.ProductNotFoundException;
import com.jr.store.productservice.ports.output.GetProductOutputPort;
import org.springframework.stereotype.Service;

@Service
public class GetProductService {

    private final GetProductOutputPort getProductOutputPort;

    public GetProductService(GetProductOutputPort getProductOutputPort) {
        this.getProductOutputPort = getProductOutputPort;
    }

    public Product getProductById(Long id) {
        return getProductOutputPort.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
