package database;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;

public class ClientServerConnection {
    private static final String CQL_VERSION = "3.0.0";
    private static final String CASSANDRA_VERSION = "1.2";
    private static final String CASSANDRA_SERVER_ADDRESS = "127.0.0.1:9160";
    private static final String CONNECTION_POOL = "ConnectionPool";
    private static final String CLUSTER_NAME = "Test Cluster";
    private static final String KEYSPACE_NAME = "analytics";
    public static final int PORT = 9160;
    public static final int MAX_CONNS = 1;
    private AstyanaxContext<Keyspace> context;
    private Keyspace keyspace;

    public ClientServerConnection() {
        this.context = new AstyanaxContext.Builder()
                .forCluster(CLUSTER_NAME)
                .forKeyspace(KEYSPACE_NAME)
                .withAstyanaxConfiguration(new AstyanaxConfigurationImpl()
                        .setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE)
                )
                .withConnectionPoolConfiguration(new ConnectionPoolConfigurationImpl(CONNECTION_POOL)
                        .setPort(PORT)
                        .setMaxConnsPerHost(MAX_CONNS)
                        .setSeeds(CASSANDRA_SERVER_ADDRESS)
                )
                .withAstyanaxConfiguration(new AstyanaxConfigurationImpl()
                        .setCqlVersion(CQL_VERSION)
                        .setTargetCassandraVersion(CASSANDRA_VERSION))
                .withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
                .buildKeyspace(ThriftFamilyFactory.getInstance());

        this.context.start();
        this.keyspace = this.context.getClient();
    }

    public AstyanaxContext<Keyspace> getContext() {
        return context;
    }

    public Keyspace getKeyspace() {
        return keyspace;
    }
}