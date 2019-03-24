package ru.findplace.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {
    public static String getEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
