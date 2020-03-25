package com.star.onlineshopping.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.UserException;
import com.star.onlineshopping.service.ProductsService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	@InjectMocks
	ProductsController productController;
	@Mock
	ProductsService productsService;
	ProductsDto productDto=new ProductsDto();
	List<ProductsDto> productList=new ArrayList<ProductsDto>();
	@Before
	public void init()
	{
		productDto.setDescription("football");
		productDto.setName("football");
		productDto.setPrice(2000.23);
		productDto.setProductCode("A123");
		productDto.setType("priority");
		productList.add(productDto);
	}
	@Test
	public void getProductByEmailTest() throws UserException, ProductException
	{
		Mockito.when(productsService.getProductByEmail("prateek@gmail")).thenReturn(productList);
		ResponseEntity<List<ProductsDto>> proList=productController.getProductByEmail("prateek@gmail");
		assertEquals(1,proList.getBody().size());
		
		
	}

}
