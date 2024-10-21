package project.packages.textrpg.textrpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Warrior extends Player{
	
	
	static String weapon = "sword";
	String type = "warrior";
	
	public Warrior(String name, int x, int y) {
	super(100,name,0,1,25,x,y,0);
	this.weapon = weapon;
	this.attack = 25;
	this.type = "warrior";
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		System.out.println(this.name+ " attacks with their " +Warrior.weapon+ "!!!");
		enemy.takeDamage(this.attack);
		if(enemy.health != 0) {
			System.out.println(enemy.name + " has " +(enemy.health)+ " health remaining");
		}
		
		else if(enemy.getHealth() == 0) {
			System.out.println("You have defeated the" +enemy.getName());
			enemiesDefeated++;
			player.gainExp(20);
		}
			
		else if(player.getHp() <= 0) {
			System.out.println("You have died.");
		}
			
		}
	
	@Override
	public void defend(Enemy enemy, Player player) {
		
		System.out.println(this.name+ " defends");
		
		if(this.type == "warrior" && enemy.name.equals("goblin")) {
			enemy.damage = (int) ((int)enemy.damage*0.75);
			
		
		}
			
	
	@Override
	public void encounter(Player player, Enemy enemy, RpgMap map) {
		
		Map<Double, String> encounterMap = new HashMap<>();
		
		Random random = new Random();
		int encounterType = random.nextInt(100);
		//String regionCoordinates = RpgMap.getRegion(player.getX(), player.getY());


  
		if(encounterType <= 60) {
			if(map.getRegion(player.getX(),player.getY()).equals("Forest")) {
				
				enemy = new Enemy(100,"Goblin",15);
				
			}
			
			else if(map.getRegion(player.getX(),player.getY()).equals("Forest")) {
				
				enemy = new Enemy(100,"Goblin",15);
			}
				
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
			
		}
			
		
			
		if(encounterType <= 25) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType <= 15) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(20);
		}
		
		
        
        System.out.print("Player " +player.name+ " (Level" +this.level+ ") has " +player.hp+ "/100 health");
        System.out.println(" and "+player.exp+ "/100 exp");
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
			return "Paladin";
		}
		else if(this.level >=6) {
			return "Eternal Knight";
		}
		return "Unknown";
	}

	public static String getWeapon() {
		return weapon;
	}

	public static void setWeapon(String weapon) {
		Warrior.weapon = weapon;
	}

}
