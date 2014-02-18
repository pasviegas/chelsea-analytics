package mapper;

import junit.framework.TestCase;
import org.junit.Test;

public class QuantityMapperTest {
    @Test
    public void shouldAddValuesToQuantityColumnFamily() throws Exception {
        QuantityMapper quantityMapper = new QuantityMapper();
        quantityMapper.insertToQuantityColumnFamily(1,2,3);
    }
}
