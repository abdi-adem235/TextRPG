package project.packages.textrpg.textrpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import com.bptn.course.PersonalProject.Enemy;

public class EnemyGenerator {
	
	static Map<Enemy, String> enemyMap = new HashMap<>();
	
	public EnemyGenerator(){
		
		enemyMap.put(new Enemy(100,"Forest Elf",15), "Forest");
		enemyMap.put(new Enemy(100,"Wyvern",20), "Valley");
		enemyMap.put(new Enemy(100,"Golem",20), "Cave");
		
		
	}
	
	
	public void generateEnemy(Player player, RpgMap map, EnemyGenerator enemygenerator){
		
		
//		switch(region) {
//		
//		
//		
//		case "Forest" ->  enemyList.add(new Enemy(100,"Forest Elf",15));
//		case "Valley" -> enemyList.add(new Enemy(100,"Wyvern",20));
//		case "Cave" -> enemyList.add(new Enemy(100,"Golem",20));
//		
//		}
		
		
		 // Using entrySet() to get keys and values
      Set<Map.Entry<Enemy, String>> entries = enemyMap.entrySet();
      for (Map.Entry<Enemy, String> entry : entries) {
      	if(entry.getValue().equals(map.getRegion(player.getX(),player.getY()))) {
      		Enemy enemy = entry.getKey();
      		player.attack(enemy,player);
      		
      	}
      	
      
	
      }
      
	}
	public Map<Enemy,String> getEnemies() {
        return enemyMap;
    }
      


	
	
}
