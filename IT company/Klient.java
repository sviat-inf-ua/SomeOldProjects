package homeWork;

public class Klient extends CreateSpecialists {

	CreateSpecialists obj = new CreateSpecialists();
	void viewSpecialits(){
		System.out.println("For view press 1, 2, 3 ");
		int menu = sc.nextInt();
		
		if(menu == 1){
			obj.specialist1.print();
		}	
		if(menu == 2){
			obj.specialist2.print();
		}	
		if(menu == 3){
			obj.specialist3.print();
		}	
	}	
		
	void writeComment(){
		int menu = 1;
		
		if(menu == 1){
			obj.specialist1.setWriteComment("Werry good specialist");
		}
	}
}
