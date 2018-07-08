package imit;

import java.awt.*;
import java.util.Random;

public class Shape extends Frame {
	private static final long serialVersionUID = 1L;

	private int posy=-10000;
	private int posx=-10000;

	public void setX(int x){
		posx=x;
	}

	public void setY(int y){
		posy=y;
	}

	public int getY(){
		return posy;
	}

	public int getX(){
		return posx;
	}
	/**
	 * This method generates random numbers
	 * @return random, sets number between 0-6
	 */
	public int RandomGenerator(){
		Random random = new Random();
		return random.nextInt(5);
	}
	public void shape(Graphics g){
		if(RandomGenerator()==1)
			g.setColor(Color.RED);//sets Color to red
		if(RandomGenerator()==2)
			g.setColor(Color.GREEN);//sets Color to green
		if(RandomGenerator()==3)
			g.setColor(Color.MAGENTA);//sets Color to magenta
		if(RandomGenerator()==4)
			g.setColor(Color.ORANGE);//sets Color to orange
		if(RandomGenerator()==5)
			g.setColor(Color.YELLOW);//sets Color to yellow
		//g.fillArc(posx, posy, 70, 70, posx, posy);
		g.fill3DRect(posx, posy, 50, 50, true);
	}
		
}
