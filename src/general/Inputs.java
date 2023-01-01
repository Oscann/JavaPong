package general;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;

public class Inputs implements KeyListener {
	
	Player player1;
	Player player2;
	
	public Inputs(Player n1, Player n2) {
		this.player1 = n1;
		this.player2 = n2;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player1.movement = -3;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player1.movement = 3;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2.movement = -3;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.movement = 3;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W) {
			player1.movement = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player1.movement = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player2.movement = 0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.movement = 0;
		}
	}

}
