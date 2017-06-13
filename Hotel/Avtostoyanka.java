package Hotel;

public class Avtostoyanka extends BazaDanix{
	int kstMists,kstPoverhiv;
	int suma = daysHotel * 20, money;
	
	void oplataParking(){
		System.out.println("for one day 20grn");
		System.out.println("You have to pay " + daysHotel * 20 + "grn");
		System.out.println("Enter money: ");
		money = sc.nextInt();
		
		oplata(suma, money);
	}
	
	void checkAvto(){
		System.out.println("Take your recipt");
		System.out.println("------------");
		System.out.println("You stayed " + daysHotel + " days");
		System.out.println("You payed for parking " + daysHotel * 20 + "grn\n");
		System.out.println("------------");
	}
}
