package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * this code is responsible for converting a coloured image to a grayscale
 * image. 
 * the alpha component of the image will remain same to the original but 
 * the RGB will be changed. 
 *   1. get the RGB value of the image
 *   2. get the average of the three
 *   3. convert them to a same value`	`	
 *   4. repeat step 1-3 to all pixels of the image  
 */

public class GreyScaleConverter {
	
	
 //main method
	public static void main (String []args) throws IOException {
		
		//set buffered image and file to null
		BufferedImage image = null;
		File file = null;
		
		
		//read the image 
		try {
			
			file  = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-four.png");
			image = ImageIO.read(file);
			
			System.out.println("read succesfully");
		}catch (IOException e) {
			System.out.println("Error"+e);
		}
		
		
		//get image's width and height
		int width = image.getWidth();
		int height = image.getHeight();
		
		
		//use a for loop to convert all the pixels to grayscale
		for(int y=0;y<height;y++) {
			
			for (int x=0; x<width;x++) {
				
				//x and y denotes image co-ordinates 
				//when modifying the pixel values, use the getRGB method 
				//and pass x and y as parameters
				int p = image.getRGB(x, y);
				
				/*
				 * to get the bits, we have to right shift the 32bits of pixels by bit position
				 * e.g 24 in case of alpha and then bitwise add it with 0xFF. 0xFF is the
				 * hexadecimal representation of the decimal value 255.
				 */
				int a  =(p>>24)& 0xff;
				int r = (p>>16)& 0xff;
				int g  =(p>>8)& 0xff;
				int b = p& 0xff;
				
				//find the average of the three
				int avg = (r+g+b)/3;
				
				//replace RGB value with average
				p = (a<<24)|(avg<<8)|avg;
				
				image.setRGB(x, y, p);
				
			}
		}
		
		//write image
		try {
			
			file = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-greyscale.png");
			ImageIO.write(image,"png",file);
			System.out.print("greyScale success");
		}catch(IOException e) {
			System.out.print("Error"+e);
		}
	}
}











