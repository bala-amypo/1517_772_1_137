package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserAccount user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(nullable = false, updatable = false)
    private Instant assignedAt;

    public UserRole() {
    }

    public UserRole(UserAccount user, Role role) {
        this.user = user;
        this.role = role;
    }

    @PrePersist
    public void onAssign() {
        this.assignedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getAssignedAt() {
        return assignedAt;
    }
    @PrePersist
    public void prePersist() {
        this.assignedAt = Instant.now();
    }
    public void setId(Long id) {
        this.id = id;
    }

}
