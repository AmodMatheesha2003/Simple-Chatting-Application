package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotpasswordController implements ActionListener{
	private ForgotpasswordView crframe;
	public ForgotpasswordController(ForgotpasswordView crframe) {
		this.crframe=crframe;
		
		crframe.forgotpwttonlistner(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == crframe.forgotpwButton()) {
			crframe.createbuttonvalidate();
			 }	
    }
}
