//package patterns;

public class NonSingleton {
	
	public NonSingleton() { value++; staticValue++; }
	private int value = 0;
    private static int staticValue = 0;

   public void increment() { value++; }
}