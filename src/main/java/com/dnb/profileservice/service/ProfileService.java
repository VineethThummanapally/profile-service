package com.dnb.profileservice.service;

import java.util.Optional;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;

public interface ProfileService {
	public Profile createProfile(Profile profile) throws IdNotFoundException;

	public Optional<Profile> getProfileById(String profileId);

	public boolean deleteProfileById(String profileId) throws IdNotFoundException;

	public boolean checkProfileExistsById(String profileId);
	
	public Iterable<Profile> getAllProfiles();

}
