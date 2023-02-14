package org.jano.web;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

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
    Emitter<String> accessEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String access() {
        System.out.println("Eae");

        CompletionStage<Void> ack = accessEmitter.send("user cristo tried to log in");

        return "access denied";
    }

}
