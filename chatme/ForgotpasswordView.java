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
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ForgotpasswordView{
	private JFrame Forgotframe;
	private JLabel imageLabe2,imageLabelprf,imageLabe,mob,vemail,send,vcode,pass,see,eerror,clearl,internerterror;
	private JTextField t2,t3,t4;
	private JPasswordField t5,t6;
	private int verificationcode;
	public JButton b2;
	private ImageIcon icon1,icon2,prf,warning;
	private String euname1;
	private ResultSet checkresultSet;
	
	public ForgotpasswordView() {
		Forgotframe = new JFrame();
		Forgotframe.setTitle("ChatMe Login");
		Forgotframe .setSize(523, 551);
		Forgotframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Forgotframe.getContentPane().setLayout(null);
		Forgotframe.setResizable(false);
		Forgotframe.getContentPane().setBackground(Colorclass.lightgreen);
		Forgotframe.setLocationRelativeTo(null);
		Forgotframe.setUndecorated(true);
		
		ImageIcon icon4 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Cancel_30px_3.png"); 
        JLabel imageLabelclose = new JLabel(icon4);
        imageLabelclose.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
        imageLabelclose.setBounds(473, 0, 50, 33); 
        Forgotframe.getContentPane().add(imageLabelclose);
        imageLabelclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabelclose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Forgotframe.dispose();
            	System.exit(0);
            }
        });
        
        ImageIcon icon5 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Minus_30px_3.png"); 
        JLabel imageLabelminimize = new JLabel(icon5);
        imageLabelminimize.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
        imageLabelminimize.setBounds(437, 0, 50, 33); 
        Forgotframe.getContentPane().add(imageLabelminimize);
        imageLabelminimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabelminimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	Forgotframe.setExtendedState(JFrame.ICONIFIED);
            }
        });
		
		ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/back4.png");
        imageLabe2 = new JLabel(icon3);
        imageLabe2.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe2.setBounds(24, 24, 45, 55); 
        Forgotframe.getContentPane().add(imageLabe2);
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	try {
           		LoginView loginf = new LoginView();
           		LoginController l1 = new LoginController(loginf);
           		Forgotframe.dispose(); 
				loginf.setVisible(true);	
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
        
		JLabel l1 = new JLabel();
		l1.setText("Mobile:");
		l1.setBounds(48,222,123,26);
		l1.setFont(new Font("Arial", Font.BOLD, 16));
		l1.setForeground(Colorclass.white);
		Forgotframe.getContentPane().add(l1);
		
		t2 = new JTextField();
		t2.setBounds(159,223,292,26);
		t2.setFont(new Font("Arial", Font.PLAIN, 16));
		Forgotframe.getContentPane().add(t2);
		
		JLabel l2 = new JLabel();
		l2.setText("Email:");
		l2.setBounds(48,278,123,26);
		l2.setFont(new Font("Arial", Font.BOLD, 16));
		l2.setForeground(Colorclass.white);
		Forgotframe.getContentPane().add(l2);
		
		t3 = new JTextField();
		t3.setBounds(159,278,292,26);
		t3.setFont(new Font("Arial", Font.PLAIN, 16));
		Forgotframe.getContentPane().add(t3);
		
		JLabel l3 = new JLabel();
		l3.setText("Verification Code:");
		l3.setBounds(48,336,155,26);
		l3.setFont(new Font("Arial", Font.BOLD, 16));
		l3.setForeground(Colorclass.white);
		Forgotframe.getContentPane().add(l3);
		
		t4 = new JTextField();
		t4.setBounds(201,335,250,26);
		t4.setFont(new Font("Arial", Font.PLAIN, 16));
		Forgotframe.getContentPane().add(t4);
		
		JLabel label = new JLabel();
        label.setBounds(159, 24, 292, 38);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(Colorclass.white);
        Forgotframe.getContentPane().add(label);        
        animateTyping(label, "Reset Password");
        
        JLabel l4 = new JLabel();
		l4 = new JLabel("New-Password:");
		l4.setBounds(48,386,123,26);
		l4.setFont(new Font("Arial", Font.BOLD, 16));
		l4.setForeground(Colorclass.white);
		Forgotframe.getContentPane().add(l4);
		
		t5 = new JPasswordField();
		t5.setBounds(201,386,250,26);
		t5.setFont(new Font("Arial", Font.PLAIN, 16));
		Forgotframe.getContentPane().add(t5);
		
		JLabel l7 = new JLabel();
		l7 = new JLabel("Re-Password:");
		l7.setBounds(48,432,123,26);
		l7.setFont(new Font("Arial", Font.BOLD, 16));
		l7.setForeground(Colorclass.white);
		Forgotframe.getContentPane().add(l7);
		
		t6 = new JPasswordField();
		t6.setBounds(201,432,250,26);
		t6.setFont(new Font("Arial", Font.PLAIN, 16));
		Forgotframe.getContentPane().add(t6);
		
		mob = new JLabel();
        mob.setBounds(331, 237, 179, 38);
        mob.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        mob.setForeground(Color.red);
        Forgotframe.getContentPane().add(mob); 
        
        vemail = new JLabel();
        vemail.setBounds(331, 301, 132, 38);
        vemail.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        vemail.setForeground(Color.red);
        Forgotframe.getContentPane().add(vemail); 
        
        
        eerror = new JLabel();
        eerror.setBounds(159, 301, 196, 38);
        eerror.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        eerror.setForeground(Color.red);
        Forgotframe.getContentPane().add(eerror);
        
        send = new JLabel("Click");
    	send.setBounds(458, 288, 61, 38);
    	send.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
    	send.setForeground(Colorclass.white);
    	Forgotframe.getContentPane().add(send);  
    	
    	vcode = new JLabel();
    	vcode.setBounds(233, 349, 238, 38);
    	vcode.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
    	vcode.setForeground(Color.red);
        Forgotframe.getContentPane().add(vcode);
        
        pass = new JLabel();
        pass.setBounds(304, 456, 152, 38);
    	pass.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
    	pass.setForeground(Color.red);
        Forgotframe.getContentPane().add(pass);
        
        internerterror = new JLabel();
        internerterror.setBounds(58, 301, 403, 38);
        internerterror.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        internerterror.setForeground(Color.red);
        Forgotframe.getContentPane().add(internerterror);
		
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeynotsee.png"); 
        JLabel imageLabeeye = new JLabel(icon);
        imageLabeeye.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        imageLabeeye.setBounds(448, 371, 66, 63); 
        Forgotframe.getContentPane().add(imageLabeeye);
        imageLabeeye.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabeeye.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (t5.getEchoChar() == 0) {
                	t5.setEchoChar('*');
                	t6.setEchoChar('*');
                	imageLabeeye.setIcon(icon);
                	see.setForeground(Color.WHITE);
                } else {
                	t5.setEchoChar((char) 0);
                	t6.setEchoChar((char) 0);
                	ImageIcon hoverIcon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeysee .png");
                	imageLabeeye.setIcon(hoverIcon);
                	see.setForeground(Color.yellow);
                }
            }
        });
       
        
         icon1 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/send1.png"); 
         icon2 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/send2.png");
         imageLabe = new JLabel(icon1);
        imageLabe.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
        imageLabe.setBounds(448, 258, 51, 55); 
        Forgotframe.getContentPane().add(imageLabe);       
        imageLabe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        imageLabe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	sendemailvalidate();

            }
        }); 
        
        b2 = new JButton("Create");
		b2.setBounds(255,489,176,45);
		b2.setFont(new Font("Arial", Font.PLAIN, 16));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setBackground(Colorclass.buttoncolor);
		b2.setForeground(Color.WHITE);
		b2.setFocusPainted(false); 
		b2.setOpaque(true); 
		b2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	b2.setBackground(Colorclass.buttoncolormouse); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	b2.setBackground(Colorclass.buttoncolor);
		    }
		});
		Forgotframe.getContentPane().add(b2);
		
		clearl = new JLabel("Clear");
        clearl.setBounds(112, 525, 59, 26);
        clearl.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        clearl.setForeground(Colorclass.white);
        Forgotframe.getContentPane().add(clearl);
        
        ImageIcon clear4 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/clear.png"); 
        JLabel imageclear = new JLabel(clear4);
        imageclear.setPreferredSize(new Dimension(clear4.getIconWidth(), clear4.getIconHeight()));
        imageclear.setBounds(86, 493, 75, 37); 
        Forgotframe.getContentPane().add(imageclear);
        imageclear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageclear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	cleartext();
            }
            @Override
		    public void mouseEntered(MouseEvent e) {
            	ImageIcon hoverclear = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/yelocle.png");
            	imageclear.setIcon(hoverclear);
            	clearl.setForeground(Color.yellow);
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	imageclear.setIcon(clear4);
		    	clearl.setForeground(Colorclass.white);
		    }
        });		
		
		see = new JLabel("Show");
        see.setBounds(461, 415, 62, 55);
        see.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        see.setForeground(Colorclass.white);
        Forgotframe.getContentPane().add(see);
        
        warning = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-page-not-found-64 (1).png");
        
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
       imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
       imageLabelprf.setBounds(201, 70, 165, 143); 
       Forgotframe.getContentPane().add(imageLabelprf);
       
        
		Forgotframe.setVisible(true);
		
		Random random = new Random();
        verificationcode = 1000 + random.nextInt(9000);
        
        //System.out.println(verificationcode);
        
	}
	public void sendemailvalidate() {
		mob.setText("");
    	vemail.setText("");
    	eerror.setText("");
    	internerterror.setText("");
    	if ( t2.getText().isEmpty() || t3.getText().isEmpty() ) {
    		mob.setText("Please fill fields first.");
            return; 
        }
        String mobile = t2.getText();
        if (!isValidMobile(mobile)) {
            mob.setText("Invalid mobile number");
            return;
        }
        String email = t3.getText();
        if (!isValidEmail(email)) {
            vemail.setText("Invalid email address");
            return; 
        }

    	SwingUtilities.invokeLater(() -> {
    	    try {
    	    	checemilnum();            	       
    	    } catch(Exception e1) {
    	    	JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
    	    }
    	});
	}
	
	public void checemilnum() {
		try {
			String phone = t2.getText();
			String temail = t3.getText();
			checkresultSet=Model.checkemail(phone,temail);
			 if (checkresultSet.next()) {
				 
			    euname1 = checkresultSet.getString("name");
			    
			    byte[] displayimage = checkresultSet.getBytes("image");
			    BufferedImage image = ImageIO.read(new ByteArrayInputStream(displayimage));
			    Image scaledImage = image.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
			    imageLabelprf.setIcon(new ImageIcon(scaledImage));			    
			 	
			 	
			 	boolean Internet = Model.isInternetAvailable();
			 	if (!Internet) {
			 		internerterror.setText("No internet connection. Please connect to the internet and try again.");
			 	    return;
			 	}

			 	imageLabe.setIcon(icon2);
                send.setText("Sending...");
                
                SwingUtilities.invokeLater(() -> {
            	    try {
            	    	emailVerification();
            	    } catch(Exception e1) {
            	    	JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
            	    }
            	});
			 }
			 else {
				 imageLabelprf.setIcon(warning);
				 eerror.setText("Invalid mobile number or email.");
			 }
			 	 checkresultSet.close();
			 } catch (Exception e) {
				 imageLabelprf.setIcon(warning);
			 }
	}
	
	
	public void forgotpwttonlistner(ActionListener listner) {
		b2.addActionListener(listner);
		
	}

	public JButton forgotpwButton() {
		return b2;
	}
	
	
	public void createbuttonvalidate() {
		pass.setText("");
        vemail.setText("");
        mob.setText("");
        vcode.setText("");        
        if (t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getPassword().length == 0 || t6.getPassword().length == 0) {
        	mob.setText("Please fill in all fields.");
            return; 
        }
        String mobile = t2.getText();
        if (!isValidMobile(mobile)) {
            mob.setText("Invalid mobile number");
            return;
        }
        String email = t3.getText();
        if (!isValidEmail(email)) {
            vemail.setText("Invalid email address");
            return; 
        }
        int ver;
        try {
            ver = Integer.parseInt(t4.getText());
            if(verificationcode!=ver) {
            	vcode.setText("Verification code must be valid.");
            	return; 
            }	            
        } catch (NumberFormatException ex) {
        	vcode.setText("Verification code must be a number.");
            return; 
        }
        if (!Arrays.equals(t5.getPassword(), t6.getPassword())) {
            pass.setText("Passwords do not match");
            return;
        }
        updatepassword();
	}
	
	public void cleartext() {
		internerterror.setText("");
		imageLabe.setIcon(icon1); 
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        pass.setText("");
        vemail.setText("");
        mob.setText("");
        vcode.setText("");
        imageLabelprf.setIcon(prf);
        eerror.setText("");
	}
	
	private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	private boolean isValidMobile(String mobile) {
        String mobileRegex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
	
	public void updatepassword() {
		try {
	        String newPassword = new String(t5.getPassword()); 
	        String phone = t2.getText();
	        String temail = t3.getText();
	     
	        int rowsAffected=Model.forgetupdateaccount(newPassword,phone,temail);
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	            LoginView loginf2 = new LoginView();
	            LoginController l1 = new LoginController(loginf2);
           		Forgotframe.dispose(); 
				loginf2.setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to update password,Try again", "Error", JOptionPane.ERROR_MESSAGE);
	            cleartext();
	        }
	    } catch (Exception e) {
	    	 JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	    }
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
	String to;
	public void emailVerification(){
	   to = t3.getText();
       String from = "chatmeofficial2003@gmail.com";
       String host = "smtp.gmail.com";
       Properties properties = System.getProperties();
       properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.smtp.port", "587");
       properties.setProperty("mail.smtp.auth", "true");
       properties.setProperty("mail.smtp.starttls.enable", "true");
       Session session = Session.getInstance(properties, new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication("chatmeofficial2003@gmail.com", "gnqx gidp wtlq ffvc");
           }
       });
       try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(from));
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
           message.setSubject("Password Reset Verification Code for Your ChatMe Account");
           String messagetouser = 
        	        "Dear "+euname1+",\r\n"
        	        + "\r\n"
        	        + "We received a request to reset your password for your ChatMe account. To proceed with the password reset process, please use the following verification code:\r\n"
        	        + "\r\n"
        	        + verificationcode + "\r\n"
        	        + "\r\n"
        	        + "This verification code is essential for resetting your password and will expire in 5 minutes. If you didn't request this password reset, please disregard this email.\r\n"
        	        + "\r\n"
        	        + "If you need further assistance or have any questions, please contact our support team at chatmeofficial2003@gmail.com.\r\n"
        	        + "\r\n"
        	        + "Best regards,\r\n"
        	        + "The ChatMe Team";           
           message.setText(messagetouser);
           Transport.send(message);
           send.setText("");
           vemail.setText("Sent email successfully."); 
       } catch (MessagingException e) {
    	   JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
       }
	}
	
	
	public void setVisible(boolean b) {	}
	
}
