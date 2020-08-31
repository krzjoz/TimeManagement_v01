package com.jk.timemrgapp.web.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypt {

    public static String encrypt(String password){
       BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
