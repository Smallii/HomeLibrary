package com.home.library.userservice.config.password;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 没有使用
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
