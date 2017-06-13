package statics;

public class Test1 {
	
	static int a=0;
	static {
		int b=9;
		System.out.println("Text");
	}
	
	int h=90;
	static int f () {
		//h=89;
		a=90;
		
		
		
		return a;
		
	}
	
	void f1 () {
		
		a=89;
		h=89;
		
	}
	
	public Test1() {
		a++;
		System.out.println(a);
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Test1 t = new Test1();
		}
	}

}
