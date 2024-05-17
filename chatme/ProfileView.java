package chatme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfileView {
	String mobile,password1,name3,name2,password,email;
	JFrame profileset;
	JLabel imageLabe2,see,etext,imageLabelprf,etext22,pass;
	JTextField t1,t2,t3;
	JPasswordField t5,t6,t7;
	JButton b1,del,prfbutton;	 
	ImageIcon prf;
	Image scaledImage;
	byte[] displayimage;
	private BufferedImage selectedImage;
	byte[] imageBytes;
	
	public ProfileView(String mobile,String name2) {
		this.mobile=mobile;
		this.name2=name2;
		
		profileset = new JFrame();
		profileset.setTitle("ChatMe Profile");
		profileset .setSize(808, 498);
		profileset.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profileset.getContentPane().setLayout(null);
		profileset.getContentPane().setBackground(Colorclass.lightgreen);
		profileset.setLocationRelativeTo(null);
		profileset.setResizable(false);
		profileset.setUndecorated(true);
		
		ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/back4.png");
        imageLabe2 = new JLabel(icon3);
        imageLabe2.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe2.setBounds(22, 28, 45, 55); 
        profileset.getContentPane().add(imageLabe2);
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	try {
           		MainFormView logg = new MainFormView(mobile);
           		MainFormContoller mc = new MainFormContoller(logg);
           		profileset.dispose(); 
           		logg.setVisible(true);
           		
           	}catch(Exception e1) {
           		JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
  			 }
	                 
           }
           public void mouseEntered(MouseEvent e) {
             	ImageIcon hoverclear = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-back-50 (3).png");
             	imageLabe2.setIcon(hoverclear);
  		    }
  		    @Override
  		    public void mouseExited(MouseEvent e) {
  		    	imageLabe2.setIcon(icon3);
  		    	
  		    }
       });
       
       JLabel label = new JLabel();
       label.setBounds(146, 28, 354, 38);
       label.setFont(new Font("Arial", Font.BOLD, 29));
       label.setForeground(Color.white);
       profileset.getContentPane().add(label);        
       animateTyping(label, "HELLO "+name2);
       
        JLabel l5 = new JLabel();
		l5.setText("Name:");
		l5.setBounds(22,105,69,26);
		l5.setFont(new Font("Arial", Font.BOLD, 16));
		l5.setForeground(Color.white);
		profileset.getContentPane().add(l5);
		
		t1 = new JTextField();
		t1.setBounds(88,106,342,26);
		t1.setEditable(false); //remogve this and addd upadate others tabels name
		t1.setFont(new Font("Arial", Font.PLAIN, 16));
		profileset.getContentPane().add(t1);
		
		JLabel l1 = new JLabel();
		l1.setText("Mobile:");
		l1.setBounds(22,155,69,26);
		l1.setFont(new Font("Arial", Font.BOLD, 16));
		l1.setForeground(Color.white);
		profileset.getContentPane().add(l1);
		
		t2 = new JTextField();
		t2.setBounds(88,154,342,26);
		t2.setFont(new Font("Arial", Font.PLAIN, 16));
		t2.setEditable(false);
		profileset.getContentPane().add(t2);
		
		JLabel l2 = new JLabel();
		l2.setText("Email:");
		l2.setBounds(22,211,69,26);
		l2.setFont(new Font("Arial", Font.BOLD, 16));
		l2.setForeground(Color.white);
		profileset.getContentPane().add(l2);
		
		t3 = new JTextField();
		t3.setBounds(88,211,342,26);
		t3.setFont(new Font("Arial", Font.PLAIN, 16));
		t3.setEditable(false);
		profileset.getContentPane().add(t3);
		
		
		JLabel l4 = new JLabel("Current Password:");
		l4.setBounds(22,262,157,26);
		l4.setFont(new Font("Arial", Font.BOLD, 16));
		l4.setForeground(Color.white);
		profileset.getContentPane().add(l4);
		
		t5 = new JPasswordField();
		t5.setBounds(214,263,342,26);
		t5.setFont(new Font("Arial", Font.PLAIN, 16));
		profileset.getContentPane().add(t5);
		
		JLabel l7 = new JLabel("New Password:");
		l7.setBounds(26,319,123,26);
		l7.setFont(new Font("Arial", Font.BOLD, 16));
		l7.setForeground(Color.white);
		profileset.getContentPane().add(l7);
		
		t6 = new JPasswordField();
		t6.setBounds(214,320,342,26);
		t6.setFont(new Font("Arial", Font.PLAIN, 16));
		profileset.getContentPane().add(t6);
		
		JLabel l8 = new JLabel("Re-Password:");
		l8.setBounds(26,377,123,26);
		l8.setFont(new Font("Arial", Font.BOLD, 16));
		l8.setForeground(Color.white);
		profileset.getContentPane().add(l8);
		
		t7 = new JPasswordField();
		t7.setBounds(214,378,342,26);
		t7.setFont(new Font("Arial", Font.PLAIN, 16));
		profileset.getContentPane().add(t7);
		
		see = new JLabel("Show");
        see.setBounds(584, 347, 66, 14);
        see.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        see.setForeground(Color.white);
        profileset.getContentPane().add(see); 
		
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeynotsee.png"); 
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        imageLabel.setBounds(566, 288, 66, 63); 
        profileset.getContentPane().add(imageLabel);
        imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t5.getEchoChar() == 0) {
                	t5.setEchoChar('*');
                	t6.setEchoChar('*');
                	t7.setEchoChar('*');
                	imageLabel.setIcon(icon);
                	see.setForeground(Color.WHITE);
                } else {
                	t5.setEchoChar((char) 0);
                	t6.setEchoChar((char) 0);
                	t7.setEchoChar((char) 0);
                	ImageIcon hoverIcon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeysee .png");
	                imageLabel.setIcon(hoverIcon);
	                see.setForeground(Color.yellow);
                }
            }
        });
        
        etext = new JLabel();
        etext.setBounds(294, 122, 136, 38);
        etext.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        etext.setForeground(Color.red);
        profileset.getContentPane().add(etext);
        
        etext22 = new JLabel();
        etext22.setBounds(399, 290, 157, 38);
        etext22.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        etext22.setForeground(Color.red);
        profileset.getContentPane().add(etext22);
        
        pass = new JLabel();
        pass.setBounds(409, 341, 157, 38);
        pass.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        pass.setForeground(Color.red);
        profileset.getContentPane().add(pass);
            
//        etext22.setText("Password can't be empty.");
//        pass.setText("Passwords don't match.");
//        etext.setText("Name can't be empty.");
		
        b1 = new JButton("Change Save Data");
		b1.setBounds(494,434,204,36);
		b1.setFont(new Font("Arial", Font.BOLD, 16));
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.setBackground(Colorclass.buttoncolor);
		b1.setForeground(Color.white);
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
		profileset.getContentPane().add(b1);
		
		del = new JButton("Delete my Account");
		del.setBounds(44,435,179,37);
		del.setFont(new Font("Arial", Font.ITALIC, 14));
		del.setCursor(new Cursor(Cursor.HAND_CURSOR));
		del.setBackground(Color.red);
		del.setForeground(Color.white);
		del.setFocusPainted(false); 
		del.setOpaque(true); 
		del.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	del.setBackground(Colorclass.bred); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	del.setBackground(Color.red);
		    }
		    
		});
		profileset.getContentPane().add(del);
        
        
        
        prfbutton = new JButton("Select Picture");
        prfbutton.setBounds(643,212,117,26);
        prfbutton.setFont(new Font("Arial", Font.ITALIC, 14));
        prfbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prfbutton.setBackground(Colorclass.buttoncolor);
        prfbutton.setForeground(Color.WHITE);
        prfbutton.setFocusPainted(false); 
        prfbutton.setOpaque(true); 
        prfbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        prfbutton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	prfbutton.setBackground(Colorclass.buttoncolormouse); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	prfbutton.setBackground(Colorclass.buttoncolor);
		    }
		    
		});
        profileset.getContentPane().add(prfbutton);
		
		JLabel logoutlabel = new JLabel();
		logoutlabel.setText("logout");
		logoutlabel.setBounds(709,79,75,26);
		logoutlabel.setFont(new Font("Arial", Font.BOLD, 16));
		logoutlabel.setForeground(Color.white);
		profileset.getContentPane().add(logoutlabel);
		
		ImageIcon logout = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logout.png"); 
        JLabel logoutLabel = new JLabel(logout);
        logoutLabel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        logoutLabel.setBounds(709, 28, 50, 55); 
        profileset.getContentPane().add(logoutLabel);
        logoutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
                ImageIcon logoutyello = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logoutyellow.png");
                logoutLabel.setIcon(logoutyello);
                logoutlabel.setForeground(Color.yellow);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	logoutLabel.setIcon(logout);
            	logoutlabel.setForeground(Color.white);
                
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            	Model.setonlineoffline("offline", mobile);
            	
            	LoginView l3 = new LoginView();
            	LoginController l1 = new LoginController(l3);
            	profileset.dispose();
            	l3.setVisible(true);
            }
        });
        
         prf = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-glyph-96.png"); 
        imageLabelprf = new JLabel(prf)
       {
           @Override
           protected void paintComponent(Graphics g) {
               Graphics2D g2 = (Graphics2D) g.create();
               Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
               g2.setClip(clip);
               super.paintComponent(g2);
               g2.dispose();
           }
       };		
       imageLabelprf.setBounds(450, 76, 183, 171); 
       imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
       
       profileset.getContentPane().add(imageLabelprf);
       setdata(mobile);
       
        
		profileset.setVisible(true);
	}
	
	public JButton savedataButton() {
		return b1;
	}
	
	public JButton delButton() {
		return del;
	}
	
	public JButton prfButton() {
		return prfbutton;
	}
	
	public void savedatabuttonlistner(ActionListener listner) {
		b1.addActionListener(listner);
		
	}
	public void delButtonlistner(ActionListener listner) {
		del.addActionListener(listner);
		
	}
	public void prfButtonlistner(ActionListener listner) {
		prfbutton.addActionListener(listner);
		
	}
	
	public void selectimage() {
		JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                selectedImage = ImageIO.read(selectedFile);
                Image scaledImage = selectedImage.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
                imageLabelprf.setIcon(new ImageIcon(scaledImage));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	public void validsavedata() {
		etext.setText("");
    	etext22.setText("");
    	pass.setText("");
    	
    	if (t1.getText().isEmpty() ) {
            etext.setText("Name can't be empty.");
            return; 
        }
    	if (t5.getPassword().length == 0 ) {
            etext22.setText("Password can't be empty.");
            return; 
        }
    	if (!Arrays.equals(t6.getPassword(), t7.getPassword())) {
            pass.setText("Passwords don't match.");
            return;
        }
    	
    	char[] enteredPasswordChars = t5.getPassword();
    	String enteredPassword = new String(enteredPasswordChars);
    	if (!password.equals(enteredPassword)) {
    		etext22.setText("Password is invalid.");
    	    return;
    	}
    	
    	char[] newPasswordChars = t6.getPassword();
    	if (newPasswordChars.length > 0) {
    	    password1 = new String(newPasswordChars);
    	} else {
    	    password1 = password; 
    	}
    	
    	if (t1.getText().equals(name2) ) {
    		name3=name2;
        }else {
        	name3=t1.getText();
        }
    	
    	if (t1.getText().equals(name2) ) {
    		//update method name
    	}
    	
    	if (selectedImage != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
				ImageIO.write(selectedImage, "jpg", baos);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            imageBytes  = baos.toByteArray();
            updateprofileuser(password1,name3,imageBytes);
        }
    	else {
    		updateprofileuser(password1,name3);
    	}
	}
	public void deleteAccount() {
	    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
	    if (confirmation == JOptionPane.OK_OPTION) {
	        try {
	        	Model.deletefrofiledata(mobile);
	            LoginView l3 = new LoginView();
	            LoginController l1 = new LoginController(l3);
	            profileset.dispose();
	            l3.setVisible(true);

	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        }
	    }
	}

	public void updateprofileuser(String password1,String name3) {
		try {
			Model.updateprofile(password1,name3,mobile);
	        
	        JOptionPane.showMessageDialog(null, "updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        ProfileView f2 = new ProfileView(mobile,name3);
	        ProfileController fc = new ProfileController(f2);
	        profileset.dispose();
        	f2.setVisible(true);
	        
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	    }
	}
	
	public void updateprofileuser(String password1,String name3,byte[] imageBytes) {
		try {
			Model.updateprofile(password1,name3,mobile,imageBytes);
	        JOptionPane.showMessageDialog(null, "updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        
	        ProfileView f2 = new ProfileView(mobile,name3);
	        ProfileController pc = new ProfileController(f2);
	        profileset.dispose();
        	f2.setVisible(true);
	        
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	    }
	}
	
	public void setdata(String mobile) {
		try {
			ResultSet setuserresultSet=Model.setuserdata(mobile);
			
			 if (setuserresultSet.next()) {
				 password = setuserresultSet.getString("password");
				 email = setuserresultSet.getString("email");
				 displayimage = setuserresultSet.getBytes("image");
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Error: " + "Login failed.");
			 }
			 	t1.setText(name2);
			 	t2.setText(mobile);
			 	t3.setText(email);
			 	
			 	BufferedImage image = ImageIO.read(new ByteArrayInputStream(displayimage));
			    scaledImage = image.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
			    
			 	imageLabelprf.setIcon(new ImageIcon(scaledImage));
			 
			 	setuserresultSet.close();
			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			 }
	}
	
	
	public void animateTyping(JLabel label,String textToType) {
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
	
	public void setVisible(boolean b) {	
		
	}
}
