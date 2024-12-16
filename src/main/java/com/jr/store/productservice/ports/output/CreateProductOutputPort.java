package com.jr.store.productservice.ports.output;

import com.jr.store.productservice.domain.model.Product;

public interface CreateProductOutputPort {

    Product save(Product product);
}
