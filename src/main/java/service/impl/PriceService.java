package service.impl;

import mapper.PriceMapper;
import models.Price;
import models.SKU;
import models.User;
import service.AnalyticsService;

public class PriceService implements AnalyticsService<Price> {

    @Override
    public void insertToDatabase(User user, SKU sku, Price price) {
        int userId = user.identifier();
        int skuId = sku.identifier();
        int priceValue = price.identifier();
        PriceMapper priceMapper = new PriceMapper();
        priceMapper.insertToPriceColumnFamily(userId, skuId, priceValue);
    }
}
