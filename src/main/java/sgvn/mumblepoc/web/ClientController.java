package sgvn.mumblepoc.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgvn.mumblepoc.context.IceContext;
import sgvn.mumblepoc.ice.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final IceContext context;

    @PostMapping("/channels")
    void createChannel() throws InvalidSecretException, InvalidChannelException, ServerBootedException, NestingLimitException {
        ServerPrx server = context.getMetaPrx().getAllServers()[0];
        server.addChannel("sgvn-" + UUID.randomUUID(), 0);
    }
}