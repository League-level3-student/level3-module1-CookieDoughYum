package _01_IntroToArrayLists;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _02_GuestBook {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	public static void main(String[] args) {
		
	}
	void GUI() {
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		frame.add(panel);
		JButton button=new JButton("Add Name");
		panel.add(button);
		JButton button1=new JButton("View Names");
		panel.add(button1);
		frame.pack();
	}
	
	
}
