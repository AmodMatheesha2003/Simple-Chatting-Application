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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class CreateAccountView {
	public JButton b2,clear,prfbutton;
	private JTextField t1,t2,t3,t4;
	private JFrame crframe;
	private int verificationcode;
	private JLabel imageLabe,imageLabe2,see,internerterror,send,done,pass,vcode,vemail,etext,mob,clearl,imgerror,imageLabelprf;
	private ImageIcon icon1,prf;
	private JPasswordField t5,t6;
	private String Username,to;
	private BufferedImage selectedImage;
	
	public CreateAccountView() {
		crframe = new JFrame();
		crframe.setTitle("Create Account");
		crframe .setSize(523, 700);
		crframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crframe.setResizable(false);
		crframe.getContentPane().setBackground(Colorclass.lightgreen);
		crframe.getContentPane().setLayout(null);
		crframe.setLocationRelativeTo(null);
		crframe.setUndecorated(true);
		
		JLabel l5 = new JLabel();
		l5.setText("Name:");
		l5.setBounds(48,292,123,26);
		l5.setFont(new Font("Arial", Font.BOLD, 16));
		l5.setForeground(Colorclass.white);
		crframe.getContentPane().add(l5);
		
		t1 = new JTextField();
		t1.setBounds(160,293,292,26);
		t1.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t1);
		
		JLabel l1 = new JLabel();
		l1.setText("Mobile:");
		l1.setBounds(48,341,123,26);
		l1.setFont(new Font("Arial", Font.BOLD, 16));
		l1.setForeground(Colorclass.white);
		crframe.getContentPane().add(l1);
		
		t2 = new JTextField();
		t2.setBounds(160,342,292,26);
		t2.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t2);
		
		JLabel l2 = new JLabel();
		l2.setText("Email:");
		l2.setBounds(48,397,123,26);
		l2.setFont(new Font("Arial", Font.BOLD, 16));
		l2.setForeground(Colorclass.white);
		crframe.getContentPane().add(l2);
		
		t3 = new JTextField();
		t3.setBounds(160,399,292,26);
		t3.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t3);
		
		JLabel l3 = new JLabel();
		l3.setText("Verification Code:");
		l3.setBounds(48,455,155,26);
		l3.setFont(new Font("Arial", Font.BOLD, 16));
		l3.setForeground(Colorclass.white);
		crframe.getContentPane().add(l3);		
		
		t4 = new JTextField();
		t4.setBounds(227,457,225,26);
		t4.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t4);
		
		JLabel l4 = new JLabel();
		l4 = new JLabel("Password:");
		l4.setBounds(48,505,123,26);
		l4.setFont(new Font("Arial", Font.BOLD, 16));
		l4.setForeground(Colorclass.white);
		crframe.getContentPane().add(l4);
		
		t5 = new JPasswordField();
		t5.setBounds(182,508,270,26);
		t5.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t5);
		
		JLabel l7 = new JLabel();
		l7 = new JLabel("Re-Password:");
		l7.setBounds(48,551,123,26);
		l7.setFont(new Font("Arial", Font.BOLD, 16));
		l7.setForeground(Colorclass.white);
		crframe.getContentPane().add(l7);
		
		t6 = new JPasswordField();
		t6.setBounds(182,554,270,26);
		t6.setFont(new Font("Arial", Font.PLAIN, 16));
		crframe.getContentPane().add(t6);
		
		b2 = new JButton("Create");
		b2.setBounds(255,610,176,45);
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
		crframe.getContentPane().add(b2);	
		
		JLabel profilelabel = new JLabel("Profile Photo:");
		profilelabel.setBounds(48,241,123,26);
		profilelabel.setFont(new Font("Arial", Font.BOLD, 16));
		profilelabel.setForeground(Colorclass.white);
		crframe.getContentPane().add(profilelabel);
		
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
        imageLabelprf.setBounds(189, 79, 165, 143); 
        crframe.getContentPane().add(imageLabelprf);
        
        prfbutton = new JButton("Select Picture");
        prfbutton.setBounds(170,242,155,26);
        prfbutton.setFont(new Font("Arial", Font.ITALIC, 14));
        prfbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prfbutton.setBackground(Colorclass.buttoncolor);
        prfbutton.setForeground(Color.WHITE);
        prfbutton.setFocusPainted(false); 
        prfbutton.setOpaque(true); 
        prfbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        b2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        prfbutton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	prfbutton.setBackground(Colorclass.buttoncolormouse); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	prfbutton.setBackground(Colorclass.buttoncolor);
		    }
		    public void mouseClicked(MouseEvent e) {
		    	JFileChooser fileChooser = new JFileChooser();
		         int returnValue = fileChooser.showOpenDialog(null);
		         if (returnValue == JFileChooser.APPROVE_OPTION) {
		             File selectedFile = fileChooser.getSelectedFile();
		             try {
		                 selectedImage = ImageIO.read(selectedFile);
		                 Image scaledImage = selectedImage.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
		                 imageLabelprf.setIcon(new ImageIcon(scaledImage));
		             } catch (IOException ex) {
		            	 JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		             }
		         }
            }
		});
		crframe.getContentPane().add(prfbutton);
		
		clearl = new JLabel("Clear");
        clearl.setBounds(112, 646, 59, 26);
        clearl.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        clearl.setForeground(Colorclass.white);
        crframe.getContentPane().add(clearl);
        
        ImageIcon clear4 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/clear.png"); 
        JLabel imageclear = new JLabel(clear4);
        imageclear.setPreferredSize(new Dimension(clear4.getIconWidth(), clear4.getIconHeight()));
        imageclear.setBounds(86, 614, 75, 37); 
        crframe.getContentPane().add(imageclear);
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
		
		ImageIcon icon = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/monkeynotsee.png"); 
        JLabel imageLabeeye = new JLabel(icon);
        
        imageLabeeye.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        imageLabeeye.setBounds(449, 505, 66, 63); 
        crframe.getContentPane().add(imageLabeeye);
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
        
        ImageIcon icon4 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Cancel_30px_3.png"); 
        JLabel imageLabelclose = new JLabel(icon4);
        imageLabelclose.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
        imageLabelclose.setBounds(473, 0, 50, 33); 
        crframe.getContentPane().add(imageLabelclose);
        imageLabelclose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabelclose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	crframe.dispose();
            	System.exit(0);
            }
        });
        
        ImageIcon icon5 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8_Minus_30px_3.png"); 
        JLabel imageLabelminimize = new JLabel(icon5);
        imageLabelminimize.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
        imageLabelminimize.setBounds(437, 0, 50, 33); 
        crframe.getContentPane().add(imageLabelminimize);
        imageLabelminimize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabelminimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	crframe.setExtendedState(JFrame.ICONIFIED);
            }
        });
        
		Random random = new Random();
        verificationcode = 1000 + random.nextInt(9000);
        
        //System.out.println(verificationcode);
        
        JLabel label = new JLabel();
        label.setBounds(139, 31, 256, 38);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(Colorclass.white);
        crframe.getContentPane().add(label);        
        animateTyping(label, "CREATE ACCOUNT");
        
        send = new JLabel("Click");
    	send.setBounds(459, 410, 61, 38);
    	send.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
    	send.setForeground(Colorclass.white);
        crframe.getContentPane().add(send); 
        
        see = new JLabel("Show");
        see.setBounds(462, 551, 61, 45);
        see.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        see.setForeground(Colorclass.white);
        crframe.getContentPane().add(see); 
        
        done = new JLabel();
        done.setBounds(160, 423, 165, 38);
        done.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        done.setForeground(Color.red);
        crframe.getContentPane().add(done);
        
        mob = new JLabel();
        mob.setBounds(332, 362, 152, 38);
        mob.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        mob.setForeground(Color.red);
        crframe.getContentPane().add(mob);
        
        internerterror = new JLabel();
        internerterror.setBounds(58, 423, 400, 38);
        internerterror.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        internerterror.setForeground(Color.red);
        crframe.getContentPane().add(internerterror);
        
        pass = new JLabel();
        pass.setBounds(309, 577, 165, 38);
        pass.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        pass.setForeground(Color.red);
        crframe.getContentPane().add(pass);
 
        vcode = new JLabel();
        vcode.setBounds(255, 480, 225, 38);
        vcode.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        vcode.setForeground(Color.red);
        crframe.getContentPane().add(vcode);
        
        vemail = new JLabel();
        vemail.setBounds(335, 423, 136, 38);
        vemail.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        vemail.setForeground(Color.red);
        crframe.getContentPane().add(vemail);
        
        etext = new JLabel();
        etext.setBounds(335, 314, 136, 38);
        etext.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        etext.setForeground(Color.red);
        crframe.getContentPane().add(etext);
        
        imgerror = new JLabel();
        imgerror.setBounds(335, 237, 176, 38);
        imgerror.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 12));
        imgerror.setForeground(Color.red);
        crframe.getContentPane().add(imgerror);
                 
        icon1 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/send1.png"); 
        ImageIcon icon2 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/send2.png");
        imageLabe = new JLabel(icon1);
        imageLabe.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
        imageLabe.setBounds(449, 380, 51, 55); 
        crframe.getContentPane().add(imageLabe);       
        imageLabe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	etext.setText("");
            	mob.setText("");
            	vemail.setText("");
            	if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() ) {
    	            etext.setText("Please fill fields first.");
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
        });        
        ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/back4.png");
        imageLabe2 = new JLabel(icon3);
        imageLabe2.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe2.setBounds(24, 24, 45, 55); 
        crframe.getContentPane().add(imageLabe2);
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	try {
           		LoginView loginf = new LoginView();
           		LoginController l1 = new LoginController(loginf);
				 crframe.dispose(); 
				 loginf.setVisible(true);
           	}catch(Exception e1) {
           	 JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
  				 //System.out.println(e1);
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
       crframe.setVisible(true);
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
	
	public void createbuttonlistner(ActionListener listner) {
		b2.addActionListener(listner);
		
	}

	public JButton createButton() {
		return b2;
	}
	
	public void validatebeforeinsert() {
		etext.setText("");
        pass.setText("");
        vemail.setText("");
        mob.setText("");
        vcode.setText("");
        done.setText("");
        imgerror.setText("");
        
        if(selectedImage == null) {
        	imgerror.setText("Please Select Profile picture.");
        	return; 
        }
        if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || t5.getPassword().length == 0 || t6.getPassword().length == 0) {
            etext.setText("Please fill in all fields.");
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
        insertdata();	
	}
	public void cleartext() {
		imageLabe.setIcon(icon1); 
		t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        etext.setText("");
        pass.setText("");
        vemail.setText("");
        mob.setText("");
        vcode.setText("");
        done.setText("");
        imgerror.setText("");
        imageLabelprf.setIcon(prf);
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
	
	public void emailVerification(){
		 to = t3.getText();
		 Username = t1.getText();
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
                return new PasswordAuthentication("**************", "***************");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Your ChatMe Account Verification Code");
            String messagetouser = 
            		"Dear "+Username+",\r\n"
            		+ "\r\n"
            		+ "Welcome to ChatMe!  To ensure the security of your account, please use the following verification code to complete your registration:\r\n"
            		+ "\r\n"
            		+ verificationcode+"\r\n"
            		+ "\r\n"
            		+ "This code is essential for account activation and will expire in 5 minutes. If you haven't initiated this registration, please disregard this email.\r\n"
            		+ "\r\n"
            		+ "If you encounter any issues or have any questions, feel free to reach out to our support team at chatmeofficial2003@gmail.com.\r\n"
            		+ "\r\n"
            		+ "Best regards,\r\n"
            		+ "The ChatMe Team" ;            
            message.setText(messagetouser);
            Transport.send(message);
            
            send.setText("");
            done.setText("Sent message successfully.");    
        } catch (MessagingException e) {
        	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
	}
	
	public void insertdata() {	    
	    try {
	        String name = t1.getText();
	        char[] passwordChars = t5.getPassword();
			String password = new String(passwordChars);
	        String email = t3.getText();
	        String mobile = t2.getText();
	        
	        byte[] imageBytes = null; 
	        
	        if (selectedImage != null) {
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            ImageIO.write(selectedImage, "jpg", baos);
	            imageBytes = baos.toByteArray();
	        }
	        
	        Model.insertuserdetail(name,password,email,mobile,imageBytes);
	        
	        JOptionPane.showMessageDialog(null, "Account Create successfully!");
	        
	        cleartext();
	        LoginView loginf = new LoginView();
	        LoginController l1 = new LoginController(loginf);
			crframe.dispose(); 
			loginf.setVisible(true);

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}


	public void setVisible(boolean b) {	
		
	}
}
