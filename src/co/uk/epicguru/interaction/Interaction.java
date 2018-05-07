package co.uk.epicguru.interaction;

import co.uk.epicguru.links.Link;
import co.uk.epicguru.window.DownloadWindow;

public final class Interaction {

	public static void openForums(){
		
		try {
			Link.open(Link.FORUM_LINK);
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
	
	public static void testDownload(){
		
		DownloadWindow var = DownloadWindow.openNew();
//		try {
//			Download.downloadTo("https://codeload.github.com/Epicguru/Boats-Guns-And-Explosions/zip/TestRelease",
//					"D:\\Dev\\Downloaded.zip",
//					new DownloadTracker(){
//
//						public void currentProgress(int bytes, int totalBytes) {
//							
//							float percentage = (float)bytes / totalBytes;
//							int p = Math.round(percentage * 100f);
//							var.progressBar.setValue(p);	
//							
//						}
//					}
//			);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
}