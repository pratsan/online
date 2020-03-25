/**
 * 
 */
package com.star.onlineshopping.service;

import java.util.List;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.UserException;

/**
 * @author Prateek
 * @since 2020-03-23
 *
 */
public interface ProductsService  {
	/**
	 * 
	 * @param email
	 * @return List of product detail based on user(normal or priority)
	 * @throws UserException
	 * @throws ProductException
	 */
	List<ProductsDto> getProductByEmail(String email) throws UserException,ProductException;

}
