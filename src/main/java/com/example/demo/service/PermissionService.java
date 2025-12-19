package com.example.demo.service;

import com.example.demo.entity.Permission;
import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);
    Permission update(Long id, Permission permission);
    Permission getById(Long id);
    List<Permission> getAll();
    void delete(Long id);
}