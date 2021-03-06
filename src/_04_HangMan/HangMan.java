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
			underScore+="__ " ;
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
	Boolean b=false;
	char guess=e.getKeyChar();
	for(int i=0; i<playWord.length(); i++) {
		if(guess==playWord.charAt(i)) {
			StringBuilder sb=new StringBuilder(underScore);
			//charFound=true;
			//underScore=underScore.substring(0, i*3)+
					//playWord.charAt(i)+" "+" "+guess+underScore.substring((i+1)*3);
			//underScore=sb.toString();
			sb=sb.replace(i*3, (i+1)*3, e.getKeyChar()+" "+" ");
			underScore=sb.toString();
			label.setText(underScore);
			b=true;
		}
	}
	if(b==false) {
		//System.out.println("Hey!");
		lives-=1;
	}
	if(lives==0) {
		 JOptionPane.showMessageDialog(null, "Game Over");
		 String re=JOptionPane.showInputDialog("Would you like to play again?");
		 if(re.equals("yes")) {
			 lives=6;
				//System.out.println("restart");
				playWord=Names.pop();
				underScore="";
				for(int i=0; i<playWord.length(); i++) {
					underScore=underScore + "__ ";
				}
				label.setText(underScore);
				 System.out.println(playWord);	 
		 }
		 else if(re.equals("no")) {
			 System.exit(0);
		 }
		 else {
			 System.out.println("null");
		 }
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
	if(!label.getText().contains("_")) {
		lives=6;
		//not working
		//System.out.println("restart");
		playWord=Names.pop();
		underScore="";
		for(int i=0; i<playWord.length(); i++) {
			underScore=underScore + "__ ";
		}
		label.setText(underScore);
		 System.out.println(playWord);
	}
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
	
}
