package myimg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Controller {
	
	/**
	 * 
	 * @param args the command line parameters
	 */
	public void start(String[] args) {
		if (args.length == 3) {
			// TODO Standardfall
			try {
				BufferedImage image;
				image = ImageIO.read(new File(args[1]));
				
				image = applyFilter(image);
				
				ImageIO.write(image, "bmp", new File(args[2]));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (args.length == 5) {
			// TODO Maskfall
			
			try {
				BufferedImage image;
				BufferedImage mask;
				
				image = ImageIO.read(new File(args[1]));
				
				mask = ImageIO.read(new File(args[3]));
				
				image = applyFilter(image, mask);
				
				ImageIO.write(image, "bmp", new File(args[4]));
			} catch (IOException e) {
				// TODO: handle exception	
				e.printStackTrace();
			}
			
		} else {
			printHelpMessage();
		}
	}

	private BufferedImage applyFilter(BufferedImage image) {
		BufferedImage filteredImage;
		// TODO Map mit Filtern anlegen und hier auswählen.
		
//		PixelFilter filter = new ThresholdFilter(128);
//		PixelFilter filter = new MonochromeFilter();
//		PixelFilter filter = new ColorBandFilter(ColorBand.RED);
		PixelFilter filter = new ColorBandFilter(ColorBand.GREEN);
//		PixelFilter filter = new ColorBandFilter(ColorBand.BLUE);
		filteredImage = filter.process(image);
		
		return filteredImage;
	}
	
	private BufferedImage applyFilter(BufferedImage image, BufferedImage mask) {
		BufferedImage filteredImage;
		// TODO Map mit Filtern anlegen und hier auswählen.
		
//		PixelFilter filter = new ThresholdFilter(128);
		PixelFilter filter = new MonochromeFilter();
//		PixelFilter filter = new ColorBandFilter(ColorBand.RED);
//		PixelFilter filter = new ColorBandFilter(ColorBand.GREEN);
//		PixelFilter filter = new ColorBandFilter(ColorBand.BLUE);
		filteredImage = filter.process(image,mask);
		
		return filteredImage;
	}

	/**
	 * Prints usage information for myimg
	 */
	private static void printHelpMessage() {
		System.out.println("myimg - apply filters to an image");
		System.out.println("usage: java programmname filtername inputImage.bmp [-m mask.bmp] outputImage.bmp");	
		System.out.println();
		System.out.println("Filters:");
		// TODO print out available filters
		System.out.println("  test\t Combine all available Filters");
		System.out.println();
		System.out.println("Optionen:\n  -m mask.bmp\t Provide a mask to limit the area the filter is used.");
	}
}
