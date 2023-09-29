package com.dnb.profileservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.profileservice.dto.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String> {

}
