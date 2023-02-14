package org.jano.domain.repositories;

public class AccessLog {
    String IP;
    String username;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccessLog(String IP, String username) {
        this.IP = IP;
        this.username = username;
    }
}
