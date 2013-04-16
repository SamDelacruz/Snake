package com.sdelacruz.snake.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.sdelacruz.snake.SnakeMain;
import com.sdelacruz.snake.controller.CollisionHandler;
import com.sdelacruz.snake.controller.PlayerController;
import com.sdelacruz.snake.model.Arena;
import com.sdelacruz.snake.model.GameStats;
import com.sdelacruz.snake.model.Snake;
import com.sdelacruz.snake.model.Snake.State;

public class GameScreen implements Screen{

	private SnakeMain mainGameWrapper;
	
	private Snake playerSnake;

	private OrthographicCamera cam;
	
	private Arena arena;
	
	private GameStats gameStats;
	
	private Array<Renderer> renderers = new Array<Renderer>();
	
	private PlayerController playerController;
	private KeyboardHandler keyboardHandler;
	private GestureHandler gestureHandler;
	private CollisionHandler collisionHandler;
	
	public static int VIEWPORT_WIDTH = 48;
	public static int VIEWPORT_HEIGHT = 32;
	
	public GameScreen(SnakeMain snakeMain) {
		this.mainGameWrapper = snakeMain;
		this.cam = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		cam.position.set(VIEWPORT_WIDTH/2,VIEWPORT_HEIGHT/2,0);
		cam.update();
		
		arena = new Arena();
		playerSnake = new Snake(VIEWPORT_WIDTH/2,VIEWPORT_HEIGHT/2,5);
		gameStats = new GameStats(this.playerSnake);
		
		playerController = new PlayerController(this.playerSnake);
		keyboardHandler = new KeyboardHandler(this.playerController);
		gestureHandler = new GestureHandler(this.playerController);
		collisionHandler = new CollisionHandler(this.playerSnake, this.arena);
		
		renderers.add(new DebugRenderer(this.arena, this.playerSnake, cam));
	}


	@Override
	public void render(float delta) {
		arena.update(delta);
		playerController.update(delta);
		collisionHandler.update(delta);
		gameStats.update(delta);
		
		if(this.playerSnake.state == State.DEAD){
			mainGameWrapper.setScreen(new GameOverScreen(mainGameWrapper, gameStats));
		}
		
		else{
		
			Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			
			for(Renderer r : renderers){
				r.render();
			}
		}
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(new InputMultiplexer(new GestureDetector(this.gestureHandler), this.keyboardHandler));
		arena.initWalls();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
