package myimg;

import java.awt.Color;

public class MonochromeFilter extends PixelFilter {
	/**
	 * Returns the int value of a color after it was processed with the monochrome filter
	 * 
	 * @param pixelColor the int value of the source pixel
	 * @return the int value of the pixel after processing
	 */
	protected int calculate (int pixelColor) {
		int red = getRed(pixelColor);
		int green = getGreen(pixelColor);
		int blue = getBlue(pixelColor);
		
		Color farbe = new Color(pixelColor);
		Color farbe2 = new Color(((farbe.getRed()+farbe.getBlue()+farbe.getGreen())/3), 
				((farbe.getRed()+farbe.getBlue()+farbe.getGreen())/3), (farbe.getRed()+farbe.getBlue()+farbe.getGreen())/3);
		
		
		return farbe2.getRGB();
		
		
		
		/*
		int output = red / 3;
		output = (output ) + green / 3;
		output = (output ) + blue / 3;
		
		return output;
		*/
	}
}
