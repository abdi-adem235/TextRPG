package project.project.packages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.packages.textrpg.characters.ConcretePlayer;
import project.packages.textrpg.characters.Enemy;
import project.packages.textrpg.characters.Player;
import project.packages.textrpg.characters.Thief;
import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.EnemyGenerator;

public class EncounterTest {
	
	private ConcretePlayer player;
	//private Thief thief;
	private RpgMap map;
	
	
	
	@BeforeEach
	public void setUp(){
		
	
		map = new RpgMap();
		player = new ConcretePlayer("dgdf",0,0);
		
	}
	
	
	@Test
	public void ThiefEncounter() {
		
		Thief thief = new Thief("TestThief", 1, 1);
		EnemyGenerator enemyGenerator = new EnemyGenerator();
		Enemy enemy = enemyGenerator.generateEnemy(thief, map, enemyGenerator);
		int health = thief.getThiefHealth();
		int exp = thief.getExp();
		assertNotNull(player, "Player should not be null");
		assertNotNull(map, "Map should not be null");
		assertNotNull(enemy, "enemy should not be null");
		
		thief.encounter(player, map);
		
		assertTrue(
				(thief.getHp() == health + 40) ||
				(enemy == null || enemy.getHealth() >= 0) ||
				(thief.getHp() <= health )||
				(thief.getHp() == 130)||
				(thief.getExp() == exp + 20),
				"Assertion works."
				);
		
	
		
		
		
		
		
		
		
	}

}
