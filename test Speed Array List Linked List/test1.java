package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class test1 {
	
	LinkedList<Integer> linkList = new LinkedList<Integer>();
	ArrayList arrList = new ArrayList();
	Random rand = new Random();
	
	void addNum(Collection col){
		
		for (int i = 0; i < 500; i++) {
			col.add(rand.nextInt(9));
		}
	}
	
	void remove(Collection col){
		
		for (int i = 0; i < col.size(); i+=2) {
			col.remove(i);
			i--;
		}
	}
	
	void sortNew(List<Integer> col){
				
		int temp;
		for (int i = 0; i < col.size() ; i++ ) {
								
			if(i < col.size() - 1){
		
				while ( ( col).get(i) 	>  col.get(i + 1) ){
											
					temp = (int) ((List) col).get(i);
					
					((List) col).set(i, ((List) col).get(i + 1));
					((List) col).set(i + 1, temp);
						
					i = 0;
				}
			}
		}
	}
		
	public static void main(String[] args) {
		
		
		test1 obj = new test1();
		long start = System.currentTimeMillis();
		obj.addNum(obj.arrList);
		long end =  System.currentTimeMillis();
		System.out.println("Colection Array list method add: " + (end - start)); 
			
		start = System.currentTimeMillis();
		obj.addNum(obj.linkList);
		end =  System.currentTimeMillis();
		System.out.println("Colection Link list method add: " + (end - start)); 
		
		start = System.currentTimeMillis();
		obj.sortNew(obj.arrList);
		end =  System.currentTimeMillis();
		System.out.println("Colection Array list method sort: " + (end - start)); 
		
		start = System.currentTimeMillis();
		obj.sortNew(obj.linkList);
		end =  System.currentTimeMillis();
		System.out.println("Colection Link list method sort: " + (end - start)); 
		
		start = System.currentTimeMillis();
		obj.remove(obj.arrList);	
		end =  System.currentTimeMillis();
		System.out.println("Array Remove: " + (end - start)); 
		
		start = System.currentTimeMillis();
		obj.remove(obj.linkList);	
		end =  System.currentTimeMillis();
		System.out.println("Link Remove: " + (end - start)); 
	}

}
