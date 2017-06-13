package homeWork;

public class CreateSpecialists extends SpecialistDataBase {
	SpecialistDataBase specialist1 = new SpecialistDataBase();
	SpecialistDataBase specialist2 = new SpecialistDataBase();
	SpecialistDataBase specialist3 = new SpecialistDataBase();
	
	void create(){
		int menu;
		
			for(;;){
				System.out.println("Please add 4 specialists\nPress 1 for first\nPress 2 for second\nPress 3 for third\nPress 5 for Exit");
				menu = sc.nextInt();
				
				if(menu == 1) {
					specialist1.specialistKnowledge();
					specialist1.birthdayDate();
					specialist1.portfolio();
					specialist1.print();
				} else if(menu == 2) {
					specialist2.specialistKnowledge();
					specialist2.birthdayDate();
					specialist2.portfolio();
					specialist2.print();
				} else if(menu == 3) {
					specialist3.specialistKnowledge();
					specialist3.birthdayDate();
					specialist3.portfolio();
					specialist3.print();
				} else if (menu == 5)break;
				 else  
					 System.out.println("Incorect input");
			}
	}
}
