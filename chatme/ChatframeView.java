package chatme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;

public class ChatframeView {
    private JFrame f1;
    private JTextField t1;
    private JButton b1;
    private JLabel imageLabe2, imageLabelprf, onlinedotlabel, onlineoffline;
    private String status;
    public String Receiver, sender, mobile;
    private ImageIcon prf;
    private byte[] displayimage;
    private Image scaledImage;
    private Timer timer;
    private JPanel panel1;
    int idfordelete;

    public ChatframeView(String sender, String Receiver, String mobile, int idfordelete) {
        this.sender = sender;
        this.Receiver = Receiver;
        this.mobile = mobile;
        this.idfordelete = idfordelete;

        f1 = new JFrame("ChatMe");
        f1.setSize(565, 632);
        f1.getContentPane().setLayout(null);
        f1.getContentPane().setBackground(new Color(50, 168, 84));
        f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);

        panel1 = new JPanel();
        panel1.setBackground(new Color(7, 94, 84));
        panel1.setBounds(0, 0, 551, 76);
        panel1.setLayout(null);
        f1.getContentPane().add(panel1);

        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.PLAIN, 14));
        t1.setBounds(25, 548, 400, 28);
        f1.getContentPane().add(t1);

        b1 = new JButton("Send");
        b1.setBounds(435, 547, 90, 28);
        b1.setBackground(new Color(7, 94, 84));
        b1.setForeground(Color.white);
        f1.getContentPane().add(b1);

        JLabel label = new JLabel();
        label.setText(Receiver);
        label.setBounds(223, 15, 292, 51);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(Color.white);
        panel1.add(label);

        onlineoffline = new JLabel();
        onlineoffline.setBounds(233, 36, 292, 51);
        onlineoffline.setFont(new Font("Arial", Font.ITALIC, 14));
        onlineoffline.setForeground(Color.white);
        panel1.add(onlineoffline);

        ImageIcon onlinedot = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-100--16.png");
        onlinedotlabel = new JLabel(onlinedot);
        onlinedotlabel.setPreferredSize(new Dimension(onlinedot.getIconWidth(), onlinedot.getIconHeight()));
        onlinedotlabel.setBounds(171, 36, 42, 51);
        panel1.add(onlinedotlabel);

        ImageIcon icon3 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/back4.png");
        imageLabe2 = new JLabel(icon3);
        imageLabe2.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
        imageLabe2.setBounds(25, 10, 42, 43);
        panel1.add(imageLabe2);
        imageLabe2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabe2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    timer.stop();
                    MainFormView mframe = new MainFormView(mobile);
                    MainFormContoller mf = new MainFormContoller(mframe);
                    f1.dispose();
                    mframe.setVisible(true);

                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });

        JScrollPane receiverScrollPane = new JScrollPane();
        receiverScrollPane.setBounds(25, 75, 500, 463);
        f1.getContentPane().add(receiverScrollPane);

        JTextPane receiverArea = new JTextPane();
        receiverScrollPane.setViewportView(receiverArea);
        receiverArea.setEditable(false);

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showprofile();
                showsender(receiverArea);
            }
        });

        timer.start();

        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    b1.doClick();
                }
            }
        };

        t1.addKeyListener(enterKeyListener);

        prf = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/icons8-glyph-96.png");
        imageLabelprf = new JLabel(prf) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                Ellipse2D.Double clip = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
                g2.setClip(clip);
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        imageLabelprf.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabelprf.setBounds(128, 10, 75, 56);
        imageLabelprf.setPreferredSize(new Dimension(prf.getIconWidth(), prf.getIconHeight()));
        panel1.add(imageLabelprf);

        imageLabelprf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserprofileView u1 = new UserprofileView(sender, Receiver, mobile, idfordelete);
                f1.dispose();
                u1.setVisible(true);
            }
        });

        showprofile();

        f1.setVisible(true);
    }

    public void showprofile() {
        try {
            ResultSet findnameresultSet = Model.findimage(Receiver);

            if (findnameresultSet.next()) {
                displayimage = findnameresultSet.getBytes("image");
                status = findnameresultSet.getString("status");
            } else {
                JOptionPane.showMessageDialog(null, "Login failed.");
            }
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(displayimage));
            scaledImage = image.getScaledInstance(imageLabelprf.getWidth(), imageLabelprf.getHeight(), Image.SCALE_SMOOTH);
            imageLabelprf.setIcon(new ImageIcon(scaledImage));

            onlineoffline.setText(status);

            if (status.equals("online")) {
                onlinedotlabel.setVisible(true);
            } else {
                onlinedotlabel.setVisible(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    public void sendbuttonlistner(ActionListener listner) {
        b1.addActionListener(listner);

    }

    public JButton sendButton() {

        return b1;
    }

    public void sendbuttonclick() {
        try {
            String message = t1.getText();
            Model.senddata(sender, Receiver, message);
            t1.setText("");
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
        }
    }

    public void showsender(JTextPane receiverArea) {
        try {
            StyledDocument doc = receiverArea.getStyledDocument();
            SimpleAttributeSet senderStyle = new SimpleAttributeSet();
            StyleConstants.setForeground(senderStyle, Color.BLUE);
            StyleConstants.setFontSize(senderStyle, 16);

            SimpleAttributeSet receiverStyle = new SimpleAttributeSet();
            StyleConstants.setForeground(receiverStyle, Color.RED);
            StyleConstants.setFontSize(receiverStyle, 16);

            ResultSet resultSet = Model.showsenddata(Receiver, sender);
            doc.remove(0, doc.getLength());
            while (resultSet.next()) {
                String message = resultSet.getString("massage");
                String sender2 = resultSet.getString("sname");
                if (sender2.equals(sender)) {
                    doc.insertString(doc.getLength(), " You: " + message + "\n", senderStyle);
                } else {
                    doc.insertString(doc.getLength(), " " + sender2 + ": " + message + "\n", receiverStyle);
                }
            }
            resultSet.close();
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
        }
    }

    public void setVisible(boolean b) {

    }
}
