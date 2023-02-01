package com.catalogue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogue.entities.Product;
import com.catalogue.repositories.ProductRepository;

@SpringBootTest
class SmartVisionApplicationTests {
	@Autowired
   private ProductRepository prorepo;
	@Test
	public void saveProduct() {
		Product pro=new Product();
		pro.setId(1L);
		pro.setName("L14");
		pro.setProductType("Washing Machine");
		pro.setCategory("electronics");
		pro.setBaseprice(17800.00);
		prorepo.save(pro);
	   assertNotNull(prorepo.findById(1L));
		
	}
	@Test
	public void readAllproduct() {
		  List<Product> list = prorepo.findAll();
		  assertThat(list).size().isGreaterThan(0);
	}
	
	 @Test
	public void testOneProduct() {
		 Product product = prorepo.findById(1L).get();
		 assertEquals(17800.00,product.getBaseprice() );
	 }
	 @Test
	 public void updateProduct() {
		 Product product = prorepo.findById(1L).get();
		 product.setBaseprice(12500.00);
		 prorepo.save(product);
		 assertNotEquals(17800.00, prorepo.findById(1L).get().getBaseprice());
	 }
	 @Test
	 public void deleteById() {
		 prorepo.deleteById(3L);
		 assertThat(prorepo.existsById(3L)).isFalse();
	 }
	
	
}
