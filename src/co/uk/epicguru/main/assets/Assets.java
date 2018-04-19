package co.uk.epicguru.main.assets;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class Assets {

	public static BufferedImage loadImage(String internalPath){
		
		try {
			return ImageIO.read(Assets.class.getResource(internalPath));
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	
}
