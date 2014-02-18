package service.impl;

import models.SKU;
import models.TimeSpan;
import models.User;
import service.AnalyticsService;

public class TimeSpanService implements AnalyticsService<TimeSpan> {

    @Override
    public void insertToDatabase(User user, SKU sku, TimeSpan object) {
        int userId = user.identifier();
        int skuId = sku.identifier();
    }
}
