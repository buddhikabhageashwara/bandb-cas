package com.bandb.cas.controller;

import com.bandb.cas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author buddika on 4/7/19
 * @project bandb-cas
 */
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/testtest")
    public String validateUser() {
        return "hi this is a test";
    }

}
