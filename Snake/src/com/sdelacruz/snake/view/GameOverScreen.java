package com.sdelacruz.snake.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.sdelacruz.snake.SnakeMain;
import com.sdelacruz.snake.model.GameStats;

public class GameOverScreen implements Screen {
	
	private SnakeMain mainGameWrapper;
	
	private GameStats stats;
	
	private Stage stage;
	
	
	public GameOverScreen(SnakeMain main, GameStats stats){
		this.mainGameWrapper = main;
		this.stats = stats;
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();
		

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage(800,480, false);
		stage.setCamera(new OrthographicCamera(800,480));
		stage.getCamera().position.set(400, 240, 0f);
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		
		table.setFillParent(true);
				
		stage.addActor(table);
		
		
		BitmapFont gameOverFont = new BitmapFont();
		gameOverFont.getRegion().getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		gameOverFont.scale(2f);
		
		BitmapFont scoreFont = new BitmapFont();
		scoreFont.getRegion().getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		scoreFont.scale(1.5f);
		
		BitmapFont buttonFont = new BitmapFont();
		buttonFont.getRegion().getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		buttonFont.scale(2f);
		
		Label gameOverText = new Label("Game Over", new LabelStyle(gameOverFont, Color.WHITE));
		table.add(gameOverText);
		table.row();
		
		Label score = new Label("Score: "+stats.score, new LabelStyle(scoreFont, Color.GREEN));
		table.add(score);
		table.row();
		
		TextButtonStyle tbtnStyle = new TextButtonStyle();
			tbtnStyle.font = buttonFont;
			tbtnStyle.fontColor = Color.WHITE;
			tbtnStyle.pressedOffsetY = 2f;
			tbtnStyle.downFontColor = new Color(0.8f,0.8f,0.8f,1);
		

			
		TextButton retryButton = new TextButton("Retry", tbtnStyle);
		retryButton.padTop(5f);
		retryButton.padBottom(5f);
		table.add(retryButton).center().colspan(2);
		
		table.row();
		
		TextButton quitButton = new TextButton("Quit", tbtnStyle);
		quitButton.padTop(5f);
		quitButton.padBottom(5f);
		table.add(quitButton).center().colspan(2);
		
		retryButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				mainGameWrapper.setScreen(new GameScreen(mainGameWrapper));
			}
		});
		
		quitButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				Gdx.app.exit();
			}
		});
		
		
	}

	@Override
	public void hide() {

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
		stage.dispose();

	}

}
