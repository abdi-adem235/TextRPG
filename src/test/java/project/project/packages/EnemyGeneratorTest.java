package project.project.packages;



import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.packages.textrpg.characters.ConcretePlayer;
import project.packages.textrpg.characters.Enemy;
import project.packages.textrpg.characters.Player;
import project.packages.textrpg.ingame.RpgMap;
import project.packages.textrpg.utilities.EnemyGenerator;

public class EnemyGeneratorTest {
	
	
	EnemyGenerator generator;
	RpgMap map;
	ConcretePlayer player; 
	
	@BeforeEach
	public void setUp(){
		
		generator = new EnemyGenerator();
		map = new RpgMap();
		player = new ConcretePlayer("sss",1,24);
		
	}

	

	@Test
	public void generateEnemyinForest() {
		player.setX(1);
		player.setY(1);
		String region = map.getRegion(player.getX(),player.getY());
		assertEquals("Forest",region);
		
		//Generate enemy for Forest
		
		Enemy enemy = generator.generateEnemy(player, map, generator);
		assertTrue(enemy.getName().equals("Forest Elf"));
		
	}

	@Test
	public void generateEnemyinValley() {
		player.setX(3);
		player.setY(0);
		String region = map.getRegion(player.getX(),player.getY());
		assertEquals("Valley",region);
		
		//Generate enemy for Valley
		
		Enemy enemy = generator.generateEnemy(player,map,generator);
		assertTrue(enemy.getName().equals("Wyvern"));;
		
		
	}





}