package src.test.com.jk.timemrgapp.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoding {

    @Test
    void getBCryptPassword(){

        final String PASSWORD = "admin";
        final String PASSWORD1 = "user";
        final String PASSWORD2 = "test";

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(PASSWORD));
        System.out.println(passwordEncoder.encode(PASSWORD1));
        System.out.println(passwordEncoder.encode(PASSWORD2));
    }

}
