package api;

import models.Price;
import service.impl.PriceService;

public class PriceApi extends BaseAnalyticsApi<Price> {

    @Override
    public void add(Price price) {
        PriceService priceService = new PriceService();
        priceService.insertToDatabase(super.user, super.sku, price);
    }

}
