package HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class DataBaseItemsRealiz implements DataBaseItems{
		
	 int total = 0;
	 int port = 6666;
	 String addres = "127.0.0.1";
	 ServerSocket serverSocket;
	 Socket socket;
	 InputStream sin;
	 OutputStream sout;
	 DataInputStream in;
	 DataOutputStream out;
	HashMap<String, Integer> clients = new HashMap<String, Integer>();

	private Scanner sc = new Scanner(System.in);
	ArrayList<String> titleSet = new ArrayList<String>();
	ArrayList<Double> priceSet = new ArrayList<Double>();
	
	
	@Override
	public void addItem() throws IOException  {
		// TODO Auto-generated method stub
		
		try(FileWriter writer = new FileWriter("Items.txt");) {
		
		
		System.out.println("Enter title of item");
		String title = sc.next();
		titleSet.add(title);
		
		System.out.println("Enter price of item");
		double price = sc.nextDouble();
		priceSet.add(price);
			   
	           // запис всєї стрічки
	    	
		for (int i = 0; i < titleSet.size(); i++) {
			writer.write("Items: " + titleSet.get(i) + " Price" + priceSet.get(i) + "\n");
		}
			
           
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
		}
	  

	}

	@Override
	public void print() throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("set size");
		out.writeInt(titleSet.size()); 
		
		  try(FileReader reader = new FileReader("Items.txt")) {
					 
		        for (int i = 0; i < titleSet.size(); i++) {
		        	 out.writeUTF((i+1) + ". " + titleSet.get(i) + " price " + priceSet.get(i));
		        	 out.flush();
				}
	          
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        }   
	}

	@Override
	public void sort() throws IOException {
		// TODO Auto-generated method stub
		
		double tempPrice;
		String tempItem;
		for (int i = 0; i < titleSet.size(); i++) {
			
			if(i < titleSet.size() - 1){
			
				while(priceSet.get(i) > priceSet.get(i + 1)){
					tempPrice = priceSet.get(i);
					tempItem = titleSet.get(i);
					
					priceSet.set(i, priceSet.get(i + 1));
					titleSet.set(i, titleSet.get(i + 1));
					
					priceSet.set(i + 1, tempPrice);
					titleSet.set(i + 1, tempItem);
					
					i =0;
				}
			}	
		}
	
		try (FileWriter writer = new FileWriter("ItemsSort.txt")){	
			
			for (int i = 0; i < titleSet.size(); i++) {
				writer.write("Item: " + titleSet.get(i) + " Price: " + priceSet.get(i) + "\n");
			}
		}	
	}
	
	@Override
	public void printSorted() throws IOException {
		// TODO Auto-generated method stub
				
		System.out.println("set size");
		out.writeInt(titleSet.size()); 
		
		  try(FileReader reader = new FileReader("ItemsSort.txt")) {
					 
		        for (int i = 0; i < titleSet.size(); i++) {
		        	 out.writeUTF((i+1) + ". " + titleSet.get(i) + " price " + priceSet.get(i));
		        	 out.flush();
				}
	          
	        }
	        catch(IOException ex){
	             
	            System.out.println(ex.getMessage());
	        }
	}
}
