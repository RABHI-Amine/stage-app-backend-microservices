package com.mactivites.mactivites.services;

import com.mactivites.mactivites.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> getAllRoles();
    public Optional<Role> getRoleById(Long id);
    public Role createRole(Role role);
    public void deleteRole(Long id);
}
