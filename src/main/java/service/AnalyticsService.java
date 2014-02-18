package service;

import models.SKU;
import models.User;

public interface AnalyticsService<T> {
    void insertToDatabase(User user, SKU sku, T object);
}
