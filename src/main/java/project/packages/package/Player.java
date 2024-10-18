package com.bptn.course.PersonalProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public abstract class Player {
	
		static int final_X = 4;
		static int final_Y = 3;
		static int min_X = 0;
		static int min_Y = 0;
	
	
		int hp = 100;
		String name;
		int exp;
		int level;
		int attack;
		int x; //for coordinates
		int y; // for coordinates
		int enemiesDefeated = 0;
		int potion = 50;
	
		//for Quests
		
		private Map<Integer, String> map = new HashMap<>();
	
		// TODO Auto-generated method stub
		//create a player class that mage, thief, warrior, derive from
		//sub classes will haver their own progression (i.e. mage -> archmage -> time wizard)
		//sub classes
	
	public Player() {
		
	}
		
	public Player(int hp,String name, int exp, int level,int attack, int x, int y, int enemiesDefeated) {
		this.hp = hp;
		this.name = name;
		this.exp = exp;
		this.level = level;
		this.attack = attack;
		this.x = x;
		this.y = y;
		this.enemiesDefeated = enemiesDefeated;
		
	}
	
	public int getHp() {
		return hp;
	}
	
	public void gainHP(int gain) { //gain hp method for player depending on current hp amount
		if(this.hp + gain <= 100) {
			this.hp += gain;
			System.out.println("You now have " +this.hp+ "total hp!");
			
		}
		else {
			System.out.println("You have the maxiumum amount of hp");
			this.hp = hp;
		}
		
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public List<Integer> getCoordinates(int x, int y) {
		return List.of(getX(),getY());
	}

	public int getEnemiesDefeated() {
		return this.enemiesDefeated;
	}

	public void setEnemiesDefeated(int enemiesDefeated) {
		this.enemiesDefeated = enemiesDefeated;
		
	public void enemiesDefeatedCounter() {
		this.enemiesDefeated = this.getEnemiesDefeated() + 1;
		return enemiesDefeated;
			
		}
	}
	
	public void usePotion(int potion) {
		if(this.hp <= 50) {
			this.hp += potion;
			System.out.println("You have healed 50 hp");
		}
		else {
			System.out.println("Too much hp. You can not use the potion at this time");
		}
		
	}
	
	public void movePlayer(char direction) {
		
		Scanner sc = new Scanner(System.in);
		boolean validMove = false;
		
		while(!validMove) {
			switch(direction) {
		
		
				case 'N' -> {
				if(this.y+1 > final_Y) {
					System.out.println("Can't move north");
				}
				else {
					this.y +=1;
					validMove = true;
				}
				}
				case 'E' -> {
				if(this.x+1 > final_X) {
					System.out.println("Can't move east");
				}
				else {
					this.x +=1;
					validMove = true;
				}
				}
				case 'S' -> {
				if(this.y-1 < min_Y) {
					System.out.println("Can't move south");
				}
				else {
					this.y -=1;
					validMove = true;
				}
				}
				case 'W' ->{
				if(this.x-1 < min_X) {
					System.out.println("Can't move west");
				}
				else {
					this.x -=1;
					validMove = true;
				}
				}
				default -> System.out.println("Not a correct direction");
			}
			
//				if(this.x + 1 > final_X || this.y + 1 > final_Y) {
//					System.out.println("Out of bounds, you can not venture on this path.");
//				}
//				else {
//					this.x = x;
//					this.y = y;
//				}
			
			if(!validMove) {
				
				System.out.println("Please enter a correct directiom: 'N', 'S', 'E', 'W' ");
				direction = sc.next().charAt(0); //user .next()
				sc.nextLine();
				//sc.close();
			
			}
			
				
				
		}
		
	}
		
	

	public abstract void attack(Enemy enemy, Player player);
	
	public abstract void defend(Enemy enemy, Player player);
	
	public abstract void encounter(Player player, Enemy enemy);
	
	public void updateQuest(String questName) {
	        Quest.updateQuest(questName);
	    }
	
	public void triggerBoss(Player player) {
		if(player.getX() == 4 && player.getY() == 3)
		System.out.println("You have encountered the boss!!!");
		Boss boss = new Boss();
		player.encounter(player, boss);
	}
	
	public void showStats() {
		try 
			{
				FileWriter fWriter = new FileWriter("src/main/java/com/bptn/course/PersonalProject/" +this.name+ "-stats.txt");
				
				//write into file
				
				fWriter.write("Stats for " +this.name+ ": \n");
				fWriter.write("Name: " +this.name+ "\n" );
				fWriter.write("Level: " +this.level+ "\n");
				fWriter.write("Exp: " +this.exp+ "\n");
				fWriter.write("Enemies defeated: " +this.enemiesDefeated);
				
				//print file contents
				
				System.out.println("test message");
				
				//close the file writer
				
				fWriter.close();
			
			}
		
		catch (IOException e){
			
			//catch IO Exception
			
			System.out.println(e.getMessage());
			
			
		}
		
	}
	
//	public void levelUp(Player player) {
//		if(this.exp >= 100) {
//			this.level += 1;
//			System.out.println(this.name+ " has leveled up and is now level" +this.level + "!!! ");
//		}
//	}
	
	public void gainExp(int expGain) {
		this.exp+= expGain;
		System.out.println(this.name+ "gained " +expGain+ " exp and now has " +this.exp+ " exp!");
		
		if(this.exp >= 100) {
			this.level += 1;
			System.out.println(this.name+ " has leveled up and is now level" +this.level + "!!! ");
			this.exp = 0;
		}
	}
		
	
	public void takeDamage(int damage) {
		this.hp = this.hp - damage;
		
	}
	
	public abstract String getJob() ;

	
	
	
	
	
	

}
