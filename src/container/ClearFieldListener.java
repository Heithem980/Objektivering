package container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ClearFieldListener implements ActionListener {
	
	private JTextArea data;

	public ClearFieldListener(JTextArea text) {
		// TODO Auto-generated constructor stub
		this.data = text;
		
		
	}
	
	// This method simply clears the JTextArea on the Frame
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		data.setText("");
	}

	

}
