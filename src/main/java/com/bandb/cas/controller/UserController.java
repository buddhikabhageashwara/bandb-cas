package com.bandb.cas.controller;

import com.bandb.cas.model.User;
import com.bandb.cas.repository.UserRepository;
import com.bandb.cas.util.FieldValidator;
import com.bandb.cas.util.enums.ValidateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

// LinkedHashMap Map Sections--> validate type id, value
// return                    --> message, boolean

    @PostMapping("/credential/validate")
    public String validateUser(User user) {

        LinkedHashMap userNameValidateResult=FieldValidator.validateField(new LinkedHashMap()
        {{
            put(ValidateType.EMAIL_NOT_NULL_NOT_EMPTY,user.getcASUsername());
        }});

        return "hi this is a test";

    }

}
