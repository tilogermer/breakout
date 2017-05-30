package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;


public class Brick extends Rectangular {
	
	/**
	 * brick lifetime is 3 at the beginning, each time reduced by 1 when hit
	 */
	private int status = 3;
	
	/**
	 * width and height of the brick and distance between 2 bricks
	 * values are final in the game, no changes
	 */
	public final static int WIDTH = 100;
	public final static int HEIGHT = 20;
	public final static int OFFSET = 5;
	
	/**
	 * constructor to create a new Brick
	 * @param game Game class to access the processing features
	 * @param position Position x, y of the brick
	 */
	public Brick(Game game, Point position) {
		super(game, position, new Dimension(WIDTH, HEIGHT));
		
	}
	
	/**
	 * displays the brick on the screen
	 * brick becomes invisible if it is dead=true
	 */
	@Override
	public void display() {
		game.rectMode(PApplet.CENTER);
		game.strokeWeight(4);
		game.noStroke();
		if(isDead()){
			game.noFill();
		} else{
			game.fill(getR(), getG(),getB());
		}
		game.rect(getX(), getY(), getWidth(), getHeight());
		
	}
	
	/**
	 * if the brick gets hit, the status is reduced by 1, starting value is 3
	 * color change when the brick is hit to make the status change visible 
	 * 3 values for red, green and blue
	 */
	public void nextStatus(){
		if(!isDead())
			status--;
		setColor(calcColorComponent(85), calcColorComponent(85), calcColorComponent(20));
	}
	
	/**
	 * finds out if the brick is already dead
	 * @return true if the remaining status is less or equal to 0
	 */
	public boolean isDead(){
		return status <=0;
	}
	
	/**
	 * calculates the color of the brick when it is hit
	 * @param factor integer basic value for RGB color scheme (0-255)
	 * @return integer new color after getting hit (0-255)
	 */
	private int calcColorComponent(int factor){
		return status * factor;
	}
}
