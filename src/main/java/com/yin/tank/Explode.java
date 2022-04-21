package com.yin.tank;

import java.awt.*;

public class Explode extends GameObject{
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int step = 0;

	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
		GameModel.getInstance().add(this);
	}
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			GameModel.getInstance().remove(this);
		}
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}
}
