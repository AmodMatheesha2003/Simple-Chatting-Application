package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

public class ProfileController implements ActionListener{
	private ProfileView f1;
	public ProfileController(ProfileView f1) {
		this.f1=f1;
		
		f1.savedatabuttonlistner(this);
		f1.delButtonlistner(this);
		f1.prfButtonlistner(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == f1.savedataButton()) {
			f1.validsavedata();
			 }	
		if (e.getSource() == f1.delButton()) {
			f1.deleteAccount();
			 }
		if (e.getSource() == f1.prfButton()) {
			f1.selectimage();
			 }
    }
	
}
