package com.bandb.cas.service;

import java.util.LinkedHashMap;

/**
 * @author buddika on 6/23/19
 * @project bandb-cas
 */
public interface UserService {

    LinkedHashMap isAUserExistForCredentials(String credential1, String credential2);

}
