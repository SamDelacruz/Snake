package com.sdelacruz.snake.model;

public class GameStats {

	public int score = 0;
	private float stateTime = 0;
	private float scoreMultiplier = 1f;
	private Snake snake;
	
	public GameStats(Snake snake){
		this.snake = snake;
	}
	
	public void update(float deltaTime){
		stateTime += deltaTime;
		scoreMultiplier = snake.speed;
		if(stateTime >= 1/snake.speed){
			score += scoreMultiplier;
			score += scoreMultiplier * (snake.nodes.size);
			stateTime = 0;
		}
	}
	
	private void setMultiplier(float x){
		this.scoreMultiplier = x;
	}
	
	private void addFruit(int value){
		score += score + (value * scoreMultiplier);
	}
	
}
