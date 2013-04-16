package com.sdelacruz.snake.controller;

import com.sdelacruz.snake.model.Arena;
import com.sdelacruz.snake.model.ArenaFruit;
import com.sdelacruz.snake.model.ArenaSquare;
import com.sdelacruz.snake.model.ArenaWall;
import com.sdelacruz.snake.model.Snake;
import com.sdelacruz.snake.model.Snake.State;

public class CollisionHandler {

	private Snake snake;
	private Arena arena;
	private ArenaSquare current = null;
	private float stateTime = 0;
	
	
	public CollisionHandler(Snake snake, Arena arena){
		this.snake = snake;
		this.arena = arena;
	}
	
	public void update(float deltaTime){
		
			stateTime += deltaTime;
			
			if(stateTime >= 1/snake.speed){
		
				current = arena.map[(int) snake.snakeHead.position.x][(int) snake.snakeHead.position.y];
				
				if(current != null){
					//Start handling of any collision events
					
					//Collision with a wall
					if(current instanceof ArenaWall){
						this.snake.state = State.DEAD;
					}
					
					if(current instanceof ArenaFruit){
						this.snake.addNode();
						arena.map[(int) snake.snakeHead.position.x][(int) snake.snakeHead.position.y] = null;
					}
					
				}
				
				else{
					
					for(int i = 1; i < snake.nodes.size; i++){
						if(snake.snakeHead.position.equals(snake.nodes.get(i).position)){
							this.snake.state = State.DEAD;
							break;
						}
					}
				}
				
				stateTime = 0;
			}
	}
	
}
