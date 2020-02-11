package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * here, i am converting the image to negative
 * the alpha in the ARGB remains the same as the original 
 * 
 * the other RGB values will have a 255 - original value
 * steps
 * 		1. get RGB value of the pixels
 * 		2. calculate the new RGB values
 * 		3. replace RGB values of the pixel with the values calculated in step 2
 * 		4. repeat step 1 to step 3 for each pixel in the image
 */
public class NegativeImageConversion {
	
	//main method
	public static void main(String[]args) throws IOException{
		
		
		//initialising bufferedImage and file to null
		BufferedImage image = null;
		File file = null;
		
		//read the file
		try {
			
			file  = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-four.png");
			image= ImageIO.read(file);
		}
		catch(IOException e) {
			System.out.println("Error"+e);
		}
		
		//getting image width and height
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		//convert to negative
		for(int y = 0;y<height;y++) {
			for(int x=0;x<width;x++) {
				
				//get image RGB
				int p = image.getRGB(x, y);
				//get bits by performing a bitwise operation
				int a = (p>>24)& 0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;
				
				//negate
				r = 255-r;
				g = 255-g;
				b= 255-b;
				
				//setting new rgb values
				p = (a<<24)|(r<<16)|(g<<8)|b;
				
				image.setRGB(x, y, p);
			}
		}
		
		//write image
		try {
			
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-negative.png");
			ImageIO.write(image,"png",file);
			System.out.println("negated");
		}
		catch(IOException e) {
			System.out.println("Error"+e);
		}
	}

}
