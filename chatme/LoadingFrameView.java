package chatme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingFrameView {
    private JFrame frame;
    private JLabel loadingNumber;
    private JProgressBar loadingProgress;
    private Timer timer ;
    private static final int MAX_TIME = 3500; 

    public LoadingFrameView() {
        frame = new JFrame("Loading");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(905, 498);
        frame.setLocationRelativeTo(null); 
        frame.setUndecorated(true); 
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Colorclass.framec);

        loadingNumber = new JLabel("0%");
        loadingNumber.setBounds(10,472,53,26);
        loadingNumber.setForeground(Color.red);
        loadingNumber.setFont(new Font("Arial", Font.BOLD, 16));
        frame.getContentPane().add(loadingNumber);

        loadingProgress = new JProgressBar(0, 100);
        loadingProgress.setBounds(51,472,854,26);
        loadingProgress.setForeground(Color.red);
        loadingProgress.setBackground(Colorclass.lightgreen);
        frame.getContentPane().add(loadingProgress);
        
        ImageIcon icon2 = new ImageIcon("C:/Users/USER/Desktop/ChatMe/Image/chatme.gif"); 
        JLabel imageLabe2 = new JLabel(icon2);
        imageLabe2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
        imageLabe2.setBounds(0, 0, 905, 473); 
        frame.getContentPane().add(imageLabe2);

    }

    public void updateProgress(int[] elapsedTime) {
        int progress = (int) ((double) elapsedTime[0] / MAX_TIME * 100);
        progress = Math.min(progress, 100);

        loadingNumber.setText(progress + "%");
        loadingProgress.setValue(progress);
        if (progress == 100) {
            frame.setVisible(false);
            timer.stop();
            LoginView login1 = new LoginView();
            LoginController l1 = new LoginController(login1);
            login1.setVisible(true);
        }
    }

    public void startProgressTimer() {
        final int[] elapsedTime = {0};
        int interval = 100; 
         timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime[0] += interval;
                updateProgress(elapsedTime);
            }
        });
        timer.start();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
