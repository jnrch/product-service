package com.jr.store.productservice.adapters.output.jpa;

import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.output.CreateProductOutputPort;
import com.jr.store.productservice.ports.output.GetProductOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductJpaAdapter implements GetProductOutputPort, CreateProductOutputPort {

    private final ProductRepository productRepository;

    public ProductJpaAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(entity);
        return mapToDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(this::mapToDomain);
    }

    private Product mapToDomain(ProductEntity entity) {
        return new Product(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }

    private ProductEntity mapToEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        return entity;
    }
}
