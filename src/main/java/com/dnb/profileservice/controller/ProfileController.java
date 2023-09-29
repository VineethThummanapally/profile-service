package com.dnb.profileservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.profileservice.dto.Profile;
import com.dnb.profileservice.exceptions.IdNotFoundException;
import com.dnb.profileservice.mapper.EntityToResponse;
import com.dnb.profileservice.mapper.RequestToEntityMapper;
import com.dnb.profileservice.payload.request.ProfileRequest;
import com.dnb.profileservice.payload.response.ProfileResponse;
import com.dnb.profileservice.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@Autowired
	private RequestToEntityMapper mapper;

	@Autowired
	private EntityToResponse entityToResponse;

	@PostMapping("/create") // combination of @RequestMapping + PostMethod => spring 4.3.
	public ResponseEntity<?> creatProfile(@RequestBody ProfileRequest profileRequest) {

		Profile profile1 = mapper.getProfileEntityObject(profileRequest);

		try {
			Profile profile2 = profileService.createProfile(profile1);
			ProfileResponse profileResponse = entityToResponse.getProfileEntityResponse(profile2);
			return new ResponseEntity<>(profileResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@GetMapping("/{profileId}") // it should help us to get the specific account details
	public ResponseEntity<?> getProfileById(@PathVariable("profileId") String profileId) throws IdNotFoundException {

		Optional<Profile> requestedProfile = profileService.getProfileById(profileId);
		if (requestedProfile.isPresent())
			return ResponseEntity.ok(requestedProfile.get());
		else {
			throw new IdNotFoundException("Requested Id Info Not found");
		}
	}

	@GetMapping("/allProfiles")
	public ResponseEntity<?> getAllProfiles() throws IdNotFoundException {
		List<Profile> allProfiles = (List<Profile>) profileService.getAllProfiles();

		if (allProfiles.size() != 0)
			return ResponseEntity.ok(allProfiles);
		else {
			throw new IdNotFoundException("No Profiles Found ");
		}
	}

	@DeleteMapping("/{profileId}")
	public ResponseEntity<?> deleteProfileById(@PathVariable String profileId) throws IdNotFoundException {

		if (profileService.checkProfileExistsById(profileId)) {
			profileService.deleteProfileById(profileId);
			return ResponseEntity.noContent().build();
		} else {
			throw new IdNotFoundException("Id Not Found");
		}
	}

}
