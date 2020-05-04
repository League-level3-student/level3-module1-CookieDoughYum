package _04_HangMan;

import javax.swing.JOptionPane;

public class HangMan{
public static void main(String[] args) {
	HangMan hm=new HangMan();
  hm.startGame();
  Utilities.readRandomLineFromFile("dictionary.txt");
}	

void startGame() {
	JOptionPane.showInputDialog("Pick a number that is up to 266" );
}
	
	
}
