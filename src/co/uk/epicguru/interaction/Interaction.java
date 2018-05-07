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
			Download.downloadTo("http://download668.mediafire.com/74w9iipoqumg/b9unq49w1bj9hhb/skillwarz_19a_x64.rar",
					"D:\\Dev\\Downloaded.rar",
					new DownloadTracker(){
						public void currentProgress(int bytes, int totalBytes) {
							
							if(downloadWindow == null)
								return;
							
							float percentage = (float)bytes / totalBytes;
							int p = Math.round(percentage * 100f);
							downloadWindow.getDownloadPercentage().setValue(p);						
						}

						public void downloadCompleted() {
							Debug.log("Completed the download, yay!");
							
							if(downloadWindow == null)
								return;
							
							// Close the window...
							downloadWindow.dispatchEvent(new WindowEvent(downloadWindow, WindowEvent.WINDOW_CLOSING));
						}

						public void downloadCancelled() {
							Debug.log("The download was interupted (cancelled).");
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