package chatme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatframeController implements ActionListener{
	private ChatframeView chat;
	public ChatframeController(ChatframeView chat) {
		this.chat=chat;
		
		chat.sendbuttonlistner(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == chat.sendButton()) {
			chat.sendbuttonclick();
			 }	
    }
}
