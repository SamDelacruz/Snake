package com.sdelacruz.snake.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.sdelacruz.snake.model.Arena;
import com.sdelacruz.snake.model.ArenaFruit;
import com.sdelacruz.snake.model.ArenaWall;
import com.sdelacruz.snake.model.Snake;
import com.sdelacruz.snake.model.SnakeNode;

public class DebugRenderer implements Renderer {
	
	public static boolean debugMode = false;
	
	private Arena arena;
	private Snake snake;
	private OrthographicCamera cam;
	private ShapeRenderer renderer;
	
	public DebugRenderer(Arena arena, Snake snake, OrthographicCamera cam){
		this.arena = arena;
		this.snake = snake;
		this.cam = cam;
		this.renderer = new ShapeRenderer();
	}

	@Override
	public void render() {
		
		if(!debugMode){
			
			renderer.setProjectionMatrix(cam.combined);
			renderer.begin(ShapeType.Line);
			renderer.setColor(1,0,0,1);
			
			for(int j = 0; j < arena.HEIGHT_IN_CELLS; j++){
				for(int i = 0; i < arena.WIDTH_IN_CELLS; i++){
					if(arena.map[i][j] instanceof ArenaWall){
						renderer.rect(i, j, 1, 1);
					}
					
					else{
						if(arena.map[i][j] instanceof ArenaFruit){
							renderer.setColor(0,0,1,1);
							renderer.rect(i, j, 1, 1);
							renderer.setColor(1,0,0,1);
						}
					}
					
				}
			}
			renderer.setColor(0, 1, 0, 1);
			
			for(SnakeNode node : snake.nodes){
				
				renderer.rect(node.position.x,node.position.y,1,1);
			}
			
			renderer.end();
			
	
		}
	}
}
