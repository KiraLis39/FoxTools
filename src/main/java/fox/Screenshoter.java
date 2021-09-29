package fox;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;


public class Screenshoter {

	private Screenshoter() {}
	
	public static void saveImage(BufferedImage image, Path saveAs) throws IOException {
		String exp = saveAs.getFileName().toString().split(".")[saveAs.getFileName().toString().split(".").length-1];
		saveImage(image, exp, saveAs);
	}
	
	public static void saveImage(BufferedImage image, String extention, Path saveAs) throws IOException {
		log("Saving the image " + saveAs + " (" + extention + ")...");
		ImageIO.write(image, extention, saveAs.toFile());
	}

	private static void log(String message) {
		System.out.println(Screenshoter.class.getName() + " : " + message);
	}
}
