package co.uk.epicguru.interaction;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

import co.uk.epicguru.download.Download;
import co.uk.epicguru.download.DownloadTracker;
import co.uk.epicguru.download.PHPQuery;
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
	
	public static void openManualDownload(){
		
		try {
			Link.open(Link.FORUM_DOWNLOAD_LINK);
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
		
		// Test PHP
		// path:
		// http://exblegal.com/downloadLink.php
		PHPQuery query;
		try {
			query = new PHPQuery("http://exblegal.com/downloadLink.php");
			query.connectAndRead();
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		downloadWindow = DownloadWindow.openNew();
		try {
			Download.downloadTo("http://download668.mediafire.com/9rq0hbi0rong/b9unq49w1bj9hhb/skillwarz_19a_x64.rar",
								"D:\\Dev\\Downloaded.rar",
					 new DownloadTracker(){
				private DecimalFormat f = new DecimalFormat("#.##");
				private String mbs = "0 MB/s";
				public void currentProgress(int bytes, int totalBytes) {
					
					if(downloadWindow == null)
						return;
					
					float percentage = (float)bytes / totalBytes;
					int p = Math.round(percentage * 100f);
					downloadWindow.getDownloadPercentage().setValue(p);
					String current = f.format(bytes / Math.pow(1024f, 3));
					String total = f.format(totalBytes / Math.pow(1024f, 3));;
					downloadWindow.getDownloadState().setText(mbs + " - " + current + " of " + total + " GB");
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
				
				public void currentSpeed(int bytesPerSecond) {
					mbs = f.format(bytesPerSecond / 1024f / 1024f) + " MB/s";					
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