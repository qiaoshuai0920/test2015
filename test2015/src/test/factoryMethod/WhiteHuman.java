package test.factoryMethod;

public class WhiteHuman implements IHuman {
	public void laugh() {
		System.out.println("白色人类会大笑，侵略的笑声");
	}

	public void cry() {
		System.out.println("白色人类会哭");
	}

	public void talk() {
		System.out.println("白色人类会说话，一般都是但是单字节！");
	}
}