package com.sdelacruz.snake.view;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.sdelacruz.snake.controller.PlayerController;

public class GestureHandler implements GestureListener {

	private PlayerController playerController;
	
	public GestureHandler(PlayerController playerController){
		this.playerController = playerController;
	}
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		//Check for horizontal swipe
		if(Math.abs(velocityX) > Math.abs(velocityY)){
			if(velocityX > 32){
				playerController.rightPressed();
			}
			else{
				if(Math.abs(velocityX) > 32){
					playerController.leftPressed();
				}
			}
		}
		
		else{
			//Y coords are reversed...
			if(velocityY > 32){
				playerController.downPressed();
			}
			else{
				if(Math.abs(velocityY) > 32){
					playerController.upPressed();
				}
			}
		}
		
		return true;
	}


	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}


}
