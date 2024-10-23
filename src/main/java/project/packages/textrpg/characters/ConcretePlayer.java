package project.packages.textrpg.characters;

import project.packages.textrpg.ingame.RpgMap;

public class ConcretePlayer extends Player {
    public ConcretePlayer(String name, int x, int y) {
        super();
    }
    

    @Override
    public void encounter(Player player, RpgMap map) {
    	int x  = 1+2;
    }
    
    @Override
    public String getJob() {
    	return "Aaa";
    }
    
    @Override
    public void attack(Enemy enemy, Player player) {
    	int x  = 1+2;
    }
}

