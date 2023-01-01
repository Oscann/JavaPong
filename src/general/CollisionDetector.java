package general;

import java.awt.Rectangle;

import entities.Ball;
import entities.Player;
import rendering.GameScreen;

public class CollisionDetector implements Runnable {

	Rectangle ball;
	Rectangle[] player;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
		
			for (Player p: GameScreen.players) {
				player = p.returnBounds();
				for (int b = 0; b < GameScreen.balls.size(); b++) {
					ball = GameScreen.balls.get(b).returnBounds();
					if (ball.intersects(player[0]) || ball.intersects(player[1])) {
						if (ball.intersects(player[0]))
							GameScreen.balls.get(b).yAxisMovement = (short) (Math.abs(GameScreen.balls.get(b).yAxisMovement) * -1);
						else
							GameScreen.balls.get(b).yAxisMovement = (short) Math.abs(GameScreen.balls.get(b).yAxisMovement);
						GameScreen.balls.get(b).xAxisMovement *= -1;
						GameScreen.balls.get(b).x += GameScreen.balls.get(b).xAxisMovement;
					}
				}
			}
		}
	}
	
}
