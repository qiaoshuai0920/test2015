package test.com;

public class SingletonClass {
	private static final SingletonClass asd= new SingletonClass();
	
	public static SingletonClass qqqq(){
		return null;
	}
	
	private SingletonClass(){
		System.out.println("Singleton!!");
	}

}
