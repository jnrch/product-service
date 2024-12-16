package com.jr.store.productservice.adapters.input.rest;

import com.jr.store.productservice.adapters.input.rest.request.ProductRequestDto;
import com.jr.store.productservice.adapters.input.rest.response.ProductResponseDto;
import com.jr.store.productservice.adapters.output.mapper.mapper.ProductMapper;
import com.jr.store.productservice.domain.model.Product;
import com.jr.store.productservice.ports.input.CreateProductInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class CreateProductController {

    private final CreateProductInputPort createProductInputPort;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto request) {
        Product productCreated = createProductInputPort.createProduct(productMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(productMapper.toResponse(productCreated));
    }
}
