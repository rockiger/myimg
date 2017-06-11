package myimg;

public class ColorBandFilter extends PixelFilter {
	
	private ColorBand color;
	
	public ColorBandFilter (ColorBand color) {
		this.color = color;
	}
	
	/**
	 * Returns the int value of a color after it was processed with the monochrome filter
	 * 
	 * @param pixelColor the int value of the source pixel
	 * @param color the color chanel to extract
	 * @return the int value of the pixel after processing
	 */
	protected int calculate (int pixelColor) {
		int output;
		
		switch (this.color) {
		case RED:
			output = getRed(pixelColor) / 3;
			output = (output << 8) + 0;
			output = (output << 8) + 0;
			break;
		case GREEN:
			output = 0;
			output = (output << 8) + getGreen(pixelColor);
			output = (output << 8) + 0;
			break;
		case BLUE:
			output = 0;
			output = (output << 8) + 0;
			output = (output << 8) + getBlue(pixelColor);
			break;
		default:
			output = pixelColor;
			break;
		}
		
		return output;
	}
}
