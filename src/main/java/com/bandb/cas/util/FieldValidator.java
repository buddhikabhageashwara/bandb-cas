package com.bandb.cas.util;

import com.bandb.cas.util.enums.ValidateType;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.*;

/**
 * @author buddika on 4/14/19
 * @project bandb-cas
 */
public class FieldValidator {

    @Autowired
    static MessageSource messageSource;

    public static LinkedHashMap validateField(LinkedHashMap validateData){

        LinkedHashMap validateResult=null;

        boolean isValidationFailed=true;

        Set entrySet = validateData.entrySet();

        Iterator it = entrySet.iterator();

        while(it.hasNext()) {

            Map.Entry mapEntry = (Map.Entry) it.next();

            switch (ValidateType.valueOf( mapEntry.getKey().toString() )){

                case EMAIL_NOT_NULL_NOT_EMPTY:

                    validateResult=new LinkedHashMap<String,String>();

                    isValidationFailed=validateEmail(mapEntry.getValue().toString());

                    if(isValidationFailed){


                        validateResult.put(messageSource.getMessage("email.validation.fail",
                                null, LocaleContextHolder.getLocale()),isValidationFailed);

                    }else {

                        validateResult.put(messageSource.getMessage("email.validation.success",
                                null, LocaleContextHolder.getLocale()),isValidationFailed);

                    }

                    break;

                case STRING_NOT_NULL_NOT_EMPTY:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case INT_NOT_ZERO:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case OBJECT_NOT_NULL:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;


                case LINKED_LIST_NOT_NULL_NOT_ZERO_LENGTH:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case PASSWORD_AT_LEAST_ONE_LOWER_CASE:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case PASSWORD_AT_LEAST_ONE_UPPER_CASE:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case PASSWORD_AT_LEAST_ONE_DIGIT:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case PASSWORD_AT_LEAST_ONE_NON_ALPHANUMERIC_CHARACTER:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case PASSWORD_LENGTH_NOT_LESS_THAN_8:

                    messageSource.getMessage("email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                default :

            }

            break;

        }

        return validateResult;

    }

    private static boolean validateEmail(String email){

        boolean isValidationFail=false;

        if(email==null || email.isEmpty()){

            isValidationFail=true;

            return isValidationFail;

        }else if (!EmailValidator.getInstance().isValid(email)){

            isValidationFail=true;

            return isValidationFail;

        }

        return isValidationFail;
    }

}
