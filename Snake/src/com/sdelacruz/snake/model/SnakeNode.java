package com.sdelacruz.snake.model;

import com.badlogic.gdx.math.Vector2;

public class SnakeNode {

	public Vector2 futurePosition = new Vector2();
	public Vector2 position = new Vector2();
	public Vector2 prevPosition = new Vector2();
	
	SnakeNode parentNode;
	
	public SnakeNode(SnakeNode parent, int startX, int startY){
		parentNode = parent;
		position.x = startX;
		position.y = startY;
		
		if(parent != null){
			futurePosition = parent.position;
		}
		else {
			futurePosition.set(startX, startY + 1);
		}
		prevPosition.y = startY - 1;
		prevPosition.x = startX;
		
		
	}
	
	public void update(){
		
		//store the last position - for new nodes
		this.prevPosition = this.position.cpy();
		this.position = futurePosition.cpy();
		if(parentNode != null)
			this.futurePosition = parentNode.position;
		
		
	}
	
	
	
}
