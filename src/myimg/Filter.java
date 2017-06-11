package myimg;

import java.awt.image.BufferedImage;

/**
 * A filter that manipulates a given Image
 * 
 * @author Marco Laspe
 * @author Deniz Aydar
 *
 */
public interface Filter {
	
	/**
	 * Returns a BufferedImage that was processed with the filter.
	 * 
	 * @param bufferedImages an Array of BufferedImage, the first will be processed, an optional second will be used as mask 
	 * @return the BufferedImage after processing with the filter
	 */
	public BufferedImage process(BufferedImage ...bufferedImages);
}
