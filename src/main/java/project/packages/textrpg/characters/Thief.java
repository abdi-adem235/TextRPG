package project.packages.textrpg.characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import project.packages.textrpg.ingame.Quest;
import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.ConsoleColors;
import project.packages.textrpg.utilities.EnemyGenerator;

public class Thief extends Player {
	
	String weapon = "dagger";
	
	public Thief(String name, int x, int y){
		super(100, name, 1, 25, x, y, 0);
		this.weapon = weapon;
		this.attack = 25;
	}
	
	@Override
	public void attack(Enemy enemy, Player player) {
		player.getJob();
		System.out.println(ConsoleColors.MAGENTA + this.name+ " attacks with their " +this.weapon+ "!!!" + ConsoleColors.RESET);
		enemy.takeDamage(this.attack);
		if(enemy.getHealth() > 0) {
			System.out.println(enemy.getName() + " has " +(enemy.getHealth())+ " health remaining");
		}
		
		else{
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
		
		EnemyGenerator enemygenerator = new EnemyGenerator();

		if(encounterType < 10) {
			System.out.println("You have found a treasure chest and have been granted some exp!");
			player.gainExp(20);
		}
			
		else if(encounterType > 10 && encounterType < 20) {
			System.out.println("You have found a healing well and have replenished some hp!");
			player.gainHP(40);
		}
		
		else if(encounterType > 20 && encounterType < 30) {
			System.out.println("A mysterious glow has enveloped the area. You feel a sudden boost in energy!");
			player.setHp(130);
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
			
		
		
		
        
		  System.out.print("Player " +this.getName()+ " (Level" +this.getLevel()+ ") has " +player.getHp()+ "/100 health");
	      System.out.println(" and "+player.getExp()+ "/100 exp");
	       
        
	
	}
	
  public int getThiefHealth() {
        return super.getHp(); // Accessing health using super
    }

	public String getWeapon() {
		return this.weapon;
	}

	public void updateWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public void updateAttack(int attack) {
		this.attack = attack;
	}
	
	@Override
	public String getJob(){
		if(this.getLevel() >= 1 && this.getLevel() <2) {
			return "Thief"; 
		}
		else if(this.getLevel() >=2 && this.getLevel() < 4) {
			updateWeapon("Twin Daggers");
			updateAttack(35);
			return "Night Master";
		}
		else if(this.getLevel() >=4) {
			updateWeapon("Shadow Curved Blade");
			updateAttack(45);
			return "Night Lord";
		}
		return "Unknown";
	}
	
	
	
	
}

