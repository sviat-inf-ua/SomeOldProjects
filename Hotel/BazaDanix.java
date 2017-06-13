package Hotel;

import java.util.Scanner;

public class BazaDanix {
	Scanner sc = new Scanner(System.in);
	int kstPov, kstKimnNaPov,daysHotel,price;
	String Name ;
	int room,count = 0;
	int i = 0;
	int suma, days;
	int tempPlace = 10;
	
	String [] nameOfVidviduvach = new String[tempPlace];
	int[] numRoomVidviduvach = new int [tempPlace];
	int[] daysVidviduvach = new int [tempPlace];
	
	void bronuv(){
		System.out.println("Your Name ?");
		Name = sc.next();
		
			System.out.println("250grn for one day");
			System.out.println("Which room you want ?");
			System.out.println("Firs # of poverh then # of room, yak tyt (103)");
			room = sc.nextInt();
			
		for (int j = 0; j < numRoomVidviduvach.length; j++) {
			
			if(room == numRoomVidviduvach[j]){
				System.out.println("this room is unavailable, chouse other one");
				room = sc.nextInt();
			}
		} System.out.println("How many days ?");
		
		daysHotel= sc.nextInt();
		
		room();
		
		printVidviduvach();
	}
	
	void room(){
		nameOfVidviduvach[i] = Name;
		numRoomVidviduvach[i] = room;
		daysVidviduvach[i] = daysHotel;
		i++;
	}
	
	void printVidviduvach(){
		System.out.println("Name:     " + Name );
		System.out.println("Room:     " + room );
		System.out.println("Stay for: " + daysHotel + " days");
			suma = 250*daysHotel; 
		System.out.println("You have to pay " + suma + "grn");
		System.out.println("Please enter money:");
			int money = sc.nextInt();
				
			oplata(suma, money);
			
			checkHotel();
	}
		
	void printBusyRooms (){
		for (int i = 0; i < numRoomVidviduvach.length; i++) {
			
			if (numRoomVidviduvach[i] != 0){
				System.out.println("room #" + numRoomVidviduvach[i] + " for " + 
											daysVidviduvach[i] + " days");
			}
		}
				
	}
	
	void oplata(int suma, int money){
		
		if(suma==money) {
			 System.out.println("Operation compleated\nHave a great day!\n");
		} if(suma>money) {
			 System.out.println("not enought money ");
			 System.out.println("enter "+(suma-money)+"grn more");
				 int tempMoney = sc.nextInt();
				 
				 	if(tempMoney ==(suma-money) ){
				 		System.out.println("Operation compleated\nHave a great day!\n");
				 	} else {
				 		System.out.println("not enought money \n");
				 		System.out.println("take your "+money+"grn back");
				 	}
		 } if(suma < money){
			 System.out.println("Take your change "+(money-suma)+"\nHave a great day!\n");
		 }
	}
	
	void checkHotel(){
		System.out.println("Take your recipt");
		System.out.println("------------");
		System.out.println("You stayed " + daysHotel + " days");
		System.out.println("You payd " + suma + "grn\n");
	}
}
