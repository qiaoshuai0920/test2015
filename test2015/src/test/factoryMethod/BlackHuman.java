package test.factoryMethod;

public class BlackHuman implements IHuman {
	public void laugh() {
		System.out.println("黑人会笑");
	}

	public void cry() {
		System.out.println("黑人会哭");
	}

	public void talk() {
		System.out.println("黑人可以说话，一般人听不懂");
	}
}