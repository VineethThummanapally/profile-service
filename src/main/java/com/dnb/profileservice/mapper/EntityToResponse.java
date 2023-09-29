package com.dnb.profileservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.SocialNetwork;
import com.dnb.profileservice.payload.response.ProfileResponse;
import com.dnb.profileservice.utils.Converters;

@Component
public class EntityToResponse {
	@Autowired
	Converters converter;

	public ProfileResponse getProfileEntityResponse(Profile profile) {

		ProfileResponse profileResponse = new ProfileResponse();

		profileResponse.setProfileId(profile.getProfileId());
		profileResponse.setBio(profile.getBio());
		profileResponse.setCompanyName(profile.getCompanyName());
		profileResponse.setGithubUserName(profile.getGithubUserName());
		profileResponse.setLocation(profile.getLocation());
		profileResponse.setProfessionalStatus(profile.getProfessionalStatus());
		profileResponse.setWebsite(profile.getWebsite());

		profileResponse.setSkills(converter.StringToList(profile.getSkills()));

		profileResponse.setUserId(profile.getUserId());

		SocialNetwork socialNetwork = new SocialNetwork();
		socialNetwork.setFacebookUrl(profile.getFacebookUrl());
		socialNetwork.setInstagramUrl(profile.getInstagramUrl());
		socialNetwork.setLinkedinUrl(profile.getLinkedinUrl());
		socialNetwork.setYoutubeUrl(profile.getYoutubeUrl());
		socialNetwork.setTwitterUrl(profile.getTwitterUrl());
		profileResponse.setSocialNetwork(socialNetwork);

		return profileResponse;
	}
}
