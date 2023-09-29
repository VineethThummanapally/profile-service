package com.dnb.profileservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.dto.User;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.user}")
	private String URL;

	@Override
	public Profile createProfile(Profile profile) throws IdNotFoundException {
		try {
			ResponseEntity<User> user = restTemplate.getForEntity(URL + "/" + String.valueOf(profile.getUserId()),
					User.class);
			return profileRepository.save(profile);
		} catch (Exception e) {
			throw new IdNotFoundException("User Id Not Found");
		}

	}

	@Override
	public Optional<Profile> getProfileById(String profileId) {
		return profileRepository.findById(profileId);
	}

	@Override
	public boolean deleteProfileById(String profileId) throws IdNotFoundException {
		boolean isExists = profileRepository.existsById(profileId);

		if (!isExists)
			throw new IdNotFoundException("Invalid Profile Id");

		profileRepository.deleteById(profileId);

		if (profileRepository.existsById(profileId))
			return false;
		else
			return true;
	}

	@Override
	public boolean checkProfileExistsById(String profileId) {
		return profileRepository.existsById(profileId);
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

}
