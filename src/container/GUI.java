package container;
import java.awt.BorderLayout;
import java.awt.GridLayout;



import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
//import container.MessageListener;

 
public class GUI {
	
	public JTextArea text = new JTextArea();
	
	// Setting up interface (GUI)
	public GUI() {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JButton button = new JButton("Update");
		JButton button2 = new JButton("Clear");

		
		JScrollPane textWithScroll = new JScrollPane (text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		
		
		MessageListener click = new MessageListener(text);
		button.addActionListener(click);
		
		ClearFieldListener clickClear = new ClearFieldListener(text);
		button2.addActionListener(clickClear);
		
		frame.add(textWithScroll, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1,2));
		panel.add(button);
		panel.add(button2);
		
		
		frame.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("CSV reader");
		frame.setSize(700, 1000);
		frame.setVisible(true);
		
	}
	
	
	
	// Create an object of "GUI" 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new GUI();
		
	}

}
