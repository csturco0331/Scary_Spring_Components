package cooksys.entity;

import javax.persistence.*;

@Entity
@Table
public class AppRole {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role")
    private String roleTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return roleTitle;
    }

    public void setRole(String role) {
        this.roleTitle = role;
    }
}
