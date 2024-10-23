package project.packages.textrpg.characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.EnemyGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Warrior extends Player{
	
	
	String weapon = "sword";
	String type = "warrior";
	
	public Warrior(String name, int x, int y) {
	super();
	this.weapon = weapon;
	this.attack = 25;
	this.type = "warrior";
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		System.out.println(this.name+ " attacks with their " +this.getWeapon()+ "!!!");
		enemy.takeDamage(this.attack);
		if(enemy.health != 0) {
			System.out.println(enemy.name + " has " +(enemy.health)+ " health remaining");
		}
		
		else if(enemy.getHealth() == 0) {
			System.out.println("You have defeated the" +enemy.getName());
			this.incrementEnemiesDefeated();
			player.gainExp(20);
		}
			
		else if(player.getHp() <= 0) {
			System.out.println("You have died.");
		}
			
		}
	
//	@Override
//	public void defend(Enemy enemy, Player player) {
//		
//		System.out.println(this.name+ " defends");
//		
//		if(this.type == "warrior" && enemy.name.equals("goblin")) {
//			enemy.damage = (int) ((int)enemy.damage*0.75);
//			
//		
//		}
			
	
	@Override
	public void encounter(Player player, RpgMap map) {
		
		Map<Double, String> encounterMap = new HashMap<>();
		
		Random random = new Random();
		int encounterType = random.nextInt(100);
		//String regionCoordinates = RpgMap.getRegion(player.getX(), player.getY());
		EnemyGenerator enemygenerator = new EnemyGenerator();

  
		if(encounterType < 50) {
			
			Enemy enemy = enemygenerator.generateEnemy(player, map, enemygenerator);
				
				
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
			
		
			
		
			
		else if(encounterType <= 25) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType <= 15) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(20);
		}
		
		else if(encounterType <= 10) {
			System.out.println("A mysterious glow has enveloped the area. You feel a sudden boost in energy!");
			player.setAttack(40);
		}
		
		
        
        System.out.print("Player " +player.name+ " (Level" +this.level+ ") has " +player.hp+ "/100 health");
        System.out.println(" and "+player.exp+ "/100 exp");
        
	}
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
        
	
//	
//	@Override
//	void defend() {
//		System.out.println(this.name+ " attacks with their " +Warrior.weapon+ "!!!");
//	}
	
	
	
	public int getExp(){
		if(this.level == 0) {
			this.exp = 0;
		}
		return this.exp;
	}
	
	@Override
	public String getJob() {
		
		if(this.level >= 0 && this.level <3) {
			return "Warrior";
		}
		else if(this.level >=3 && this.level < 6) {
			updateWeapon("Broadsword");
			return "Paladin";
		}
		else if(this.level >=6) {
			updateWeapon("Legendary Greatsword");
			return "Eternal Knight";
		}
		return "Unknown";
		
	}


	public void updateWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public String getWeapon() {
		return this.weapon;
	}


}
	