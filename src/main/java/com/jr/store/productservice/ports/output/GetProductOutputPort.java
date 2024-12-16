package com.jr.store.productservice.ports.output;

import com.jr.store.productservice.domain.model.Product;

import java.util.Optional;

public interface GetProductOutputPort {

    Optional<Product> findById(Long id);
}
