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
	public int randomInt;
	public ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		_06_IPodShuffle shuffle = new _06_IPodShuffle();
		shuffle.setup();
	}
	private void setup() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("surprise");
		panel.add(button);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		songs.add(new Song("/Users/league/Desktop/level3-module1-Sportsdawg1/src/_01_IntroToArrayLists/ACDC - Thunderstruck (Official Music Video).mp3"));
		songs.add(new Song("/Users/league/Desktop/level3-module1-Sportsdawg1/src/_01_IntroToArrayLists/Miley Cyrus - Party In The U.S.A. (Official Music Video).mp3"));
		songs.add(new Song("/Users/league/Desktop/level3-module1-Sportsdawg1/src/_01_IntroToArrayLists/Immigrant Song (2007 Remaster).mp3"));
		songs.add(new Song("/Users/league/Desktop/level3-module1-Sportsdawg1/src/_01_IntroToArrayLists/Journey - Don't Stop Believin' (Audio).mp3"));
		songs.add(new Song("/Users/league/Desktop/level3-module1-Sportsdawg1/src/_01_IntroToArrayLists/Kenny Loggins - Danger Zone (Audio).mp3"));
		songs.get(randomInt).stop();
		for (int i = 0; i < songs.size(); i++) {
			songs.get(i).stop();
		}
		randomInt = r.nextInt(5);
		songs.get(randomInt).play();
	}
}