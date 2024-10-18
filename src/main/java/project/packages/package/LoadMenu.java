package com.bptn.course.PersonalProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadMenu {
	
	public Scanner scanner;
	

	public LoadMenu() {
		scanner = new Scanner(System.in);
	}
	
	
	public void DisplayMenu(Player player, RpgMap map) {
		
		while(true) {
			
			try {
				System.out.println("Please select from the following options");
				System.out.println("1: Check Quests   2: Choose Direction  3: Heal  4:Show/Save Stats");
				
				int choice = scanner.nextInt();
				scanner.nextLine();
			
			
			
				//System.out.println(choice);
				
				switch(choice) {
				
				case 1 -> Quest quest = new Quest();
				case 2 -> {
				
					System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
					System.out.println("Please enter a directiom: 'N', 'S', 'E', 'W' ");
					char direction = scanner.next().toUpperCase().charAt(0);
					//scanner.nextLine();
					player.movePlayer(direction);
					System.out.println(player.getCoordinates(player.x,player.y));
					System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
				
				}
				case 3 -> player.usePotion(50);
				case 4 -> player.showStats();
				
				
				
				
				
				}
			
			}catch (Exception e){
				//e.printStackTrace();
				System.out.println("Invalid input, please try again");
				scanner.nextLine();
			}
			
		
		
		
		
	}
	
	
	
	

	}
	
}
