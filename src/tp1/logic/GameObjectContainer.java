package tp1.logic;

import java.util.ArrayList;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Goomba;
import tp1.logic.gameobjects.Ground;
import tp1.logic.gameobjects.Mario;

public class GameObjectContainer {
//	private ArrayList<Ground> groundList;		   // advanced implementation
	private Ground[] groundList;
	
	private Goomba goomba;
	private ExitDoor exitDoor;
	private Mario mario;
	
	private int counter = 0;
	
	public GameObjectContainer() {
//		groundList = new ArrayList<Ground>();		// advanced implementation
	}
	
	public void add(Ground ground) {		
		// counter will work as the position in which the ground is added?¿
		groundList[counter] = ground;
		counter++;
	}
	

}
