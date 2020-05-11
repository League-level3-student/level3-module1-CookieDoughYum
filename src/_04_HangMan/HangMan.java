package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	Stack<String> Names=new Stack();
	String underScore="";
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	int lives=6;
public static void main(String[] args) {
	HangMan hm=new HangMan();
    hm.startGame();
    hm.GUI();
}	

void startGame() {
	String number=JOptionPane.showInputDialog("Pick a number that is up to 266" );
	 int num=Integer.parseInt(number);
	for(int i=0; i<num; i++) {
		  Names.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		  }
	String playWord=Names.pop();
	char[] a=playWord.toCharArray();
	for(int i=0; i<a.length; i++) {
		underScore+="__ ";
		String guess=JOptionPane.showInputDialog(" What is your guess for character number " + i + " ? ")
	}
}

void GUI() {
	frame.setVisible(true);
	frame.add(panel);
	panel.add(label);
	frame.pack();
	label.setText(underScore);
}
	
}
