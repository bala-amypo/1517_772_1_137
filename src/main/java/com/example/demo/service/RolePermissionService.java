package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import java.util.List;

public interface RolePermissionService {

    RolePermission grantPermission(RolePermission mapping);

    List<RolePermission> getAllMappings();

    RolePermission getMappingById(Long id);

    void revokePermission(Long id);
}