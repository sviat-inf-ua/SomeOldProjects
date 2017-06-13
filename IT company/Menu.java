package homeWork;

public class Menu extends Manager {

	
	public static void main(String[] args) {
		Manager obj = new Manager();
		int menu;
		
		
		for(;;){
			System.out.println("Hello in best IT company");
			System.out.println("For manager 1\nFor client 2");
			
			menu = obj.sc.nextInt();
			
			if(menu == 1){
				System.out.println("You enter like manager");
				obj.start();
			} if(menu == 2){
				System.out.println("You enter liek klient");
				obj.viewSpecialits();
				System.out.println("if you want to leve a comment press 1 or 0 for exit");
				obj.writeComment();
			}
		}

	}

}
