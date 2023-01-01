package rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import entities.Ball;
import entities.Player;
import general.CollisionDetector;
import general.GenerateBalls;
import general.Inputs;

public class GameScreen extends JLayeredPane implements Runnable {

	static public final int WIDTH = 800;
	static public final int HEIGHT = 600;
	Dimension size;

	static public ArrayList<Player> players = new ArrayList<Player>();
	static public ArrayList<Ball> balls = new ArrayList<Ball>();
	GenerateBalls ballGenerator;
	CollisionDetector coll;
	GUI gui;
	Player player1;
	Player player2;
	public static short team1Score = 0;
	public static short team2Score = 0;

	Thread update;
	Thread generating;
	Thread collisions;
	int updatesPerSecond = 60;
	long timeBetweenUpdates = 1000000000 / updatesPerSecond;
	long lastUpdate = 0;
	long lastReport = 0;
	short framesAndUpdates = 0;
	Inputs input;

	GameScreen() {

		player1 = new Player(100, 200, 10, 200);
		players.add(player1);

		player2 = new Player(690, 200, 10, 200);
		players.add(player2);

		input = new Inputs(player1, player2);

		this.size = new Dimension(WIDTH, HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(input);

		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setOpaque(true);
		this.setBackground(Color.black);

		this.setLayout(null);

		this.add(gui = new GUI(GameScreen.WIDTH, GameScreen.HEIGHT));

		update = new Thread(this);
		update.start();

		coll = new CollisionDetector();
		collisions = new Thread(coll);
		collisions.start();

		ballGenerator = new GenerateBalls(this);
		generating = new Thread(ballGenerator);
		generating.start();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		for (Player p : players) {
			g.fillRect(p.x, p.y, p.width, p.height);
		}

		for (Ball p : balls) {
			g.fillRect(p.x, p.y, p.ratio, p.ratio);
		}
	}

	public void update() {
		gui.updateScore();

		for (Player p : players) {
			p.updateThis();
		}

		for (int x = 0; x < balls.size(); x++) {

			balls.get(x).updateThis();
		}
	}

	public void reportUpdate() {
		if (System.currentTimeMillis() - lastReport > 1000) {
			lastReport = System.currentTimeMillis();
			System.out.println("FPS and UPS: " + framesAndUpdates);
			framesAndUpdates = 0;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			if (System.nanoTime() - lastUpdate > timeBetweenUpdates) {
				this.repaint();
				this.update();
				framesAndUpdates++;
				lastUpdate = System.nanoTime();
				reportUpdate();
			}
		}
	}
}
