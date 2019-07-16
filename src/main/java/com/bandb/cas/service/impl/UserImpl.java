package com.bandb.cas.service.impl;

import com.bandb.cas.model.User;
import com.bandb.cas.repository.UserRepository;
import com.bandb.cas.service.UserService;
import com.bandb.cas.util.enums.AuthenticationType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

/**
 * @author buddika on 6/23/19
 * @project bandb-cas
 */
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isAUserExistForCredentials(AuthenticationType authenticationType,
                                                    User userBean, String credential1, String credential2) {

        switch (authenticationType) {

            case USERNAME_PASSWORD:

                break;

            case FACEID:

                break;

            default:

        }

        return false;

    }
}
