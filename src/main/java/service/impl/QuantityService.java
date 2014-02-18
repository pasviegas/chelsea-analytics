package service.impl;

import models.SKU;
import models.User;
import service.AnalyticsService;

public class QuantityService implements AnalyticsService<models.Quantity> {

    @Override
    public void insertToDatabase(User user, SKU sku, models.Quantity object) {
        int userId = user.identifier();
        int skuId = sku.identifier();

    }
}
