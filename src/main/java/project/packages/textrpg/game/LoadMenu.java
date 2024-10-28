package project.packages.textrpg.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import project.packages.textrpg.characters.Player;
import project.packages.textrpg.ingame.Dialogue;
import project.packages.textrpg.ingame.Quest;
import project.packages.textrpg.ingame.RpgMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadMenu {
	
	public Scanner scanner;
	

	public LoadMenu() {
		scanner = new Scanner(System.in);
	}
	
	
	public void DisplayMenu(Player player, RpgMap map, Dialogue dialogue) {
		boolean loop = false;
		int totalWidth = 70;
		int padding = (totalWidth - ("Menu").length()) / 2; 
		while(!loop) {
			

			
					try {
						System.out.println("Please select from the following options\n");
						 // Print top border
						System.out.println("-".repeat(totalWidth));
						System.out.println(" ".repeat(padding) + "Menu");
						System.out.println("-".repeat(totalWidth));
						System.out.printf("| %-9s | %-10s | %-5s | %-10s %n", "1: Check Quests",  "2: Choose Direction",  "3: Heal",  "4:Show/Save Stats\n");
						System.out.println("-".repeat(totalWidth));
						
						int choice = scanner.nextInt();
						scanner.nextLine();
						
						
						switch(choice) {
						
						case 1 : Quest.displayQuest();
						break;
						case 2 : {
						
							System.out.println("You are now in the "+map.getRegion(player.getX(),player.getY())+ " region");
							System.out.println("Please enter a direction: 'N', 'S', 'E', 'W' ");
							char direction = scanner.next().toUpperCase().charAt(0);
							//scanner.nextLine();
							player.movePlayer(direction);
							System.out.println(dialogue.getDialogue(player));
							System.out.println(player.getCoordinates(player.getX(),player.getY()));
							System.out.println("You are now in the "+map.getRegion(player.getX(),player.getY())+ " region");
							if (map.getRegion(player.getX(), player.getY()).equalsIgnoreCase("Boss Zone")) {
	                               player.encounterBoss(player);
	                            } 
							else {
	                                player.encounter(player, map);
	                            }
						
						}
						break;
						case 3 : player.usePotion(50);
						break;
						case 4 : player.showStats();
						break;
						
						
						
						
						
						}
					
					}catch (Exception e){
						//e.printStackTrace();
						System.out.println("Invalid input, please try again");
						scanner.nextLine();
					}
					
					if(player.getHp() <= 0) {
						System.out.println("You have died.....");
						loop = true;
					}
					 
					
//			}
			
		
		
		
		
	}
	
	
	
	

	}
	
}
