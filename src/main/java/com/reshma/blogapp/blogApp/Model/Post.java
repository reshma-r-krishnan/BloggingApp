package com.reshma.blogapp.blogApp.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String body;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	
	@ManyToOne
	private User user;

}
