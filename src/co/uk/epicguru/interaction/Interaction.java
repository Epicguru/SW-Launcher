package co.uk.epicguru.interaction;

import java.awt.event.WindowEvent;

import co.uk.epicguru.download.Download;
import co.uk.epicguru.download.DownloadTracker;
import co.uk.epicguru.links.Link;
import co.uk.epicguru.main.Debug;
import co.uk.epicguru.window.DownloadWindow;

public final class Interaction {

	public static DownloadWindow downloadWindow;
	
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
		
		if(Download.downloading)
			return;
		
		downloadWindow = DownloadWindow.openNew();
		try {
			Download.downloadTo("https://datapacket.dl.sourceforge.net/project/fotohound/sample-pictures/Sample/Sample-Pictures.zip",
					"D:\\Dev\\Downloaded.zip",
					new DownloadTracker(){
						public void currentProgress(int bytes, int totalBytes) {
							
							float percentage = (float)bytes / totalBytes;
							int p = Math.round(percentage * 100f);
							downloadWindow.getDownloadPercentage().setValue(p);						
						}
					}
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void downloadCancelRequest(){
		if(!Download.downloading)
			return;
		
		Debug.log("Download cancel requested...");
		Download.cancelDownload = true;
	}
	
	public static void downloadCancelConfirmed(){
		// When a download cancel request has been confirmed, so close the open window.
		Debug.log("Cancel confirmed, closing window!");
		
		if(downloadWindow != null){
			downloadWindow.dispatchEvent(new WindowEvent(downloadWindow, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public static void downloadWindowClosed(){
		Debug.log("Download window is closed, disposing...");
		
		Download.cancelDownload = true;
		downloadWindow = null;
	}
}