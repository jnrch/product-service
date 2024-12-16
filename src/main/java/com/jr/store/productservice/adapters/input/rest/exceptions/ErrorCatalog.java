package com.jr.store.productservice.adapters.input.rest.exceptions;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

  GENERIC_ERROR("ERR_001", "Oops! Something went wrong unexpectedly. Please try again later or contact support"),
  TYPE_MISMATCH_ERROR("ERR_002", "Please ensure the correct data type is used for this field."),
  ARGUMENT_NOT_VALID_ERROR("ERR_003", "Please ensure the correct data type is used or present."),
  PRODUCT_NOT_FOUND("ERR_004", "Product not found for given parameters.");

  private final String code;
  private final String message;

  ErrorCatalog(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
