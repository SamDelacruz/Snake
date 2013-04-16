package com.sdelacruz.snake.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.sdelacruz.snake.model.GameStats;

public class ScoreBarRenderer implements Renderer {

	
	private GameStats stats;
	private OrthographicCamera cam;
	private SpriteBatch batch;
	private ShapeRenderer shape;

	private BitmapFont titleFont;
	private BitmapFont scoreFont;

	
	public ScoreBarRenderer(GameStats stats, OrthographicCamera cam){
		this.stats = stats;
		this.cam = cam;
		
		batch = new SpriteBatch();
		
		shape = new ShapeRenderer();
		
		titleFont = new BitmapFont();
		titleFont.getRegion().getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		titleFont.setUseIntegerPositions(false);
		titleFont.setScale(0.15f);
		scoreFont = new BitmapFont();
		scoreFont.getRegion().getTexture().setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		scoreFont.setUseIntegerPositions(false);
		scoreFont.setScale(0.1f);
		
	}
	
	@Override
	public void render() {
		
		shape.setProjectionMatrix(cam.combined);
		batch.setProjectionMatrix(cam.combined);
		
		shape.begin(ShapeType.Line);
		shape.setColor(0, 1, 0, 1);
		
		shape.rect(32, 0, 16, 32);
		
		shape.end();
		
		batch.begin();
		titleFont.draw(batch, "TurboSnake", 34, 28);
		scoreFont.draw(batch, "Score: "+stats.score, 34, 25);
		batch.end();

	}

}
