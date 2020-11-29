package com.todo1.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo1.api.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	public Optional<Product> findById(Integer id);
}