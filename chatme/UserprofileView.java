package chatme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;

public class UserprofileView{
    private JFrame userprofile;
    private JButton removebutton;
    private JLabel imageLabe2,imageLabelprf,emaillabel,mobilelabel;
    public String Receiver,sender,mobile,email,mobilel;
    private ImageIcon prf;
    private byte[] displayimage;
    private Image scaledImage;
    private int idfordelete;
   

    public UserprofileView(String sender,String Receiver,String mobile,int idfordelete) {
    	this.sender=sender;
    	this.Receiver=Receiver;
    	this.mobile=mobile;
    	this.idfordelete=idfordelete;
    	
        userprofile = new JFrame("ChatMe");
        userprofile.setSize(565, 632);
        userprofile.getContentPane().setLayout(null);
        userprofile.getContentPane().setBackground(new Color(50, 168, 84));
//      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userprofile.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        userprofile.setResizable(false);
        userprofile.setLocationRelativeTo(null);
        
        removebutton = new JButton("Remove as a friend");
        removebutton.setBounds(77,419,238,25);
        removebutton.setFont(new Font("Arial", Font.ITALIC, 14));
        removebutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removebutton.setBackground(Color.red);
        removebutton.setForeground(Color.white);
        removebutton.setFocusPainted(false); 
        removebutton.setOpaque(true); 
        removebutton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	removebutton.setBackground(Colorclass.bred); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	removebutton.setBackground(Color.red);
		    }
		    public void mouseClicked(MouseEvent e) {
		    	removefreind();
		    }
		});
        userprofile.getContentPane().add(removebutton);
        
        JLabel label = new JLabel();
        label.setText(Receiver);
        label.setBounds(182, 248, 292, 51);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.white);  
        userprofile.getContentPane().add(label); 
        
        emaillabel = new JLabel();
        emaillabel.setBounds(180, 293, 361, 51);
        emaillabel.setFont(new Font("Arial", Font.BOLD, 20));
        emaillabel.setForeground(Color.white);  
        userprofile.getContentPane().add(emaillabel);  
        
        mobilelabel = new JLabel();
        mobilelabel.setBounds(182, 338, 359, 51);
        mobilelabel.setFont(new Font("Arial", Font.BOLD, 20));
        mobilelabel.setForeground(Color.white);  
        userprofile.getContentPane().add(mobilelabel);  
        
        JLabel nameshow = new JLabel("Name:");
        nameshow.setBounds(77, 248, 70, 51);
        nameshow.setFont(new Font("Arial", Font.BOLD, 20));
        nameshow.setForeground(Color.white);  
        userprofile.getContentPane().add(nameshow); 
        
        JLabel emaillshow = new JLabel("Email:");
        emaillshow.setBounds(77, 293, 70, 51);
        emaillshow.setFont(new Font("Arial", Font.BOLD, 20));
        emaillshow.setForeground(Color.white);  
        userprofile.getContentPane().add(emaillshow);  
        
        JLabel mobilelshow = new JLabel("Mobile:");
        mobilelshow.setBounds(77, 338, 81, 51);
        mobilelshow.setFont(new Font("Arial", Font.BOLD, 20));
        mobilelshow.setForeground(Color.white);  
        userprofile.getContentPane().add(mobilelshow);  
        
        ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/back4.png");
        imageLabe2 = new JLabel(icon3);
        imageLabe2.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe2.setBounds(25, 23, 42, 43); 
        userprofile.getContentPane().add(imageLabe2);
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe2.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
           	try {
           		ChatframeView mframe = new ChatframeView(sender,Receiver,mobile,idfordelete);
           		ChatframeController ch = new ChatframeController(mframe);
           		userprofile.dispose(); 
           		mframe.setVisible(true);
           		
           	}catch(Exception e1) {
  				 System.out.println(e1);
  			 }
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
       imageLabelprf.setBounds(182, 41, 207, 186); 
       imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
       userprofile.getContentPane().add(imageLabelprf);

       showprofile();
        
       userprofile.setVisible(true);
    }
    
    public void showprofile() {
		try {
			ResultSet findnameresultSet=Model.findimage(Receiver);
			
			 if (findnameresultSet.next()) {
				 displayimage = findnameresultSet.getBytes("image");
				 email = findnameresultSet.getString("email");
				 mobilel= findnameresultSet.getString("mobile");
			 }
			 else {
				 JOptionPane.showMessageDialog(null,"Login failed." );
			 }
			 	BufferedImage image = ImageIO.read(new ByteArrayInputStream(displayimage));
			    scaledImage = image.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
			 	imageLabelprf.setIcon(new ImageIcon(scaledImage));
			 	
			 	emaillabel.setText(email);
			 	mobilelabel.setText(mobilel);
			 	

			 } catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			 }
		
    }
    
    public void removefreind() {
    	int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove "+Receiver+" ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
	    if (confirmation == JOptionPane.OK_OPTION) {
	        try {
	        	Model.removefreind(idfordelete);
	            MainFormView m1 = new MainFormView(mobile);
	            MainFormContoller m2 = new MainFormContoller(m1);
	            userprofile.dispose();
	            m1.setVisible(true);

	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        }
	    }
    }

	public void setVisible(boolean b) {
		
	}
}


