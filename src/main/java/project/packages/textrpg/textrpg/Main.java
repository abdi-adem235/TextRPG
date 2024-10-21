package project.packages.textrpg.textrpg;

import java.util.Scanner;



public class Main {
	
	public static void main(String args []) {
		
		
		RpgMap map = new RpgMap();
		Player player = null;
		LoadMenu menu = new LoadMenu();
		Dialogue dialogue = new Dialogue();
		Quest.initializeQuests();
		
		//Warrior warrior = new Warrior("AAaa", 0, 1);
		//Mage mage = new Mage("ddsafs", 0, 1);
		
		//warrior.attack();
		
		//warrior.showStats();
		
		//System.out.println(mage.getJob());
		
		//prompt user for user name, password validation
		
		StartGame game = new StartGame();
        game.login();
		
		
		
		//Start game loop
		Scanner sc = new Scanner(System.in);
		boolean gameLoop = true;
				
		
			System.out.println("Welcome new player! Please choose your class and embark on a new journey!");
			System.out.println("Please enter 1 for Warrior, 2 for Mage, or 3 for Thief.");
			int playerChoice = sc.nextInt();
			sc.nextLine();
			
			switch(playerChoice) {
			
			case 1:
				System.out.println("You have chosen Warrior, please make a name for your character");
				String nameChoice = sc.nextLine();
				player = new Warrior(nameChoice,0,0);
				break;
				
			case 2:
				System.out.println("You have chosen Mage, please make a name for your character");
				String nameChoice2 = sc.nextLine();
				player = new Mage(nameChoice2,0,0);
				break;
				
			case 3:
				System.out.println("You have chosen Thief, please make a name for your character");
				String nameChoice3 = sc.nextLine();
				player = new Thief(nameChoice3,0,0);
				System.out.println("Welcome, Thief" +nameChoice3+ "!");
				break;
			
			
			}
			
			
			
//			    Enemy goblin = new Enemy(100,"Goblin",15);
//				System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
//				System.out.println("Please enter a directiom: 'N', 'S', 'E', 'W' ");
//				char direction = sc.next().charAt(0);
//				player.movePlayer(direction);
//				System.out.println(player.getCoordinates(player.x,player.y));
//				System.out.println("You are now in the "+map.getRegion(player.x,player.y)+ " region");
//				player.attack(goblin);
//				goblin.attackPlayer(player);
//				player.encounter(player, goblin);
//				System.out.println("Player" +player.name+ "has" +player.hp+ "health remaining.");
//				player.triggerBoss(player);
//				should have triggerBoss method in player class and within encounter method 
				
				
			while(gameLoop) {
				
				menu.DisplayMenu(player,map,dialogue);
				player.triggerBoss(player);
			
			
		
		
			}
			
			player.showStats();
			sc.close();
		
			
		//}
		
		
		
		//prompt user to create class
		
		//give beginning dialogue
		
		//prompt user to pick direction
		
		//
		

	}

	
}
