package service.impl;


import models.Price;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceServiceTest {
    private PriceService priceService;
    private User user;
    private Price price;
    private SKU sku;

    @Before
    public void setUp() throws Exception {
        priceService = new PriceService();
        user = mock(User.class);
        price = mock(Price.class);
        sku = mock(SKU.class);
    }

    @Test
    public void shouldGetUserId() throws Exception {
        when(user.identifier()).thenReturn(1);
        priceService.insertToDatabase(user, sku, price);
        verify(user).identifier();
    }

    @Test
    public void shouldGetSKUId() throws Exception {
        when(sku.identifier()).thenReturn(1);
        priceService.insertToDatabase(user, sku, price);
        verify(sku).identifier();
    }

}
