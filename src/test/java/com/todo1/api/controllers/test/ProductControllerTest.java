package com.todo1.api.controllers.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo1.api.controllers.ProductBuyController;
import com.todo1.api.controllers.ProductRegistryController;
import com.todo1.api.controllers.ProductSaleController;

@SpringBootTest
public class ProductControllerTest {
	
	@Autowired
	private ProductBuyController buyController;
	
	@Autowired
	private ProductSaleController saleController;
	
	@Autowired
	private ProductRegistryController registryController;

	@Test
	public void buyControllerTest() throws Exception {
		assertThat(buyController).isNotNull();
	}
	
	@Test
	public void saleControllerTest() throws Exception {
		assertThat(saleController).isNotNull();
	}
	
	@Test
	public void registryControllerTest() throws Exception {
		assertThat(registryController).isNotNull();
	}
}
