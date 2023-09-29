package com.dnb.profileservice.payload.request;

import java.util.List;

import com.dnb.profileservice.dto.SocialNetwork;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProfileRequest {
	@NotBlank(message = "Professional Staus can not be empty")
	private String professionalStatus;
	private String companyName;
	private String website;
	private String location;

	@NotBlank(message = "Skills can not be empty")
	private List<String> skills;
	private String githubUserName;
	private String bio;

	private SocialNetwork socialNetwork;

	private String userId;

}
