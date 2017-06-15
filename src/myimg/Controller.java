package myimg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Controller {
	
	/**
	 * 
	 * @param args the command line parameters
	 */
	public void start(String[] args) {
		if (args.length == 3) {
			// TODO Standardfall
			
			Map<String,String> befehle = new HashMap<String, String>();
			befehle.put("filter", args[0]);
			befehle.put("eingabe", args[1]);
			befehle.put("ausgabe", args[2]);
			
			try {
				BufferedImage image;
				image = ImageIO.read(new File(befehle.get("eingabe")));
				
				image = applyFilter(image, befehle);
				
				ImageIO.write(image, "bmp", new File(befehle.get("ausgabe")));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (args.length == 5) {
			// TODO Maskfall
			
			Map<String,String> befehle = new HashMap<String, String>();
			befehle.put("filter", args[0]);
			befehle.put("eingabe", args[1]);
			befehle.put("-m", args[2]);
			befehle.put("maske", args[3]);
			befehle.put("ausgabe", args[4]);
			
			try {
				BufferedImage image;
				BufferedImage mask;
				
				image = ImageIO.read(new File(befehle.get("eingabe")));
				
				mask = ImageIO.read(new File(befehle.get("maske")));
				
				image = applyFilter(image, mask, befehle);
				
				ImageIO.write(image, "bmp", new File(befehle.get("ausgabe")));
			} catch (IOException e) {
				// TODO: handle exception	
				e.printStackTrace();
			}
			
		} else {
			printHelpMessage();
		}
	}

	private BufferedImage applyFilter(BufferedImage image, Map befehle) {
BufferedImage filteredImage;
		
		PixelFilter filter = null;
		
		String befehl = (String) befehle.get("filter");
		
		
		if(befehl.contains("colorband"))
		{
			String color = befehl.substring(10);
			
			if(color.contains("RED"))
			{
				filter = new ColorBandFilter(ColorBand.RED);
			}
			else if(color.contains("GREEN"))
			{
				filter = new ColorBandFilter(ColorBand.GREEN);
			}
			else if(color.contains("BLUE"))
			{
				filter = new ColorBandFilter(ColorBand.BLUE);
			}
			
		}
		else if(befehl.contains("monochrom"))
		{
			filter = new MonochromeFilter();
			
		}
		else if(befehl.contains("threshold"))
		{
			int wert = Integer.parseInt(befehl.substring(10));
			filter = new ThresholdFilter(wert);
			
		}
		else if(befehl.contains("colorreplacement"))
		{
			int wert = Integer.parseInt(befehl.substring(17));
			filter = new ColorReplacementFilter(wert);
		}
		else
		{
			System.out.println("Falsche Argumenteingabe! ");
		}
		
		
		// TODO Map mit Filtern anlegen und hier auswählen.
//		PixelFilter filter = new ColorReplacementFilter();
//		PixelFilter filter = new ThresholdFilter(128);
//		PixelFilter filter = new MonochromeFilter();
//		PixelFilter filter = new ColorBandFilter(ColorBand.RED);
//		PixelFilter filter = new ColorBandFilter(ColorBand.GREEN);
//		PixelFilter filter = new ColorBandFilter(ColorBand.BLUE);
		filteredImage = filter.process(image);
		
		return filteredImage;
	}
	
	private BufferedImage applyFilter(BufferedImage image, BufferedImage mask, Map befehle) {
		BufferedImage filteredImage;
		
		PixelFilter filter = null;
		
		String befehl = (String) befehle.get("filter");
		
		
		if(befehl.contains("colorband"))
		{
			String color = befehl.substring(10);
			
			if(color.contains("RED"))
			{
				filter = new ColorBandFilter(ColorBand.RED);
			}
			else if(color.contains("GREEN"))
			{
				filter = new ColorBandFilter(ColorBand.GREEN);
			}
			else if(color.contains("BLUE"))
			{
				filter = new ColorBandFilter(ColorBand.BLUE);
			}
			
		}
		else if(befehl.contains("monochrom"))
		{
			filter = new MonochromeFilter();
			
		}
		else if(befehl.contains("threshold"))
		{
			int wert = Integer.parseInt(befehl.substring(10));
			filter = new ThresholdFilter(wert);
			
		}
		else if(befehl.contains("colorreplacement"))
		{
			int wert = Integer.parseInt(befehl.substring(17));
			filter = new ColorReplacementFilter(wert);
		}
		else
		{
			System.out.println("Falsche Argumenteingabe! ");
		}
		
		
//		PixelFilter filter = new ColorReplacementFilter(128);
//		PixelFilter filter = new ThresholdFilter(128);
//		PixelFilter filter = new MonochromeFilter();
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




	private Map getBefehle(String args[])
	{
		if (args.length == 3) {
			
			
			Map<String,String> befehle = new HashMap();
			befehle.put("filter", args[0]);
			befehle.put("eingabe", args[1]);
			befehle.put("ausgabe", args[2]);
			
			return befehle;
		}
		
		if (args.length == 5) {
		
			
			Map<String,String> befehle = new HashMap();
			befehle.put("filter", args[0]);
			befehle.put("eingabe", args[1]);
			befehle.put("-m", args[2]);
			befehle.put("maske", args[3]);
			befehle.put("ausgabe", args[4]);
			
			return befehle;
		
		}
		else
			return null;
	}

}


	
