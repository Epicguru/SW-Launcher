package co.uk.epicguru.main;

import co.uk.epicguru.window.MainWindow;

public final class Main {

	public static void main(String... args){
		
		Debug.log("Hello, world!");
		
		try{
			
			// Run the whole launcher and catch any exceptions to report them.
			run();
			
		}catch(Exception e){
			
		}
		
	}
	
	private static void run() throws Exception{		
		
		MainWindow.launch();
		
	}
	
}