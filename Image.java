
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//Created Image class
public class Image {
	
	 int width ;
	 int height;
	public byte[]data;
	String header;
	
// creating a public byte array to store 24-bit RGB(3 byte per pixel	
public Image(int width,int height) {
	
		this.width = width;
		this.height =height;
		// Multiplying the  RGB with 3
		data = new byte[width*height*3];
		int pixelvalue = width*height;
		int bytesvalue = pixelvalue*3;
		this.data = new byte[bytesvalue];
		
	}

//Created a method named as set which sets a single pixel at
//given position represented by value
public void set(int x, int y, int value) {
	
	
	// split the 4 byte integer into its RGB
	
	int red = (value & 0xFF0000)>>4*4;
	int green = (value & 0x00FF00)>>2*4;
        int blue = (value & 0x0000FF);
       
        System.out.println("r: " + red + ", g: " + green + ", b: " + blue);
			int position = (x+ y*width)*3;
			data[position] = (byte) red;
			data[position+1] = (byte)green;
			data[position+2] = (byte)blue;
			
			
		}
// Created a method name as write that writes the image data into file
public void write(String filename) throws Exception {
	 
	FileOutputStream out = new FileOutputStream(filename);
	 try {
	
	 out.write(new String(header).getBytes());
	 out.close();
		
} catch (IOException e) {
	
	e.printStackTrace();
	}
}
}



 

