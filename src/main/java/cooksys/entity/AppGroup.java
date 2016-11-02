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

    @ManyToOne // MANY AppUsers can have ONE AppGroup
    @JoinColumn(name = "Owner") //This will be a numeric column in the database named "owner_id" that is used by the ORM tool to find (using a join statement) which AppUser object belongs to this AppGroup object
    @JsonIgnore
    private AppUser owner;

    @ManyToMany
    @JoinTable(name = "GroupUsers", //The name of the join table in the database (the table will be called group_users)
    	joinColumns = @JoinColumn(name = "group_id"), //The foreign key column in the join table that THIS ENTITY (AppGroup) will be joined on
    	inverseJoinColumns = @JoinColumn(name = "user_id")) // the foreign key column in the join table that the REFERENCED ENTITY (AppUser) will be joined on
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
