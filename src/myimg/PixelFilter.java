package myimg;

import java.awt.image.BufferedImage;

public abstract class PixelFilter implements Filter {

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
		
		for (int y = 0; y < inputImage.getHeight(); y++) {
			for (int x = 0; x < inputImage.getWidth(); x++) {
				outputImage.setRGB(x, y, calculate(inputImage.getRGB(x, y)));
			}
		}
		return outputImage;
	}

	/**
	 * Returns the int value of a color after it was processed with the filter
	 * 
	 * @param pixelColor the int value of the source pixel
	 * @return the int value of the pixel after processing
	 */
	protected int calculate (int pixelColor) {
		return pixelColor;
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
}
