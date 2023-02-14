package org.jano.web;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jano.domain.repositories.AccessLog;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoggerResource {

    @Incoming("access")
    public void consumeAccess(AccessLog access) {
        System.out.println(access.getIP());
    }
}
