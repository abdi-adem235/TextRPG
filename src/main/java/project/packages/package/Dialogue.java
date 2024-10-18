package com.bptn.course.PersonalProject;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Dialogue extends RpgMap {
	
	private Map<List <Integer>, String> dialogue = new HashMap<>();
	
	public Dialogue() {
		super();
		dialogue = new HashMap<>();
		initializeDialogue();
	}
	
	public void initializeDialogue() {
		dialogue.put(List.of(0,1), "A lush, beautiful forest. Who knows what may be lurking...");
		dialogue.put(List.of(0,2), "Enchanting sounds can be heard. What might it be???");
		dialogue.put(List.of(0,3), "You approach a valley. Who knows what may be lurking...");
		dialogue.put(List.of(0,4), "What a view!!!. Who knows what may be lurking...");
	}

}
