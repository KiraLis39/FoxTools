package fox;

import lombok.extern.slf4j.Slf4j;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class Screensaver {
    public static void saveImage(BufferedImage image, Path saveAs) throws IOException {
        String exp = saveAs.getFileName().toString().split("\\.")[saveAs.getFileName().toString().split("\\.").length - 1];
        saveImage(image, exp, saveAs);
    }

    public static void saveImage(BufferedImage image, String extension, Path saveAs) throws IOException {
        log.debug("Saving the image " + saveAs + " (" + extension + ")...");
        ImageIO.write(image, extension, saveAs.toFile());
    }

    private Screensaver() {}
}
