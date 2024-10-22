package project.packages.textrpg.textrpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Thief extends Player {
	
	String weapon = "dagger";
	
	Thief(String name, int x, int y){
		super(100,name,0,1,25,x,y,0);
		this.weapon = weapon;
		this.attack = 25;
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		System.out.println(this.name+ " attacks with their " +this.weapon+ "!!!");
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
	public void encounter(Player player, RpgMap map) {
		
		Map<Double, String> encounterMap = new HashMap<>();
		
		Random random = new Random();
		int encounterType = random.nextInt(100);
		
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
			
		
			
		

  
	
		if(encounterType <= 25) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType == 15) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(40);
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
	
	

	public String getWeapon() {
		return this.weapon;
	}

	public void updateWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	@Override
	public String getJob(){
		if(this.level >= 0 && this.level <3) {
			return "Thief"; 
		}
		else if(this.level >=3 && this.level < 6) {
			updateWeapon("Twin Daggers");
			return "Night Master";
		}
		else if(this.level >=6) {
			updateWeapon("Shadow Curved Blade");
			return "Night Lord";
		}
		return "Unknown";
	}
	
	
	
	
}

