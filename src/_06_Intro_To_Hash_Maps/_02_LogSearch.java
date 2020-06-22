package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener{
	HashMap<Integer, String> logs = new HashMap<Integer, String>();
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JButton button=new JButton("Add");
	JButton button1=new JButton("Search");
	JButton button2=new JButton("View");
	JButton button3=new JButton("Remove");
	public static void main(String[] args) {
		new _02_LogSearch().GUI();
	}
	void GUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			String I=JOptionPane.showInputDialog("Enter an ID number");
			int ID=Integer.parseInt(I);
			String name=JOptionPane.showInputDialog("Enter a name");
			logs.put(ID, name);
		}
		if(e.getSource()==button1) {
			String I1=JOptionPane.showInputDialog("Enter an ID number");
			int ID1=Integer.parseInt(I1);
			if(logs.containsValue(ID1)) {
				for(Integer i : logs.keySet()){
					JOptionPane.showMessageDialog(null, " The person with that ID is named " + i);
				}	
			}
			else {
				JOptionPane.showMessageDialog(null, "That entry does not exist");
			}
		}
	}
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	
}
