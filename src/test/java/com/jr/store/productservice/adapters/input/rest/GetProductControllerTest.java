package com.jr.store.productservice.adapters.input.rest;

import com.jr.store.productservice.domain.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetProductById() throws Exception {
        Long id = 1L;
        Product product = new Product(id, "product_1", "description_1", 20.00);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(product.getName()))
                .andExpect(jsonPath("$.description").value(product.getDescription()))
                .andExpect(jsonPath("$.price").value(product.getPrice()));
    }

    @Test
    public void shouldReturnNotFoundWhenProductDoesNotExist() throws Exception {
        Long id = 999L;

        mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}