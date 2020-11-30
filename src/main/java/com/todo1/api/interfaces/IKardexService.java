package com.todo1.api.interfaces;

import com.todo1.api.entities.Kardex;
import com.todo1.api.exceptions.ProductException;

public interface IKardexService {
	public Kardex getKardex() throws ProductException;
	public Kardex saveKardex(Kardex kardex);
}
