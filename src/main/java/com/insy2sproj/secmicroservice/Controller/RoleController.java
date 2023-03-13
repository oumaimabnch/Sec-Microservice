package com.insy2sproj.secmicroservice.Controller;

import com.insy2sproj.secmicroservice.entities.Role;
import com.insy2sproj.secmicroservice.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/roles")
@RequiredArgsConstructor
public class RoleController {
        private final RoleService roleService;
        @GetMapping
        public ResponseEntity<List<Role>> getAllRoles() {
            List<Role> roles = roleService.getAllRoles();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
            Role role = roleService.getRoleById(id);
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        @PostMapping
        public ResponseEntity<Role> createRole(@RequestBody Role role) {
            Role createdRole = roleService.createRole(role);
            return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
            Role updatedRole = roleService.updateRole(id, role);
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
            roleService.deleteRole(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }





