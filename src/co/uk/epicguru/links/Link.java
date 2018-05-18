package co.uk.epicguru.links;

import java.awt.Desktop;
import java.net.URI;

import co.uk.epicguru.main.Debug;

public final class Link {

	public static final String FORUM_LINK = "https://skillwarz.com/";
	public static final String FORUM_DOWNLOAD_LINK = "https://skillwarz.com/downloads.php";
	public static final String YOUTUBE_LINK = "https://www.youtube.com/user/OneManArmy3D/";
	
	public static void open(String url) throws Exception{
		
		if (Desktop.isDesktopSupported()) {
		    Desktop.getDesktop().browse(new URI(url));
		}else{
			Debug.log("Not running on desktop? Desktop lib not supported, cannot open link!");
		}
		
	}
	
}
