package Hotel;

public class Restoran extends Avtostoyanka{
	int workHour;
	int borsch, fish, vareniki, menuKyxny, bill = 0;
	int a,b,c;
	
	void kyxnya(){
		System.out.println("Sogodni v nas v menu:\n");
		System.out.println("1.Borsch - 25grn\n2.Fish - 45grn\n3.Vareniki - 35grn");
		menuKyxny = Hotel.sc.nextInt();
		
		reserv();
	}
	void reserv(){
		if(menuKyxny == 1){
			bill += 25;
			a=1;
		} if(menuKyxny == 2){
			bill +=45;
			b = 1;
		} if(menuKyxny == 3){
			bill +=35;
			c = 1;
		} System.out.println("U want order more ?\n1. Yes\n2. No");
			int FoodTemp = Hotel.sc.nextInt();
		if(FoodTemp == 1){
			kyxnya();
		} else System.out.println();
	}
	
	void zamovVnomer(){
		System.out.println("Ok we will bring it to your room");
	}
	
	void zamovZsoboy(){
		System.out.println("Ok in a minute it will be ready");
	}
	
	void oplata(){
		System.out.println("You have to pay "+bill+"grn\n");
		System.out.println("please enter money: ");
		int money1 = sc.nextInt();
		oplata(bill, money1);
		checkRestoran();
	}
	
	void checkRestoran(){
		System.out.println("Take your recipt");
		System.out.println("------------");
				
		if(a == 1){System.out.println("Borsch   - 25grn");    
			} if(b == 1){
				System.out.println("Fish     - 45grn");
			} if(c == 1){
				System.out.println("Vareniki - 35grn");
		    }
				System.out.println("------------");
				System.out.println(" restoran = "+bill);
	}

}
