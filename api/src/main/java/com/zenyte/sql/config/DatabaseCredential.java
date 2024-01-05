package com.zenyte.sql.config;

public enum DatabaseCredential {
    
    LOCAL("localhost", "elvarg", "xx01$xz$Elvarg!Discord"),
    BETA_DOCKER("172.50.1.4", "zenyte", "HrvDRV`nKdW?=C7R:Y}j.-)4(u6[rS]="),
    ;
    
    private String host;
    private String user;
    private String pass;
    
    DatabaseCredential(final String host, final String user, final String pass) {
        this.host = host;
        this.user = user;
        this.pass = pass;
    }
    
    public String getHost() {
        return host;
    }
    
    public String getUser() {
        return user;
    }
    
    public String getPass() {
        return pass;
    }
}
