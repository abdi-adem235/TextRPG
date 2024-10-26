package project.packages.textrpg.ingame;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import project.packages.textrpg.characters.Boss;
import project.packages.textrpg.characters.Player;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Quest {
	
	static List<Quest> questList = new ArrayList<>();
//	
	
	
	private String questName;
	private String questDescription;
	private boolean questCompleted;

	Quest(String questName, String questDescription, Boolean questCompleted){
		this.questName = questName;
		this.questDescription = questDescription;
		this.questCompleted = questCompleted;
	}
	
	
	public static void initializeQuests() {
		
		questList.add(new Quest("Find the Lost Emerald!!!","The emerald from the king's crown was lost during a voyage. Find the emerald and bring glory back to the kingdom",false));
		questList.add(new Quest("Defeat 3 enemies","Find and defeat 3 enemies",false));
		questList.add(new Quest("Defeat the Time Lord","The Time Lord is residing at the edge of the world. Find and defeat him to restore peace to the kingdom! ",false));
		
		
	}
	

	// override toString to access object values
	@Override
	public String toString() {
	    return String.format("%-25s %-45s %-10s", questName, questDescription, questCompleted);
	}

	
	public static void questOne(Player player) {
		if(player.getX() == 2 && player.getY() == 2) {
			System.out.println("You have completed the quest!!");
			updateQuest("Find the Stolen Emerald!!!");
		}
	}
	
	public static void questTwo(Player player) {
		if(player.getEnemiesDefeated() > 3) {
			System.out.println("You have completed the quest!!");
			updateQuest("Defeat 3 enemies");
		}
	}
	
	public static void questThree(Player player,Boss boss) {
		if(boss.getHealth() <= 0 && player.getHp() > 0) {
			System.out.println("You have completed the quest!!");
			updateQuest("Defeat the boss");
		}
	}
	
	
	public Boolean addQuest(Quest quest) {
		return questList.add(new Quest(quest.questName, quest.questDescription, quest.questCompleted));
	}
	
	public Boolean questCompleted() {
		this.questCompleted = true;
		return questCompleted;
	}
	
	public static void updateQuest(String questName) {
		{
	        for (Quest quest : questList) {
	            if (quest.getName().equalsIgnoreCase(questName)) {
	                quest.questCompleted();
	                System.out.println("Quest '" + questName + "' has been completed.");
	                break;
	        
	            }
	            else {
	            	System.out.println("Quest '" + questName + "' not found.");
	            }
	        }
	        
	    
		}
	}
	
	public static void displayQuest() {
		{
	        System.out.printf("%-25s %-45s %-10s%n", "Quest Name", "Description", "Completed");
	        System.out.println("------------------------------------------------------------------------------------");
	        for(Quest quest: questList) {
	        	System.out.println(quest);
	        }
	}
		
	}

	public String getName() {
		return questName;
	}

	public void setName(String questName) {
		this.questName = questName;
	}

	public String getDescription() {
		return questDescription;
	}

	public void setDescription(String questDescription) {
		this.questDescription = questDescription;
	}
	
	
	
	
	
	
}
