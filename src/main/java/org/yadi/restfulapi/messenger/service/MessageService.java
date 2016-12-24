package org.yadi.restfulapi.messenger.service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.yadi.restfulapi.messenger.model.Message;
import org.yadi.restfulapi.messenger.database.DatabaseClass;

public class MessageService {
	
	private HashMap<Long,Message> messages= DatabaseClass.getMessages();
	
	public MessageService() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public List<Message> getAllMessage() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessageForYear(int year) {
		ArrayList<Message> obj= new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message messsage:messages.values()){
			cal.setTime(messsage.getCreated());
			if(cal.get(Calendar.YEAR) == year){
			 obj.add(messsage);
			}
		}
		return obj;
	}
	
	public List<Message> getAllMessageForPage(int start, int end) {
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start+end > list.size()){
			return new ArrayList<Message>();
		}
		return list.subList(start, start+end);
	}
	
	public Message getMessage(long id) {
		System.out.println("Hi I am reached");
		return messages.get(id);
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message addMessages(Message message) {
		System.out.println("Size" + messages.size());
		message.setId((long)(messages.size()+1));
		messages.put((long)(messages.size()+1), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
