package com.todo1.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.api.entities.Kardex;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.interfaces.IKardexService;
import com.todo1.api.repositories.KardexRepository;

@Service
public class KardexServiceImpl implements IKardexService{
	private final KardexRepository kardexRepository;

    @Autowired
    public KardexServiceImpl(KardexRepository kardexRepository) {
        this.kardexRepository = kardexRepository;
    }
    
	@Override
	public Kardex getKardex() throws ProductException{
		return (Kardex) kardexRepository.findById(1)
										.orElseThrow(() -> new ProductException("No hay cargado un registro en kardex, compruebe la consistencia de datos"));
	}

	@Override
	//Solamente puede haber un registro en el kardex
	public Kardex saveKardex(Kardex kardex){
		kardexRepository.deleteAll();
		return kardexRepository.save(kardex);
	}
}