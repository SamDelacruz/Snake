package com.sdelacruz.snake.controller;

import java.util.HashMap;
import java.util.Map;

import com.sdelacruz.snake.model.Snake;
import com.sdelacruz.snake.view.DebugRenderer;

@SuppressWarnings("unused")
public class PlayerController {

	enum Keys {
		UP,
		RIGHT,
		DOWN,
		LEFT,
		DEBUG
	}
	
	private Snake snake;
	
	public PlayerController(Snake player){
		snake = player;
	}
	
	Keys lastDirection = Keys.UP;
	static boolean debug = false;
	
	public void upPressed(){
		if(lastDirection != Keys.DOWN)
		lastDirection = Keys.UP;
	}
	
	public void rightPressed(){
		if(lastDirection != Keys.LEFT)
		lastDirection = Keys.RIGHT;
	}
	
	public void downPressed(){
		if(lastDirection != Keys.UP)
		lastDirection = Keys.DOWN;
	}
	
	public void leftPressed(){
		if(lastDirection != Keys.RIGHT)
		lastDirection = Keys.LEFT;
	}
	
	public void debugPressed(){
		debug = true;
	}
	
	public void upReleased(){
	}
	
	public void rightReleased(){
	}
	
	public void downReleased(){
	}
	
	public void leftReleased(){
	}
	
	public void debugReleased(){
		debug = false;
	}
	
	public void update(float delta){
		processInput();
		snake.update(delta);
	}
	
	public void processInput(){
		if(lastDirection == Keys.UP){
			snake.snakeHead.futurePosition.set(snake.snakeHead.position.cpy().add(0, 1));
			if(snake.snakeHead.futurePosition.equals(snake.snakeHead.prevPosition))
				snake.snakeHead.futurePosition.add(0 , -2);
		}
		
		if(lastDirection == Keys.RIGHT){
			snake.snakeHead.futurePosition.set(snake.snakeHead.position.cpy().add(1, 0));
			if(snake.snakeHead.futurePosition.equals(snake.snakeHead.prevPosition))
				snake.snakeHead.futurePosition.add(-2 , 0);
			}
		
		if(lastDirection == Keys.DOWN){
			snake.snakeHead.futurePosition.set(snake.snakeHead.position.cpy().add(0, -1));
			if(snake.snakeHead.futurePosition.equals(snake.snakeHead.prevPosition))
				snake.snakeHead.futurePosition.add(0 , 2);
		}
		
		if(lastDirection == Keys.LEFT){
			snake.snakeHead.futurePosition.set(snake.snakeHead.position.cpy().add(-1, 0));
			if(snake.snakeHead.futurePosition.equals(snake.snakeHead.prevPosition))
				snake.snakeHead.futurePosition.add(2 , 0);
		}
		
		DebugRenderer.debugMode = debug;
		
	}
	
}
