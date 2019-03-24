package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("add name");
	JButton view = new JButton("view names");
	String s = "";
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		_02_GuestBook book = new _02_GuestBook();
		book.createUI();
	}
	void createUI () {
		add.addActionListener(this);
		view.addActionListener(this);
		panel.add(add);
		panel.add(view);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == add) {
			names.add(JOptionPane.showInputDialog("what name"));
		} else if (buttonPressed == view) {
			for (int i = 0; i < names.size(); i++) {
				int num = i+1;
				s = s + "Guest #" + num + ": " + names.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, s);
		}
	}
	
}

	
	

