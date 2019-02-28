package ru.findplace.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.findplace.demo.entity.Role;
import ru.findplace.demo.entity.User;
import ru.findplace.demo.repository.UserRepository;

import java.util.*;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.repository.findByEmail(email);
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(r -> roles.add(r.getAuthority()));
        String[] strRoles = Arrays.copyOf(roles.toArray(), roles.size(), String[].class);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                AuthorityUtils.createAuthorityList(strRoles));
    }

}
