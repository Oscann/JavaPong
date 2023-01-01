package rendering;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import general.GenerateBalls;

public class GUI extends JLabel {
	
	int width;
	int height;
	int x;
	int y = 0;
	
	GUI(int width, int height){
		this.width = width/2;
		this.height = height/6;
		this.x = width/4;
		
		this.setBounds(this.x, this.y, this.width, this.height);
		this.setForeground(Color.white);
		this.setFont(new Font("Roboto",Font.BOLD, 100));
		this.setHorizontalAlignment(CENTER);
	}
	
	void updateScore() {
		if (System.currentTimeMillis() - GenerateBalls.timeForGenerating < 5000) {
			this.setText(Integer.toString((int) Math.abs((Math.ceil((System.currentTimeMillis() - GenerateBalls.timeForGenerating)/1000)) -5)));
			return;
		}
		this.setText(GameScreen.team1Score + "  :  " + GameScreen.team2Score);
	}
}
