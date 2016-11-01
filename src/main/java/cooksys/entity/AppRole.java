package cooksys.entity;

import javax.persistence.*;

@Entity
@Table
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role")
    private String roleTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return roleTitle;
    }

    public void setRole(String role) {
        this.roleTitle = role;
    }
}
