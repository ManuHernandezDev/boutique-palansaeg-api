package com.manuhdz.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    @NotBlank(message = "User name is mandatory")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "username is mandatory")
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;


    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be al least 8 characters long")
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
