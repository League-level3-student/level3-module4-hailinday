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
	public static void main(String[] args) {
        Hangman man = new Hangman();
        man.setup();
	}
	public void setup() {
		JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        frame.add(panel);
        panel.add(label);
        label.addKeyListener(this);
        frame.setVisible(true);
        frame.pack();
        
		Stack<String> hang = new Stack<String>();
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
		String hangWord = hang.pop();
		String text = "";
		for (int i = 0; i < hangWord.length(); i++) {
			text = text + "_";
			label.setText(text);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
