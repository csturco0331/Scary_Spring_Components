package cooksys.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AppUser")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@ManyToOne // MANY AppUsers can have ONE AppRole
	@JoinColumn //This will be a numeric column in the "app_user" table of the database named "role_id" that is used by the ORM tool to find (using a join statement) which AppRole object belongs to this AppUser object
	@JsonIgnore
	private AppRole role;
	
	@ManyToMany(mappedBy = "members") //Tells this Entity to look at the "members" field of the AppGroup Entity for a @JoinTable annotation
	private List<AppGroup> groups;

	public AppUser() {

	}
	
	public AppUser(String name, String city, String state, AppRole role) {
		this.name = name;
		this.city = city;
		this.state = state;
		this.role = role;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppRole getRole() {
		return role;
	}

	public void setRole(AppRole role) {
		this.role = role;
	}

	public List<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<AppGroup> groups) {
		this.groups = groups;
	}

}
