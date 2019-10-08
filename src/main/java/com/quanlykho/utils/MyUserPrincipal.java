package com.quanlykho.utils;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.quanlykho.model.Employee;

public class MyUserPrincipal extends org.springframework.security.core.userdetails.User {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Employee user;

    public MyUserPrincipal(Employee user){
        super(user.getUserName(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
    }

}
