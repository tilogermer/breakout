package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

/**
 * Blueprint for a Ball
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */

public class Ball extends Elliptic {
	
	/**
	 * size of the ball in the game
	 */
	private int fullSize;
	/**
	 * direction of the ball when it is moving on the screen
	 */
	private Vector direction;
	
	/**
	 * creates a ball in the ballDepot in small size(10,10)
	 * ball will have fullSize(30,30) in the game and color red
	 * @param game Game reference that gives access to the processing features
	 * @param position Position x, y on the screen
	 */
	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
		direction = new Vector(2,2);
		fullSize = 30;
		setColor(255,0,0);
	}

	/**
	 * draw the ball with processing features from Game class
	 * use methods of class CollisionObject
	 */
	@Override
	public void display() {
		game.ellipseMode(PApplet.CENTER);
		game.noStroke();
		game.fill(getR(), getG(), getB());
		game.ellipse(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * moves the ball across the screen, 
	 */
	public void move() {
		update(new Point(getX() + (int) direction.getX(), getY() + (int) direction.getY()), new Dimension (getWidth(), getHeight()));
		
	}
	/**
	 * ball gets fullSize(30,30), when it goes moves from the ballDepot to the starting position of the game
	 */
	public void addAir(){
		update(new Point(getX(), getY()), new Dimension(fullSize, fullSize));
	}
	
	/**
	 * moves the ball from the ballDepot to starting position
	 */
	public void moveToStart(){
		update(Game.STARTPOSITION, new Dimension(fullSize, fullSize));
	}
	
	/**
	 * bounces the ball in x-direction on collision
	 */
	void bounceX(){
		direction.setX(-direction.getX());
	}
	
	/**
	 * bounces the ball in y-position on collision
	 */
	void bounceY(){
		direction.setY(-direction.getY());
	}
	
	/**
	 * sets the speed of the ball
	 * @param speed
	 */
	void setSpeed(int speed){
		direction.normalize();
		direction.mult(speed);
	}
	
	/**
	 * checks if the ball is currently moving in upwards-direction 
	 * @return true if it is moving upwards
	 */
	public boolean isMovingUpwards(){
		return direction.getY() > 0;
	}
	
}
