package battleShips;

import java.util.Scanner;

public class Shots extends Ships{
	
	
	void shot(){
		Scanner sc =new Scanner(System.in);
		
				System.out.println("--------------------");
				System.out.println("    FiGHT !!!!   ");
				System.out.println("--------------------\n");
				System.out.println("Enter X");
				int i = sc.nextInt();
				
				System.out.println("Enter Y");
				int k = sc.nextInt();
				
				if (field[i - 1][k - 1] == "O") {
					System.out.println("\nStruck !!!\n");
					field[i - 1][k - 1] = "X";
				} else if (field[i - 1][k - 1] == "."){
					System.out.println("\nMiss !!!\n");
					field[i - 1][k - 1] = "*";
				}
							
				print();
	}	

}
