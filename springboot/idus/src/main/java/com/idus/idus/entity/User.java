package com.idus.idus.entity;


import com.idus.idus.role.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

@Table(name="tb_users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid

    @Column(nullable = false)
    @NotBlank(message = "O username é obrigatório e não pode ser vazio.")
    @Size(min = 3, max = 50, message = "O username deve ter entre 3 e 50 caracteres.")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "A senha é obrigatória e não pode ser vazia.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)  // Define que o valor do Enum será salvo como String
    @NotNull(message = "O papel (role) é obrigatório.")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Point> points = new ArrayList<>();



    public User() {}

    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        try {
            // Converte a String para o Enum Role
            this.role = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException("Valor da Role invalida: " + role);
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
