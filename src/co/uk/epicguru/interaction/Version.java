package co.uk.epicguru.interaction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import co.uk.epicguru.links.Link;
import co.uk.epicguru.main.Debug;

public class Version {

	public static String getInstalled(){
		
		String docFolder = Link.getMyDocuments();
		File docs = new File(docFolder);
		
		if(!docs.exists() || !docs.isDirectory()){
			Debug.log("The 'My Documents' directory '" + docs.getAbsolutePath() + "' does not exist or is not a directory!");
			return null;
		}
		
		File gameDir = Paths.get(docs.getAbsolutePath(), "Skillwarz", "Installed", "Version.txt").toFile();
		if(!gameDir.exists() || gameDir.isDirectory()){
			Debug.log("Game installation version file '" + gameDir.getAbsolutePath() + "' does not exist or is a directory!");
			return null;
		}
		
		try {
			String str = FileUtils.readFileToString(gameDir, Charset.defaultCharset());
			return str.trim();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
}