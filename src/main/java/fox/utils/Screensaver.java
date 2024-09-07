package fox.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@UtilityClass
public class Screensaver {
    public static void saveImage(BufferedImage image, File saveAs) throws IOException {
        String[] parts = saveAs.getName().split("\\.");
        String exp = parts[parts.length - 1];
        saveImage(image, exp, saveAs);
    }

    public static void saveImage(BufferedImage image, String extension, File saveAs) throws IOException {
        log.debug("Saving the image " + saveAs + " (" + extension + ")...");
        ImageIO.write(image, extension, saveAs);
    }
}
