package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Meeting {

	static int minDuration = 15;
	static int maxDuration = 180; //3 hours
	
	private String name;
	private List<User> users;
	private int duration; //minutes
	private LocalDateTime date;
	
	public Meeting(String name, int duration, LocalDateTime date) {
		if(!(duration >= minDuration && duration <= maxDuration)) throw new IllegalArgumentException("Duration must be between 15 and 180");
		users = new ArrayList<User>();
		this.name = name;
		this.duration = duration;
		this.date = date;	
	};
	
	public List<User> getUsers() {
		return this.users;
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
	public LocalDateTime getStartDate() {
		return date;
	}
	
	public LocalDateTime getEndDate() {
		return date.plusMinutes(duration);
	}
	
	public String toString() {
		return "Meeting: "+name +", Duration: "+duration+" minutes, Date: "+date; 
	}
}
