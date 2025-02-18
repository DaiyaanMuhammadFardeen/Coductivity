package com.coductivity.Coductivity.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @ToString.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password; // Store hashed password

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repo> repositories = new ArrayList<>();

    // Constructor that excludes 'userID' as it's auto-generated
    public User(String userName, String email, String password, List<Repo> repositories) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.repositories = repositories != null ? new ArrayList<>(repositories) : new ArrayList<>();
    }
}
