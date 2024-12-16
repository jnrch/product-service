package com.jr.store.productservice.adapters.input.rest;

import com.jr.store.productservice.adapters.input.rest.response.ProductResponseDto;
import com.jr.store.productservice.adapters.output.mapper.mapper.ProductMapper;
import com.jr.store.productservice.ports.input.GetProductInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GetProductController {

    private final GetProductInputPort getProductInputPort;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productMapper.toResponse(getProductInputPort.getProduct(id)));
    }
}
