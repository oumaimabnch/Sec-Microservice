package com.insy2sproj.secmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecMicroserviceApplication.class, args);
    }
  /*  @Bean
CommandLineRunner run (UserService userService)
{
    return args -> {
        userService.saveRole(new Role(null,"ROLE_ADMIN"));
        userService.saveRole(new Role(null,"ROLE_MANAGER"));

        userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

        userService.saveRole(new Role(null,"ROLE_USER"));


        userService.saveUser(new User(null,"john","1234",new ArrayList<>()));
        userService.saveUser(new User(null,"yohan","1564",new ArrayList<>()));
        userService.saveUser(new User(null,"jim","1569",new ArrayList<>()));
        userService.saveUser(new User(null,"lisa","3025",new ArrayList<>()));

        userService.addRoleToUser("john","ROLE_ADMIN");
        userService.addRoleToUser("john","ROLE_MANAGER");
        userService.addRoleToUser("jim","ROLE_USER");
        userService.addRoleToUser("lisa","ROLE_SUPER_ADMIN");

        userService.addRoleToUser("yohan","ROLE_MANAGER");










    };

}*/
}
