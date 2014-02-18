package api;

import models.Quantity;
import service.impl.QuantityService;

public class QuantityApi extends BaseAnalyticsApi<Quantity> {

    @Override
    public void add(Quantity quantity) {
        QuantityService quantityService = new QuantityService();
        quantityService.insertToDatabase(super.user, super.sku, quantity);
    }
}
