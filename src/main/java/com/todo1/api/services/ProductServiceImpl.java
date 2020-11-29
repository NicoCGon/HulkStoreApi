package com.todo1.api.services;

import java.math.BigInteger;
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

import lombok.extern.java.Log;

@Log
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
	//Se registra un nuevo producto con su stock y se suma al registro kardex
    public Product addProduct(Product product) throws ProductException{
		try {
			Kardex kardex = getKardex();
			productRepository.save(product);
			kardex.setCounter(kardex.getCounter().add(product.getStock()));
			kardexRepository.save(kardex);
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
			Kardex kardex = getKardex();
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
	//Se venden cantidad de productos expecificada en el campo 'und' del objeto 'product' y se resta al registro kardex
	public Product downProduct(Product product) throws ProductException{
		try {
			if(hasStock(product.getId())) {
				Kardex kardex = getKardex();
				product.setStock(product.getStock().subtract(product.getUnd()));
				productRepository.save(product);
				kardex.setCounter(kardex.getCounter().subtract(product.getUnd()));
				kardexRepository.save(kardex);
			}
		}
		catch (ProductException productException) {
			log.severe(productException.getMessage());
			throw productException;
		}
		return product;
	}
    
	@Override
    public Boolean hasStock(Integer id) throws ProductException{
    	Product product = productRepository.findById(id)
    										.orElseThrow(() -> new ProductException("No existe el producto con este id"));
    	if(product.getStock().compareTo(BigInteger.ZERO) <= 0) {
    		throw new ProductException(String.join(" ", "No hay stock para el producto:",id.toString()));
    	}
    	return Boolean.TRUE;
    }

	@Override
	public Kardex getKardex() throws ProductException{
		return (Kardex) Arrays.asList(kardexRepository.findAll())
								.stream().findFirst().orElseThrow(() -> new ProductException("No hay cargado un registro en kardex, compruebe la consistencia de datos"));
	}
}