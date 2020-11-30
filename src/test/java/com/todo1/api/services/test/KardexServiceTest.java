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
import com.todo1.api.exceptions.ProductException;
import com.todo1.api.repositories.KardexRepository;
import com.todo1.api.services.KardexServiceImpl;

/* Estos test se corren con junit4 */
public class KardexServiceTest {

    @Mock
    private KardexRepository mockKardexRepository;

    private KardexServiceImpl kardexServiceUnderTest;
    private Kardex kardex;

	@Before
    @SuppressWarnings("deprecation")
    public void setUp() {
        initMocks(this);
        kardexServiceUnderTest = new KardexServiceImpl(mockKardexRepository);

        kardex = Kardex.builder()
		                .id(1)
		                .counter(new BigInteger("5000000"))
		                .build();
        
        Mockito.when(mockKardexRepository.save((Kardex) any())).thenReturn(kardex);
        Mockito.when(mockKardexRepository.findById((Integer) any())).thenReturn(Optional.of(kardex));
    }

    @Test
    public void testFindById() {
        // Setup
        final BigInteger counter = new BigInteger("5000000");
		try {
			Kardex result = kardexServiceUnderTest.getKardex();
	        assertEquals(counter, result.getCounter());
	        
		} catch (ProductException e) {
			assert(Boolean.FALSE);
		}
    }

    @Test
    public void testSaveFirstKardex() {
        // Setup
        final BigInteger counter = new BigInteger("5000000");
		Kardex result = kardexServiceUnderTest.saveKardex(kardex);
        assertEquals(counter, result.getCounter());
    }
    
}
