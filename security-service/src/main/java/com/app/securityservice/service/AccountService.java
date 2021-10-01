package com.app.securityservice.service;

import com.app.securityservice.entities.AppRole;
import com.app.securityservice.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(String username,String password,String passwordConfirmation);
    public AppRole saveRole(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String roleName);

}

