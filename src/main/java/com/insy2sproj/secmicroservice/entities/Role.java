package com.insy2sproj.secmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")

public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

}
