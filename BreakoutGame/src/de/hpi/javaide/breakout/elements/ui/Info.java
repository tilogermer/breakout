package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;


public class Info extends UIObject {

	/**
	 * info in the display
	 */
	private String content;
	
	/**
	 * creates a new text info for the screen
	 * @param game Game class to access the processing features
	 * @param content info for the player
	 */
	public Info(Game game, String content) {
		super(game);
		this.content = content;
	}

	/**
	 * displays the info on the screen 
	 */
	@Override
	public void display() {
	    game.textFont(Font.getFont24());
	    game.text(content, game.width/2, game.height/2);

	}

	@Override
	public void update(String input) {
		
		content = input;
		
	}
}
