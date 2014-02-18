package api;

import models.TimeSpan;
import service.impl.TimeSpanService;

public class TimeSpanApi extends BaseAnalyticsApi<TimeSpan> {

    @Override
    public void add(TimeSpan timeSpan) {
        TimeSpanService timeSpanService = new TimeSpanService();
        timeSpanService.insertToDatabase(super.user, super.sku, timeSpan);
    }
}
