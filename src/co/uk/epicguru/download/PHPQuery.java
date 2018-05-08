package co.uk.epicguru.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import co.uk.epicguru.main.Debug;

public class PHPQuery {

	private String address;
	private URL url;
	
	public PHPQuery(String URL){
		this.address = URL;
		
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}			
	}	
	
	public String connectAndRead() throws IOException{
		
		HttpURLConnection conn;
		try{
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
		}catch(IOException e){
			throw e;
		}	
		
		
		StringBuilder str = new StringBuilder();		
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));		
		String line;
		
		while((line = in.readLine()) != null){
			str.append(line);
			Debug.log(line);
		}
		
		in.close();
		
		return str.toString().trim();
	}
}