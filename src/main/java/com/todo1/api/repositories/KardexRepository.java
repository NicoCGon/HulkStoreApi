package com.todo1.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo1.api.entities.Kardex;

@Repository
public interface KardexRepository extends CrudRepository<Kardex, Integer> {
	public Optional<Kardex> findById(Integer id);
}