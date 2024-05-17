package chatme;

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainFormView implements ActionListener{
	private JFrame crframe;
	private JButton[] buttons;
	private JButton[] addBtn;
	private JButton[] decline;
	private JButton[] approve;
	private JPanel panel2;
	private String mobile,fromname,toname,searchname,name2,buttonText1;
	public JButton button,button2,b1 ,b2,b3;
	private JLabel[] addfreindlabel ;
	private JLabel[] addfreindlabel2;
	private Timer timer;
	private int idfordelete ;
	
	public MainFormView(String mobile) {	
		this.mobile=mobile;
		
		crframe = new JFrame();
		crframe.setTitle("ChatMe");
		crframe .setSize(808, 498);
		//crframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		crframe.getContentPane().setBackground(Colorclass.lightgreen);
		crframe.setLocationRelativeTo(null);
		crframe.setResizable(false);
		//crframe.setUndecorated(true);
		
		JPanel panel = new JPanel();
        panel.setBounds(0, 0, 794, 76);
        panel.setBackground(Colorclass.lightgreen);

        panel2 = new JPanel();
        panel2.setBackground(Colorclass.lightgreen);

        b1 = new JButton("Chat Friend");
        b1.setPreferredSize(new Dimension(650, 50));
        b1.setBackground(new Color(7,94,84));
        
        b2 = new JButton("Add Friend");
        b2.setPreferredSize(new Dimension(650, 50));
        b2.setBackground(Colorclass.lightgreen);
        b3 = new JButton("Friend Request");
        b3.setPreferredSize(new Dimension(650, 50));
        b3.setBackground(Colorclass.lightgreen);
        
        b1.setForeground(Color.white);
        b1.setFocusPainted(false); 
		b1.setOpaque(true);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
        b2.setForeground(Color.white);
        b2.setFocusPainted(false); 
		b2.setOpaque(true);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
        b3.setForeground(Color.white);
        b3.setFocusPainted(false); 
		b3.setOpaque(true);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
        panel.setLayout(new GridLayout(1, 2));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        
        JPanel paneicon = new JPanel();
        paneicon.setBackground(Colorclass.lightgreen);
        
        ImageIcon icon2 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/settingsmale.png"); 
        JLabel imageLabe2 = new JLabel(icon2);
        imageLabe2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
        imageLabe2.setBounds(427, 125, 100, 33); 
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        paneicon.add(imageLabe2);
        
        JLabel test = new JLabel();
        paneicon.add(test);
        
        ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logout.png"); 
        JLabel imageLabe3 = new JLabel(icon3);
        imageLabe3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe3.setBounds(427, 125, 100, 33);
        imageLabe3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        paneicon.add(imageLabe3);
        panel.add(paneicon);
        
        imageLabe3.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
                ImageIcon logoutyello = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logoutyellow.png");
                imageLabe3.setIcon(logoutyello);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	imageLabe3.setIcon(icon3);
                
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            	Model.setonlineoffline("offline", mobile);
            	LoginView l3 = new LoginView();
            	LoginController l4 = new LoginController(l3);
            	crframe.dispose();
            	l3.setVisible(true);
            }
        });
        
        imageLabe2.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
                ImageIcon hoverIcon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/settingsmaleyello1.png");
                imageLabe2.setIcon(hoverIcon);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	imageLabe2.setIcon(icon2);
                
            }
            public void mouseClicked(MouseEvent e) {
            	if (timer != null) {
                    timer.stop();
                }
            	ProfileView f1 = new ProfileView(mobile,name2);
            	ProfileController pf1 = new ProfileController(f1);
            	crframe.dispose();
            	f1.setVisible(true);
            }
        });

        
        
        
        name2=findname(mobile);
        chat(panel2,name2);        
		
        b1.addMouseListener(new MouseAdapter() {
            @Override
            
            public void mouseEntered(MouseEvent e) {
            	b1.setForeground(Color.YELLOW);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	b1.setForeground(Color.WHITE);
                
            }
        });
        b2.addMouseListener(new MouseAdapter() {
            @Override
            
            public void mouseEntered(MouseEvent e) {
        		b2.setForeground(Color.YELLOW);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	b2.setForeground(Color.WHITE);
                
            }
        });
        b3.addMouseListener(new MouseAdapter() {
            @Override
            
            public void mouseEntered(MouseEvent e) {
            	b3.setForeground(Color.YELLOW);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	b3.setForeground(Color.WHITE);
                
            }
        });
        
		JScrollPane scrollPane = new JScrollPane(panel2);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        crframe.getContentPane().setLayout(new BorderLayout());
        crframe.getContentPane().add(panel, BorderLayout.NORTH);
        crframe.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        
		crframe.setVisible(true);
	}
	
	public void chatbuttonlistner(ActionListener listner) {
		b1.addActionListener(listner);
		
	}
	public void addfrbuttonlistner(ActionListener listner) {
		b2.addActionListener(listner);
		
	}
	public void reqButtonlistner(ActionListener listner) {
		b3.addActionListener(listner);
		
	}

	public JButton chatButton() {
		return b1;
	}
	public JButton addfrButton() {
		return b2;
	}
	public JButton reqButton() {
		return b3;
	}
	
	public void b1chatframe() {
		panel2.removeAll();
    	if (timer != null) {
            timer.stop();
        }
    	if(b1.getText().equals("Chat Friend")) {
    		b1.setBackground(new Color(7,94,84));
			b2.setBackground(Colorclass.lightgreen);
			b3.setBackground(Colorclass.lightgreen);
			chat(panel2,name2);
			
			timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	panel2.removeAll();
	                
	            	chat(panel2,name2);
	            }
	        });
			timer.start();
			
		} 
	}
	
	public void b2addfreind() {
		panel2.removeAll();
    	if (timer != null) {
            timer.stop();
        }
    	
    	if(b2.getText().equals("Add Friend")) {
			b2.setBackground(new Color(7,94,84));
			b1.setBackground(Colorclass.lightgreen);
			b3.setBackground(Colorclass.lightgreen);
			addfriend(panel2,name2);
			
			 timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	panel2.removeAll();
	                
	            	addfriend(panel2,name2);
	            }
	        });
			timer.start();
			
		} 
	}
	
	public void b3freindrequest() {
		panel2.removeAll();
    	if (timer != null) {
            timer.stop();
        }
    	if(b3.getText().equals("Friend Request")) {
			b3.setBackground(new Color(7,94,84));
			b1.setBackground(Colorclass.lightgreen);
			b2.setBackground(Colorclass.lightgreen);
			Request(panel2,name2);
			
			timer = new Timer(2000, new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	panel2.removeAll();
	                
	            	Request(panel2,name2);
	            }
	        });
			timer.start();
		} 
	}
	
	
	int i;
	public void chat(JPanel panel2,String name2) {
		try {
			panel2.setLayout(new GridLayout(0, 1));
			
			buttons= new JButton[100];
			  
			ResultSet chatresultSet2 = Model.chatdata(name2);
            i=0;
            while (chatresultSet2.next()) {
                String name = chatresultSet2.getString("freind");
                if(name.equals(name2)) {
                	name = chatresultSet2.getString("user");
                }
                buttons[i] = new JButton(name);
                buttons[i].addActionListener(this);
                buttons[i].setPreferredSize(new Dimension(765, 40));
                buttons[i].setMargin(new Insets(5, 10, 5, 10));
                buttons[i].setBackground(Colorclass.buttoncolor);
                buttons[i].setForeground(Color.white);
                buttons[i].setFocusPainted(false); 
                buttons[i].setOpaque(true);
                buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR));

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                buttonPanel.add(buttons[i]);
                buttonPanel.setBackground(Colorclass.lightgreen);
                panel2.add(buttonPanel);
                i++;
            }
            
            
            crframe.revalidate(); 
             
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
	}
	
	public void addfriend(JPanel panel2,String name2) {
		try {
			panel2.setLayout(new GridLayout(0, 1));
			
			addBtn= new JButton[100];
			addfreindlabel = new JLabel[100];
			
			ResultSet addfriendresultSet =Model.addfrienddata(name2);
			
            i=0;
            while (addfriendresultSet.next()) {
            	 final int currentIndex = i; 
                 String name = addfriendresultSet.getString("name");
                 addfreindlabel[i] = new JLabel(name);               
                 addfreindlabel[i].setForeground(Color.white);
                 addBtn[i] = new JButton("Add Friend");
                 addBtn[i].setPreferredSize(new Dimension(110, 40));
                 addBtn[i].setMargin(new Insets(5, 10, 5, 10));
                 addBtn[i].setBackground(Colorclass.buttngreen);
                 addBtn[i].setForeground(Color.white);
                 addBtn[i].setFocusPainted(false); 
                 addBtn[i].setOpaque(true);
                 addBtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                JPanel labelsh = new JPanel();
                labelsh.setLayout(new FlowLayout(FlowLayout.LEFT));
                labelsh.setPreferredSize(new Dimension(650, 40));
                labelsh.setBackground(Colorclass.buttoncolor);
                labelsh.add(addfreindlabel[i]);

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                buttonPanel.add(labelsh);
                buttonPanel.add(addBtn[i]);
                buttonPanel.setBackground(Colorclass.lightgreen);

                panel2.add(buttonPanel);
                
                addBtn[currentIndex].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String buttonText = addfreindlabel[currentIndex].getText();
                        clickaddbutton(buttonText,name2);
                    }
                });
                
                i++;
            }
            
            crframe.revalidate(); 
             
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

	}
	
	public void Request(JPanel panel2,String name2) {
		try {
			panel2.setLayout(new GridLayout(0, 1));
			
			addfreindlabel2 = new JLabel[100];
			approve= new JButton[100];
			decline= new JButton[100];
			
			ResultSet requestresultSet=Model.requestdata(name2);
            
            i=0;
            while (requestresultSet.next()) {
            	final int currentIndex2 = i; 
                String name = requestresultSet.getString("user");
                addfreindlabel2[i] = new JLabel(name);
                addfreindlabel2[i].setForeground(Color.white);
                JPanel labelsh = new JPanel();
                labelsh.setLayout(new FlowLayout(FlowLayout.LEFT));
                labelsh.setPreferredSize(new Dimension(476, 40));
                labelsh.setBackground(Colorclass.buttoncolor);
                labelsh.add(addfreindlabel2[i]);

                approve[i] = new JButton("Approve");
                approve[i].setPreferredSize(new Dimension(140, 40));
                approve[i].setMargin(new Insets(5, 10, 5, 10));
                
                decline[i] = new JButton("Decline");
                decline[i].setPreferredSize(new Dimension(140, 40));
                decline[i].setMargin(new Insets(5, 10, 5, 10));
                
                approve[i].setBackground(Colorclass.buttngreen);
                approve[i].setForeground(Color.white);
                approve[i].setFocusPainted(false); 
                approve[i].setOpaque(true);
                approve[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                decline[i].setBackground(Color.red);
                decline[i].setForeground(Color.white);
                decline[i].setFocusPainted(false); 
                decline[i].setOpaque(true);
                decline[i].setCursor(new Cursor(Cursor.HAND_CURSOR));

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                buttonPanel.add(labelsh);
                buttonPanel.add(approve[i]);
                buttonPanel.add(decline[i]);
                buttonPanel.setBackground(Colorclass.lightgreen);

                panel2.add(buttonPanel);
                
                approve[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	 buttonText1 = addfreindlabel2[currentIndex2].getText();
                    	approvefreind(buttonText1,name2);
                    }
                });

                
                decline[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	 buttonText1 = addfreindlabel2[currentIndex2].getText();
                    	diclinefreind(buttonText1,name2);
                    }
                });
                i++;
            }
            
            crframe.revalidate(); 
             
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
	}
	
	public void approvefreind(String buttonText1,String name2) {
		try {
			Model.approvefreinddata(name2,buttonText1);

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	public void diclinefreind(String buttonText1,String name2) {
		try {
			Model.diclinefreinddata(name2,buttonText1);
	        
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	public String findname(String mobile) {//userprofiledata
		try {
			ResultSet findnameresultSet=Model.findnamedata(mobile);
            while (findnameresultSet.next()) {
                searchname = findnameresultSet.getString("name");
            }
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
		return searchname;
	}
	
	public void actionPerformed(ActionEvent e) {		
		try {
			  toname = e.getActionCommand();
			  ResultSet selectreciverresultSet=Model.selectreciver(mobile);
			        while (selectreciverresultSet.next()) {
			            fromname = selectreciverresultSet.getString("name");
			            
			        }
                	idfordelete=findconid(name2,toname);
			        ChatframeView chf1 = new ChatframeView(fromname,toname,mobile,idfordelete);
			        ChatframeController ah = new ChatframeController(chf1);
			        crframe.dispose();
			        chf1.setVisible(true);
			        
			  }catch(SQLException ex1) {
				  JOptionPane.showMessageDialog(null, "Error: " + ex1.getMessage());
			  }
		
	}
	
	public int findconid(String name,String frind) {
		int id=0;
		Model.userprofiledata(name,frind);
		try {
			ResultSet findnameresultSet=Model.userprofiledata(name,frind);;
            while (findnameresultSet.next()) {
            	id = findnameresultSet.getInt("id");
            }
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
		return id;
	}
	
	public void clickaddbutton(String buttonText,String name2) {
		try {
			Model.toapprovedata(buttonText,name2);
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	public void setVisible(boolean b) {
		
	}
}
