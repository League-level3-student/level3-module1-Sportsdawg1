package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
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
		frame.pack();
		for (int i = 0; i < num; i++) {
			strings.push(u.readRandomLineFromFile("dictionary.txt"));
		}
		setupLabel(strings.pop());
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
	
}
