package entities;

import java.awt.Rectangle;

import general.GenerateBalls;
import rendering.GameScreen;

public class Ball {
	public int x;
	public int y;
	public int ratio;
	int mapWidth;
	int mapHeight;
	public short xAxisMovement = 4;
	public short yAxisMovement = 3;
	static byte startingDirection = 1;
	GameScreen gs;
	long importantTime;
	
	public Ball(int x, int y, int ratio, GameScreen gsx) {
		this.x = x;
		this.y = y;
		this.ratio = ratio;
		this.mapHeight = GameScreen.HEIGHT - ratio;
		this.mapWidth = GameScreen.WIDTH - ratio;
		this.gs = gsx;
		this.xAxisMovement *= startingDirection;
		importantTime = System.currentTimeMillis();
	}
	
	public Rectangle returnBounds() {
		return new Rectangle(this.x, this.y, ratio, ratio);
	}
	
	public void updateThis() {
		this.x += xAxisMovement;
		this.y += yAxisMovement;
		this.checkOutMap();
		this.increaseSpeed();
	}
	
	public void checkOutMap() {
		if (this.x < 0) {
			GameScreen.team2Score++;
			GenerateBalls.timeForGenerating = System.currentTimeMillis();
			startingDirection *= -1;
			GameScreen.balls.remove(this);
		}
		
		if (this.x > mapWidth) {
			GameScreen.team1Score++;
			GenerateBalls.timeForGenerating = System.currentTimeMillis();
			startingDirection *= -1;
			GameScreen.balls.remove(this);
		}
		
		if (this.y < 0 || this.y > mapHeight) {
			this.yAxisMovement *= -1;
		}
	}
	
	void increaseSpeed() {
		if (System.currentTimeMillis() - importantTime > 5000) {
			importantTime = System.currentTimeMillis();
			if(this.xAxisMovement > 0)
				this.xAxisMovement++;
			if(this.xAxisMovement < 0)
				this.xAxisMovement--;
		}	
	}
}
