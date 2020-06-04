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
	String underScore="";
	String playWord;
	char[] a;
	JFrame frame=new JFrame();
	JPanel panel=new JPanel();
	JLabel label=new JLabel();
	int lives=6;
	StringBuilder sb=new StringBuilder();
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
			underScore+="__ ";
		}
	 label.setText(underScore);
	 a=playWord.toCharArray();
	 System.out.println(playWord);
}

void restart() {
	//System.out.println("re");
	if(Names.isEmpty()==false) {
		playWord=Names.pop();
		sb=new StringBuilder(playWord.length());
		//System.out.println(playWord + "playWord");
	a=playWord.toCharArray();
	underScore="";
	System.out.println(a);
	for(int i=0; i<playWord.length(); i++) {
		underScore+="__ ";
	}
	label.setText(underScore);
	lives=6;
	}
	else {
		JOptionPane.showMessageDialog(null, "There are no words in the list");
	}
	}//




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
	boolean charFound=false;
	for(int i=0; i<a.length; i++) {
		if(e.getKeyChar()==a[i]) {
			charFound=true;
			sb=sb.replace(i*3, i*3+2, e.getKeyChar()+" ");
			underScore=sb.toString();
			label.setText(underScore);
		}
	}
	if(!charFound) {
		lives-=1;
	}
	if(lives==0) {
		 JOptionPane.showMessageDialog(null, "Game Over");
		 String again=JOptionPane.showInputDialog("Would you like to play again?");
		 if(again.equals("yes")) {
			 //System.out.println("re");
			 //label.setText(underScore);
			 System.out.println("Restart");
			 restart();
		 }
		 if(again.equals("no")) {
			 System.exit(0);
		 }
	 }
	//text=sb.toString();
	if(!underScore.contains("_")) {
		//not working
		System.out.println("restart");
		restart();
	}
	//label.setText(underScore);
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
