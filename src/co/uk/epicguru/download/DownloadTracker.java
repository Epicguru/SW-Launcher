package co.uk.epicguru.download;

public interface DownloadTracker {

	public void currentProgress(int bytes, int totalBytes);	
	
}