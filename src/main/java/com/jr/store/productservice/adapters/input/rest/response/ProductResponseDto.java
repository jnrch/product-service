package com.jr.store.productservice.adapters.input.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String id;
    private String name;
    private String description;
    private Double price;
}
