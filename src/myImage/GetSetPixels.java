package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * pixels is the smallest unit of an image which contains of four components
 * this is the ARGB
 *   each component is an 8bit component, therefore 8*4 = 32, 0-31
 * 		A - alpha (transparency measure) 31-24
 * 		R - red ranges from 16-23
 * 		G - green ranges from 8-22
 * 		B - blue ranges from 0-7
 */
public class GetSetPixels {
	
	
	//main method
	public static void main(String []args) throws IOException {
		
		//initialise a null buffered Image
		BufferedImage img = null;
		//initialise a null file
		File file; 
		
		//read image
		try {
			
			file = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-four.png");
			
			//read the file
			img= ImageIO.read(file);
			System.out.println("file read successfully");
		}catch(IOException e) {
			System.out.println(e);
		}
		
		
		//get image width and height
		int width  = img.getWidth();
		int height = img.getHeight();
		
		/*
		 * the RGB method getRGB() denotes the coordinates of the image from which the pixel 
		 * values need to be extracted.
		 */
		int p = img.getRGB(0, 0);
		
		/*
		 * to get the bits, we have to right shift the 32bits of pixels by bit position
		 * e.g 24 in case of alpha and then bitwise add it with 0xFF. 0xFF is the
		 * hexadecimal representation of the decimal value 255.
		 */
		
		//get alpha
		int a = (p>>24) & 0xFF;
		
		//get red
		int r = (p>>16) & 0xFF;
		
		//get green
		int g = (p>>8) & 0xFF;
		
		//get blue
		int b = p & 0xFF;
		
		//set ARGB values to 255,100,150 and 200 respectively. 
		a= 100;
		r=50;
		g=50;
		b=200;
		
		//set pixel value
		p = (a<<24)|(r<<16)|(g<<8)|b;
		img.setRGB(0,0,p);
		
		//write image
		try {
			
			file = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-java.png");
			ImageIO.write(img,"png",file);
			
			//print a success message
			System.out.print("successful write");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
