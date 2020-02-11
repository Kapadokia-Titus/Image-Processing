package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * when converting the new value to serpia the alpha value remains same to original
 * 
 * the other RGB values will be calculated as follows
	 * 	newRed = 0.393*R + 0.769*G + 0.189*B
		newGreen = 0.349*R + 0.686*G + 0.168*B
		newBlue = 0.272*R + 0.534*G + 0.131*B
		
		If any of these output values is greater than 255, 
		simply set it to 255.
		These specific values are the values for sepia tone 
		that are recommended by Microsoft. 
 */

public class ColouredToSerpia {

	//main method
	public static void main(String[]args)throws IOException {
		
		//null inits
		BufferedImage image=null;
		File file = null;
		
		//read file
		try {
			file = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-four.png");
			image = ImageIO.read(file);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		//get width and height
		int width = image.getWidth();
		int height = image.getHeight();
		
		//converting to serpia
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				
				//get RGB
				int p = image.getRGB(x, y);
				
				//get bits
				int a =(p>>24)&0xff;
				int r=(p>>16)&0xff;
				int g=(p>>8)&0xff;
				int b = p&0xff;
				
				//calculate to serpian(newRed, newGreen and newBlue)
				int newRed = (int)(0.393*r +0.769*g+0.189*b);
				int newGreen = (int)(0.349*r + 0.686*g + 0.168*b);
				int newBlue = (int)(0.272*r + 0.534*g + 0.131*b); 
				  
				//check if the value is greater than 255
				if(newRed>255)r=255;
				else r=newRed;
				
				if(newGreen>255)g=255;
				else g=newGreen;
				
				if(newBlue>255)b=255;
				else b=newBlue;
				
				//set the values
				p =(a<<24)|(r<<16)|(g<<8)|b;
				image.setRGB(x, y, p);
			}
		}
		
		//write image
		try {
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-serpia.png");
			ImageIO.write(image,"png",file);
			System.out.println("serpia written");
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	
}















 