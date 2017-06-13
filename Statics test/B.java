package statics;

public class B {

	A obj = new A();
	static A obj1 = new A(); 
	B(){
		System.out.println("constructor B");
	}
	
	void f1(){
		System.out.println("class B (f1)");
	}
	
}
