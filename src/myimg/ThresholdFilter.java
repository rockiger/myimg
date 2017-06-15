package myimg;

import java.awt.Color;

public class ThresholdFilter extends PixelFilter {

	private int greylevel;
	
	public ThresholdFilter(int greylevel)
	{
		this.greylevel =greylevel;
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
			farbe2 = new Color(greylevel,greylevel,greylevel);
		}
		
		
		return farbe2.getRGB();
		

	}
	
}
