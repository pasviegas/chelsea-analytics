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

public class QuantityMapper {

    private static ColumnFamily<Integer, String> QUANTITY_CF;
    private final AstyanaxContext<Keyspace> context;
    private final Keyspace keyspace;
    static final String QUANTITY_CF_NAME = "quantity";
    static final String COL_NAME_QUANTITY = "quantity";


    private static final String INSERT_STATEMENT =
            String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, dateof(now()));",
                    QUANTITY_CF_NAME, COL_NAME_USER_ID, COL_NAME_SKU_ID, COL_NAME_QUANTITY, COL_NAME_ADD_TIME);

    public QuantityMapper() {
        ClientServerConnection clientServerConnection = new ClientServerConnection();
        context = clientServerConnection.getContext();
        keyspace = clientServerConnection.getKeyspace();
        QUANTITY_CF = ColumnFamily.newColumnFamily(
                QUANTITY_CF_NAME,
                IntegerSerializer.get(),
                StringSerializer.get());
    }

    public void insertToQuantityColumnFamily(int userId, int skuId, int priceValue) {
        try {
            OperationResult<CqlResult<Integer, String>> result = keyspace
                    .prepareQuery(QUANTITY_CF)
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
