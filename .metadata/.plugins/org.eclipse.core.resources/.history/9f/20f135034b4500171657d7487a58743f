package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Score extends UIObject {
	
	/**
	 * score of the game
	 */
	private int score;
	
	public Score(Game game) {
		super(game);
		score = 0;
	}

	@Override
	public void display() {
		
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Score: " + score,  game.width-150, game.height-100);
	}

	@Override
	public void update(String input) {
		// TODO cumulated highscore after 3 balls when the game is finished
		score += Integer.parseInt(input);
		
	}
}
