package project.packages.textrpg.textrpg;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadMenu {
	
	public Scanner scanner;
	

	public LoadMenu() {
		scanner = new Scanner(System.in);
	}
	
	
	public void DisplayMenu(Player player, RpgMap map, Dialogue dialogue) {
		boolean loop = false;
		while(!loop) {
			
//			if(player.getHp() <= 0) {
//				System.out.println("You have died......\n");
//				System.out.println("You have died......\n");
//				break;
//			}
//			
//			else {
			
					try {
						System.out.println("Please select from the following options\n");
						System.out.println("1: Check Quests   2: Choose Direction  3: Heal  4:Show/Save Stats\n");
						
						int choice = scanner.nextInt();
						scanner.nextLine();
						//Dialogue dialogue = new Dialogue();
					
					
						//System.out.println(choice);
						
						switch(choice) {
						
						case 1 : Quest.displayQuest();
						break;
						case 2 : {
						
							System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
							System.out.println("Please enter a direction: 'N', 'S', 'E', 'W' ");
							char direction = scanner.next().toUpperCase().charAt(0);
							//scanner.nextLine();
							player.movePlayer(direction);
							System.out.println(dialogue.getDialogue(player));
							System.out.println(player.getCoordinates(player.x,player.y));
							System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
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
						System.out.println("you have died.....");
						loop = true;
					}
					 
					
//			}
			
		
		
		
		
	}
	
	
	
	

	}
	
}
