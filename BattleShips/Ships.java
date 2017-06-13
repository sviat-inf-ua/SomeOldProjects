package battleShips;


import java.util.Scanner;

public class Ships extends Game {
	
	int a = 4;
	int b = 3; // dva 
	int c = 2; // tri
	int d = 1; // chotiru
	int length;
	int iB, jB;
	int iC, jC;
	int iD, jD;
	int ship;
	
	Scanner sc = new Scanner(System.in);
	
	void shipA(){
		field();
		
		length = 4;
		
			System.out.println("Enter coordinat\nX = ");
			iA = sc.nextInt()-1;
				System.out.println("Y = ");
			jA = sc.nextInt()-1;
			
			shipPlace(length, iA, jA);
			
			System.out.println("1 2 3 4 5 6 7 8 9 10");
			for (int i1 = 0; i1 < field.length; i1++) {
				for (int j = 0; j < field.length; j++) {
					System.out.print(field[i1][j] + " ");
				} //System.out.print(i1+1); 
				System.out.println();
			}
	
	}
	
	void shipB(){
		length = 3;
		ship = 2;
		for (int k = 0; k < ship; k++) {
				
			System.out.println("Enter coordinat\nX = ");
			iA = sc.nextInt() - 1;
				System.out.println("Y = ");
			jA = sc.nextInt() - 1;
			
			shipPlace(length, iA, jA);
			
			if(countShip > 0){
				System.out.println("count ship " + countShip);
				k--;
				countShip = 0;
			}
			System.out.println("1 2 3 4 5 6 7 8 9 10");
			for (int i1 = 0; i1 < field.length; i1++) {
				for (int j = 0; j < field.length; j++) {
					System.out.print(field[i1][j] + " ");
				} System.out.print(i1+1); 
				System.out.println();
			}
		}
	}
	
	void shipC(){
		length = 2;
		for (int k = 0; k < 3; k++) {
			
			System.out.println("Enter coordinat\nX = ");
			iA = sc.nextInt() - 1;
				System.out.println("Y = ");
			jA = sc.nextInt() - 1;
			
			shipPlace(length, iA, jA);
			
			System.out.println("1 2 3 4 5 6 7 8 9 10");
			for (int i1 = 0; i1 < field.length; i1++) {
				for (int j = 0; j < field.length; j++) {
					System.out.print(field[i1][j] + " ");
				} System.out.print(i1+1); 
				System.out.println();
			}
		}
	}
}
