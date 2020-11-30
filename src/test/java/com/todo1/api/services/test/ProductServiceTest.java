package com.todo1.api.services.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

import java.math.BigInteger;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.todo1.api.entities.Kardex;
import com.todo1.api.entities.Product;
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.repositories.KardexRepository;
import com.todo1.api.repositories.ProductRepository;
import com.todo1.api.services.KardexServiceImpl;
import com.todo1.api.services.ProductServiceImpl;

/* Estos test se corren con junit4 */
public class ProductServiceTest {

    @Mock
    private ProductRepository mockProductRepository;
    @Mock
    private KardexRepository mockKardexRepository;

    private ProductServiceImpl productServiceUnderTest;
    private KardexServiceImpl kardexServiceUnderTest;
    private Product product;
    private Kardex kardex;

	@Before
    @SuppressWarnings("deprecation")
    public void setUp() {
        initMocks(this);
        kardexServiceUnderTest = new KardexServiceImpl(mockKardexRepository);
        productServiceUnderTest = new ProductServiceImpl(mockProductRepository, kardexServiceUnderTest);
        product = Product.builder()
		                .id(1)
		                .productName("Camisa Marvel")
		                .stock(new BigInteger("25"))
		                .url("https://www.google.com")
		                .und(new BigInteger("24"))
		                .build();

        kardex = Kardex.builder()
		                .id(1)
		                .counter(new BigInteger("25"))
		                .build();
        
        Mockito.when(mockProductRepository.save((Product) any())).thenReturn(product);
        Mockito.when(mockProductRepository.findById((Integer) any())).thenReturn(Optional.of(product));
        Mockito.when(mockKardexRepository.save((Kardex) any())).thenReturn(kardex);
        Mockito.when(mockKardexRepository.findById((Integer) any())).thenReturn(Optional.of(kardex));
    }

    @Test
    public void testFindById() {
        // Setup
        final String productName = "Camisa Marvel";
        final Optional<Product> result = productServiceUnderTest.findById(1);
        assertEquals(productName, result.get().getProductName());
    }

    @Test
    public void testAddProduct() {
        // Setup
        final String productName = "Camisa Marvel";
		try {
			Product result = productServiceUnderTest.addProduct(product);
		 	assertEquals(productName, result.getProductName());
		} catch (ProductException e) {
			assert(Boolean.FALSE);
		}
    }

    @Test
    public void testDownProduct() {
        // Setup
        final String productName = "Camisa Marvel";
		try {
			Product result = productServiceUnderTest.downProduct(product);
		 	assertEquals(productName, result.getProductName());
		} catch (ProductException e) {
			assert(Boolean.FALSE);
		}
    }

    @Test
    public void testRegistryProduct() {
        // Setup
        final String productName = "Camisa Marvel";
		try {
			Product result = productServiceUnderTest.upProduct(product);
		 	assertEquals(productName, result.getProductName());
		} catch (ProductException e) {
			assert(Boolean.FALSE);
		}
    }
    
    
}
