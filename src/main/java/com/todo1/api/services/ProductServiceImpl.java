package com.todo1.api.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.api.entities.Kardex;
import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.interfaces.IProductService;
import com.todo1.api.repositories.KardexRepository;
import com.todo1.api.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private KardexRepository kardexRepository;

	@Override
	public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

	@Override
    public Product addProduct(Product product) throws ProductException{
    	return product;
    }

	@Override
	public Product upProduct(Product product) throws ProductException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product downProduct(Product product) throws ProductException{
		if(hasStock(product.getId())) {
			Kardex kardex = (Kardex) Arrays.asList(kardexRepository.findAll()).stream().findFirst().orElseThrow(() -> new ProductException("No hay cargado un registro en kardex"));
			product.setStock(product.getStock().subtract(product.getUnd()));
			productRepository.save(product);
			kardex.setCounter(kardex.getCounter().subtract(product.getUnd()));
			kardexRepository.save(kardex);
		}
		return null;
	}
    
	@Override
    public Boolean hasStock(Integer id) throws ProductException{
    	Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("No existe el producto con este id"));
    	if(product.getStock().equals(0)) {
    		throw new ProductException("No hay stock para este producto");
    	}
    	return Boolean.TRUE;
    }
}