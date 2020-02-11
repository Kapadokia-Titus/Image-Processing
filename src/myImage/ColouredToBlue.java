package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColouredToBlue {
	
	//main method
	public static void main(String[]args) throws IOException {
		
		//set BufferedImage and File to null
		BufferedImage image = null;
		File file = null;
		
		//read image
		try {
			
			file = new File("C:\\\\\\\\Users\\\\\\\\user\\\\\\\\Documents\\\\\\\\qwosha-fashion\\\\\\\\img\\\\\\\\kevo-four.png");
			image = ImageIO.read(file);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		
		
		//getting the image width and height
		int width = image.getWidth();
		int height = image.getHeight();
		
		
		//convert to blue effect
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				
				//get the pixel's RGB
				int p = image.getRGB(x,y);
				
				//get the bit
				int a = (p>>24)&0xff;
				int b = p&0xff;
				
				//set the green effect
				//the values of green and red will be set to zero
				p = (a<<24)|(0<<18)|(0<<8)|b;
				image.setRGB(x, y, p);
			}
		}
		
		//write image
		try {
			file = new File("C:\\\\\\\\Users\\\\\\\\user\\\\\\\\Documents\\\\\\\\qwosha-fashion\\\\\\\\img\\\\\\\\kevo-blue.png");
			ImageIO.write(image,"png",file);
			System.out.println("write succesful");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}














