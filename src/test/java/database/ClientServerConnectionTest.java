package database;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class ClientServerConnectionTest{
    private ClientServerConnection clientServerConnection;

    @Before
    public void setUp() throws Exception {
        clientServerConnection = new ClientServerConnection();
    }

    @Test
    public void testConnectionEstablishment() throws Exception {
        AstyanaxContext<Keyspace> context = clientServerConnection.getContext();
        assertNotNull(context);
    }

}
