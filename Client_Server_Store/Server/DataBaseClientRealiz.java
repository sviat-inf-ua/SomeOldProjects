package HomeWork;

import java.awt.ItemSelectable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class DataBaseClientRealiz extends DataBaseItemsRealiz implements DataBaseClient{


	
	
	@Override
	public void connection() {
		// TODO Auto-generated method stub
		
		 try {
	    	   
	         serverSocket = new ServerSocket(port); 
	         System.out.println("Waiting for a client...");

	         socket = serverSocket.accept(); 
	         System.out.println("Client connected");
	         System.out.println();

	         sin = socket.getInputStream();
	         sout = socket.getOutputStream();

	         in = new DataInputStream(sin);
	         out = new DataOutputStream(sout);
	         
			for (;;) {
				 int temp = in.readInt();
			     
			     if(temp == 1){
			    	 registrationClient(); 
			     }else if(temp == 2){
			    	 signInClient();
			     }else if(temp == 3){
			    	 print();
			     } else if (temp == 4){
			    	 sort();
			    	 printSorted();
			     } else if (temp == 5){
			    	 addToBasket();
			     } else if (temp == 6){
			    	 viewItemsInBasket();
			     } else if (temp == 7){
			    	 buy(); 
			    	 pay();
			     }	  	  
			}
	     
	      } catch(Exception x) {
	    	  x.printStackTrace(); 
	      }
	}
		
	@Override
	public void registrationClient() throws IOException {
		// TODO Auto-generated method stub
		
		try {
			out.writeUTF("Enter your NAME");
			out.flush();
			
			String name = in.readUTF();
			
			out.writeUTF("Enter your PASSWORD");
	        out.flush();
			
			String password = in.readUTF();
					
			clients.put(name,new Integer(password.hashCode()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void signInClient() throws IOException {
		// TODO Auto-generated method stub
		
		String checkName = null ;
		String checkPass ;
		int checkHash = 0;
		
			out.writeUTF("enter your NAME dlya vhody");
			out.flush();
			
			checkName = in.readUTF();
			
			out.writeUTF("enter PASSWORD dlya vxody");
			out.flush();
					
			checkPass = in.readUTF();
					 
			checkHash = checkPass.hashCode();
			
				if(clients.containsKey(checkName) && clients.get(checkName)==checkHash){
					
						out.writeUTF("you enter like " + checkName + "\n");
						out.flush();
	
				} 
				else {
					out.writeUTF("incorect information");
					out.flush();
				}
	}
	
	
	@Override
	public void viewItemsInBasket() throws IOException {
		// TODO Auto-generated method stub
		
		out.writeUTF("Its items in your basket\n");
		out.writeInt(basket.size());
		
		for (String string : basket.keySet()) {
			out.writeUTF("items: " + string + " price: " + basket.get(string));
		}
		
	}

	@Override
	public void addToBasket() throws IOException {
		// TODO Auto-generated method stub
		
		for(;;){
			System.out.println();
			
			print();
			
			out.writeUTF("Enter # of item what u whant to buy or press 0 to Exit");
			
			int add = in.readInt();
			System.out.println("add = " + add);
			if(add == (0)){
				System.out.println("See you !!!");
				break;
				
			} else if(add > 0 && add <= titleSet.size()){
				basket.put(titleSet.get(add - 1), priceSet.get(add - 1));
				out.writeUTF("You want add to basket more Y/N");
				String more = in.readUTF();
				
				if(more.equals("Y") || more.equals("y")){
					System.out.println("back to addBasked");
					System.out.println("enter to Y / y");
					addToBasket();
				}else if (more.equals("N") || more.equals("n"))  {
					out.writeUTF("Perexid na kypivly");
					break;
				}
			} 
				out.writeUTF("Exit from basked");
				addToBasket();
		}
	}

	@Override
	public void delFromBasket() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter title of item you want delete");
		String delItem = sc.next();
		
		if(basket.containsKey(delItem)){
			basket.remove(delItem);
			buy();
		} else {
			System.out.println("Incorect item");
			delFromBasket();
		}
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		
		 total = 0;
		
		for (String string : basket.keySet()) {
			System.out.println("items: " + string + " price: " + basket.get(string));
			total += basket.get(string);
		} 
	}

	@Override
	public void pay() throws IOException {
		// TODO Auto-generated method stub
		
		out.writeUTF("You have to pay " + total);
		out.flush();
		double 	pay = in.readDouble();
		
		if(pay == total){
			out.writeUTF("Thank You for buying in our store \nHave a good day");
			out.flush();
		}else {
			out.writeUTF("paying not compeated");
			out.flush();
		}
		
	}
}
