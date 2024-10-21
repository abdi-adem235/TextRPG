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
		dialogueMap.put(List.of(0,2), "Enchanting sounds can be heard. What might it be???");
		dialogueMap.put(List.of(2,0), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(2,1), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(2,2), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(0,2), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(1,2), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(2,2), "You approach a valley. Who knows what may be lurking...");
		dialogueMap.put(List.of(3,2), "What a view!!!. Who knows what may be lurking...");
		dialogueMap.put(List.of(3,3), "What a view!!!. Who knows what may be lurking...");
	//}
	}
	
	public String getDialogue(Player player) {
		String dialogue = dialogueMap.getOrDefault(List.of(player.getX(),player.getY()),"...");
		return dialogue;
	}
	
	

}
