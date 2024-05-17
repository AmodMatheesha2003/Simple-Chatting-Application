package chatme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomDialog extends JDialog {
    public CustomDialog(JFrame parent, String message, String title) {
        super(parent, title, true);
        JPanel panel = new JPanel(new BorderLayout());
        
        JLabel label = new JLabel(message);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(label, BorderLayout.CENTER);
        
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
        okButton.setBackground(new Color(17, 184, 44));
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
        okButton.setForeground(Color.white);
        okButton.setFocusPainted(false); 
        okButton.setOpaque(true); 
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(okButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        panel.setBackground(new Color(66, 245, 81)); 
        buttonPanel.setBackground(new Color(66, 245, 81));
        getContentPane().add(panel);
        
        
        
        setSize(300, 150); 
        setLocationRelativeTo(parent);
    }
}
