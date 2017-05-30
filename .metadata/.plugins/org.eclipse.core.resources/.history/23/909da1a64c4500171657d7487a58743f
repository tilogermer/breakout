package de.hpi.javaide.breakout.elements.ui;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.basics.UIObject;
import de.hpi.javaide.breakout.starter.Game;

public class Timer extends UIObject {

	public static final String RESET = "reset";
	int time;
	int wait = 1000;
	private int seconds;

	public Timer(Game game) {
		super(game);
		seconds = 60;
		time = game.millis();
	}

	@Override
	public void display() {
		game.fill(255);
		game.textFont(Font.getFont16());
		game.text("Time left: " + seconds, game.width-150, game.height-80);
	}

	@Override
	public void update(String input) {
		// TODO special action when the time is running out like a shot clock
		if(RESET.equals(input)){
			seconds = 60;
		} else {
			if(game.millis() - time >= wait){
				if (seconds > 0){
					seconds--;
				} else {
					update(RESET);
				}
				time = game.millis();
			}
		}
		
	}
}
