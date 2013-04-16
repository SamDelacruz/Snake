package com.sdelacruz.snake;

import com.badlogic.gdx.Game;
import com.sdelacruz.snake.view.GameScreen;

public class SnakeMain extends Game {

	GameScreen gameScreen;
	
	@Override
	public void create() {
		gameScreen = new GameScreen(this);
		setScreen(gameScreen);
		
	}
	
}
