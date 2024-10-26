package project.packages.textrpg.game;

import java.util.Map;
import java.util.Scanner;

import project.packages.textrpg.characters.Boss;
import project.packages.textrpg.characters.Mage;
import project.packages.textrpg.characters.Player;
import project.packages.textrpg.characters.Thief;
import project.packages.textrpg.characters.Warrior;
import project.packages.textrpg.ingame.Dialogue;
import project.packages.textrpg.ingame.Quest;
import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.ValidateUser;



public class Main {
	
	public static void main(String args []) {
		
		//Initialize rpg map objects (player, map, menu, dialogue, quest, boss)
		RpgMap map = new RpgMap();
		Player player = null;
		LoadMenu menu = new LoadMenu();
		Dialogue dialogue = new Dialogue();
		Quest.initializeQuests();
		Boss boss = new Boss();
		
		
		
		//prompt user for user name, password validation
		
		StartGame game = new StartGame();
        game.login();
		
		
		
		//Start game loop
		Scanner sc = new Scanner(System.in);
		boolean gameLoop = true;
	
		while(gameLoop) {
			
			boolean correctInput = false;
			
			//flag for checking valid input
			while(!correctInput) {
				
				//try except block for choosing player class
				try {
					System.out.println("Welcome new player! Please choose your class and embark on a new journey!");
					System.out.println("Please enter 1 for Warrior, 2 for Mage, or 3 for Thief.");
					int playerChoice = sc.nextInt();
					sc.nextLine();
					
					switch(playerChoice) {
					
					case 1:
						System.out.println("You have chosen Warrior, please make a name for your character");
						String warriorChoice = sc.nextLine();
						player = new Warrior(warriorChoice,0,0);
						System.out.println("Welcome, Warrior " +warriorChoice+ "!");
						correctInput = true;
						break;
						
					case 2:
						System.out.println("You have chosen Mage, please make a name for your character");
						String mageChoice = sc.nextLine();
						player = new Mage(mageChoice,0,0);
						System.out.println("Welcome, Mage " +mageChoice+ "!");
						correctInput = true;
						break;
						
					case 3:
						System.out.println("You have chosen Thief, please make a name for your character");
						String thiefChoice = sc.nextLine();
						player = new Thief(thiefChoice,0,0);
						System.out.println("Welcome, Thief " +thiefChoice+ "!");
						correctInput = true;
						break;
					
					
					}
					
				}
				catch (Exception e){
					//e.printStackTrace();
					System.out.println("Invalid input, please try again");
					sc.nextLine();
				}
		
			}
		
		
				
				menu.DisplayMenu(player,map,dialogue);
				player.encounterBoss(player);
				player.getCoordinates(player.getX(), player.getY());
				Quest.questTwo(player);
				Quest.questThree(player,boss);
				

		
		}
		
				player.showStats();
				sc.close();

	
	}
	
	
}
