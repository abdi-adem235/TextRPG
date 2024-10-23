package project.packages.textrpg.characters;

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
	public void attackPlayer(Player player) {
		int damage = random.nextInt(26);
		player.setHp(player.getHp() - damage);
		System.out.println("Player " +player.getName()+ " has taken " +this.damage+ " and has " +player.getHp()+ " remaining");
	}
	
	public int getHp(){
		return super.getHealth();
	}
	
	

}
