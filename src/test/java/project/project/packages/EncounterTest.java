package project.project.packages;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.packages.textrpg.characters.ConcretePlayer;
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
		//Random random = new Random();
		Thief thief = new Thief("TestThief", 0, 0);
		EnemyGenerator enemyGenerator = new EnemyGenerator();
		int health = thief.getThiefHealth();
		int exp = thief.getExp();
		int encounterType = 0;
		assertNotNull(player, "Player should not be null");
		assertNotNull(map, "Map should not be null");
		
		
		player.encounter(player, map);
		
		assertTrue(
				(player.getHp() == health + 40) ||
				(player.getHp() <= health )||
				(player.getHp() == 130)||
				(player.getExp() == exp + 20),
				"Assertion works."
				);
		
	
		
		
		
		
		
		
		
	}

}
