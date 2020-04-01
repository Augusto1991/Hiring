package main;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom {
	
	private List<Meeting> meetings;
	private String name;
	
	public ConferenceRoom(String name) {
		this.name = name;
		meetings = new ArrayList<Meeting>();
	}
	
	public String addMeeting(Meeting meeting) {
		if(isOverlapping(meeting)) {
			return "There's a meeting asigned at that date.";
		} else {
			meetings.add(meeting);
			return "New meeting added";
		}
	}
	
	private boolean isOverlapping(Meeting meeting) {	
		for(Meeting m : this.meetings) {
			if((meeting.getStartDate().isBefore(m.getEndDate())) && (meeting.getEndDate().isAfter( m.getStartDate()))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ConferenceRoom conferenceRoom = new ConferenceRoom("CF1");
		
		Meeting meeting1 = new Meeting("m1", 20, LocalDateTime.of(2020, Month.APRIL, 10, 11, 00));
		Meeting meeting2 = new Meeting("m2", 30, LocalDateTime.of(2020, Month.APRIL, 10, 11, 20));
		Meeting meeting3 = new Meeting("m3", 100, LocalDateTime.of(2020, Month.APRIL, 10, 11, 50));
		
		try {
			Meeting meetingError = new Meeting("m3", 200, LocalDateTime.of(2020, Month.APRIL, 10, 11, 50));	
		} catch (Exception e){
			System.out.println("Error while creating a meeting");
		}
		
		//Adding correct meetings
		System.out.println(conferenceRoom.addMeeting(meeting1));
		System.out.println(conferenceRoom.addMeeting(meeting2));
		System.out.println(conferenceRoom.addMeeting(meeting3));
		
		//Overlapping meeting4 with meeting1
		Meeting meeting4 = new Meeting("m4", 100, LocalDateTime.of(2020, Month.APRIL, 10, 11, 30));
		System.out.println(conferenceRoom.addMeeting(meeting4));
		
	}

}
