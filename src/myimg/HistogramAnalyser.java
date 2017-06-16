package myimg;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class HistogramAnalyser extends PixelFilter {

	/**
	 * Processes all pixels of a given inputImage and returns them in a new outputImage after the are processed.
	 * 
	 * @param bufferedImages an Array of BufferedImage, the first will be processed, an optional second will be used as mask 
	 * @return the BufferedImage after processing every pixel with the filter
	 */
	@Override
	public BufferedImage process(BufferedImage... bufferedImages) {
		BufferedImage inputImage = (bufferedImages.length > 0) ? bufferedImages[0] : null;
		BufferedImage mask = (bufferedImages.length > 1) ? bufferedImages[1] : null; // TODO MASK feature
		int width = inputImage.getWidth();
		int height = inputImage.getHeight();
		BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int[] hist = new int[256];
		
		for (int y = 0; y < inputImage.getHeight(); y++) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				
				if(mask == null)
				{
					outputImage.setRGB(x, y, calculate(inputImage.getRGB(x, y)));
				}
				else
				{
					if(getWhite() == mask.getRGB(x, y))
					{
						outputImage.setRGB(x, y, inputImage.getRGB(x, y));
					}
					else
					{
						outputImage.setRGB(x, y, calculate(inputImage.getRGB(x, y)));
					}
					
					
				}
				
			}
		}
		countGreyVals(hist,outputImage);
		
		for (int i = 0; i < hist.length; i++) {
			System.out.println(i + ": " + hist[i]);
		}
		
		return inputImage;
	}


	

	private void countGreyVals(int[] hist, BufferedImage outputImage) {
		int greyVal;
		
		for (int y = 0; y < outputImage.getHeight(); y++) {
			for (int x = 0; x < outputImage.getWidth(); x++) {
				greyVal = outputImage.getRGB(x, y);
				hist[greyVal] += 1;
			}
		}
	}




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
	}
}
