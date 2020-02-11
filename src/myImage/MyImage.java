package myImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class MyImage  {
	
	
	public static void main(String []args)throws IOException {
		
		int width = 963; //image width
		int height = 640;
		
		
		//code for storing image in RAM
		BufferedImage image = null;
		
		//read image
		try {
			
			File input_file = new File("C:\\tito.jpg");
			
			/*
			 * create an object of BufferedImage type and pass 
               as parameter the width,  height and image int 
               type.TYPE_INT_ARGB means that we are representing 
               the Alpha, Red, Green and Blue component of the 
               image pixel using 8 bit integer value.
			 */
			
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			//reading the input file
			image = ImageIO.read(input_file);
			
			System.out.println("Reading complete");
		}
		catch(IOException e) {
			System.out.println("Error: "+e);
		}
		
		//Write Image
		try {
			
			//file output init
			File output_file = new File("C:\\Users\\user\\Documents\\out.jpg");
			
			//writing to file, taking the type(.jpg) and path(C:\\...)
			ImageIO.write(image, "jpg", output_file);
			
			System.out.println("writting complete");
		}catch(IOException e) {
			
			System.out.println("Error"+e);
		}
	}

}
