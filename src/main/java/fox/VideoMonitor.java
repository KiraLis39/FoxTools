package fox;

import java.awt.*;

public class VideoMonitor {
	private final static GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private final static GraphicsDevice device = environment.getDefaultScreenDevice();
	private final static GraphicsConfiguration configuration = device.getDefaultConfiguration();

	
	public DisplayMode getDisplayMode() {
		return device.getDisplayMode();
	}
	
	public void setDisplayMode(DisplayMode mode) {
		device.setDisplayMode(mode);
	}
	
	public void switchFullscreen(Window win) {
		device.setFullScreenWindow(win);
	}
	
	public int getRefreshRate() {
		return device.getDisplayMode().getRefreshRate();
	}

	public GraphicsEnvironment getEnvironment() {
		return environment;
	}

	public GraphicsDevice getDevice() {
		return device;
	}

	public GraphicsConfiguration getConfiguration() {
		return configuration;
	}
}
