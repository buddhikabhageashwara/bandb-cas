package com.bandb.cas.util.enums;

/**
 * @author buddika on 6/30/19
 * @project bandb-cas
 */
public enum PasswordPolicyRule {

    AT_LEAST_ONE_LOWER_CASE(1,"password.validation.lowercase.fail"),
    AT_LEAST_ONE_UPPER_CASE(2,"password.validation.uppercase.fail"),
    AT_LEAST_ONE_NUMERIC(3,"password.validation.numeric.fail"),
    AT_LEAST_ONE_NON_ALPHANUMERIC_CHARACTER(4,"password.validation.alphanumeric.fail"),
    LENGTH_NOT_LESS_THAN_8(5,"password.validation.length.fail"),
    POLICY_PASSED(6,"password.validation.success");

    public final String messageProperty;

    PasswordPolicyRule(int iD, String messageProperty) {
        this.messageProperty = messageProperty;
    }

}
