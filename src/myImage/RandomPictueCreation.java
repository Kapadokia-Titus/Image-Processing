package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * we are generating a random image
 * we will not require any input since a the image is randomly generated 
 */

public class RandomPictueCreation {
	
	public static void main(String[]args) throws IOException{
		
		//Image file dimensions
		int width = 640, height=320;
		
		//create a buffered image object
		BufferedImage image = null;
		image =new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		//file object
		File file = null;
		
		//create a random value pixel by pixel
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				
				//generating value less than 256
				int a = (int)(Math.random()*256);
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				int p=(a<<24)|(r<<16)|(g<<8)|b;
				image.setRGB(x, y, p);
			}
		}
		
		//write
		try {
			
			file = new File("C:\\\\\\\\Users\\\\\\\\user\\\\\\\\Documents\\\\\\\\qwosha-fashion\\\\\\\\img\\\\\\\\random.png");
			ImageIO.write(image,"png",file);
			
			System.out.println("random image created");
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	
	

}
