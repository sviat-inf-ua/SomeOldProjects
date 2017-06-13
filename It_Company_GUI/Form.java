package homeWork;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//import rewrite.persons;

public class Form {
	
	int count = 0;
//	Form obj_Form = new Form();
	ArrayList<Add_Specialist> we;
	ArrayList<Add_Specialist> arr_spec = new ArrayList<Add_Specialist>();
	Add_Specialist add_Spec_obj;
	Add_Specialist add_Spec_obj1;
	
	
	public Form() {
		// TODO Auto-generated constructor stub
				
		JFrame jfr = new JFrame ("IT Company");
		jfr.setLayout(new FlowLayout());
		
		jfr.setSize(380, 400);
		jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		jfr.setVisible(true);
		
		JLabel jl_text = new JLabel("                                                        "
				                  + "----------- Add Specialist -----------"	
				                  + "                                                        ");
		JLabel jl_add_specialist = new JLabel("Add name                                          ");
		JTextField jtf_add_scpecialist = new JTextField(10);
		
		JLabel jl_add_knowledge = new JLabel("Add knowledge                                ");
		JTextField jtf_add_knowledge = new JTextField(10);
		
		JLabel jl_add_experience = new JLabel("Enter experience in months         ");
		JTextField jtf_add_experience = new JTextField(10);
		
		JLabel jl_add_comment = new JLabel("Enter comment about this guy    ");
		JTextField jtf_add_comment = new JTextField(10);
		
		JLabel jl_result = new JLabel();
		
		JButton jb_add_specialist = new JButton("add");
				
		JLabel jl_one = new JLabel("");
		JLabel jl_one1 = new JLabel("");
						
		jfr.add(jl_text);
		jfr.add(jl_add_specialist);
		jfr.add(jtf_add_scpecialist);
		
		jfr.add(jl_add_knowledge);
		jfr.add(jtf_add_knowledge);
		
		jfr.add(jl_add_experience);
		jfr.add(jtf_add_experience);
		
		jfr.add(jl_add_comment);
		jfr.add(jtf_add_comment);
						
		jfr.add(jb_add_specialist);
		
		jb_add_specialist.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if(count == 0) {
										
					Add_Specialist add_Spec_obj = new Add_Specialist(jtf_add_scpecialist.getText(), jtf_add_knowledge.getText(), jtf_add_comment.getText(), Integer.parseInt(jtf_add_experience.getText()));
					arr_spec.add(add_Spec_obj);
									
				} if (count == 1){
				
					Add_Specialist add_Spec_obj1 = new Add_Specialist(jtf_add_scpecialist.getText(), jtf_add_knowledge.getText(), jtf_add_comment.getText(), Integer.parseInt(jtf_add_experience.getText()));
					arr_spec.add(add_Spec_obj1);
					
				}
						
				jfr.add(jl_result);	
				jtf_add_scpecialist.setText("");
				jtf_add_knowledge.setText("");
				jtf_add_experience.setText("");
				jtf_add_comment.setText("");
							
				if(count == 1){
					
					try {
					
						FileOutputStream fis = new FileOutputStream("test123.txt");
						ObjectOutputStream out = new ObjectOutputStream(fis);
						out.writeObject(arr_spec);
						out.close();
						fis.close();
						System.out.println("Write to file Ok");
										
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("Wrong write");
					}
					
					try {
					
						we = new ArrayList<Add_Specialist>();
						FileInputStream fis = new FileInputStream("test123.txt");
						
						ObjectInputStream in = new ObjectInputStream(fis);
						
						we = (ArrayList<Add_Specialist>) in.readObject();
						System.out.println(we.get(0).name);
						System.out.println(we.get(0).knowledge);
						System.out.println(we.get(0).experience);
						System.out.println(we.get(0).comment);
						System.out.println("other one " );
						
						System.out.println(we.get(1).name);
						System.out.println(we.get(1).knowledge);
						System.out.println(we.get(1).experience);
						System.out.println(we.get(1).comment);
												
						in.close();
						fis.close();
						
						JButton jb_update = new JButton("Update");
						JButton jb_update1 = new JButton("Update1");
						
						jb_add_specialist.setVisible(false);
						
						jfr.add(jb_update);
						jfr.add(jl_one);
						
						jfr.add(jb_update1);
						jfr.add(jl_one1);
												
						jl_one.setText("\n   " + we.get(0).name + " / " + we.get(0).knowledge + " / " + we.get(0).experience + " / " + we.get(0).comment + "                 ");
						
						jl_one1.setText(we.get(1).name + " / " + we.get(1).knowledge + " / " + we.get(1).experience + " / " + we.get(1).comment);
										
						jb_update.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								add_Spec_obj = new Add_Specialist(jtf_add_scpecialist.getText(), jtf_add_knowledge.getText(), jtf_add_comment.getText(), Integer.parseInt(jtf_add_experience.getText()));
								jl_one.setText(add_Spec_obj.name + " / " + add_Spec_obj.knowledge + " / " + add_Spec_obj.experience + " / " + add_Spec_obj.comment);
							
							}
						});
						
						jb_update1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								add_Spec_obj1 = new Add_Specialist(jtf_add_scpecialist.getText(), jtf_add_knowledge.getText(), jtf_add_comment.getText(), Integer.parseInt(jtf_add_experience.getText()));
								jl_one1.setText(add_Spec_obj1.name + " / " + add_Spec_obj1.knowledge + " / " + add_Spec_obj1.experience + " / " + add_Spec_obj1.comment);
								
							}
						});
												
						// create save and recet buttons 
						
						JButton jb_save = new JButton("Save");
						JButton jb_reset = new JButton("Recet from file");
						JLabel jl_lot_of_spaces = new JLabel("                                                                             ");
						JLabel jl_lot_of_spaces1 = new JLabel("                                                                             ");
						JButton jb_search = new JButton("Search");
						JLabel jl_search = new JLabel("Bla Bla");
																	
						jfr.add(jl_lot_of_spaces1);
						jfr.add(jb_save);
						jfr.add(jl_lot_of_spaces);
						jfr.add(jb_reset);
						
						jfr.add(jb_search);
						jfr.add(jl_search);
						//
						
						jb_save.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								arr_spec.clear();
								arr_spec.add(add_Spec_obj);
								arr_spec.add(add_Spec_obj1);
								
								FileOutputStream fis;
								try {
									fis = new FileOutputStream("test123.txt");
									ObjectOutputStream out = new ObjectOutputStream(fis);
									out.writeObject(arr_spec);
									out.close();
									fis.close();
									System.out.println("Write to file Ok");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
						jb_reset.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
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
																
								jl_one.setText("\n   " + we.get(0).name + " / " + we.get(0).knowledge + " / " + we.get(0).experience + " / " + we.get(0).comment + "                 ");
								
								jl_one1.setText(we.get(1).name + " / " + we.get(1).knowledge + " / " + we.get(1).experience + " / " + we.get(1).comment);
							}
						});
										
						jb_search.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
														
								Form_search obj = new Form_search();		
															
							}
						});
					
					} catch (Exception e2) {
						// TODO: handle exception
						System.out.println("wrong read");
					}
								
				}
				count++;
			}
					
		});
		
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Form f = new Form();
			}
		});
	}
}
