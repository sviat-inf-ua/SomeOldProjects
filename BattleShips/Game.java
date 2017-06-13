package battleShips;

import java.util.Scanner;

public class Game{
	String[][] field = new String[10][10];
	int iA , jA ;
	int countShip=0;
	Scanner sc = new Scanner(System.in);
	
	void field(){
		
		for (int i = 0; i < field.length; i++) {
			
			for (int j = 0; j < field.length; j++) {
				field[i][j] = ".";

			}
		}
	}
	
	int shipPlace(int length, int tempI, int tempJ){
		int menuRozmisch;
		System.out.println("rozmischennya po horizontali press 1, "
				+ "po verticali press 2");
		menuRozmisch = sc.nextInt();
		
		if(menuRozmisch == 1){
		
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field.length; j++) {
					if(i == iA && j == jA){
						
						int temp = 0;
						for (int j2 = 0; j2 <= length; j2++) {
							if(i > 0 && j > 0 && i < field.length - 1 && field[i - 1][tempJ] != "O" && field[i - 1][tempJ - 1] != "O"
									&& tempJ + length <= field.length  && field[i - 1][tempJ + 1] != "O" 
									&& field[i][tempJ + 1] != "O" && field[i][tempJ - 1] != "O" 
									&& field[i + 1][tempJ] != "O" && field[i + 1][tempJ - 1] != "O"
									&& field[i + 1][tempJ + 1] != "O"
											|| i == 0 && i < field.length - 1 && field[i][tempJ + 1] != "O"	&& field[i][tempJ - 1] != "O" && field[i + 1][tempJ] != "O"
											&& field[i + 1][tempJ - 1] != "O" && field[i + 1][tempJ + 1] != "O"
											|| i == field.length - 1 && field[i - 1][tempJ] != "O" && field[i - 1][tempJ - 1] != "O"
													&& field[i - 1][tempJ + 1] != "O" && field[i][tempJ + 1] != "O"
													&& field[i][tempJ - 1] != "O" 
													|| tempJ == 0 && field[i - 1][tempJ] != "O" && field[i - 1][tempJ + 1] != "O" && field[i][tempJ + 1] != "O"
															&& field[i + 1][tempJ] != "O" && field[i + 1][tempJ + 1] != "O"
															|| tempJ == (field.length - 1) && field[i - 1][tempJ] != "O" && field[i - 1][tempJ - 1] != "O"
																	&& field[i][tempJ - 1] != "O" && field[i + 1][tempJ] != "O"
																	&& field[i + 1][tempJ - 1] != "O" 
																	|| j + length <= field.length && field[i][j + 1] != "O" && field[i][j + (length -1)] != "O" 
																	&& field[i - 1][j] != "O" && field[i + 1][j + 1] != "O" && field[i + 1][j + 1] != "O" &&  
																	field[i - 1][j + (length - 1)] != "O")

								{
															
								tempJ++;
								temp ++;
								
								 if(temp == length){
									 for (int j21 = 0; j21 < length; j21++) {
										 
												 field[tempI = i][tempJ-1] = "O";
												 tempJ--;
												
												 temp = 0;
									 }
									 
								 } else if(field[i][tempJ] == "O") {
										System.out.println("try again 1");
										countShip++;
								 }
							}
							
							else if (i >= 1 && field[i - 1][tempJ] == "O" || i >= 1 && field[i - 1][tempJ + 1] == "O"){
								System.out.println("Incorect input !!!\n");
								
								if (tempJ > 0){
									if(field[tempI = i][tempJ-1] == "O"){
										field[tempI = i][tempJ-1] = "O";
								}
								} else
									if (tempJ > 0){
										field[tempI = i][tempJ-1] = ".";
									countShip++;
									//length ++;
									}
								countShip++;
								break;
								
							}
							
						}
				    }
				}
			}
			
		} if (menuRozmisch == 2){
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field.length; j++) {
					if(i == iA && j == jA){
						for (int j2 = 0; j2 < length; j2++) {
							field[tempI][tempJ = j] = "O";
							 tempI++;
						}
				    }
				}
			}
		} return 0;
	}
	
	void print(){
		System.out.println("1 2 3 4 5 6 7 8 9 10");
		for (int i1 = 0; i1 < field.length; i1++) {
			for (int j = 0; j < field.length; j++) {
				System.out.print(field[i1][j] + " ");
			} System.out.print(i1+1); 
			System.out.println();
		}
	}
}
