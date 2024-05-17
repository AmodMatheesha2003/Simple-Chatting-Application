package chatme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;


public class LoginView  {
	public JButton b1;
	private JTextField t1;
	private JFrame frame;
	private JPasswordField t2;
	private JLabel error,clearl;
	
		public LoginView() {
			frame = new JFrame();
			frame.setTitle("ChatMe Login");
			frame .setSize(523, 551);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setUndecorated(true);
			frame.getContentPane().setBackground(Colorclass.lightgreen);
			
			JLabel l1 = new JLabel("Mobile Number:");
			l1.setBounds(60,240,123,26);
			l1.setForeground(Colorclass.white);
			l1.setFont(new Font("Arial", Font.BOLD, 16));
			frame.getContentPane().add(l1);
			
			JLabel l2 = new JLabel("Password:");
			l2.setBounds(60,292,123,27);
			l2.setForeground(Colorclass.white);
			l2.setFont(new Font("Arial", Font.BOLD, 16));
			frame.getContentPane().add(l2);
			
			t1 = new JTextField ();
			t1.setBounds(193,241,232,26);
			t1.setFont(new Font("Arial", Font.PLAIN, 16));
			frame.getContentPane().add(t1);
			
			t2 = new JPasswordField();
			t2.setBounds(193,293,232,26);
			t2.setFont(new Font("Arial", Font.PLAIN, 16));
			frame.getContentPane().add(t2);
			
			b1 = new JButton("Login");
			b1.setBounds(242,387,214,37);
			b1.setFont(new Font("Arial", Font.PLAIN, 16));
			b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b1.setBackground(Colorclass.buttoncolor);
			b1.setForeground(Colorclass.white);
			b1.setFocusPainted(false); 
			b1.setOpaque(true); 
			b1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        b1.setBackground(Colorclass.buttoncolormouse); 
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			        b1.setBackground(Colorclass.buttoncolor);
			    }
			});
			frame.getContentPane().add(b1);
			
			ImageIcon clear = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/clear.png"); 
	        JLabel imageclear = new JLabel(clear);
	        imageclear.setPreferredSize(new Dimension(clear.getIconWidth(), clear.getIconHeight()));
	        imageclear.setBounds(79, 387, 75, 37); 
	        frame.getContentPane().add(imageclear);
	        imageclear.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        imageclear.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	t1.setText("");
					 t2.setText("");
					 error.setText("");
	            }
	            @Override
			    public void mouseEntered(MouseEvent e) {
	            	ImageIcon hoverclear = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/yelocle.png");
	            	imageclear.setIcon(hoverclear);
	            	clearl.setForeground(Color.yellow);
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			    	imageclear.setIcon(clear);
			    	clearl.setForeground(Colorclass.white);
			    }
	        });
			
			JLabel l4 = new JLabel("Don't have an account?");
			l4.setBounds(105,465,196,26);
			l4.setForeground(Colorclass.white);
			l4.setFont(new Font("Arial", Font.BOLD, 16));
			frame.getContentPane().add(l4);
			
			error = new JLabel();
			error.setBounds(193,320,232,26);
			error.setForeground(Color.red);
			error.setFont(new Font("Arial", Font.ITALIC, 12));
			frame.getContentPane().add(error);
			
			JLabel see = new JLabel("Show");
	        see.setBounds(442, 320, 59, 49);
	        see.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
	        see.setForeground(Colorclass.white);
	        frame.getContentPane().add(see);
	        
	        clearl = new JLabel("Clear");
	        clearl.setBounds(105, 419, 59, 26);
	        clearl.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
	        clearl.setForeground(Colorclass.white);
	        frame.getContentPane().add(clearl);
			
			JLabel l5 = new JLabel("Forgot Password ?");
			l5.setBounds(294,349,147,26);
			l5.setForeground(Colorclass.buttoncreate);
			l5.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			    	l5.setForeground(Colorclass.cr); 
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			    	l5.setForeground(Colorclass.buttoncreate);
			    }
			});
			l5.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	ForgotpasswordView crframe = new ForgotpasswordView();
	            	ForgotpasswordController f1 = new ForgotpasswordController(crframe);
		            frame.dispose();
		            crframe.setVisible(true);
	            }
	        });
			l5.setCursor(new Cursor(Cursor.HAND_CURSOR));
			l5.setFont(new Font("Arial", Font.ITALIC |Font.BOLD, 14));
			frame.getContentPane().add(l5);
			
			JLabel createAccountLabe = new JLabel("Create an account");
	        createAccountLabe.setForeground(Colorclass.buttoncreate);
	        createAccountLabe.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        createAccountLabe.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			    	createAccountLabe.setForeground(Colorclass.cr); 
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			    	createAccountLabe.setForeground(Colorclass.buttoncreate);
			    }
			});
	        createAccountLabe.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	CreateAccountView crframe = new CreateAccountView();
	            	CreateAccountController l2 = new CreateAccountController(crframe);
		            frame.dispose();
		            crframe.setVisible(true);
	            }
	        });
	        createAccountLabe.setBounds(300,460,141,37);
	        createAccountLabe.setFont(new Font("Arial", Font.ITALIC |Font.BOLD, 16));
	        frame.getContentPane().add(createAccountLabe);
	        
	        ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeynotsee.png"); 
	        JLabel imageLabel = new JLabel(icon);
	        imageLabel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
	        imageLabel.setBounds(421, 276, 66, 63); 
	        frame.getContentPane().add(imageLabel);
	        imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        imageLabel.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (t2.getEchoChar() == 0) {
	                	t2.setEchoChar('*');
	                	imageLabel.setIcon(icon);
	                	see.setForeground(Color.WHITE);
	                } else {
	                	t2.setEchoChar((char) 0);
	                	ImageIcon hoverIcon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeysee .png");
		                imageLabel.setIcon(hoverIcon);
		                see.setForeground(Color.yellow);
	                }
	            }
	        });
	        
	        ImageIcon icon4 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Cancel_30px_3.png"); 
	        JLabel imageLabelclose = new JLabel(icon4);
	        imageLabelclose.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
	        imageLabelclose.setBounds(473, 0, 50, 33); 
	        frame.getContentPane().add(imageLabelclose);
	        imageLabelclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        imageLabelclose.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	frame.dispose();
	            	System.exit(0);
	            }
	        });
	        
	        ImageIcon icon5 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Minus_30px_3.png"); 
	        JLabel imageLabelminimize = new JLabel(icon5);
	        imageLabelminimize.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
	        imageLabelminimize.setBounds(437, 0, 50, 33); 
	        frame.getContentPane().add(imageLabelminimize);
	        imageLabelminimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        imageLabelminimize.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	frame.setExtendedState(JFrame.ICONIFIED);
	            }
	        });
	        
	        ImageIcon prf = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-glyph-96.png"); 
	        JLabel imageLabelprf = new JLabel(prf);
	        imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
	        imageLabelprf.setBounds(215, 111, 100, 100); 
	        frame.getContentPane().add(imageLabelprf);
	        
	        ImageIcon icon2 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/phone.png"); 
	        JLabel imageLabe2 = new JLabel(icon2);
	        imageLabe2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
	        imageLabe2.setBounds(428, 233, 50, 33); 
	        frame.getContentPane().add(imageLabe2);
	        
	        JLabel label = new JLabel();
	        label.setBounds(95, 63, 316, 38);
	        label.setFont(new Font("Arial", Font.BOLD, 30));
	        label.setForeground(Colorclass.white);
	        frame.getContentPane().add(label);        
	        animateTyping(label, "ChatMe LOGIN FORM");
	        
	        KeyAdapter enterKeyListener = new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    b1.doClick();
	                }
	            }
	        };
	        t1.addKeyListener(enterKeyListener);
	        t2.addKeyListener(enterKeyListener);
	        
			frame.setVisible(true);
		}
		public void loginuttonlistner(ActionListener listner) {
			b1.addActionListener(listner);
			
		}

		public JButton LoginButton() {
			return b1;
		}
		
		public void animateTyping(JLabel label, String textToType) {
	        Timer timer = new Timer();
	        int[] index = {0};
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	@Override
	            public void run() {
	                try {
	                    if (index[0] < textToType.length()) {
	                        label.setText(textToType.substring(0, index[0] + 1));
	                        index[0]++;
	                    } else {
	                        timer.cancel();
	                    }
	                } catch (Exception e) {
	                	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	                    timer.cancel();
	                }
	            }
	        }, 0, 100);
	    }
		
		 public void loginvalidate()
		 {	
			 try {
				 String mobile = t1.getText();
				 char[] passwordChars = t2.getPassword();
				 String password = new String(passwordChars);
				 ResultSet resultSet2 = Model.Logindata(mobile,password);
				 if (resultSet2.next()) {				 				 	  				 	  
				 	 CustomDialog dialog = new CustomDialog(frame, "Login successful", "Login Success");
		             dialog.setVisible(true);
		             String isadmin = resultSet2.getString("mobile");
		             String setname = resultSet2.getString("name");
		             byte[] displayimage = resultSet2.getBytes("image");
		             if(isadmin.equals("admin")) {
		            	    AdminFrameView admin = new AdminFrameView(setname,displayimage);
		            	    AdminFrameController af = new AdminFrameController(admin);
						 	frame.dispose();
						 	admin.setVisible(true);
		             }else {
		            	 	Model.setonlineoffline("online", mobile);
		            	    MainFormView mframe = new MainFormView(mobile);
		            	    MainFormContoller m1 = new MainFormContoller(mframe);
						 	frame.dispose();
						 	mframe.setVisible(true);
		             }
				 					 	
				 }
				 else {
					 error.setText("Incorrect mobile number or password.");
				 }
				 resultSet2.close();
				 } catch (Exception e) {
					 JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
				 }

		 }
		 
		public void setVisible(boolean b) {	
			
		}		 		 
}


