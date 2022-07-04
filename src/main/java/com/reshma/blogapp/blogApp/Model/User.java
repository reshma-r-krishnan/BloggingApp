package com.reshma.blogapp.blogApp.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String userName;
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private Set<Post> posts;

}
