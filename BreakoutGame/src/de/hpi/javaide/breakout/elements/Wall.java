package de.hpi.javaide.breakout.elements;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;


public class Wall implements Displayable, Iterable<Brick> {
	
	/**
	 * ArrayList to build a wall out of the bricksDatastructure to keep the Bricks
	 */
	private ArrayList<Brick> wall;
	
	/**
	 * position of the Wall with columns and rows
	 */
	private int offsetX;
	private int offsetY;

	/**
	 * creates the wall with the columns and rows in the middle of the screen
	 * @param game Game class to access the processing features
	 * @param i integer number of columns in the wall
	 * @param j integer number of rows in the wall
	 */
	public Wall(Game game, int i, int j) {
		// TODO Auto-generated constructor stub
		wall = new ArrayList<>();
		offsetX = (game.width/2) - (i * Brick.WIDTH/2)+40;
		offsetY = Brick.HEIGHT/2;
		buildWall(game, i, j);
	}
	
	/**
	 * removes a brick from the wall
	 * @param index place where to remove the brick
	 */
	public void removeBrick(int index){
		wall.set(index, null);
	}
	
	/**
	 * creates an iterator for the wall
	 */
	@Override
	public Iterator<Brick> iterator() {
		return wall.iterator();
	}
	
	/**
	 * Build the wall by putting the single bricks into their position
	 * 
	 * @param game Game class to access the processing features
	 * @param columns integer number of columns in the wall
	 * @param rows  integer number of rows in the wall
	 */
	private void buildWall(Game game, int columns, int rows) {
		int bricksCount = columns * rows;
		
		for (int index = 0; index < bricksCount; index++){
			int column = index % columns;
			int row = (index-column)/columns;
			addBrick(game, index, column, row);
		}
	}
	
	/**
	 * adds a brick to the wall
	 * calculates its position in relation to the columns and rows
	 * @param game Game class to access the processing features
	 * @param index place where to remove the brick
	 * @param column integer number of columns in the wall
	 * @param row integer number of rows in the wall
	 */
	private void addBrick(Game game, int index, int column, int row){
		Brick brick = new Brick(game, new Point(calcXPos(column), calcYPos(row)));
		wall.add(brick);
		}
	
	/**
	 * calculates the x-position of the brick within the wall depending on the current column
	 * @param column
	 * @return 
	 */
	private int calcXPos(int column){
		return column * (Brick.WIDTH + Brick.OFFSET) + this.offsetX;
	}
	
	/**
	 * calculates the y-position of the brick within the wall depending on the current row
	 * @param row
	 * @return
	 */
	private int calcYPos(int row){
	return row * (Brick.HEIGHT + Brick.OFFSET) + this.offsetY;
	}
	
	/**
	 * displays the wall on the screen
	 */
	@Override
	public void display() {
		// TODO Auto-generated method stub
		for (Brick b: wall){
			if(b != null){
				b.display();
			}
		}
		
		
	}
}
