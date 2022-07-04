package com.reshma.blogapp.blogApp.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Registerdto {
	private String name;
	private String userName;
	private String email;
	private String password;
}
