package com.todo1.api.interfaces;

import java.util.Optional;

import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;

public interface IProductService {
	public Optional<Product> findById(Integer id);
	public Product addProduct(Product product) throws ProductException;
	public Product upProduct(Product product) throws ProductException;
	public Product downProduct(Product product) throws ProductException;
	public Boolean hasStock(Integer id) throws ProductException;
}
