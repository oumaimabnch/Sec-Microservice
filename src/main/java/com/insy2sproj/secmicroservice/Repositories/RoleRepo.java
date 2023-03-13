package com.insy2sproj.secmicroservice.Repositories;

import com.insy2sproj.secmicroservice.entities.Role;
import com.insy2sproj.secmicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
