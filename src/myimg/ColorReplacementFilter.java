package myimg;

import java.awt.Color;

public class ColorReplacementFilter extends PixelFilter{
	
	private int greylevel;
	private int zufallsFarbe = (int) (Math.random() * 255);
	private int zufallsFarbe2 = (int) (Math.random() * 255);
	private int zufallsFarbe3 = (int) (Math.random() * 255);
	
	public ColorReplacementFilter(int greylevel){
		
		this.greylevel = greylevel;
	}

	public int calculate(int pixelColor)
	{
		Color farbe, farbe2;
		
		farbe = new Color(pixelColor);
		
		if((farbe.getGreen()+farbe.getBlue()+farbe.getRed()/3) < greylevel)
		{
			farbe2 = new Color(0,0,0);
		}
		if((farbe.getGreen()+farbe.getBlue()+farbe.getRed()/3) > greylevel)
		{
			farbe2 = new Color(255,255,255);
		}
		else
		{
			farbe2 = new Color(zufallsFarbe,zufallsFarbe2,zufallsFarbe3);
		}
		
		
		return farbe2.getRGB();
		

	}
}
