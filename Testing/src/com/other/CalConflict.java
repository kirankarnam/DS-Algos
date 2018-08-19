package com.other;

import java.util.ArrayList;
import java.util.List;

public class CalConflict {
	
	
	public static void main(String[] args) {
		List<calendarDetails> events = new ArrayList<calendarDetails>();
		events.add(new calendarDetails(1, 2, "a"));
		events.add(new calendarDetails(2, 4, "b"));
		events.add(new calendarDetails(3, 5, "c"));
		events.add(new calendarDetails(6, 7, "k"));
		events.add(new calendarDetails(9, 13, "e"));
		events.add(new calendarDetails(12, 15, "f"));
		events.add(new calendarDetails(16, 18, "f"));
		
		List<calendarDetails> conflicts = find_conflicts(events);
		for(calendarDetails conflict : conflicts) {
			System.out.println("start:"+conflict.start +" end:"+conflict.end +" event name is:"+conflict.details);
		}
	}
	
	public static List<calendarDetails> find_conflicts(List<calendarDetails> events) {
		List<calendarDetails> conflicts = new ArrayList<calendarDetails>();
		int openEventEnd = events.get(0).end;
		List<calendarDetails> tempConflicts = new ArrayList<calendarDetails>();
		tempConflicts.add(events.get(0));

		for (int i = 1; i < events.size(); i++) {
			if (events.get(i).start >= openEventEnd) {
				if (tempConflicts.size() > 1) {
					for (calendarDetails tempConflict : tempConflicts) {
						conflicts.add(tempConflict);
					}
				}
				tempConflicts = new ArrayList<calendarDetails>();
			}
			openEventEnd = Math.max(events.get(i).end,openEventEnd);
			tempConflicts.add(events.get(i));
		}
		if (tempConflicts.size() > 1) {
			for (calendarDetails tempConflict : tempConflicts) {
				conflicts.add(tempConflict);
			}
		}
		return conflicts;
	}

}

class calendarDetails{
	
	public calendarDetails(int start, int end, String details) {
		super();
		this.start = start;
		this.end = end;
		this.details = details;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	int start;
	int end;
	String details;
}