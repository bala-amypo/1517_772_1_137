package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import java.util.List;

public interface RolePermissionService {
    RolePermission save(RolePermission rolePermission);
    RolePermission getById(Long id);
    List<RolePermission> getAll();
    void delete(Long id);
}