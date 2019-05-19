package _04_HangMan;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	String currentString;
	int letterPosition;
	int timesCorrect = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("6");
	JLabel lives = new JLabel("");
	int numLives = 6;
	Utilities u = new Utilities();
	String labelString = "";
	Stack<String> strings = new Stack<String>();
	
	public static void main(String[] args) {
		HangMan h = new HangMan();
		h.setup();
	}
	
	void setup() {
		int num = howManyStrings();
		panel.add(label);
		panel.add(lives);
		frame.add(panel);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.pack();
		for (int i = 0; i < num; i++) {
			strings.push(u.readRandomLineFromFile("dictionary.txt"));
		}
		currentString = strings.pop();
		setupLabel(currentString);
		label.setText(labelString);
	}
	
	void resetWithNewString () {
		currentString = strings.pop();
		setupLabel(currentString);
		label.setText(labelString);
	}
	
	int howManyStrings() {
		String s = JOptionPane.showInputDialog("how many strings");
		return Integer.parseInt(s);
	}
	
	void setupLabel(String s) {
		for (int i = 0; i < s.length(); i++) {
			labelString = labelString + "_";
		}
	}
	
	boolean hasLetter (char c, String s) {
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}
	
	int whichLetter (char c, String s) {
		int letterPos = -1;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				letterPos = i;
			}
		}
		return letterPos;
	}
	
	void updateLabelString (int position, char c) {
		StringBuilder sb = new StringBuilder(labelString);
		sb.setCharAt(position, c);
		
		labelString = sb.toString();
		label.setText(labelString);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char charPressed = e.getKeyChar();
		if(hasLetter(charPressed, currentString)) {
			System.out.println(whichLetter(charPressed, currentString) + " " + currentString);
			letterPosition = whichLetter(charPressed, currentString);
			updateLabelString(letterPosition, charPressed);
			timesCorrect++;
			if (timesCorrect == (currentString.length() + 1) && strings.size() != 0) {
				resetWithNewString();
			} else if (timesCorrect == (currentString.length() + 1) && strings.size() != 0) {
				int itn = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
				if (itn == 0) {
					setup();
				}
			}
		} else {
			numLives--;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
