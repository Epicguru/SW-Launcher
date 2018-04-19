package co.uk.epicguru.main;

public final class Debug {

	private static String NULL = "<null>";
	
	public static void log(Object o){
		System.out.println(o == null ? NULL : o.toString());
	}
	
}