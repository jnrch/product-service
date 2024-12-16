package com.jr.store.productservice.ports.input;

import com.jr.store.productservice.domain.model.Product;

public interface CreateProductInputPort {

    Product createProduct(Product product);
}
