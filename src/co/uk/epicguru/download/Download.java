package co.uk.epicguru.download;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import co.uk.epicguru.main.Debug;

public final class Download {

	public static boolean downloading = false;
	public static boolean cancelDownload = false;
	
	public static void downloadTo(String web, String destination, DownloadTracker tracker){
		
		// Test file:
		// https://datapacket.dl.sourceforge.net/project/fotohound/sample-pictures/Sample/Sample-Pictures.zip
		if(downloading){
			Debug.log("Already downloading file, cannot process multiple downloads at once.");
			return;
		}
		downloading = true;
		cancelDownload = false;
		
		runOnThread(() -> {
			try{
				
				//DecimalFormat f = new DecimalFormat("#.##");
				URL url = new URL(web);
				InputStream is = url.openStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				
				int estimate = getFileSize(url);
				int total = 0;
				
				int n = 0;
				byte[] chunk = new byte[(int) (10 * 1024)]; // 10 KB
				
				long lastTime = System.currentTimeMillis();
				int bytesDownloaded = 0;
				//long totalBytes = 0;
				
				while((n = is.read(chunk)) > 0){		
					
					out.write(chunk, 0, n);
					total += n;
					
					bytesDownloaded += n;
					//totalBytes += n;
					
					if(tracker != null){
						tracker.currentProgress(total, estimate);
					}
					
					long timeSinceLast = System.currentTimeMillis() - lastTime;
					if(timeSinceLast >= 1000){
						lastTime = System.currentTimeMillis();
						
						//Debug.log("Downloading at " + f.format(bytesDownloaded / 1024f / 1024f) + " MB/s.");
						//Debug.log("Downloaded " + f.format(totalBytes / 1024 / 1024) + " of " + f.format(estimate / 1024 / 1024) + " MB");
						
						if(tracker != null){
							tracker.currentSpeed(bytesDownloaded);
						}
						
						bytesDownloaded = 0;
					}
					
					if(cancelDownload){
						Debug.log("Download has been canceled, no longer requesting more bytes...");
						
						out.close();
						is.close();
						
						downloading = false;
						
						if(tracker != null){
							tracker.downloadCancelled();
						}
						
						return;
					}
				}
				
				Debug.log("Estimated " + estimate + " bytes, there were " + total + " bytes.");
				
				byte[] bytesRead = out.toByteArray();
				out.close();
				
				// Save to file
				File file = new File(destination);
				bytesToFile(bytesRead, file);
				
				// Execute new and delete this.			
				is.close();
				
				downloading = false;
				
				if(tracker != null){
					tracker.downloadCompleted();
				}
				
			}catch(Exception e){
				e.printStackTrace();
				downloading = false;
			}
		});
	}
	
	private static void runOnThread(Runnable r){
		Thread thread = new Thread(r);
		thread.start();
	}
	
	private static int getFileSize(URL url) {
	    HttpURLConnection conn = null;
	    try {
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("HEAD");
	        //conn.getInputStream();
	        return conn.getContentLength();
	    } catch (IOException e) {
	        return -1;
	    } finally {
	        conn.disconnect();
	    }
	}
	
	public static void bytesToFile(byte[] array, File file) throws Exception{
		
		if(file.isDirectory()){
			return;
		}
		
		if(file.exists()){
			file.delete();
		}
		
		Debug.log("Writing to " + file.getAbsolutePath());
		
		if(!file.exists()){
			if(file.getParentFile() != null){
				file.getParentFile().mkdirs();
			}else{
				// ERROR?
				Debug.log("Error : Parent file of " + file.getAbsolutePath() + " was null!");
				return;
			}
		}	
		boolean worked = file.createNewFile();
		Debug.log("Created new file : " + worked);		
		
		// Save to disk, it is all in memory
		FileUtils.writeByteArrayToFile(file, array);	
	}	
}