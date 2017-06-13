package statics;

public class C extends B{
	
	A a = new A();
	C(){
		System.out.println("constructor C");
		a.f();
		B b = new B();
		b.f1();
		
	}
	static B b2 = new B();
	B b3 = new B();
	
}
