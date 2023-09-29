package com.dnb.profileservice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.payload.request.ProfileRequest;
import com.dnb.profileservice.utils.Converters;

@Component
public class RequestToEntityMapper {

	@Autowired
	Converters converter;

	public Profile getProfileEntityObject(ProfileRequest profileRequest) {
		Profile profile = new Profile();

		profile.setBio(profileRequest.getBio());
		profile.setCompanyName(profileRequest.getCompanyName());
		profile.setLocation(profileRequest.getLocation());
		profile.setProfessionalStatus(profileRequest.getProfessionalStatus());
		profile.setGithubUserName(profileRequest.getGithubUserName());
		profile.setWebsite(profileRequest.getWebsite());

		profile.setSkills(converter.ListToString(profileRequest.getSkills()));

		profile.setTwitterUrl(profileRequest.getSocialNetwork().getTwitterUrl());
		profile.setInstagramUrl(profileRequest.getSocialNetwork().getInstagramUrl());
		profile.setLinkedinUrl(profileRequest.getSocialNetwork().getLinkedinUrl());
		profile.setFacebookUrl(profileRequest.getSocialNetwork().getFacebookUrl());
		profile.setYoutubeUrl(profileRequest.getSocialNetwork().getYoutubeUrl());

		profile.setUserId(profileRequest.getUserId());

		return profile;
	}

}