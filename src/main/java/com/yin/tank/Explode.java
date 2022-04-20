package com.yin.tank;

import com.yin.tank.factory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	private TankFrame tf;
	private int x, y;
	
	private int step = 0;

	public Explode(int x, int y,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		if(step >= ResourceMgr.explodes.length) {
			tf.explodes.remove(this);
		}
	}
}
