package com.mactivites.mactivites.controllers;


import com.mactivites.mactivites.entities.Role;
import com.mactivites.mactivites.services.RoleService;
import com.mactivites.mactivites.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ms1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    private List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    private Optional<Role> getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @PostMapping("/roles")
    private Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @DeleteMapping("/roles/{id}")
    private void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
}
