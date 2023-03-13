package com.insy2sproj.secmicroservice.Repositories;

import com.insy2sproj.secmicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
   Optional<User>  findByUsername(String username);

}
