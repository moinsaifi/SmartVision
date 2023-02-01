package com.catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.dto.ProductDto;
import com.catalogue.service.ProductService;
@RequestMapping("/api/product")
@RestController


public class ProductController {
	@Autowired
	private ProductService productservice;
	//Save method by using data transfer object 
	@PostMapping
	public ResponseEntity<ProductDto>createpost(@RequestBody ProductDto productdto){
		
		
		return new ResponseEntity<>(productservice.create(productdto),HttpStatus.CREATED);
	}
	@GetMapping
	public List<ProductDto>getAllRecord(){
		List<ProductDto> productdto = productservice.getAllRecord();
		
		return productdto;
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto>getRecordById(@PathVariable("id")long id){
		ProductDto productdto = productservice.getRecordById(id);
		
		return ResponseEntity.ok(productdto);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto>updateRecordById(@RequestBody ProductDto productdto,
			@PathVariable("id")long id	){
		
		        ProductDto newproduct = productservice.updateOneRecord(productdto,id);
		
		return new ResponseEntity<>(newproduct,HttpStatus.OK);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteOneRecord(@PathVariable("id")long id ){
		productservice.deleteProductById(id);
		return new ResponseEntity<>("product entity deleted successfully",HttpStatus.OK);
	}
	
	
	

}