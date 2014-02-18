package mapper;


import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.OperationResult;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.CqlResult;
import com.netflix.astyanax.serializers.IntegerSerializer;
import com.netflix.astyanax.serializers.StringSerializer;
import database.ClientServerConnection;
import static mapper.KeySpaceConstants.*;

public class PriceMapper {

    private final AstyanaxContext<Keyspace> context;
    private final Keyspace keyspace;
    static final String PRICE_CF_NAME = "price";
    private ColumnFamily<Integer, String> PRICE_CF;
    private static final String COL_NAME_PRICE = "price";
    private static final String INSERT_STATEMENT =
            String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, dateof(now()));",
                    PRICE_CF_NAME, COL_NAME_USER_ID, COL_NAME_SKU_ID, COL_NAME_PRICE, COL_NAME_ADD_TIME);

    public PriceMapper() {
        ClientServerConnection clientServerConnection = new ClientServerConnection();
        context = clientServerConnection.getContext();
        keyspace = clientServerConnection.getKeyspace();
        PRICE_CF = ColumnFamily.newColumnFamily(
                PRICE_CF_NAME,
                IntegerSerializer.get(),
                StringSerializer.get());
    }

    public void insertToPriceColumnFamily(int userId, int skuId, int priceValue) {
        try {
            OperationResult<CqlResult<Integer, String>> result = keyspace
                    .prepareQuery(PRICE_CF)
                    .withCql(INSERT_STATEMENT)
                    .asPreparedStatement()
                    .withIntegerValue(userId)
                    .withIntegerValue(skuId)
                    .withIntegerValue(priceValue)
                    .execute();
        } catch (ConnectionException e) {
            throw new RuntimeException("Failed to write to column", e);
        }
    }
}
