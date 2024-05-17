package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrameController implements ActionListener{
	private AdminFrameView admin;
	public AdminFrameController(AdminFrameView admin) {
		this.admin=admin;
		
		admin.viewbttonlistner(this);
		admin.searchbttonlistner(this);
		admin.deletebttonlistner(this);
		admin.loadframebttonlistner(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == admin.viewButton()) {
			admin.viewdata();
			 }	
		if (e.getSource() == admin.searchButton()) {
			admin.searchdata();
			 }	
		if (e.getSource() == admin.deleteButton()) {
			admin.deletedata();
			 }	
		if (e.getSource() == admin.loadframeButton()) {
			admin.loadframedata();
			 }	
    }
}
