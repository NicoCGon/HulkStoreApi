package com.todo1.api.services;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.api.entities.Kardex;
import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.interfaces.IKardexService;
import com.todo1.api.interfaces.IProductService;
import com.todo1.api.repositories.ProductRepository;

import lombok.extern.java.Log;

@Log
@Service
public class ProductServiceImpl implements IProductService{
	
	private final IKardexService kardexService;
	private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, IKardexService kardexService) {
        this.productRepository = productRepository;
        this.kardexService = kardexService;
    }
    
	@Override
	public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

	@Override
	//Se registra un nuevo producto con su stock y se suma al registro kardex
    public Product addProduct(Product product) throws ProductException{
		try {
			Kardex kardex = kardexService.getKardex();
			productRepository.save(product);
			kardex.setCounter(kardex.getCounter().add(product.getStock()));
			kardexService.saveKardex(kardex);
		}
		catch (ProductException productException) {
			log.severe(productException.getMessage());
			throw new ProductException("Inconsistencia de datos");
		}
    	return product;
    }

	@Override
	//Se compran uno o varios articulos del mismo producto expecificada en el campo 'stock' del objeto 'product' y se suma al registro kardex
	public Product upProduct(Product product) throws ProductException{
		try {
			Kardex kardex = kardexService.getKardex();
			product.setStock(product.getStock().add(product.getStock()));
			productRepository.save(product);
			kardex.setCounter(kardex.getCounter().add(product.getStock()));
		}
		catch (ProductException productException) {
			log.severe(productException.getMessage());
			throw new ProductException("Inconsistencia de datos");
		}
		return product;
	}

	@Override
	//Se venden cantidad de productos expecificada en el campo 'und' del objeto 'product' y se resta al stock y al registro kardex
	public Product downProduct(Product product) throws ProductException{
		try {
			if(hasStock(product) && hasAvaibleStock(product)) {
				Kardex kardex = kardexService.getKardex();
				product.setStock(product.getStock().subtract(product.getUnd()));
				productRepository.save(product);
				kardex.setCounter(kardex.getCounter().subtract(product.getUnd()));
				kardexService.saveKardex(kardex);
			}
		}
		catch (ProductException productException) {
			log.severe(productException.getMessage());
			throw productException;
		}
		return product;
	}
    
	@Override
	//Devuelve true si tiene stock
    public Boolean hasStock(Product product) throws ProductException{
    	if(product.getStock().compareTo(BigInteger.ZERO) <= 0) {
    		throw new ProductException(String.join(" ", "No hay stock para el producto:",product.getId().toString()));
    	}
    	
    	return Boolean.TRUE;
    }
    
	@Override
	//Devuelve true si se puede vender cierta cantidad dependiendo del stock
    public Boolean hasAvaibleStock(Product product) throws ProductException{
    	if(product.getStock().compareTo(product.getUnd()) <= 0) {
    		throw new ProductException(String.join(" ", "No se puede vender esta cantidad:",product.getId().toString()));
    	}
    	return Boolean.TRUE;
    }
}