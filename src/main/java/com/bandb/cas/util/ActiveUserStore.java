package com.bandb.cas.util;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buddika on 7/15/19
 * @project bandb-cas
 */
public class ActiveUserStore {

    public List<String> users;

    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

    @Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
