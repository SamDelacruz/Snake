package com.sdelacruz.snake.model;

import java.util.Random;

public class Arena {

	public final int WIDTH_IN_CELLS = 32;
	public final int HEIGHT_IN_CELLS = 32;
	
	private Random randomW = new Random();
	private Random randomH = new Random();
	
	private float stateTime = 0;
	
	private int fruitTime = 5;
	
	public ArenaSquare[][] map = new ArenaSquare[WIDTH_IN_CELLS][HEIGHT_IN_CELLS];
	
	public void initWalls(){
		for(int j = 0; j < HEIGHT_IN_CELLS; j++){
			for(int i = 0; i < WIDTH_IN_CELLS; i++){
				if(j == 0 || j == (HEIGHT_IN_CELLS - 1) || i == 0 || i == (WIDTH_IN_CELLS - 1))
					map[i][j] = new ArenaWall();
			}
		}
	}
	
	public void update(float delta){
		stateTime += delta;
		if(stateTime >= fruitTime){
			int i = randomW.nextInt(WIDTH_IN_CELLS);
			int j = randomH.nextInt(HEIGHT_IN_CELLS);
			
			if(map[i][j] == null)
				map[i][j] = new ArenaFruit();
			
			stateTime = 0;
		}
	}
	
}
