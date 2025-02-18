package Jichu.Test;






public class TargetObject {

	@NotNull(mustRole = "admin")
	private String value;

	@SuppressWarnings("sas")
	protected boolean aBoolean;
	public TargetObject() {
		value = "JavaGuide";
		aBoolean = false;
	}

	public void publicMethod(String s) {
		System.out.println("I love " + s);
	}

	private void privateMethod() {
		System.out.println("value is " + value);
	}
	protected void hhh() {
		System.out.println("aBoolean is " + aBoolean);
	}
}
