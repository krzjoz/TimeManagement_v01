package com.jk.timemrgapp.web.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;


public class Utils {

    public static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public static String getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return String.valueOf(authentication.getAuthorities());
    }

}
