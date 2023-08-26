package sgvn.mumblepoc.context;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Exception;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sgvn.mumblepoc.ice.MetaPrx;

@Service
@Getter
@Setter
@Slf4j
public class IceContext {

    @Value("${ice.server.address}")
    private String serverIceIpAddr;

    @Value("${ice.server.port}")
    private String serverIcePort;

    @Value("${ice.connection.timeout}")
    private String iceConnectionTimeout;

    private MetaPrx metaPrx;

    @PostConstruct
    public void initialize() {
        String connectionStr = String.format("Meta:tcp -h %s -p %s -t %s", serverIceIpAddr, serverIcePort, iceConnectionTimeout);

        InitializationData initializationData = new InitializationData();
        initializationData.properties = Util.createProperties();
        initializationData.properties.setProperty("Ice.ImplicitContext", "Shared");
        initializationData.properties.setProperty("Ice.MessageSizeMax", "65536");
        initializationData.properties.setProperty("Ice.Trace.Network", "1");
        initializationData.properties.setProperty("Ice.Trace.Protocol", "1");
        ObjectPrx objectPrx;

        try {
            Communicator initialize = Util.initialize(initializationData);
            initialize.getImplicitContext().put("secret", "secret");
            objectPrx = initialize.stringToProxy(connectionStr);
            objectPrx.ice_ping();
            metaPrx = MetaPrx.checkedCast(objectPrx);

            String connectStr = "tcp -h 127.0.0.1 -p 6502 -t 60000";
            ObjectAdapter objectAdapterWithEndpoints = initialize.createObjectAdapterWithEndpoints("Callback.Client", connectStr);
            objectAdapterWithEndpoints.activate();
            metaPrx.ice_ping();
        } catch (Exception ex) {
            log.error("Error: ", ex);
        }
    }
}
