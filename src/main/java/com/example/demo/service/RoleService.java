package com.example.demo.service;

import com.example.demo.entity.Role;
import java.util.List;

public interface RoleService {
    Role save(Role role);
    Role update(Long id, Role role);
    Role getById(Long id);
    List<Role> getAll();
    void delete(Long id);
}