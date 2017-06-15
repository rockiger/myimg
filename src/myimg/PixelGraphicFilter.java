package myimg;

import java.awt.image.BufferedImage;

public class PixelGraphicFilter implements Filter {

	@Override
	public BufferedImage process(BufferedImage... bufferedImages) {
		BufferedImage inputImage = (bufferedImages.length > 0) ? bufferedImages[0] : null;
		BufferedImage mask = (bufferedImages.length > 1) ? bufferedImages[1] : null;
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for (int y = 0; y < inputImage.getHeight(); y++) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				
				if(mask == null)
				{
					int xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
					int ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
					int pixel1 = inputImage.getRGB(xpos, ypos);
					
					xpos = x;
					ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
					int pixel2 = inputImage.getRGB(xpos, ypos);
					
					xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
					ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
					int pixel3 = inputImage.getRGB(xpos, ypos);
					
					xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
					ypos = y;
					int pixel4 = inputImage.getRGB(xpos, ypos);
					
					int pixel5 = inputImage.getRGB(x, y);
					
					xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
					ypos = y;
					int pixel6 = inputImage.getRGB(xpos, ypos);
					
					xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
					ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
					int pixel7 = inputImage.getRGB(xpos, ypos);
					
					xpos = x;
					ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
					int pixel8 = inputImage.getRGB(xpos, ypos);
					
					xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
					ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
					int pixel9 = inputImage.getRGB(xpos, ypos);
					
					int[] pixel = {pixel1, pixel2, pixel3, pixel4, pixel5, pixel6, pixel7, pixel8, pixel9};
					
					outputImage.setRGB(x, y, calculate(pixel, 0, inputImage.getWidth(), inputImage.getHeight()));
				}
				else
				{
					if(getBlack() == mask.getRGB(x, y))
					{
						continue;
					}
					else
					{
						int xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
						int ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
						int pixel1 = inputImage.getRGB(xpos, ypos);
						
						xpos = x;
						ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
						int pixel2 = inputImage.getRGB(xpos, ypos);
						
						xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
						ypos = (y < 1) ? inputImage.getHeight() - 1 : y - 1;
						int pixel3 = inputImage.getRGB(xpos, ypos);
						
						xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
						ypos = y;
						int pixel4 = inputImage.getRGB(xpos, ypos);
						
						int pixel5 = inputImage.getRGB(x, y);
						
						xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
						ypos = y;
						int pixel6 = inputImage.getRGB(xpos, ypos);
						
						xpos = (x < 1) ? inputImage.getWidth() - 1 : x - 1;
						ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
						int pixel7 = inputImage.getRGB(xpos, ypos);
						
						xpos = x;
						ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
						int pixel8 = inputImage.getRGB(xpos, ypos);
						
						xpos = (x == inputImage.getWidth() - 1) ? 0 : x + 1;
						ypos = (y == inputImage.getHeight() - 1) ? 0 : y + 1;
						int pixel9 = inputImage.getRGB(xpos, ypos);
						
						int[] pixel = {pixel1, pixel2, pixel3, pixel4, pixel5, pixel6, pixel7, pixel8, pixel9};
						
						outputImage.setRGB(x, y, calculate(pixel, 0, inputImage.getWidth(), inputImage.getHeight()));
					}
					
					
				}
				
			}
		}
		return outputImage;
	}

	
	protected int calculate(int[] pixel, /*int [] maskPixel,*/ int index, int width, int height) {
		int r = 0;
		int g = 0;
		int b = 0;
		
		for (int i = 0; i < pixel.length; i++) {
			r += getRed(pixel[i]);
			r += getGreen(pixel[i]);
			r += getBlue(pixel[i]);
		}
		

		int output = r / pixel.length;
		output = (output << 8) + (g / pixel.length);
		output = (output << 8) + (b / pixel.length);
				
		return output;
	}
	
	/** Returns the hex value of the blue channel of a RGB int
	 * 
	 * @param pixelColor RGB value as int
	 * @return
	 */
	protected int getBlue(int pixelColor) {
		return pixelColor &  0xFF;
	}

	/** Returns the hex value of the green channel of a RGB int
	 * 
	 * @param pixelColor RGB value as int
	 * @return
	 */
	protected int getGreen(int pixelColor) {
		return (pixelColor >> 8) & 0xFF;
	}

	/** Returns the hex value of the red channel of a RGB int
	 * 
	 * @param pixelColor RGB value as int
	 * @return
	 */
	protected int getRed(int pixelColor) {
		return (pixelColor >> 16) & 0xFF;
	}
	protected int getBlack(){
		int black;
		
		black = 0xFFFFFFF;
		
		return black;
	}
	
}
