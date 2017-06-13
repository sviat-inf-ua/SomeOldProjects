package homeWork;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Form_search{
	

	public Form_search() {
		// TODO Auto-generated constructor stub
		
		JFrame jfr = new JFrame("Search menu");
		jfr.setLayout(new FlowLayout());
		
		jfr.setSize(600, 400);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jfr.setVisible(true);
				
		JLabel jl_text = new JLabel("                                                        "
                + "----------- Search Specialist -----------"	
                + "                                                        ");
		JLabel jl_add_specialist = new JLabel("Enter name                                          ");
		JTextField jtf_add_scpecialist = new JTextField(10);
		
		JLabel jl_add_knowledge = new JLabel("Enter knowledge                                ");
		JTextField jtf_add_knowledge = new JTextField(10);
		
		JLabel jl_add_experience = new JLabel("Enter experience in months         ");
		JTextField jtf_add_experience = new JTextField(10);
		JLabel jl_search = new JLabel();
		JButton jb_search = new JButton("Try");
					
		jfr.add(jl_text);
		jfr.add(jl_add_specialist);
		jfr.add(jtf_add_scpecialist);
		
		jfr.add(jl_add_knowledge);
		jfr.add(jtf_add_knowledge);
		
		jfr.add(jl_add_experience);
		jfr.add(jtf_add_experience);
		jfr.add(jb_search);
		jfr.add(jl_search);
		
		jb_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Add_Specialist> we;
				
				we = new ArrayList<Add_Specialist>();
				FileInputStream fis;
				
				try {
					fis = new FileInputStream("test123.txt");
					ObjectInputStream in = new ObjectInputStream(fis);
					
					we = (ArrayList<Add_Specialist>) in.readObject();
					in.close();
					fis.close();
				} catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for (int i = 0; i < we.size(); i++) {
					
					int years = (int) we.get(i).experience;
					int tempEpx = 0;
										
					if((jtf_add_experience.getText()).equals("")){
						
						 tempEpx = 0;
						
					}
					
					// only name true 
				    if (we.get(i).name.equals(jtf_add_scpecialist.getText()) && jtf_add_knowledge.getText().equals("") && jtf_add_experience.getText().equals("")){
						 years = (int) (we.get(i).experience/12);
						jl_search.setText("You need " + we.get(i).name + " he know " + we.get(i).knowledge + " his expiriance " + years/12 + "years and " + years%12 + " months and he is " + we.get(i).comment + " guy");
						
					}
					//only knowledge true 
				    else if (jtf_add_scpecialist.getText().equals("") && we.get(i).knowledge.equals(jtf_add_knowledge.getText()) && jtf_add_experience.getText().equals("")){
						 years = (int) (we.get(i).experience/12);
						jl_search.setText("You need " + we.get(i).name + " he know " + we.get(i).knowledge + " his expiriance " + years/12 + "years and " + years%12 + " months and he is " + we.get(i).comment + " guy");
						
					}
				    // name and knowledge
				    
				    else if(we.get(i).name.equals(jtf_add_scpecialist.getText()) && we.get(i).knowledge.equals(jtf_add_knowledge.getText()) ){
				    	
						jl_search.setText("You need " + we.get(i).name + " he know " + we.get(i).knowledge + " his expiriance " + years/12 + "years and " + years%12 + " months and he is " + we.get(i).comment + " guy");
						
				    }
				  
				    // Experience and knowledge
				    else if(years >= tempEpx && we.get(i).knowledge.equals(jtf_add_knowledge.getText()) && jtf_add_scpecialist.getText().equals("")){
				    	 
				    	jl_search.setText("You need " + we.get(i).name + " he know " + we.get(i).knowledge + " his experience " + years/12 + "years and " + years%12 + " months and he is " + we.get(i).comment + " guy");
				    }	
				}
			}
		});
		
	}
	
}
