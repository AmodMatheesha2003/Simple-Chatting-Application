package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountController implements ActionListener{
	private CreateAccountView crframe;
	public CreateAccountController(CreateAccountView crframe) {
		this.crframe=crframe;
		
		crframe.createbuttonlistner(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == crframe.createButton()) {
			crframe.validatebeforeinsert();
			 }	
    }
}
