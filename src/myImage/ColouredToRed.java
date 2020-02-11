package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * in this file,  we are converting a coloured image to a red effect
 * 
 */
public class ColouredToRed {
	
	//main method
	public static void main(String[]args) throws IOException {
		
		
		//bufferedImage and File init
		BufferedImage image =null;
		File file = null;
		
		//read file
		try {
			
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-four.png");
			image = ImageIO.read(file);
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
		//get width and height of the image
		int width = image.getWidth();
		int height = image.getHeight();
		
		
		//convert to a red effect
		for(int y = 0; y<height;y++) {
			for(int x =0; x<width;x++) {
				
				
				//get the RGB
				int p = image.getRGB(x,y);
				
				//get bits
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				
				//set the info
				p = (a<<24)|(r<<16)|(0<<8)|0;
				image.setRGB(x, y, p);
			}
		}
		
		//write image
		try {
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-red.png");
			ImageIO.write(image,"png",file);
		}
		catch(IOException e) {
			System.out.println("Error"+e);
		}
		
		
		
	}

}
