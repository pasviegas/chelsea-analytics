package service.impl;

import models.Quantity;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class QuantityServiceTest {
    private QuantityService quantityService;
    private User user;
    private Quantity quantity;
    private SKU sku;

    @Before
    public void setUp() throws Exception {
        quantityService = new QuantityService();
        user = mock(User.class);
        quantity = mock(Quantity.class);
        sku = mock(SKU.class);
    }

    @Test
    public void shouldGetUserId() throws Exception {
        when(user.identifier()).thenReturn(1);
        quantityService.insertToDatabase(user, sku, quantity);
        verify(user).identifier();
    }

    @Test
    public void shouldGetSKUId() throws Exception {
        when(sku.identifier()).thenReturn(1);
        quantityService.insertToDatabase(user, sku, quantity);
        verify(sku).identifier();
    }
}
