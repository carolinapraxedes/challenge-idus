package com.idus.idus.entity;


import com.idus.idus.role.Role;
import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Entity

@Table(name="tb_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // Define que o valor do Enum será salvo como String
    private Role role;

    public User() {}

    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        try {
            // Converte a String para o Enum Role
            this.role = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Lida com erro, por exemplo, definindo um valor default ou lançando uma exceção personalizada
            throw new IllegalArgumentException("Invalid role value: " + role);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        // Converte a String para o enum Role
        this.role = Role.valueOf(role.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", id=" + id +
                '}';
    }
}
