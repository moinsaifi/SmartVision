package com.catalogue.service;

import java.util.List;

import com.catalogue.dto.ProductDto;

public interface ProductService {
 public ProductDto create(ProductDto productdto);

public List<ProductDto> getAllRecord();

public ProductDto getRecordById(long id);

public ProductDto updateOneRecord(ProductDto productdto, long id);

public void deleteProductById(long id);
}
