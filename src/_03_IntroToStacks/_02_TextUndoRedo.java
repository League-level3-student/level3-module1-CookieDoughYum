package _03_IntroToStacks;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class _02_TextUndoRedo implements KeyListener{
	//Stack<Character> TextEditor = new Stack<Character>();
	Stack<Character> DeletedChars = new Stack<Character>();
	JLabel label=new JLabel("");
	public static void main(String[] args) {
		_02_TextUndoRedo tur=new _02_TextUndoRedo();
		tur.GUI();
		
		//String type=JOptionPane.showInputDialog("Type Something");
		//JOptionPane.showMessageDialog(null, " You typed " + tur.label);
	}
	void GUI(){
		JFrame frame=new JFrame();
		JPanel panel=new JPanel();
		frame.add(panel);
		frame.addKeyListener(this);
		panel.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		label.setText(label.getText()+e.getKeyChar());
		//label.setText(TextEditor.pop());
		if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			String labelText = label.getText();
			Char current = labelText.charAt(labelText.length()-1);
			label.setText(labelText.substring(0,labelText.length()-1));
			//label.remove(label.getText()+e.getKeyChar());
			DeletedChars.push(e.getKeyChar());
		}
		if(e.getKeyCode()==KeyEvent.VK_TAB) {
			DeletedChars.pop();
			label.setText(label.getText()+e.getKeyChar());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
