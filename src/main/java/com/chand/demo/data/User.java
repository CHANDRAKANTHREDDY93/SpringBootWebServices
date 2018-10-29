package com.chand.demo.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user. ")
@Entity
public class User {
	
	@OneToMany(mappedBy="user")
	private List<Post> post;
	
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	public User() {
		
	}
	
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2, message="Name should contain more than 3 characters")
	@ApiModelProperty(notes="Name should have atleast 3 characters")
	private String name;
	@Past
	@ApiModelProperty(notes="Birthdate cannot be a future date")
	private Date dateofBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public User(int id, String name, Date dateofBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateofBirth = dateofBirth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateofBirth=" + dateofBirth + "]";
	}
	
	
	

}
