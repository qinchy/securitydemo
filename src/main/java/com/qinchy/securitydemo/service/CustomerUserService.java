package com.qinchy.securitydemo.service;

import com.qinchy.securitydemo.model.SysUser;
import com.qinchy.securitydemo.repository.SysUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

public class CustomerUserService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(CustomerUserService.class);

    @Resource
    SysUserRepository userRepository;

    // implents spring sedurity
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(s);
        if (null == user) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("SysUser{" +
                "id=" + user.getId() +
                ", username='" + user.getUsername() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", roles=" + user.getRoles() +
                '}');
        return user;
    }
}
