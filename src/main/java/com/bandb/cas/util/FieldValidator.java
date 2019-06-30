package com.bandb.cas.util;

import com.bandb.cas.model.User;
import com.bandb.cas.util.enums.ValidateType;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.*;

/**
 * @author buddika on 4/14/19
 * @project bandb-cas
 */
public class FieldValidator {

    final static Logger logger = Logger.getLogger(FieldValidator.class);

    @Autowired
    static MessageSource messageSource;

    public static LinkedHashMap validateField(LinkedHashMap validateData, User userBean){

        String validationType = "";
        String validationMessage = "";
        String messageProperty = "";
        LinkedHashMap validateResult = new LinkedHashMap<String,String>();
        String isValidationFailed = "true";
        Set entrySet = validateData.entrySet();
        Iterator it = entrySet.iterator();

        while(it.hasNext()) {

            Map.Entry mapEntry = (Map.Entry) it.next();

            validationType = mapEntry.getKey().toString();

            logger.debug("["+userBean.gettRXID()+"] - validation started for "+
                    mapEntry.getKey().toString()+" type");

            switch (ValidateType.valueOf(validationType)){

                case USERNAME_EMAIL_NOT_NULL_NOT_EMPTY:

                    messageProperty = validateEmail(mapEntry.getValue().toString());
                    break;

                case PASSWORD_POLICY_1:

                case PASSWORD_POLICY_2:

                case PASSWORD_POLICY_3:

                    messageProperty = validatePassword(mapEntry.getValue().toString(),
                            ValidateType.valueOf(validationType));
                    break;

                case STRING_NOT_NULL_NOT_EMPTY:

                    messageSource.getMessage("username.email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case INT_NOT_ZERO:

                    messageSource.getMessage("username.email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case OBJECT_NOT_NULL:

                    messageSource.getMessage("username.email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                case LINKED_LIST_NOT_NULL_NOT_ZERO_LENGTH:

                    messageSource.getMessage("username.email.validation.fail",
                            null, LocaleContextHolder.getLocale());

                    break;

                default :

                    logger.debug("["+userBean.gettRXID()+"] - there is no validation exist" +
                            " for such a type call "+validationType);

            }

            break;

        }

        if(messageProperty.contains(".fail")){
            isValidationFailed = "true";
        }else {
            isValidationFailed = "false";
        }
        validationMessage = messageSource.getMessage(messageProperty,
                null, LocaleContextHolder.getLocale());
        validateResult.put(isValidationFailed,validationMessage);

        logger.debug("["+userBean.gettRXID()+"] - validation done for "+
                validationType+" type and return "+isValidationFailed+
                " with "+validationMessage+" message ");

        return validateResult;

    }

    private static String validateEmail(String email){

        String messageProperty = "username.email.validation.success";

        if(email == null || email.isEmpty()){

            messageProperty = "username.email.validation.fail";

            return messageProperty;

        }else if (!EmailValidator.getInstance().isValid(email)){

            messageProperty = "username.email.validation.fail";

            return messageProperty;

        }

        return messageProperty;
    }

    private static String validatePassword(String password, ValidateType passwordPolicy){
        if(password == null || password.isEmpty()){
            return "password.validation.empty.fail";
        }
        return PasswordPolicyValidator.validate(password,passwordPolicy);
    }

}
