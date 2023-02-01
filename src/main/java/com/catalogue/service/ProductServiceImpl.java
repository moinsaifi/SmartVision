package com.catalogue.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogue.dto.ProductDto;
import com.catalogue.entities.Product;
import com.catalogue.repositories.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository postrepo;

	@Override
	public ProductDto create(ProductDto productdto) {
		 Product product = mapToEntity(productdto);
		 
	       Product productEntity = postrepo.save(product);
	       
	      ProductDto dto= mapToDto(productEntity);
		return dto;
	}
	
	public Product mapToEntity(ProductDto productdto) {
		
		Product product=new Product();
		product.setId(productdto.getId());
		product.setName(productdto.getName());
		product.setBaseprice(productdto.getBaseprice());
	     product.setProductType(productdto.getProductType());
	     product.setCategory(productdto.getCategory());
		return product;
	}
	
	public ProductDto mapToDto(Product product){
		ProductDto dto =new ProductDto();
	       dto.setId(product.getId());
	       dto.setName(product.getName());
	       dto.setCategory(product.getCategory());
	       dto.setBaseprice(product.getBaseprice());
	       dto.setProductType(product.getProductType());
		return dto;
		
	}

	@Override
	public List<ProductDto> getAllRecord() {
		List<Product> find = postrepo.findAll();
		  List<ProductDto> datadto = find.stream().map(dto->mapToDto(dto)).collect(Collectors.toList());
		return datadto;
	}

	@Override
	public ProductDto getRecordById(long id) {
		  Optional<Product> findById = postrepo.findById(id);
		             Product product = findById.get();
		             ProductDto productdto = mapToDto(product);
		             
		return productdto;
	}

	@Override
	public ProductDto updateOneRecord(ProductDto productdto, long id) {
		      Optional<Product> findById = postrepo.findById(id);
		      Product product = findById.get();
		      product.setProductType(productdto.getProductType());
		      product.setName(productdto.getName());
		      product.setId(productdto.getId());
		      product.setCategory(productdto.getCategory());
		      product.setBaseprice(productdto.getBaseprice());
		      Product newproduct = postrepo.save(product);
		return mapToDto(newproduct);
	}

	@Override
	public void deleteProductById(long id) {
		postrepo.deleteById(id);
		
	}

	
	

	
	
	
}
