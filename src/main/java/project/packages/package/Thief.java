package com.bptn.course.PersonalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Thief extends Player {
	
	static String weapon = "dagger";
	
	Thief(String name, int x, int y){
		super(100,name,0,1,25,x,y,0);
		this.weapon = weapon;
		this.attack = 25;
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		System.out.println(this.name+ " attacks with their " +Thief.weapon+ "!!!");
		enemy.takeDamage(this.attack);
		if(enemy.health != 0) {
			System.out.println(enemy.name + " has " +(enemy.health)+ " health remaining");
		}
		
		else if(enemy.getHealth() == 0) {
			System.out.println("You have defeated the" +enemy.getName());
			enemiesDefeated++;
			player.gainExp(20);
		}
			
		else if(this.hp <= 0) {
			System.out.println("You have died.");
		}
			
	}
	
	@Override
	public void encounter(Player player, Enemy enemy) {
		
		Map<Double, String> encounterMap = new HashMap<>();
		
		Random random = new Random();
		int encounterType = random.nextInt(100);
		


  
		if(encounterType <= 60) {
			System.out.println("A " +enemy.name+ " has appeared!!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (enemy.getHealth() > 0 && player.getHp() > 0) {
				player.attack(enemy,player);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				enemy.attackPlayer(player);
			}
			
		}
			
		if(encounterType <= 25) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType == 15) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(20);
		}
		
		
        
        System.out.println("Player (Level" +this.level+ ") has " +player.hp+ " health remaining");
        System.out.println("Player " +player.name+ " has " +player.exp+ " exp");
//		encounterMap.put(0.45, "An" +enemy.name+ " has appeared!");
//		encounterMap.put(0.25, "You have found a healing well and have replenished some hp!");
//		encounterMap.put(0.30, "You have found a treasure chest and have been granted some exp!");
//		
//		 // Using entrySet() to get keys and values
//        Set<Map.Entry<Double, String>> entries = encounterMap.entrySet();
//        for (Map.Entry<Double, String> entry : entries) {
//        	if(entry.getKey() == 0.45) {
//        		enemy = new Enemy(100,"Dragon");
//        		System.out.println(entry.getValue());
//        		player.attack(enemy);
//        		
//        	}
//        	
//        	else if(entry.getKey() == 0.25) {
//        		System.out.println(entry.getValue());
//        	}
//        	
//        	else if(entry.getKey() == 0.30) {
//        		System.out.println(entry.getValue());
//        	}
        }
	
	

	public static String getWeapon() {
		return weapon;
	}

	public static void setWeapon(String weapon) {
		Thief.weapon = weapon;
	}
	
	@Override
	public String getJob(){
		if(this.level >= 0 && this.level <5) {
			return "Thief"; 
		}
		else if(this.level >=5 && this.level < 10) {
			return "Night Master";
		}
		else if(this.level >=10) {
			return "Night Lord";
		}
		return "Unknown";
	}
	
	
	
	
}

