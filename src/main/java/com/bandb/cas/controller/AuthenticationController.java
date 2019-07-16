package com.bandb.cas.controller;

import com.bandb.cas.model.User;
import com.bandb.cas.service.impl.UserImpl;
import com.bandb.cas.util.FieldValidator;
import com.bandb.cas.util.enums.AuthenticationType;
import com.bandb.cas.util.enums.ValidateType;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
@RestController
@RequestMapping("user")
public class AuthenticationController {

    final Logger logger = Logger.getLogger(AuthenticationController.class);

    private ApplicationContext context;

    User userBean = context.getBean(User.class);

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserImpl userImpl;

    @PostMapping("/authorize/usernamepassword")
    public User authorizeForUsernamePassword(HttpServletRequest request, User user) {

        JSONObject json = new JSONObject(user);
        userBean.settRXID(UUID.randomUUID().toString());
        logger.debug("[API CALL Request] [POST] ["+userBean.gettRXID()+"] - "+
                request.getRequestURL()+"  "+json.toString());

        LinkedHashMap passwordValidateResult = FieldValidator.validateField(new LinkedHashMap()
        {{
            put(ValidateType.PASSWORD_POLICY_1,user.getcASPassword());
        }},userBean);

        if(passwordValidateResult.get("true") != null){
            LinkedHashMap userNameValidateResult = FieldValidator.validateField(new LinkedHashMap()
            {{
                put(ValidateType.USERNAME_EMAIL_NOT_NULL_NOT_EMPTY,user.getcASUsername());
            }},userBean);

            if(userNameValidateResult.get("true") != null){

                if(userImpl.isAUserExistForCredentials(AuthenticationType.USERNAME_PASSWORD,userBean,
                        user.getcASUsername(),user.getcASPassword()) && userBean.isAllowMultipleLogin()){



                }

                user.setcASPassword("");
                user.setcASUsername("");
                return user;
            }else {
                user.setcASPassword("");
                user.setcASUsername("");
                user.setMessage(userNameValidateResult.get("false").toString());
                return user;
            }
        }else {
            user.setcASPassword("");
            user.setcASUsername("");
            // detail password validation fail message is avoided to present in login page
            user.setMessage(messageSource.getMessage("password.validation.fail",
                    null, LocaleContextHolder.getLocale()));
            return user;
        }
    }

    @PostMapping("/authorize/faceid")
    public User authorizeForFaceID(HttpServletRequest request, User user) {

        return null;

    }

}
