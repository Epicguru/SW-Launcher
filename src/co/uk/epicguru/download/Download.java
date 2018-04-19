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

	public static void downloadTo(String web, String destination) throws Exception{
		
		// Test file:
		// http://ipv4.download.thinkbroadband.com/20MB.zip
		// https://c14.workupload.com/download/c2kh9NB
		
		URL url = new URL(web);
		InputStream is = url.openStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int estimate = getFileSize(url);
		int total = 0;
		
		int n = 0;
		byte[] chunk = new byte[(int) (10 * 1024)]; // 10 KB
		
		while((n = is.read(chunk)) > 0){		
			
			out.write(chunk, 0, n);
			total += n;
			
			float p = total / (float)estimate;
			p *= 100;
			
			Debug.log("Downloaded " + p + "%");
		}
		
		Debug.log("Estimated " + estimate + " bytes, there were " + total + " bytes.");
		
		byte[] bytesRead = out.toByteArray();
		out.close();
		
		// Save to file
		File file = new File(destination);
		bytesToFile(bytesRead, file);
		
		// Execute new and delete this.			
		is.close();
		
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