package battleShips;


public class Menu extends Shots{

	
	public static void main(String[] args) {
		
		Menu obj = new Menu();
		
		obj.field();
		obj.shipA();
		obj.shipB();
		obj.shipC();
		
		for(;;){
			obj.shot();
			int count = 0;
			
			for (int i = 0; i < obj.field.length; i++) {
				for (int j = 0; j < obj.field.length; j++) {
					if(obj.field[i][j] == "O") {
						count++;
					}
				}
			} if(count > 0){
				System.out.println("count " + count);
				count = 0;
			}

			else{
				System.out.println("\nThe End\n");
				break;
			}
			 
		}
	}
}
