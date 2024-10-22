package project.packages.textrpg.textrpg;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Quest {
	
	static List<Quest> questList = new ArrayList<>();
//	
	
	
	String questName;
	String questDescription;
	boolean questCompleted;

	Quest(String questName, String questDescription, Boolean questCompleted){
		this.questName = questName;
		this.questDescription = questDescription;
		this.questCompleted = questCompleted;
	}
	
	
	public static void initializeQuests() {
		
		questList.add(new Quest("Find the Stolen Emerald!!!","sfsf",false));
		questList.add(new Quest("Defeat 3 enemies","sfsf",false));
		questList.add(new Quest("Defeat the Boss","sfsf",false));
		
		
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
		if(boss.getHealth() <= 0) {
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
	        }
	        System.out.println("Quest '" + questName + "' not found.");
	    
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
