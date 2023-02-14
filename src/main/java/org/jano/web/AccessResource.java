package org.jano.web;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.vertx.ext.web.RoutingContext;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jano.domain.repositories.AccessLog;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/access")
public class AccessResource {

    @Inject
    @Broadcast
    @Channel("access")
    Emitter<AccessLog> accessEmitter;

    @Inject
    RoutingContext context;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String access() {
        String ip = context.request().host();
        AccessLog accessLog = new AccessLog(ip, "cristo" );
        System.out.println("Eae");

        CompletionStage<Void> ack = accessEmitter.send(accessLog);

        return "access denied";
    }

}
