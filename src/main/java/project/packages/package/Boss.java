package com.bptn.course.PersonalProject;

public class Boss extends Enemy {
	
	int boss_X = 4;
	int boss_Y = 3;
	
	int exp = 30;
	
	public Boss() {
		super(150, "Time Lord",30);
	}
	
	@Override
	void attackPlayer(Player player) {
		player.hp -= damage;
		System.out.println("Player " +player.name+ " has taken " +this.damage+ " and has " +player.hp+ " remaining");
	}
	
	

}
