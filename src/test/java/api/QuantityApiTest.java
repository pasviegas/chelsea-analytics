package api;

import models.Quantity;
import models.SKU;
import models.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class QuantityApiTest {
    private Quantity skuQuantity;
    private User user;
    private SKU sku;
    QuantityApi quantityApi;

    @Before
    public void setUp() throws Exception {
        skuQuantity = mock(Quantity.class);
        user = mock(User.class);
        sku = mock(SKU.class);
        quantityApi = spy(new QuantityApi());
    }

    @Test
    public void shouldAddUserInformation() throws Exception {
        quantityApi.addInfo(user, sku, skuQuantity);
        assertEquals(user, quantityApi.getUser());
    }

    @Test
    public void shouldAddSKUInformation() throws Exception {
        quantityApi.addInfo(user, sku, skuQuantity);
        assertEquals(sku, quantityApi.getSKU());
    }

    @Test
    public void shouldCallAddOnSKUPrice() throws Exception {
        quantityApi.addInfo(user, sku, skuQuantity);
        verify(quantityApi).add(skuQuantity);

    }

}
