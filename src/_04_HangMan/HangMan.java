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
	playWord=Names.pop();
	a=playWord.toCharArray();
	underScore="";
	for(int i=0; i<a.length; i++) {
		underScore+="__ ";
	}
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
	StringBuilder sb=new StringBuilder(underScore);
	// TODO Auto-generated method stub
	for(int i=0; i<a.length; i++) {
		if(e.getKeyChar()==a[i]) {
			sb.replace(i*3, i*3+2, e.getKeyChar()+" ");
		}
		else {
			lives-=1;
		}
	}
	underScore=sb.toString();
	if(!underScore.contains("_")) {
		label.setText("");
		restart();
		lives=6;
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
