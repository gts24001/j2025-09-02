//package patterns;

public class Singleton {
	
	private Singleton() { }
	
	private static Singleton CLASS_INSTANCE = new Singleton();
	public static Singleton getInstance() {
		return CLASS_INSTANCE;
	}
}
