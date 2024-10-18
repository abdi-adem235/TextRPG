package com.bptn.course.PersonalProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Quest {
	
	static List<Quest> questList = new ArrayList<>();
//	
	
	
	String questName;
	String questDescription;
	boolean questCompleted;
	
	Quest(String name, String description, Boolean questCompleted){
		this.name = name;
		this.description = description;
		this.questCompleted = questCompleted;
	}
	
	
	public void initializeQuests() {
		
		questList.add(new Quest("Find the Stolen Emerald!!!","sfsf",false));
		questList.add(new Quest("Defeat 3 enemies","sfsf",false));
		questList.add(new Quest("Defeat the Boss","sfsf",false));
		
		
	}
	
	public static void questOne(Player player) {
		if(player.getX() == 2 && player.getY() == 2) {
			System.out.println("You have completed the quest!!");
			player.updateQuest("Defeat 3 enemies");
		}
	}
	
	
	public Boolean addQuest(Map<String,Boolean> map, Quest quest) {
		return map.put(quest.name, quest.questCompleted);
	}
	
	public Boolean questCompleted() {
		return questCompleted;
	}
	
//	public void updateQuest(String questName) {
//		{
//	        for (Quest quest : questList) {
//	            if (quest.getName().equalsIgnoreCase(questName)) {
//	                quest.questCompleted(true);
//	                System.out.println("Quest '" + questName + "' has been completed.");
//	        
//	            }
//	        }
//	        System.out.println("Quest '" + questName + "' not found.");
//	    
//	}
//	
	public void displayQuest() {
		for(Quest quest: questList) {
			System.out.println(quest);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}
