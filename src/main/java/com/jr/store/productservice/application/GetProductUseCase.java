package com.jr.store.productservice.application;

import com.jr.store.productservice.domain.service.GetProductService;
import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.input.GetProductInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetProductUseCase implements GetProductInputPort {

    private static final Logger LOG = LoggerFactory.getLogger(GetProductUseCase.class);

    private final GetProductService getProductService;

    public GetProductUseCase(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Override
    public Product getProduct(Long id) {
        LOG.info("Getting product by id: {}", id);
        return getProductService.getProductById(id);
    }
}
