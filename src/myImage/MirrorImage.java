package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * here we are creating a mirror image
 *  
 *   the main trick is to take the source pixels from left to right 
 *   and set them in the output image from right to left;
 *    
 *    STEPS:
    Read the source image in a BufferedImage to read the given image.
    Get the dimensions of the given image.
    Create another BufferedImage object of same dimension to hold the mirror image.
    Get ARGB (Alpha, Red, Green and Blue) values from source image [in left to right fashion].
    Set ARGB (Alpha, Red, Green and Blue) to newly created image [in right to left fashion].
    Repeat the steps 4 and 5 for each pixels of the image.

 */
public class MirrorImage {
	
	//main method
	public static void main(String[]args) throws IOException {
		
		//buffered image set to null 
		BufferedImage input_image = null;
		BufferedImage output_image = null;
		
		//file init
		File file = null;
		
		//read input image
		try {
			file  = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-five.png");
			input_image= ImageIO.read(file);
		}
		catch(IOException e) {
			System.out.print(e);
		}
		
		//get image dimensions
		int height = input_image.getHeight();
		int width = input_image.getWidth();
		
		//buffered image of the same dimensions to hold the mirrored image
		output_image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		
		//creating a mirrored image pixel by pixel
		for(int y=0;y<height;y++) {
			for(int lx=0, rx=width-1; lx<width;lx++,rx--) {
				
				// lx starts from the left side of the image 
                // rx starts from the right side of the image 
                // lx is used since we are getting pixel from left side 
                // rx is used to set from right side 
                // get source pixel value 
				int p = input_image.getRGB(lx, y);
				
				//set mirror image pixel value
				output_image.setRGB(rx, y, p);
				
			}
		}
		
		//save and output the mirror image
		try {
			file = new File("C:\\Users\\user\\Documents\\qwosha-fashion\\img\\kevo-inversion.png");
			ImageIO.write(output_image,"png",file);
			System.out.println("inversion complete");
			
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}

}





















