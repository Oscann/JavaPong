package entities;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rendering.GameScreen;



public class Player {
	public int x;
	public int y;
	public int width;
	public int height;
	public int movement = 0;
	
	public Player(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle[] returnBounds() {
		return new Rectangle[] {new Rectangle(this.x, this.y, this.width, this.height/2), new Rectangle(this.x, y + this.height/2,
				this.width, this.height/2)};
	}
	
	public void updateThis() {
		this.y += movement;
		checkOutMap();
	}
	
	void checkOutMap() {
		if(this.y < 0) {
			this.y = 0;
		}
		if (this.y > GameScreen.HEIGHT - this.height) {
			this.y = GameScreen.HEIGHT - this.height;
		}
	}

}
