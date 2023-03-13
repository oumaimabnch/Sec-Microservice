package com.insy2sproj.secmicroservice.service;

import com.insy2sproj.secmicroservice.Repositories.RoleRepo;
import com.insy2sproj.secmicroservice.entities.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@Transactional

public class RoleService {

     @Autowired
    private RoleRepo roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role role) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        existingRole.setName(role.getName());
        return roleRepository.save(existingRole);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}