package com.bandb.cas.service.impl;

import com.bandb.cas.repository.UserRepository;
import com.bandb.cas.service.UserService;
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
    public LinkedHashMap isAUserExistForCredentials(String credential1, String credential2) {
        return null;
    }
}
