package api;

import models.SKU;
import models.User;

public abstract class BaseAnalyticsApi<T> implements AnalyticsApi<T> {
    protected User user;
    protected SKU sku;

    public User getUser() {
        return this.user;
    }

    public SKU getSKU() {
        return this.sku;
    }

    public abstract void add(T object);

    @Override
    public void addInfo(User user, SKU sku, T attribute) {
        this.user = user;
        this.sku = sku;
        add(attribute);
    }


}
