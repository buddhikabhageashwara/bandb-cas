package com.bandb.cas.util.enums;

/**
 * @author buddika on 7/14/19
 * @project bandb-cas
 */
public enum AuthenticationType {

    USERNAME_PASSWORD(1,"username password based authentication type"),
    FACEID(2,"faceid based authentication type"),
    SAML(3,"SAML based authentication type");

    public final String description;

    AuthenticationType(int iD, String description) {
        this.description = description;
    }

}
