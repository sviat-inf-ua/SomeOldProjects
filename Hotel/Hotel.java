package Hotel;

import java.util.Scanner;

public class Hotel extends Restoran{
		
	static Hotel hotel1 = new Hotel();
	static Hotel hotel2 = new Hotel();
	static Hotel hotel3 = new Hotel();
	static Scanner sc = new Scanner(System.in);
	
	void createHotel(){
		int a,b,c = 0;
		int a1 = 0,b1 = 0;
		int hourStart = 0,hourEnd = 0 ;
		
		System.out.println("Enter kilkist pov");
			a = sc.nextInt();
			kstPov = a;
		System.out.println("Enter kilkist kimnat na poversi");
			b = sc.nextInt();
			kstKimnNaPov = b;
		
		for(int i =0;i<2;i++){
			System.out.println("Yakso treba dobavitu:\n1.Avtostoyanka\n2.Restoran\n0.End");
			c = sc.nextInt();
			
			if(c == 1){
				System.out.println("Enter kilkist poverhiv");
					a1 = sc.nextInt();
					kstPoverhiv= a1;
				System.out.println("Kilkist mists na poversi");
					b1 = sc.nextInt();
					kstMists = b1;
			} else if(c == 2){
				System.out.println("start work hour:");
					hourStart = sc.nextInt();
					workHour = hourStart;
				System.out.println("end hour:");
					hourEnd = sc.nextInt();
			} else if(c == 0)
				i = 1;
		} System.out.println("Yakscho xochete print result press: 1.\nExit press: 0");
				int tempPrint = sc.nextInt();
			
		if(tempPrint == 1){
			System.out.println("new Hotel");
			System.out.println("kilkist poverxiv "+a);
			System.out.println("kilkist kimnat na poversi "+b);
			if(a1>0)
				System.out.println("Prisutnya Avtostoyanka "+a1+"poverxiv "+a1*b1+" mists\n");
			if(hourStart>0)
				System.out.println("Prisutnui Restoran. Works from "+hourStart+"to "+hourEnd);
		}
	}
	
	void vidvidyvach(){
		
			if(kstPov>1){
				System.out.println("Hotel: \nYou can chouse one of " + kstPov + " poverhiv\n" + 
								   "and one of "+kstKimnNaPov + " kimnat na poversi" );
				
				printBusyRooms();
			} else if(kstPov == 1) {
				System.out.println("This hotel has only 1 poverx \nYou can chouse one of "+kstKimnNaPov + 
						           " kimnat na poversi");
				printBusyRooms();
			}
			bronuv();
			
			if( workHour > 0){
				System.out.println("If you want to visit restoran \npress: 1.\npress: 0 to Exit");
				int RestoranTemp = sc.nextInt();
				
				if(RestoranTemp == 1){
					
					kyxnya();
						System.out.println("If you want order :\n1.To your room\n2.To go\n3.Stay");
						int RezervTemp = sc.nextInt();
						
					if(RezervTemp == 1){
						
						zamovVnomer();
						
						oplata();
					} else if(RezervTemp == 2){
						
						zamovZsoboy();
						
						oplata();
						
					} else if(RezervTemp == 3){
						System.out.println("You can sit on any free table");
						
						oplata();
					}else 
						System.out.println("bay");
				} 
			} if(kstMists > 0){
				System.out.println("If you wont to park your car press:\nYes 5\nNo press 0");
				int tempPark = sc.nextInt();
			
				if(tempPark == 5) {
					oplataParking();
					checkAvto();
				}
			}		
		}
				
	public static void main(String[] args) {
		int menu;
		
		for(;;){
			System.out.println("enter:\n1.for Admin \n2.for vidviyvach\n3.for Exit");
			menu = sc.nextInt();
			
			if(menu == 1){
				int password,pass = 123;
				System.out.println("Enter password:");
				password = sc.nextInt();
				
				if(password==pass){
					System.out.println("You enter like admin");
					System.out.println("\nYou have 3 hotels");
					System.out.println("Press:\n1 create first\n2 create second\n3 create third\n   4 for see activity");
					int menu1 = sc.nextInt();
					
					if(menu1 == 1){
						hotel1.createHotel();
						
					} if(menu1 == 2){
						hotel2.createHotel();
						
					} if(menu1 == 3){
						hotel3.createHotel();
					}
					if(menu1 == 4){
						hotel1.printBusyRooms();
						hotel2.printBusyRooms();
						hotel3.printBusyRooms();
					}
				} else System.out.println("Incorect passwor, bye...");
			} else if(menu == 2){
				System.out.println("You enter like vidvidyvach");
				System.out.println("\nYakui Hotel vu vubiraete:\n1.for Hotel #1\n2.for Hotel #2\n3 for Hotel #3");
				int menuVidvid = sc.nextInt();
				
				if(menuVidvid == 1){
					hotel1.vidvidyvach();
				} if(menuVidvid == 2){
					hotel2.vidvidyvach();
				} if(menuVidvid == 3){
					hotel3.vidvidyvach();
				}
			} else if(menu==3){
					System.out.println("Buy");
				break;
			}
		}

	}

}
