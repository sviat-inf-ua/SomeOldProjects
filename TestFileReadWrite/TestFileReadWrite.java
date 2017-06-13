
import java.io.*;
import java.util.Random;

public class TestFileReadWrite {
	
	Random rand = new Random();
	char[] table;

	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long end =  System.currentTimeMillis();
		
		TestFileReadWrite obj = new TestFileReadWrite();
				
		obj.createTable();
		
		//time catch for FileInputStream and OutputStream
			start = System.currentTimeMillis();
			obj.first();
			end =  System.currentTimeMillis();
			System.out.println("FileInputStream and OutputStream:    " + (end - start)); 
			System.out.println();
		
				
		//time catch for DataOutputStream і DataInputStream
			start = System.currentTimeMillis();
			obj.Second();
			end =  System.currentTimeMillis();
			System.out.println("DataOutputStream і DataInputStream:  " + (end - start)); 
			System.out.println();
		
		
		//time catch for FileReader і FileWriter
			start = System.currentTimeMillis();
			obj.third();
			end =  System.currentTimeMillis();
			System.out.println("FileReader і FileWriter:             " + (end - start)); 
			System.out.println();
		
		
		//time catch for BufferedReader i BufferedWriter
			start = System.currentTimeMillis();
			obj.fourth();
			end =  System.currentTimeMillis();
			System.out.println("BufferedReader i BufferedWriter:     " + (end - start)); 
			System.out.println();
						
	}
	
	
	void createTable(){
	int milion = 1000000;	
	table = new char[milion];
	
	for (int i = 0; i < table.length; i++) {
		table[i] = (char) (rand.nextInt(10)+48);
	}
	
//	for (int i = 0; i < table.length; i++) {
//		System.out.print(table[i]);
//	}
	}
	
	void first(){
		
		//FileInputStream and OutputStream
		
		
	File file = new File("file1.txt");
				
		FileInputStream fis;
		OutputStream f;
		try {	
			
			fis = new FileInputStream(file);
			f = new FileOutputStream("file1.txt"); 
			
			for (int i = 0; i < table.length; i++) {
				f.write(table[i]);
			}// f.close();
					
			
			System.out.println("Total file size to read (inbytes) : "+ fis.available());
			System.out.println();
			
			int content;
			while ((content = fis.read()) != -1) {
				// converttocharanddisplayit
				//System.out.print((char)content);
				String a = "";
				a = a + " " +  content;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	void Second(){
		
		//Класи DataOutputStream і DataInputStream
		
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("file2.txt"));
			
			//Запис у file2 
			for (int i = 0; i < table.length; i++) {
				dos.write(table[i]);
			}
		
			
			
			DataInputStream dis = new DataInputStream(new FileInputStream("file2.txt"));
			
		//	System.out.println("Total file size to read (inbytes) : "+ dis.available());
			//Читання з нього
			
			int content;
			while ((content = dis.read()) != -1) {
				// converttocharanddisplayit
				//System.out.print((char) content);
				String a = "";
				a = a + " " +  content;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void third(){
		
		// запис текстових файлів. FileReader і FileWriter
		
		try (FileWriter writer = new FileWriter("file3.txt")){
			
			for (int i = 0; i < table.length; i++) {
				writer.write(table[i]);
				}
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Читання з нього
		
		try(FileReader reader = new FileReader("file3.txt"))
        {
			
			// читаємопосимвольно
			int c;
			while((c = reader.read())!=-1){
			
				//System.out.print((char)c);
				String a = "";
				a = a + " " +  c;
			} 
		}
		catch(IOException ex){
			
			System.out.println(ex.getMessage());
	    }   
	
	}
	
	void fourth(){
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("file4.txt"))){
			
			for (int i = 0; i < table.length; i++) {
				bw.write(table[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("file4.txt"))){
			
			// читаємопосимвольно
						int c;
						while((c = br.read())!=-1){
						
							//System.out.print((char)c);
							String a = "";
							a = a + " " +  c;
							
						} 
				} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}


