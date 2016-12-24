package org.yadi.restfulapi.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.yadi.restfulapi.messenger.database.DatabaseClass;
import org.yadi.restfulapi.messenger.model.Message;
import org.yadi.restfulapi.messenger.model.Profile;

public class ProfileService {

	private HashMap<String,Profile> profiles= DatabaseClass.getProfile();
	public ProfileService() {
	}

	public List<Profile> getAllProfile() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name) {
		System.out.println("Hi I am reached");
		return profiles.get(name);
	}
	
	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getMessage(), profile);
		return profile;
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId((long)(profiles.size()+1));
		profiles.put(profile.getMessage(), profile);
		return profile;
	}
	
	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}
}
