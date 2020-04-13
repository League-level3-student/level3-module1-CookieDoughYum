package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JButton button=new JButton("Add Name");
	JButton button1=new JButton("View Names");
    ArrayList<String> names=new ArrayList<String>();
	public static void main(String[] args) {
	    _02_GuestBook gb=new _02_GuestBook();
		gb.GUI();
	}
	void GUI() {
		JFrame frame=new JFrame();
		frame.setVisible(true);
		JPanel panel=new JPanel();
		frame.add(panel);
		panel.add(button);
		button.addActionListener(this);
		panel.add(button1);
		button1.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String name=JOptionPane.showInputDialog("Please enter a name to add to the guest book");
			names.add(name);
		}
		if(e.getSource()==button1) {
			String book="";
			for(int i=0; i<names.size(); i++) {
				//System.out.println(i);
				book+=("Guest #" + (i+1) + ": ");
				book+=(names.get(i));
				book+="\n";
			}
			JOptionPane.showMessageDialog(null, book);
		}
	}
	
	
}
