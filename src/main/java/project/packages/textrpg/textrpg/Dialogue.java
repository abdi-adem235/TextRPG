package project.packages.textrpg.textrpg;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Dialogue extends RpgMap {
	
	private static Map<List <Integer>, String> dialogueMap = new HashMap<>();
	
//	public Dialogue() {
//		super();
//		dialogueMap = new HashMap<>();
//		initializeDialogue();
//	}
	
	public Dialogue() {
		dialogueMap.put(List.of(0,1), "A lush, beautiful forest. Who knows what may be lurking...");
		dialogueMap.put(List.of(1,0), "A lush, beautiful forest. Who knows what may be lurking...");
		dialogueMap.put(List.of(2,2), "Something shiny glistens at your feet. What could it be???");
		dialogueMap.put(List.of(3,0), "You approach a valley. Strong gusts of wind can be felt.");
		dialogueMap.put(List.of(3,1), "You approach a valley. Strong gusts of wind can be felt.");
		dialogueMap.put(List.of(3,2), "You approach a valley. Strong gusts of wind can be felt.");
		dialogueMap.put(List.of(0,3), "You stumble into a deep and dark cave ....");
		dialogueMap.put(List.of(1,3), "You stumble into a deep and dark cave ....");
		dialogueMap.put(List.of(2,3), "You stumble into a deep and dark cave ....");
		dialogueMap.put(List.of(3,3), "A mysterious prescence can be felt...");
	//}
	}
	
	public String getDialogue(Player player) {
		String dialogue = dialogueMap.getOrDefault(List.of(player.getX(),player.getY()),"...");
		return dialogue;
	}
	
	

}
