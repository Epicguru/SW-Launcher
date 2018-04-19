package co.uk.epicguru.interaction;

import co.uk.epicguru.download.Download;
import co.uk.epicguru.links.Link;

public final class Interaction {

	public static void openForums(){
		
		try {
			Link.open(Link.FORUM_LINK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Download.downloadTo("https://codeload.github.com/Epicguru/Boats-Guns-And-Explosions/zip/TestRelease", "D:\\Dev\\Downloaded.zip");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void openYoutube(){
		
		try {
			Link.open(Link.YOUTUBE_LINK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
