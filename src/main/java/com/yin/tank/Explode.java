package com.yin.tank;

import java.awt.*;

public class Explode extends GameObject{
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private GameModel gm;
	
	private int step = 0;

	public Explode(int x, int y,GameModel gm) {
		this.x = x;
		this.y = y;
		this.gm = gm;
	}
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			gm.remove(this);
		}
	}
}
