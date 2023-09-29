package com.dnb.profileservice.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.profileservice.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
	@GenericGenerator(name = "profile_seq", strategy = "com.dnb.devconnector.utils.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "PRO_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String profileId;

	@NotBlank(message = "Professional Staus can not be empty")
	private String professionalStatus;
	private String companyName;
	private String website;
	private String location;

	@NotBlank(message = "Skills can not be empty")
	private String skills;
	private String githubUserName;
	private String bio;

	private String twitterUrl;
	private String facebookUrl;
	private String youtubeUrl;
	private String linkedinUrl;
	private String instagramUrl;

	private String userId;

}
