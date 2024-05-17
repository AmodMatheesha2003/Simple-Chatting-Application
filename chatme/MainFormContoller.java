package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFormContoller implements ActionListener{
	private MainFormView m1;
	public MainFormContoller(MainFormView m1) {
		this.m1=m1;

		m1.chatbuttonlistner(this);
		m1.addfrbuttonlistner(this);
		m1.reqButtonlistner(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == m1.chatButton()) {
			m1.b1chatframe();
			 }	
		if (e.getSource() == m1.addfrButton()) {
			m1.b2addfreind();
			 }
		if (e.getSource() == m1.reqButton()) {
			m1.b3freindrequest();
			 }
    }
}
