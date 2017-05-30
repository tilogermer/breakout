package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;


public class BallDepot implements Displayable, Measureable {
	
	/**
	 * ArrayList to store the balls
	 */
	ArrayList<Ball> balls = new ArrayList<>();
	
	/**
	 * x- and y-position of the ballDepot and distance between the single balls
	 */
	private int depotX;
	private int depotY;
	private int offset = 50;
	
	/**
	 * creates the ballDepot in the right bottom corner of the screen
	 * number of balls according to setting in GameConstant
	 * @param game Game class to access the Processing features
	 */
	public BallDepot(Game game) {
		balls = new ArrayList<>();
		
		depotX = game.width - this.getWidth();
		depotY = game.height - this.getHeight();
		
		for (int i = 0; i < Game.LIVES; i++){
			balls.add(new Ball(game, new Point(depotX + (i*offset), depotY)));
		}
	}

	@Override
	public int getX() {
		return depotX;
	}

	@Override
	public int getY() {
		
		return depotY;
	}

	@Override
	public int getWidth() {
		
		return Game.LIVES * offset;
	}

	@Override
	public int getHeight() {
		
		return offset;
	}
	
	/**
	 * displays the ballDepot with the single Balls
	 */
	@Override
	public void display() {
		
		for (Ball ball : balls){
			ball.display();
		}
		
	}
	
	/**
	 * checks if the ballDepot is empty
	 * @return true if no more balls in the ballDepot
	 */
	public boolean isEmpty() {
		
		return balls.isEmpty();
	}

	/**
	 * dispenses a ball into the game
	 * takes the ball out of the depot, pumps up air to fullSize and moves to starting position
	 * @return Ball Ball is the currentBall in the game
	 */
	public Ball dispense() {
		
		if (balls.size() > 0){
			System.out.println("Go for next game!");
			Ball currentBall = balls.remove(0);
			currentBall.addAir();
			currentBall.moveToStart();
			return currentBall;
		} else{
			System.out.println("Sorry, game over!");
			return null;
		}
		
	}

}
