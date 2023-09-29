package com.dnb.profileservice.payload.response;

import java.util.List;

import com.dnb.profileservice.dto.SocialNetwork;
import com.dnb.profileservice.dto.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ProfileResponse {
	
	private String profileId;
	
	private String professionalStatus;
	
	private String companyName;
	
	private String website;
	
	private String location;
	
	private List<String> skills;
	
	private String githubUserName;
	
	private String bio;

	private SocialNetwork socialNetwork;

	private String userId;
	
	@JsonIgnore
	private User user;
}
