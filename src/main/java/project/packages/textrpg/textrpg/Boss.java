package project.packages.textrpg.textrpg;

import java.util.Random;

public class Boss extends Enemy {
	
	Random random = new Random();
	int boss_X = 4;
	int boss_Y = 3;
	
	int exp = 30;
	
	public Boss() {
		super(150, "Time Lord",30);
	}
	
	@Override
	void attackPlayer(Player player) {
		int damage = random.nextInt(26);
		player.hp -= damage;
		System.out.println("Player " +player.name+ " has taken " +this.damage+ " and has " +player.hp+ " remaining");
	}
	
	public int getHp(){
		return super.health;
	}
	
	

}
