package com.reshma.blogapp.blogApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userResponse {
	
	private String token;
	private String message;

}
