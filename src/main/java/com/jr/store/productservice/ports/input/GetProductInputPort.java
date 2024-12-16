package com.jr.store.productservice.ports.input;

import com.jr.store.productservice.domain.model.Product;

public interface GetProductInputPort {

    Product getProduct(Long id);
}
