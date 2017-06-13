package HomeWork;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public interface DataBaseClient {

	
	Scanner sc = new Scanner(System.in);
	HashMap<String, Double> basket = new HashMap<String, Double>();
	
	void registrationClient() throws IOException;
	void signInClient() throws IOException;
	void connection();
	void viewItemsInBasket() throws IOException;
	void addToBasket() throws IOException;
	void delFromBasket();
	void buy();
	void pay() throws IOException;
	
}
