package myimg;

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
		
		int output = red / 3;
		output = (output << 8) + green / 3;
		output = (output << 8) + blue / 3;
		
		return output;
	}
}
