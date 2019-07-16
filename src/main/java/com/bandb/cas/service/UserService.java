package com.bandb.cas.service;

import com.bandb.cas.model.User;
import com.bandb.cas.util.enums.AuthenticationType;

import java.util.LinkedHashMap;

/**
 * @author buddika on 6/23/19
 * @project bandb-cas
 */
public interface UserService {

    boolean isAUserExistForCredentials(AuthenticationType authenticationType,
                                             User userBean, String credential1, String credential2);

}
