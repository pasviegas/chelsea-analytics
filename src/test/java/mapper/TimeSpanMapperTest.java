package mapper;

import org.junit.Test;

public class TimeSpanMapperTest {
    @Test
    public void shouldAddValuesToTimeSpanColumnFamily() throws Exception {
        TimeSpanMapper timeSpanMapper = new TimeSpanMapper();
        timeSpanMapper.insertToTimeSpanColumnFamily(1,2,3);
    }
}
