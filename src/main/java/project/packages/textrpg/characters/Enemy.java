package project.packages.textrpg.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import project.packages.textrpg.utilities.ConsoleColors;



public class Enemy {
	
		private Integer health;
		private String name;
		//Player player;
		protected int damage;
		int exp = 20;
		
		public Enemy(Integer health, String name, int damage) {
			this.health = health;
			this.name = name;
			this.damage = damage;
		}
		
		
		public void generateEnemy(){
			List<Enemy> enemyList = new ArrayList<>();
			enemyList.add(new Enemy(100,"Wyvern",20));
			enemyList.add(new Enemy(100,"Forest Elf",15));
			enemyList.add(new Enemy(100,"Golem",20));
			
		}
		
		public void attackPlayer(Player player) {
			
	        Random random = new Random();
	        int damage = random.nextInt(16);
			player.hp -= damage;
			System.out.println(ConsoleColors.RED + "Enemy " +this.getName()+ " has inflicted " +damage+ " damage and " +player.getName()+ " has " +player.getHp()+ " health remaining" + ConsoleColors.RESET);
			
		}
		
		public int getDamage() {
			return this.damage;
		}


		public void setDamage(int damage) {
			this.damage = damage;
		}


		void takeDamage(int damage) {
			this.health -= damage;
			
		}
		
		void dropLoot() {
			if (this.health == 0){
				
			}
			
		}


		public Integer getHealth() {
			return health;
		}


		public void setHealth(Integer health) {
			this.health = health;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


//		public Player getPlayer() {
//			return player;
//		}
//
//
//		public void setPlayer(Player player) {
//			this.player = player;
//		}
//		
		
		
		

	}


