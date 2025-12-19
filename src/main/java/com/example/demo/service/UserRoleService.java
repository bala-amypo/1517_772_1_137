package com.example.demo.service;

import com.example.demo.entity.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole save(UserRole userRole);
    UserRole getById(Long id);
    List<UserRole> getAll();
    void delete(Long id);
}