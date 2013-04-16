package com.sdelacruz.snake.model;

import com.badlogic.gdx.utils.Array;

public class Snake {

	public float speed = 1.5f;
	public final static int MAX_LENGTH = 100;
	public Array<SnakeNode> nodes = new Array<SnakeNode>(MAX_LENGTH);
	public SnakeNode snakeHead;
	public SnakeNode snakeEnd;
	public boolean newNodeNeeded = false;
	
	private float stateTime = 0f;
	public State state;
	
	public enum State {
		ALIVE,
		DEAD
	}
	
	public Snake(int x, int y, int n){
		state = State.ALIVE;
		
		SnakeNode head = new SnakeNode(null, x, y);
		nodes.add(head);
		snakeHead = head;
		snakeEnd = head;
		
		if(n>1){
			for(int i = 0; i < n-1; i++){
				addNode();
			}
		}
		
	}
	
	public void addNode(){
		if(nodes.size <= MAX_LENGTH){
			SnakeNode tmp = new SnakeNode(snakeEnd, (int)snakeEnd.prevPosition.x, (int)snakeEnd.prevPosition.y);
			nodes.add(tmp);
			snakeEnd = tmp;
			speed += 0.1f;
		}
	}
	
	public void update(float delta){
		//increment the internal timer
		stateTime += delta;
		if(state == State.ALIVE){
			if(stateTime >= (1/speed)){
				for(SnakeNode node : nodes){
					node.update();
				}
				
				stateTime = 0f;
			}
		
		}
	}
	
}
