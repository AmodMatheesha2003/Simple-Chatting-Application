package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
	LoginView login1;
	public LoginController(LoginView login1) {
		this.login1=login1;
		
		login1.loginuttonlistner(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login1.LoginButton()) {
			login1.loginvalidate();
			 }	
    }

}
