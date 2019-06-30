package com.bandb.cas.util;


import com.bandb.cas.util.enums.ValidateType;

import static com.bandb.cas.util.enums.PasswordPolicyRule.*;

/**
 * @author buddika on 6/30/19
 * @project bandb-cas
 */
public class PasswordPolicyValidator {

    static String validate(String password, ValidateType passwordPolicy){

        switch (passwordPolicy) {

            case PASSWORD_POLICY_1:

                if(isALowerCaseExist(password)){
                    if(isAUpperCaseExist(password)){
                        if(isLengthNotLessThan8(password)){
                            if(isANoneAlphanumericExist(password)){
                                if(isANumericExist(password)){
                                    break;
                                }else {
                                    return AT_LEAST_ONE_NUMERIC.messageProperty;
                                }
                            }else {
                                return AT_LEAST_ONE_NON_ALPHANUMERIC_CHARACTER.messageProperty;
                            }
                        }else {
                            return LENGTH_NOT_LESS_THAN_8.messageProperty;
                        }
                    }else {
                        return AT_LEAST_ONE_UPPER_CASE.messageProperty;
                    }
                }else{
                    return AT_LEAST_ONE_LOWER_CASE.messageProperty;
                }

            case PASSWORD_POLICY_2:

                break;

            case PASSWORD_POLICY_3:

        }

        return POLICY_PASSED.messageProperty;
    }

    private static boolean isALowerCaseExist(String password){
        return !password.equals(password.toUpperCase());
    }

    private static boolean isAUpperCaseExist(String password){
        return !password.equals(password.toLowerCase());
    }

    private static boolean isLengthNotLessThan8(String password){
        return password.length() > 7;
    }

    private static boolean isANoneAlphanumericExist(String password){
        return !password.matches("[A-Za-z0-9]*");
    }

    private static boolean isANumericExist(String password){
        return password.matches(".*[0-9].*");
    }


}
