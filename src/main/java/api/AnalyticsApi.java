package api;

import models.SKU;
import models.User;

public interface AnalyticsApi<T> {
    void addInfo(User user, SKU sku, T object);
}
