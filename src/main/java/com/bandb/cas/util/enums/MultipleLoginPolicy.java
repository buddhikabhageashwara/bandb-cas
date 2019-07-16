package com.bandb.cas.util.enums;

/**
 * @author buddika on 7/14/19
 * @project bandb-cas
 */
public enum MultipleLoginPolicy {

    PREVIOUS_USER_REMOVE(1,"previous session of user be removed"),
    DISALLOW_NEW_USER(2,"new session of user be disallowed");

    public final String multipleLoginPolicy;

    MultipleLoginPolicy(int iD, String multipleLoginPolicy) {
        this.multipleLoginPolicy = multipleLoginPolicy;
    }

}
