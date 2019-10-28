package com.quanlykho.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.quanlykho.exception.ApplicationException;
import com.quanlykho.model.Employee;
import com.quanlykho.repository.base.EmployeeRepository;
import com.quanlykho.utils.MyUserPrincipal;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private EmployeeRepository userRepository;

    public CustomUserDetailService() {
        super();
    }

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(EmployeeRepository.class);
    }

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Employee user = userRepository.findByUserName(userName);

        if (user == null) {
            throw new ApplicationException("Username " + userName + " not found or password is not correct" );
        }
        if (user.getStatus().equals("deactive")) {
             throw new ApplicationException("Username " + userName + " deactive");
        }

        System.out.println("Found User: " + user.getUserName() + "         role: " + user.getRole());
        return new MyUserPrincipal(user);
    }

}
