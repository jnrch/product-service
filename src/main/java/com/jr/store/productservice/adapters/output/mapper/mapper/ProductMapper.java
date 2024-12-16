package com.jr.store.productservice.adapters.output.mapper.mapper;

import com.jr.store.productservice.adapters.input.rest.request.ProductRequestDto;
import com.jr.store.productservice.adapters.input.rest.response.ProductResponseDto;
import com.jr.store.productservice.domain.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductRequestDto productRequest);

    ProductResponseDto toResponse(Product product);
}
