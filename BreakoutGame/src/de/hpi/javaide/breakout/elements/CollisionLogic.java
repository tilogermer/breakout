package de.hpi.javaide.breakout.elements;

import java.awt.geom.Rectangle2D;

import de.hpi.javaide.breakout.Collidable;
import de.hpi.javaide.breakout.starter.Game;


public class CollisionLogic {
	/**
	 * The constructor of this class is private to make sure that it is only used as a static class.
	 * - it cannot be instantiated,
	 * - it cannot hold a state,
	 * - it contains only static methods
	 */
	private CollisionLogic() {}
	
	/**
	 * This method provides a way to determine if the ball collides with any of the Collidable elements
	 * as Paddle, Brick, SideBoundary, TopBoundary
	 * 
	 * @param game Game class to access the processing features
	 * @param ball currentBall
	 * @param paddle Paddle
	 * @param wall Wall
	 */
	public static void checkCollision(Game game, Ball ball, Paddle paddle, Wall wall) {
		//TODO fill in method
		if(collidesWithSideBoundary(game, ball)){
			ball.bounceX();
		} else if(collidesWithTopBoundary(game, ball)){
			ball.bounceY();
		} else if(collidesWithPaddle(ball, paddle)){
			ball.bounceY();
			ball.setSpeed(paddle.getSpeed());
		} else{
			for (Brick b : wall){
				if(collidesWithBrick(ball, b)){
					if(!b.isDead()){
						ball.bounceY();
						if(ball.isMovingUpwards()){
							b.nextStatus();
							game.increaseScore(1);
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * 
	 * @param game Game class to access the processing features
	 * @param ball Ball
	 * @return true if collides with the relevant parts as brick, paddle, top- and sideBoundary
	 */
	private static boolean collidesWithSideBoundary(Game game, Collidable ball){
		return 0 > (ball.getX() - ball.getWidth()/2) || game.width < (ball.getX() + ball.getWidth()/2);
	}
	private static boolean collidesWithTopBoundary(Game game, Collidable ball){
		return 0 > (ball.getY() - ball.getHeight()/2);
	}
	private static boolean collidesWithPaddle(Collidable ball, Collidable paddle){
		return ball.getGeometry().intersects((Rectangle2D) paddle.getGeometry());
	}
	private static boolean collidesWithBrick(Collidable ball, Collidable brick){
		return ball.getGeometry().intersects((Rectangle2D) brick.getGeometry());
	}

}
