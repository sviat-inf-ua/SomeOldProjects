package homeWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SpecialistDataBase {
	String[] knowledgeArray;
	private String name, portpholio;
	private int dosvid ;
	private String writeComment; 
	private String pretenzia;
	
	public String getPretenzia() {
		return pretenzia;
	}
	public void setPretenzia(String pretenzia) {
		this.pretenzia = pretenzia;
	}
	
	public String getWriteComment() {
		return writeComment;
	}
	public void setWriteComment(String writeComment) {
		this.writeComment = writeComment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPortpholio() {
		return portpholio;
	}
	public void setPortpholio(String portpholio) {
		this.portpholio = portpholio;
	}
	public int getDosvid() {
		return dosvid;
	}
	public void setDosvid(int dosvid) {
		this.dosvid = dosvid;
	}
	
	SpecialistDataBase obj ;
	Scanner sc = new Scanner(System.in);
	
	void name(){
		System.out.println("Enter specialist name ");
		setName(sc.next());
	}
	
	void specialistKnowledge(){
		int menu = 0;
		int i = 0;
		obj = new SpecialistDataBase();
		knowledgeArray = new String [4];
				
		obj.name();
		
		System.out.println("Enter knowledge of specialist:"
				+ "\n1.Java\n2.C++\n3.Python\n4.PHP & HTML\n5.Exit");
		for(;;){
			menu = sc.nextInt();
			if(menu == 1){
				knowledgeArray[i] = "Java";
				i++;
			} if (menu == 2){
				knowledgeArray[i] = "C++";
				i++;
			} if (menu == 3){
				knowledgeArray[i] = "Python";
				i++;
			} if (menu == 4){
				knowledgeArray[i] = "PHP & HTML";
				i++;
			} if (menu == 5){
				break;
			}	
		}
		
		dosvidRobotu();	
	}
	
	void dosvidRobotu(){
		System.out.println("Enter dosvid robotu ");
		 setDosvid(sc.nextInt());
	}
	
	void birthdayDate()  {
		String pattern = "MM/dd/yyyy";
		String inputDate ;
		SimpleDateFormat example = new SimpleDateFormat(pattern);
						
		try {
			System.out.println("Enter date: MM/dd/yyyy");
			inputDate = sc.next();
		      Date date = example.parse(inputDate);
		      System.out.println(date);
		    } catch (ParseException e) {
		      //e.printStackTrace();
		      System.out.println("Date shuld be: MM/dd/yyyy");
   			  inputDate = sc.next();
   			}
	}
	
	void print(){
		System.out.println(obj.getName()); /// на name треба obj на dosvid ні ?
		
		for (int i = 0; i < knowledgeArray.length; i++) {
			if(knowledgeArray[i] != null){
				System.out.println(knowledgeArray[i]);
			}
		}
		System.out.println("Dosvid robotu " + getDosvid()); 
		System.out.println("Link to portfolio :" + getPortpholio());
		
		if(getPretenzia() != null){
			System.out.println("Pretenzia from manager " + getPretenzia());
		}
		System.out.println();
	}
	
	String portfolio(){
		System.out.println("Enter link for portfolio ");
		 setPortpholio(sc.next());
		 return getPortpholio();
	}
	
	void trySpecialist() {
		SpecialistDataBase obj = new SpecialistDataBase();
		obj.specialistKnowledge();
		obj.birthdayDate();
		obj.portfolio();
		obj.print();
	}

}
