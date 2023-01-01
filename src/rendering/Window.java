package rendering;

import javax.swing.JFrame;

public class Window extends JFrame {
	Window() throws InterruptedException{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pong");
		this.setResizable(false);
		
		this.add(new GameScreen());
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Window();
	}
}
