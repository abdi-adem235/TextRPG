package project.packages.textrpg.textrpg;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class RpgMap {
	
	private static Map<List<Integer>, String> map = new HashMap<>();
	
	public RpgMap() {
		map.put(List.of(0,0), "Start");
		map.put(List.of(0,1), "Forest");
		map.put(List.of(0,2), "Forest");
		map.put(List.of(1,0), "Forest");
		map.put(List.of(2,0), "Forest");
		map.put(List.of(1,1), "Forest");
		map.put(List.of(2,1), "Forest");
		map.put(List.of(1,2), "Forest");
		map.put(List.of(2,2), "Forest");
		map.put(List.of(3,0), "Valley");
		map.put(List.of(4,0), "Valley");
		map.put(List.of(3,1), "Valley");
		map.put(List.of(4,1), "Valley");
		map.put(List.of(3,2), "Valley");
		map.put(List.of(4,2), "Valley");
		map.put(List.of(0,3), "Cave");
		map.put(List.of(1,3), "Cave");
		map.put(List.of(2,3), "Cave");
		map.put(List.of(3,3), "Cave");
		map.put(List.of(4,3), "Boss Zone");
	}
	
	public String getRegion(int x, int y) {
		List<Integer> coordinates = List.of(x,y);
        return map.get(coordinates);
    }
	
	
	
	

}
