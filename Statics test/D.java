package statics;

public class D {

	public static void main(String[] args) {
		
		System.out.println("Create obj class  A");
		A objA = new A();
		System.out.println("Create obj class  C");
		C objC = new C();

	}

	static A objAst = new A();
	static C objCst = new C();
}
