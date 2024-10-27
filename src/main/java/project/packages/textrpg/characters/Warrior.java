package project.packages.textrpg.characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import project.packages.textrpg.ingame.Quest;
import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.ConsoleColors;
import project.packages.textrpg.utilities.EnemyGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Warrior extends Player{
	
	
	private String weapon = "sword";
	private String type = "warrior";
	
	public Warrior(String name, int x, int y) {
	super(100, name, 1, 25, x, y, 0);
	this.weapon = weapon;
	this.attack = 25;
	this.type = "warrior";
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		player.getJob();
		System.out.println(ConsoleColors.GREEN + this.name+ " attacks with their " +this.getWeapon()+ "!!!" + ConsoleColors.RESET);
		enemy.takeDamage(this.attack);
		if(enemy.getHealth() > 0) {
			System.out.println(enemy.getName() + " has " +(enemy.getHealth())+ " health remaining");
		}
		
		else {
			System.out.println("You have defeated the " +enemy.getName());
			incrementEnemiesDefeated();
			player.gainExp(20);
		}
			
			
		}
			
	
	@Override
	public void encounter(Player player, RpgMap map) {
		
		Map<Double, String> encounterMap = new HashMap<>();
		
		Random random = new Random();
		int encounterType = random.nextInt(100);
		//String regionCoordinates = RpgMap.getRegion(player.getX(), player.getY());
		EnemyGenerator enemygenerator = new EnemyGenerator();

		if(encounterType < 10) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType > 10 && encounterType < 20) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(20);
		}
		
		else if(encounterType > 20 && encounterType < 30) {
			System.out.println("A mysterious glow has enveloped the area. You feel a sudden boost in energy!");
			player.setAttack(40);
		}
		
		
		else if(encounterType > 50) {
			
			Enemy enemy = enemygenerator.generateEnemy(player, map, enemygenerator);
				
				
			while (enemy.getHealth() > 0 && player.getHp() > 0) {
				
				player.attack(enemy,player);
				System.out.println("-------------");
				
				
				if(enemy.getHealth() > 0) {
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					enemy.attackPlayer(player);
					System.out.println("-------------");
					
				}
				
				
				
				
				if (player.getHp() <= 0) {
			        System.out.println("...");
			        break; // Exit the loop if player health is zero
			    }
				
			}
			
			Quest.questTwo(player);
			
			
			
			
			
			}
			
		
		
		
        
        System.out.print("Player " +this.getName()+ " (Level" +this.level+ ") has " +player.hp+ "/100 health");
        System.out.println(" and "+player.exp+ "/100 exp");
        
	}

	
	
	public int getExp(){
		if(this.level == 0) {
			this.exp = 0;
		}
		return this.exp;
	}
	
	public void updateAttack(int attack) {
		this.attack = attack;
	}
	
	@Override
	public String getJob() {
		
		if(this.level >= 1 && this.level <2) {
			return "Warrior";
		}
		else if(this.level >=2 && this.level < 4) {
			updateWeapon("Broadsword");
			updateAttack(35);
			return "Paladin";
		}
		else if(this.level >=4) {
			updateWeapon("Legendary Greatsword");
			updateAttack(45);
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
	