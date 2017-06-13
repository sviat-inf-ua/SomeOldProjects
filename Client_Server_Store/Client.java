import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
    public static void main(String[] ar) {
    	Scanner sc = new Scanner(System.in);
        int serverPort = 6666; 
        String address = "127.0.0.1"; 
        Client obj = new Client();
        Scanner sc1 = new Scanner(System.in);

        try {
            InetAddress ipAddress = InetAddress.getByName(address); 
           // System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            Socket socket = new Socket(ipAddress, serverPort); 
            System.out.println("Connected.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null,pass = null;
            
//            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
//            System.out.println();
            int menu =0;
            while (true) {
            	
            	System.out.println("1 - for regestration");
            	System.out.println("2 - for enter your acount");
            	System.out.println("3 - for print items on sale");
            	System.out.println("4 - for sort items");
            	System.out.println("5 - for add items to basked press");
            	System.out.println("6 - for view items in basked");
            	System.out.println("7 - for buy items");
            	menu = sc.nextInt();
            	
            	//registration connect
            	if(menu == 1){
            		out.writeInt(1);
            		out.flush();
            		System.out.println(in.readUTF());
            		//System.out.println("Enter your NAME");
            		line = keyboard.readLine();
            		out.writeUTF(line);
            		out.flush();
            		
            		System.out.println(in.readUTF());
            		//System.out.println("Enter your PASSWORD");
            		line = keyboard.readLine();
            		out.writeUTF(line);
            	        menu =0;    		
            	}
            	//signIn connection
            	else if (menu == 2){
            		out.writeInt(2);
            		out.flush();
            		
            		System.out.println(in.readUTF());
            		
            		line = keyboard.readLine();
            		out.writeUTF(line);
            		out.flush();
            		
            		System.out.println(in.readUTF());
            		line = keyboard.readLine();
            		out.writeUTF(line);
            		out.flush();
            	            		
            			System.out.println(in.readUTF());
           		} else if (menu == 3){
           			out.writeInt(3);
            		out.flush();
           			//reading size of array
           			int size = in.readInt();
           			
           			System.out.println("--------------------");
           			for (int i = 0; i < size; i++) {
						System.out.println(in.readUTF());
						
					} System.out.println("--------------------");
					System.out.println();
           		} else if(menu == 4){
           			out.writeInt(4);
            		out.flush();
            		
            		//reading size of array
           			int size = in.readInt();
           			System.out.println("--------------------");           			
           			for (int i = 0; i < size; i++) {
						System.out.println(in.readUTF());
						
					} System.out.println("--------------------");
           			System.out.println();
           		} else if(menu == 5){
           			out.writeInt(5);
            		out.flush();
            		
            		for (int i = 0; i < 1; i++) {
            		//inform from print
            		int size = in.readInt();
	           			
           			for (int i1 = 0; i1 < size; i1++) {
						System.out.println(in.readUTF());
						
					} System.out.println();
															
	            		System.out.println(in.readUTF());
	            		int lineInt = sc1.nextInt();
	            		
	            		out.writeInt(lineInt);
	            		out.flush();
	            		
	            		if (lineInt == 0){
	            			System.out.println(in.readUTF());
	            		}           		
	            		else if(lineInt > 0 ){
	            			System.out.println(in.readUTF());
	            			line = keyboard.readLine();
	                		out.writeUTF(line);
	                		out.flush();
	                		
	            			
	                			if(line.equals("Y") || line.equals("y")) {
	                				i--;
	                				System.out.println("enter to Y / y");
	                			}
	                			else if(line.equals("N") || line.equals("n")){
	                			//	System.out.println("enter to N / n");
	                				System.out.println(in.readUTF()); 
	                			               				
	                			}
	                			
	            		} else System.out.println("something rong");
            		}
            		
            		
           		} else if(menu == 6){
           			out.writeInt(6);
            		out.flush();

            		System.out.println(in.readUTF());
            		int size = in.readInt();
	           			
           			for (int i = 0; i < size; i++) {
						System.out.println(in.readUTF());
						
					} System.out.println();
            		
            		} if(menu == 7){
                		out.writeInt(7);
                		out.flush();
                		
                		System.out.println(in.readUTF());
                		System.out.println("please enter money");
                		double pay = sc.nextDouble();
                		out.writeDouble(pay);
                		out.flush();
                		
                		System.out.println(in.readUTF());
            		}
            }
 
        } catch (Exception x) {
            x.printStackTrace();
        }

    }

}







