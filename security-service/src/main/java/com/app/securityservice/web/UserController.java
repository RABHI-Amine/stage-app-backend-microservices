package com.app.securityservice.web;

import com.app.securityservice.entities.AppUser;
import com.app.securityservice.service.AccountService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm  userForm){
        return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getPasswordConfirmation());
    }
}

@ToString
@Data
class UserForm{
    private String username;
    private String password;
    private String passwordConfirmation;
}
