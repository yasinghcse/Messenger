package org.yadi.restfulapi.messenger.database;

import java.util.HashMap;

import org.yadi.restfulapi.messenger.model.*;
import org.yadi.restfulapi.messenger.model.Message;

public class DatabaseClass {
	private static HashMap<Long,Message> message = new HashMap<Long,Message>();
	
	static{
	Message m1 = new Message(1,"yadi","yadu");
	Message m2 = new Message(2,"sonu","sonu");
	
	message.put((long) (message.size()+1), m1);
	message.put((long) (message.size()+1), m2);
	}
	
	private static HashMap<String,Profile> profile = new HashMap<String,Profile>();
	static{
		Profile m1 = new Profile(1,"yadi","yadu");
		Profile m2 = new Profile(2,"sonu","sonu");
		
		profile.put("yadi", m1);
		profile.put("sonu", m2);
		}
	
	public DatabaseClass() {
		
		// TODO Auto-generated constructor stub
		
	}
	
	public static HashMap<Long,Message> getMessages(){
		return message;
	}

	public static HashMap<String,Profile> getProfile(){
		return profile;
	}
}
