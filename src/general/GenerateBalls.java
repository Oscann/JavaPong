package general;

import rendering.GameScreen;

import java.util.ArrayList;
import java.util.Random;

import entities.Ball;

public class GenerateBalls implements Runnable{
	
	GameScreen gs;
	int ratio = 10;
	Random randomTool;
	public static long timeForGenerating= 0;
	
	public GenerateBalls(GameScreen gs) {
		this.gs = gs;
		GenerateBalls.timeForGenerating = System.currentTimeMillis();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			System.out.println("");
			if (GameScreen.balls.size() == 0) {
				if (System.currentTimeMillis() - timeForGenerating < 5000)
					continue;
				GameScreen.balls.add(new Ball((GameScreen.WIDTH - ratio)/2, (GameScreen.HEIGHT - ratio)/2, ratio, gs));
				System.out.println("Homem?");
			}
		}
	}
	
}
