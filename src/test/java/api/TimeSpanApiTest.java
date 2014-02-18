package api;

import models.TimeSpan;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class TimeSpanApiTest {
    private TimeSpan skuTimeSpan;
    private User user;
    private SKU sku;
    TimeSpanApi timeSpanApi;

    @Before
    public void setUp() throws Exception {
        skuTimeSpan = mock(TimeSpan.class);
        user = mock(User.class);
        sku = mock(SKU.class);
        timeSpanApi = spy(new TimeSpanApi());
    }

    @Test
    public void shouldAddUserInformation() throws Exception {
        timeSpanApi.addInfo(user, sku, skuTimeSpan);
        assertEquals(user, timeSpanApi.getUser());
    }

    @Test
    public void shouldAddSKUInformation() throws Exception {
        timeSpanApi.addInfo(user, sku, skuTimeSpan);
        assertEquals(sku, timeSpanApi.getSKU());
    }

    @Test
    public void shouldCallAddOnSKUTimeSpan() throws Exception {
        timeSpanApi.addInfo(user, sku, skuTimeSpan);
        verify(timeSpanApi).add(skuTimeSpan);

    }

}
