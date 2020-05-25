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
	 restart();
}

void restart() {
	//System.out.println("re");
	playWord=Names.pop();
	a=playWord.toCharArray();
	underScore="";
	System.out.println(playWord);
	for(int i=0; i<a.length; i++) {
		underScore+="__ ";
	}
	label.setText(underScore);
	lives=6;
	}//




void GUI() {
	frame.setVisible(true);
	frame.add(panel);
	frame.addKeyListener(this);
	panel.add(label);
	frame.pack();
	label.setText(underScore);
}

@Override
public void keyPressed(KeyEvent e) {
	//System.out.println(lives);
	StringBuilder sb=new StringBuilder(underScore);
	// TODO Auto-generated method stub
	boolean charFound=false;
	for(int i=0; i<a.length; i++) {
		if(e.getKeyChar()==a[i]) {
			charFound=true;
			sb.replace(i*3, i*3+2, e.getKeyChar()+" ");
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
			 restart();
		 }
		 if(again.equals("no")) {
			 System.exit(0);
		 }
	 }
	underScore=sb.toString();
	if(!underScore.contains("_")) {
		restart();
	}
	label.setText(underScore);
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
