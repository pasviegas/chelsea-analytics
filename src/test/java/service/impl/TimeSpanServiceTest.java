package service.impl;

import models.TimeSpan;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TimeSpanServiceTest {
    private TimeSpanService timeSpanService;
    private User user;
    private TimeSpan quantity;
    private SKU sku;

    @Before
    public void setUp() throws Exception {
        timeSpanService = new TimeSpanService();
        user = mock(User.class);
        quantity = mock(TimeSpan.class);
        sku = mock(SKU.class);
    }

    @Test
    public void shouldGetUserId() throws Exception {
        when(user.identifier()).thenReturn(1);
        timeSpanService.insertToDatabase(user, sku, quantity);
        verify(user).identifier();
    }

    @Test
    public void shouldGetSKUId() throws Exception {
        when(sku.identifier()).thenReturn(1);
        timeSpanService.insertToDatabase(user, sku, quantity);
        verify(sku).identifier();
    }
}
