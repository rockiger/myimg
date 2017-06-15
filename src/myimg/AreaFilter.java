package myimg;

import java.awt.image.BufferedImage;



public class AreaFilter implements Filter {

	

	public int calculate(int[] maskPixel, int index, int width, int height) {
		return 0;
	}

	@Override
	public BufferedImage process(BufferedImage... bufferedImages) {
		BufferedImage image1, image2;
		
		image1 = (bufferedImages.length > 0) ? bufferedImages[0] : null;
		
		return null;
	}

}
