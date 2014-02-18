package mapper;


import org.junit.Test;


public class PriceMapperTest{
    @Test
    public void shouldAddValuesToPriceColumnFamily() throws Exception {
        PriceMapper priceMapper = new PriceMapper();
        priceMapper.insertToPriceColumnFamily(1,2,3);
    }

}
