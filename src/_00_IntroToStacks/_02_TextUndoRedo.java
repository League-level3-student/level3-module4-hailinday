package _00_IntroToStacks;

import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JTextField field = new JTextField();
	StringBuilder builder = new StringBuilder("");
	public static void main(String[] args) {
		_02_TextUndoRedo something = new _02_TextUndoRedo();
		something.setup();
	}
	public void setup() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.pack();
	}
	public void redo() {
		
	}
	public void undo() {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (Character.isAlphabetic(e.getKeyChar()) || Character.isDigit(e.getKeyChar()) || Character.isSpace(e.getKeyChar())) {
			label.setText(builder.append(e.getKeyChar()).toString());
			frame.pack();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
			if (builder.toString().equals("")) {
				System.out.println("bbbbbbb");
			} else {
				System.out.println("nnn");
				label.setText(builder.deleteCharAt(builder.length()-1).toString());
			}
		}
		frame.pack();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
