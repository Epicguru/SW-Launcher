package co.uk.epicguru.main.assets;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import co.uk.epicguru.main.Debug;

public final class Assets {

	public static HashMap<String, BufferedImage> loadedImages = new HashMap<String, BufferedImage>();
	
	public static BufferedImage loadImage(String internalPath){
		
		// Loads an image from the internal co.uk.epicguru.main.assets classpath.
		if(internalPath == null){
			Debug.log("Null loadImage input, null output!");
			return null;
		}
		
		if(loadedImages.containsKey(internalPath)){
			return loadedImages.get(internalPath);
		}
		
		try {
			// Load internally and cache for faster reading later.
			BufferedImage img = ImageIO.read(Assets.class.getResource(internalPath));
			loadedImages.put(internalPath, img);
			return img;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void unloadImage(String internalPath){
		
		// Unloads any cached version of an image.
		if(internalPath == null){
			return;
		}
		
		if(!loadedImages.containsKey(internalPath)){
			return;
		}
		
		// Remove the image from the map.
		loadedImages.remove(internalPath);
	}
}
