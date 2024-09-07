package fox.utils;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.awt.*;

@Getter
@UtilityClass
public class VideoMonitor {
    private final static GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private final static GraphicsDevice device = environment.getDefaultScreenDevice();
    private final static GraphicsConfiguration configuration = device.getDefaultConfiguration();

    public static DisplayMode getDisplayMode() {
        return device.getDisplayMode();
    }

    public static void setDisplayMode(DisplayMode mode) {
        device.setDisplayMode(mode);
    }

    public static void setFullscreen(Window win) {
        device.setFullScreenWindow(win);
    }

    public static int getRefreshRate() {
        return device.getDisplayMode().getRefreshRate();
    }

    public static int getAvailableAcceleratedMemory() {
        return device.getAvailableAcceleratedMemory();
    }

    public static DisplayMode[] getDisplayModes() {
        return device.getDisplayModes();
    }

    public static BufferCapabilities getBufferCapabilities() {
        return configuration.getBufferCapabilities();
    }

    public static ImageCapabilities getImageCapabilities() {
        return configuration.getImageCapabilities();
    }
}
