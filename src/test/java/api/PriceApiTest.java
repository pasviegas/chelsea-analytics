package api;

import models.Price;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;


public class PriceApiTest {
    private Price skuPrice;
    private User user;
    private SKU sku;
    PriceApi priceApi;

    @Before
    public void setUp() throws Exception {
        skuPrice = mock(Price.class);
        user = mock(User.class);
        sku = mock(SKU.class);
        priceApi = spy(new PriceApi());
    }

    @Test
    public void shouldAddUserInformation() throws Exception {
        priceApi.addInfo(user, sku, skuPrice);
        assertEquals(user, priceApi.getUser());
    }

    @Test
    public void shouldAddSKUInformation() throws Exception {
        priceApi.addInfo(user, sku, skuPrice);
        assertEquals(sku, priceApi.getSKU());
    }

    @Test
    public void shouldCallAddOnSKUPrice() throws Exception {
        priceApi.addInfo(user, sku, skuPrice);
        verify(priceApi).add(skuPrice);
    }

}
