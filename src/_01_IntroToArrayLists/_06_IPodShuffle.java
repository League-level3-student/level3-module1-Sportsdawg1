package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
		Random r = new Random();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(new Song("/_01_Data_Structures/src/_01_IntroToArrayLists/ACDC - Thunderstruck (Official Music Video).mp3"));
		songs.add(new Song("/_01_Data_Structures/src/_01_IntroToArrayLists/Miley Cyrus - Party In The U.S.A. (Official Music Video).mp3"));
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}
	private void setup() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("surprise");
		panel.add(button);
		frame.add(panel);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}