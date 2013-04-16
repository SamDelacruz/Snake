package com.sdelacruz.snake.view;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.sdelacruz.snake.controller.PlayerController;

public class KeyboardHandler implements InputProcessor {

	private PlayerController playerController;
	
	public KeyboardHandler(PlayerController playerController){
		this.playerController = playerController;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP){
			playerController.upPressed();
		}
		
		if(keycode == Keys.RIGHT){
			playerController.rightPressed();
		}
		
		if(keycode == Keys.DOWN){
			playerController.downPressed();
		}
		
		if(keycode == Keys.LEFT){
			playerController.leftPressed();
		}
		
		if(keycode == Keys.D){
			playerController.debugPressed();
		}
		return true;
	}


	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP){
			playerController.upReleased();
		}
		
		if(keycode == Keys.RIGHT){
			playerController.rightReleased();
		}
		
		if(keycode == Keys.DOWN){
			playerController.downReleased();
		}
		
		if(keycode == Keys.LEFT){
			playerController.leftReleased();
		}
		
		if(keycode == Keys.D){
			playerController.debugReleased();
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
