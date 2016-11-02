package cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String roleTitle;
    
    @OneToMany(mappedBy = "role")
	private List<AppUser> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String role) {
        this.roleTitle = role;
    }

	public List<AppUser> getUsers() {
		return users;
	}

	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
}
