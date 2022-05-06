package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	Stack<String> hang = new Stack<String>();
	int lives = 10;
	StringBuilder builder = new StringBuilder("");
	String hangWord = "";
	JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
	public static void main(String[] args) {
        Hangman man = new Hangman();
        man.setup();
	}
	public void setup() {
        frame.add(panel);
        panel.add(label);
        frame.addKeyListener(this);
        frame.setVisible(true);
        frame.pack();
   
		String num = JOptionPane.showInputDialog("Enter a number from 1 to 266");
		int amm = Integer.parseInt(num);
		for (int i = 0; i < amm; i++) {
			String push = Utilities.readRandomLineFromFile("dictionary.txt");
			hang.add(push);
			if (hang.contains(push)==false) {
				push = Utilities.readRandomLineFromFile("dictionary.txt");
				hang.add(push);
			}
		}
		newWord();
	}
	public void newWord() {
		hangWord = hang.pop();
		System.out.println(hangWord);
		for (int i = 0; i < hangWord.length(); i++) {
			builder.append("_");
			label.setText(builder.toString());
			frame.pack();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int lifeCheck = 0;
		int popCheck = 0;
		for (int i = 0; i < builder.length(); i++) {
			if (hangWord.charAt(i)==e.getKeyChar()) {
				lifeCheck+=1;
				String rep = "" + hangWord.charAt(i);
				label.setText(builder.replace(i, i+1, rep).toString());
				frame.pack();
			}
		}
		for (int i = 0; i < hangWord.length(); i++) {
			String check = "" + builder.toString().charAt(i);
			if (check.equalsIgnoreCase("_")) {
				popCheck+=1;
			}
		}
		if (popCheck==0) {
			lives = 10;
			builder.delete(0, builder.length());
			newWord();
		}
		if (lifeCheck==0) {
			lives-=1;
		}
		if (lives==0) {
			JOptionPane.showMessageDialog(null, "You lost but you can continue if you'd like to!");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
