package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * converting the image to Green effect
 */
public class ColouredToGreen {

	
	//main method
	public static void main (String[]args) throws IOException{
		
		BufferedImage image = null;
		File file = null;
		
		//read file
		try {
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-four.png");
			image = ImageIO.read(file);
		}catch(IOException e) {
			System.out.print(e);
		}
		
		
		//get image width and height
		int width = image.getWidth();
		int height = image.getHeight();
		
		//convert to green effect 
		for(int y=0; y<height;y++) {
			for(int x=0;x<width;x++) {
				
				int p = image.getRGB(x, y);
				
				//get bits
				int a = (p>>24)&0xff;
				int g= (p>>8)&0xff;
				
				//set
				p = (a<<24)|(0<<18)|(g<<8)|0;
				image.setRGB(x, y, p);
			}
		}
		
		//writing the image
		try {
			
			file = new File("C:\\\\Users\\\\user\\\\Documents\\\\qwosha-fashion\\\\img\\\\kevo-four.png");
			ImageIO.write(image,"png",file);
			System.out.print("successful write");
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}
