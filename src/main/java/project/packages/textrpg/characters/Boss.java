package project.packages.textrpg.characters;

import java.util.Random;

import project.packages.textrpg.utilities.ConsoleColors;

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
		int damage = random.nextInt(30);
		player.setHp(player.getHp() - damage);
		System.out.println(ConsoleColors.CYAN + "Player " +player.getName()+ " has taken " +damage+ " and has " +player.getHp()+ " remaining" + ConsoleColors.RESET);
	}
	
	public int getHp(){
		return super.getHealth();
	}
	
	

}
