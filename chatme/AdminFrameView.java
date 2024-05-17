package chatme;

import java.awt.Color;
import java.awt.Component;
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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminFrameView {
	private JFrame adminframe;
	private ImageIcon prf;
	private JLabel imageLabelprf,quanty,onlinequanty,l2,error;
	public String name;
	byte[] displayimage;
	private JTable table;
	private DefaultTableModel model;
	private JTextField text;
	private JButton view,search ,delete,loadframe;
	private JPanel onlinepanel,count,tabelpanel;
	private JScrollPane scrollPane;
	
	public AdminFrameView(String name,byte[] displayimage)  {
		this.name=name;
		this.displayimage=displayimage;
		adminframe = new JFrame();
		adminframe.setTitle("ChatMe Profile");
		adminframe .setSize(1027, 601);
		adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminframe.setResizable(false);
		adminframe.getContentPane().setLayout(null);
		adminframe.getContentPane().setBackground(Colorclass.lightgreen);
		adminframe.setLocationRelativeTo(null);
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
	       imageLabelprf.setBounds(30, 22, 193, 171); 
	       imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
	       try {
	    	   BufferedImage image = ImageIO.read(new ByteArrayInputStream(displayimage));
			    Image scaledImage = image.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
			 	imageLabelprf.setIcon(new ImageIcon(scaledImage));   
	       }catch(IOException e) {
	    	  System.out.println(e) ;
	       }
	       	       
	    JPanel p1 = new JPanel();    
		p1.setBackground(new Color(32, 184, 98));
		p1.setLayout(null);
		p1.setBounds(0, 0, 261, 564);
		p1.add(imageLabelprf);
		
		JLabel label = new JLabel();
        label.setBounds(436, 23, 379, 38);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.white);
        adminframe.getContentPane().add(label);        
        animateTyping(label, "Admin Panel");
       
        JLabel label2 = new JLabel();
        label2.setBounds(32, 214, 239, 38);
        label2.setFont(new Font("Arial", Font.BOLD, 30));
        label2.setForeground(Color.white);
        label2.setText(name);
        p1.add(label2);
        
        count = new JPanel();
        count.setLayout(null);
        count.setBounds(384, 153, 220, 124);
        
        JLabel countlabel = new JLabel();
        countlabel.setBounds(52, 10, 158, 38);
        countlabel.setFont(new Font("Arial", Font.BOLD, 30));
        countlabel.setForeground(Color.red);
        countlabel.setText("Register");
        count.add(countlabel);
        
        quanty = new JLabel();
        quanty.setBounds(90, 58, 130, 38);
        quanty.setFont(new Font("Arial", Font.BOLD, 30));
        quanty.setForeground(Color.red);
        quanty.setText(String.valueOf(Model.countUser()));
        count.add(quanty);
        
        JLabel adminlabel = new JLabel("Admin");
        adminlabel.setBounds(40,189,70,26);
        adminlabel.setForeground(Color.white);
        adminlabel.setFont(new Font("Arial", Font.ITALIC, 16));
		p1.add(adminlabel);
        
        onlinepanel = new JPanel();
        onlinepanel.setLayout(null);
        onlinepanel.setBounds(648, 153, 220, 124);
        
        JLabel onlinelabel = new JLabel();
        onlinelabel.setBounds(62, 10, 158, 38);
        onlinelabel.setFont(new Font("Arial", Font.BOLD, 30));
        onlinelabel.setForeground(Color.red);
        onlinelabel.setText("Online");
        onlinepanel.add(onlinelabel);
        
        onlinequanty = new JLabel();
        onlinequanty.setBounds(100, 58, 110, 38);
        onlinequanty.setFont(new Font("Arial", Font.BOLD, 30));
        onlinequanty.setForeground(Color.red);
        onlinequanty.setText(String.valueOf(Model.countonline()));
        onlinepanel.add(onlinequanty);
        
        view = new JButton("View Users");
        view.setBounds(30,336,176,45);
        view.setFont(new Font("Arial", Font.PLAIN, 16));
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.setBackground(Colorclass.buttoncolor);
        view.setForeground(Color.WHITE);
        view.setFocusPainted(false); 
        view.setOpaque(true); 
		p1.add(view);
		
		loadframe = new JButton("Status");
		loadframe.setBounds(30,273,176,45);
		loadframe.setFont(new Font("Arial", Font.PLAIN, 16));
		loadframe.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loadframe.setBackground(new Color(7,94,84));
		loadframe.setForeground(Color.WHITE);
		loadframe.setFocusPainted(false); 
		loadframe.setOpaque(true); 
		p1.add(loadframe);
		
		delete = new JButton("delete");
		delete.setBounds(542,498,100,37);
		delete.setFont(new Font("Arial", Font.PLAIN, 16));
		delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		delete.setBackground(Colorclass.buttoncolor);
		delete.setForeground(Colorclass.white);
		delete.setFocusPainted(false); 
		delete.setOpaque(true); 
		delete.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	delete.setBackground(Colorclass.buttoncolormouse); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	delete.setBackground(Colorclass.buttoncolor);
		    }
		});
		adminframe.getContentPane().add(delete);
		
		search = new JButton("Search");
		search.setBounds(652,498,100,37);
		search.setFont(new Font("Arial", Font.PLAIN, 16));
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.setBackground(Colorclass.buttoncolor);
		search.setForeground(Colorclass.white);
		search.setFocusPainted(false); 
		search.setOpaque(true); 
		search.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	search.setBackground(Colorclass.buttoncolormouse); 
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	search.setBackground(Colorclass.buttoncolor);
		    }
		});
		adminframe.getContentPane().add(search);
        
        
        try {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    onlinequanty.setText(String.valueOf(Model.countonline()));
                    quanty.setText(String.valueOf(Model.countUser()));
                }
            }, 0, 1000);
        } catch (Exception e) {
            System.err.println("Error occurred during typing animation: " + e.getMessage());
        }
        
        
        
        error = new JLabel();
		error.setBounds(314,474,458,26);
		error.setForeground(Color.red);
		error.setFont(new Font("Arial", Font.ITALIC, 12));
		adminframe.getContentPane().add(error);
		
		model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Mobile");
        model.addColumn("Image");

        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.setRowHeight(150);
        table.getColumnModel().getColumn(4).setCellRenderer((table, value, isSelected, hasFocus, row, column) ->getImageRendererComponent(table, value, isSelected, hasFocus, row, column));

        
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, tabelpanel.getWidth(), tabelpanel.getHeight());
        
        tabelpanel = new JPanel();
        tabelpanel.setLayout(null);
        tabelpanel.setBounds(318, 94, 655, 347);
        
        text = new JTextField();
        text.setBounds(402,498,130,38);
        text.setFont(new Font("Arial", Font.PLAIN, 16));
        adminframe.getContentPane().add(text);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	error.setText("");
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object mobilenum = model.getValueAt(selectedRow, 3); 
                    if (mobilenum != null) {
                        text.setText(mobilenum.toString());
                    }
                }
            }
        });
       
        l2 = new JLabel();
		l2 = new JLabel("mobile:");
		l2.setBounds(314,498,113,27);
		l2.setForeground(Colorclass.white);
		l2.setFont(new Font("Arial", Font.BOLD, 20));
		adminframe.getContentPane().add(l2);
		
		l2.setVisible(false);    
		text.setVisible(false); 
		delete.setVisible(false); 
		search.setVisible(false);
		
        ImageIcon logout = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logout.png"); 
        JLabel logoutLabel = new JLabel(logout);
        logoutLabel.setPreferredSize(new Dimension(logout.getIconWidth(), logout.getIconHeight()));
        logoutLabel.setBounds(939, 23, 50, 55); 
        adminframe.getContentPane().add(logoutLabel);
        logoutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutLabel.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
                ImageIcon logoutyello = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/logoutyellow.png");
                logoutLabel.setIcon(logoutyello);
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	logoutLabel.setIcon(logout);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
            	LoginView l3 = new LoginView();
            	LoginController lc = new LoginController(l3);
            	adminframe.dispose();
            	l3.setVisible(true);
            }
        });
        
        adminframe.getContentPane().add(p1);
        adminframe.getContentPane().add(count);
        adminframe.getContentPane().add(onlinepanel);
		adminframe.setVisible(true);
	}
	public void viewbttonlistner(ActionListener listner) {
		view.addActionListener(listner);
		
	}
	
	public void searchbttonlistner(ActionListener listner) {
		search.addActionListener(listner);
		
	}
	public void deletebttonlistner(ActionListener listner) {
		delete.addActionListener(listner);
		
	}
	
	public void loadframebttonlistner(ActionListener listner) {
		loadframe.addActionListener(listner);
		
	}

	public JButton viewButton() {
		
		return view;
	}
	
	public JButton searchButton() {
		
		return search;
	}
	public JButton deleteButton() {
		
		return delete;
	}
	
	public JButton loadframeButton() {
		
		return loadframe;
	}
	
	public void viewdata() {
		loadframe.setBackground(Colorclass.buttoncolor);
    	view.setBackground(new Color(7,94,84));
    	tabelpanel.setVisible(true);
    	tabelpanel.add(scrollPane);
    	adminframe.getContentPane().add(tabelpanel);
        count.setVisible(false);
        onlinepanel.setVisible(false);
        l2.setVisible(true);    
		text.setVisible(true);
		delete.setVisible(true); 
		search.setVisible(true);
		fetchDataFromDatabase();
		text.setText("");
	}
	
	public void loadframedata() {
		view.setBackground(Colorclass.buttoncolor);
    	loadframe.setBackground(new Color(7,94,84));
        count.setVisible(true);
        onlinepanel.setVisible(true);
        tabelpanel.setVisible(false);
        l2.setVisible(false);    
		text.setVisible(false);
		delete.setVisible(false); 
		search.setVisible(false);
	}
	
	public void deletedata() {
		error.setText("");
    	deleteAccount();
	}
	
	public void searchdata() {
		error.setText("");
    	String mobileNum = text.getText().trim(); 
        if (!mobileNum.isEmpty()) { 
            searcuser(mobileNum);
        }else {
        	error.setText("Enter Mobile number..");
        }
	}
	
	public void deleteAccount() {
		String mobileNum = text.getText().trim();
		if (mobileNum.isEmpty()) {
			error.setText("Enter Mobile number..");
	        return;
	    }
	    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Confirmation", JOptionPane.OK_CANCEL_OPTION);
	    if (confirmation == JOptionPane.OK_OPTION) {
	        try {
	        	boolean success=Model.deletefrofiledata(mobileNum); 
	        	if(success) {
	        		fetchDataFromDatabase();
		        	text.setText("");
	        	}else {
	        		error.setText("Error deleting.. check mobile number.");
	        	}
	        	
	        } catch (Exception e) {
	        	error.setText("Error deleting"+ e.getMessage());
	        }
	    }
	}
	
	private void fetchDataFromDatabase() {
        try {
        	model.setRowCount(0);
            ResultSet resultSet = Model.getDataFromDatabaseadmin();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                byte[] imageData = resultSet.getBytes("image");
                ImageIcon imageIcon = null;

                if (imageData != null) {
                    try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData)) {
                        BufferedImage bufferedImage = ImageIO.read(bis);
                        if (bufferedImage != null) {
                            Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(scaledImage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                model.addRow(new Object[]{id, name, email, mobile, imageIcon});
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private void searcuser(String mobilenum) {
		model.setRowCount(0);
        try {
            ResultSet resultSet = Model.searchadmin(mobilenum);
            boolean found = false;
            while (resultSet.next()) {
            	found = true;
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                byte[] imageData = resultSet.getBytes("image");
                ImageIcon imageIcon = null;

                if (imageData != null) {
                    try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData)) {
                        BufferedImage bufferedImage = ImageIO.read(bis);
                        if (bufferedImage != null) {
                            Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                            imageIcon = new ImageIcon(scaledImage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                model.addRow(new Object[]{id, name, email, mobile, imageIcon});
            }
            
            if (!found) {
            	error.setText("No records found for the provided mobile number.");
            	fetchDataFromDatabase();
                }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Component getImageRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        if (value != null) {
            label.setIcon((ImageIcon) value);
            label.setHorizontalAlignment(JLabel.CENTER);
        }
        return label;
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
                    System.err.println("Error occurred during typing animation: " + e.getMessage());
                    timer.cancel();
                }
            }
        }, 0, 100);
    }
	
	public void setVisible(boolean b) {	
		
	}
}
