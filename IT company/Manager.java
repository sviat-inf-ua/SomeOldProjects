package homeWork;

import java.util.Scanner;

public class Manager extends Klient{

	
	CreateSpecialists obj1 = new CreateSpecialists();
		
	void pretenzia(){
		System.out.println("for first");
		System.out.println("Enter pretenzia");
		sc = new Scanner(System.in);
	String str = sc.nextLine();
		specialist1.setPretenzia(str);
	}

	void start(){
		int menu;
		for(;;){
			System.out.println("For create new Specialist press 1\nFor give a pretenzia press 2"
					+ "\nFor view All specialusts press 3");
			menu = sc.nextInt();
			
			if(menu == 1){
				obj.create();
			} if(menu == 2){
				pretenzia();
			} if(menu == 3){
				viewSpecialits();
			} else {
				System.out.println("Bye\n"); 
					break;
			}
			
		}
		
	}
	
}
