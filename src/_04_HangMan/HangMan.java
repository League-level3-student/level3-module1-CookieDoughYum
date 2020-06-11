package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	Stack<String> Names=new Stack();
	static String underScore="";
	static String playWord="";
	//char[] a;
	static JFrame frame=new JFrame();
	static JPanel panel=new JPanel();
	static JLabel label=new JLabel();
	int lives=6;
	//static String sb="";
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
	 lives=6;
	 playWord=Names.pop();
	 for(int i=0; i<playWord.length(); i++) {
			underScore+="_";
		}
	 label.setText(underScore);
	 //a=playWord.toCharArray();
	 System.out.println(playWord);
}

/*
 * void restart() { //System.out.println("re"); if(Names.isEmpty()==false) {
 * playWord=Names.pop(); sb=playWord; //System.out.println(playWord +
 * "playWord"); a=playWord.toCharArray(); underScore=""; System.out.println(a);
 * for(int i=0; i<playWord.length(); i++) { underScore+="__ "; }
 * label.setText(underScore); lives=6; } else {
 * JOptionPane.showMessageDialog(null, "There are no words in the list"); } }//
 */



void GUI() {
	frame.setVisible(true);
	frame.add(panel);
	frame.addKeyListener(this);
	panel.add(label);
	frame.pack();
	//label.setText(underScore);
}
//String text="";
@Override
public void keyPressed(KeyEvent e) {
	//System.out.println(lives);
	// TODO Auto-generated method stub
	char guess=e.getKeyChar();
	for(int i=0; i<playWord.length(); i++) {
		if(guess==playWord.charAt(i)) {
			//charFound=true;
			underScore=underScore.substring(0, i)+guess+underScore.substring(i+1);
			//underScore=sb.toString();
			label.setText(underScore);
		}
		else {insert
			lives-=1;
		}
	}
	if(lives==0) {
		 JOptionPane.showMessageDialog(null, "Game Over");
		 System.exit(0);
			 //System.out.println("re");
			 //label.setText(underScore);
			 //System.out.println("Restart");
	 }
	//text=sb.toString()
    }
	//label.setText(underScore);


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	if(label.getText().equals(playWord)) {
		lives=6;
		//not working
		//System.out.println("restart");
		playWord=Names.pop();
		underScore="";
		for(int i=0; i<playWord.length(); i++) {
			underScore=underScore + "_";
		}
		label.setText(underScore);
	}
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
	
}
