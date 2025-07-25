import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.awt.Color;

public class ImageToGrayscale {

    public static void main(String[] args) throws Exception {
    	
        File inputFile = new File("beach.png"); // Input file
        File outputFile = new File("beach_grayscale.png"); // Output file

        try {
        	long startTime = System.currentTimeMillis();
            BufferedImage image = ImageIO.read(inputFile);
            
           //convertToGrayscale(image);
            convertToGrayscaleConcurrently(image, 2);
            long endTime = System.currentTimeMillis();
            System.out.println(startTime-endTime + " time taken to grayscale");

            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    														// 5000 			// 2
     private static void convertToGrayscaleConcurrently(BufferedImage image, int numberOfThreads) throws InterruptedException {
    	int hightPerThread = image.getHeight() / numberOfThreads;  // 2500
    	GrayScaleConvertorThread[] threads = new GrayScaleConvertorThread[numberOfThreads];
    	for(int i = 0; i < threads.length; i++) {
    		int startY = i * hightPerThread;
    		int endY = startY + hightPerThread;
    		threads[i] = new GrayScaleConvertorThread(image, startY, endY);
    		threads[i].start();
    	}
    	//Thread 0 -> 0 *2500 , endY 0 + 2500
    	//Thread 1 -> 2500 * 2500 , endY 2500 + 2500 = 5000
    	for(GrayScaleConvertorThread g : threads) {
    		g.join();
    	}
        
     }


    private static void convertToGrayscale(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb, true);
    
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                // Compute the average of red, green, and blue (simple grayscale)
                int gray = (red + green + blue) / 3;
                
                // Create new grayscale color
                Color grayColor = new Color(gray, gray, gray, color.getAlpha());
                image.setRGB(x, y, grayColor.getRGB());
            }
        }
    }
}
