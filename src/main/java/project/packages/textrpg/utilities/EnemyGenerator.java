package project.packages.textrpg.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import project.packages.textrpg.characters.Enemy;
import project.packages.textrpg.characters.Player;
import project.packages.textrpg.ingame.RpgMap;

//import com.bptn.course.PersonalProject.Enemy;

public class EnemyGenerator {
	
	static Map<String, Enemy> enemyMap = new HashMap<>();
	
	//constructor for Enemy Generator class - hashmap with regions, enemy objects
	public EnemyGenerator(){
		
		enemyMap.put("Forest", new Enemy(100,"Forest Elf",15));
		enemyMap.put("Valley", new Enemy(100,"Wyvern",20));
		enemyMap.put("Cave", new Enemy(100,"Golem",20));
		
		
	}
	
	
	public Enemy generateEnemy(Player player, RpgMap map, EnemyGenerator enemygenerator){
		
		

		Enemy generatedEnemy = null;
		
		 // Using entrySet() to get keys and values
	      Set<Map.Entry<String, Enemy>> entries = enemyMap.entrySet();
	      for (Map.Entry<String, Enemy> entry : entries) {
	      	if(entry.getKey().equals(map.getRegion(player.getX(),player.getY()))) {
	      		generatedEnemy = entry.getValue();
	      		//player.encounter(player, map);
	      		//player.attack(enemy,player);
	      		System.out.println("A " +generatedEnemy.getName()+ " has appeared!!!");
	      		break;
	      		
	      	}
      	
      
	
      }
	return generatedEnemy;
      
	}
	public Map<String,Enemy> getEnemies() {
        return enemyMap;
    }
      


	
	
}
