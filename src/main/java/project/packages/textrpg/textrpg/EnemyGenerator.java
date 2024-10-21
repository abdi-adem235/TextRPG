package project.packages.textrpg.textrpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import com.bptn.course.PersonalProject.Enemy;

public class EnemyGenerator {
	
	static Map<String, Enemy> enemyMap = new HashMap<>();
	
	public EnemyGenerator(){
		
		enemyMap.put("Forest", new Enemy(100,"Forest Elf",15));
		enemyMap.put("valley", new Enemy(100,"Wyvern",20));
		enemyMap.put("Cave", new Enemy(100,"Golem",20));
		
		
	}
	
	
	public Enemy generateEnemy(Player player, RpgMap map, EnemyGenerator enemygenerator){
		
		
//		switch(region) {
//		
//		
//		
//		case "Forest" ->  enemyList.add(new Enemy(100,"Forest Elf",15));
//		case "Valley" -> enemyList.add(new Enemy(100,"Wyvern",20));
//		case "Cave" -> enemyList.add(new Enemy(100,"Golem",20));
//		
//		}
		Enemy generatedEnemy = null;
		
		 // Using entrySet() to get keys and values
      Set<Map.Entry<String, Enemy>> entries = enemyMap.entrySet();
      for (Map.Entry<String, Enemy> entry : entries) {
      	if(entry.getKey().equals(map.getRegion(player.getX(),player.getY()))) {
      		generatedEnemy = entry.getValue();
      		player.encounter(player, map);
      		//player.attack(enemy,player);
      		System.out.println("A " +generatedEnemy.name+ " has appeared!!!");
      		
      	}
      	
      
	
      }
	return generatedEnemy;
      
	}
	public Map<String,Enemy> getEnemies() {
        return enemyMap;
    }
      


	
	
}
