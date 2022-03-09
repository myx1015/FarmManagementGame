package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
	
	public BufferedImage loadImage(String imgName) {
		
		BufferedImage image = null;
		
		// Get inputStream from resources folder (for JAR File)
		InputStream in = getClass().getClassLoader().getResourceAsStream(imgName);
		if (in == null) {
			// in == null when the program is excecuted in IDE, so add "resources/" before imgName
			in = getClass().getClassLoader().getResourceAsStream("resources/" + imgName);
		}
		
		try {
			image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Normally, image will never be null
		return image;
	}
	
}
