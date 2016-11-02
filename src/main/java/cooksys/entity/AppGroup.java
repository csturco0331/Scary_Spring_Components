package cooksys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AppGroup")
public class AppGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Owner")
    @JsonIgnore
    private AppUser owner;

    @ManyToMany
    @JoinTable(name = "GroupUsers",
    	joinColumns = @JoinColumn(name = "group_id"), 
    	inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private List<AppUser> members;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }

    public List<AppUser> getMembers() {
        return members;
    }

    public void setMembers(List<AppUser> members) {
        this.members = members;
    }
}
