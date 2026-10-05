package com.manuhdz.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roleId;

    @NotBlank(message = "Role name is mandatory")
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String roleName;
}
