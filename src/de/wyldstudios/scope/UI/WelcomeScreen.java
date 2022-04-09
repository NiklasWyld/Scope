package de.wyldstudios.scope.UI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import de.wyldstudios.scope.GameInit;
import de.wyldstudios.scope.UI.Logic.*;

public class WelcomeScreen extends JPanel {
	private JLabel start_button;
    private JLabel settings;
	private JLabel close;
    private JCheckBox backgroundmusic;
	private JLabel info;

	/* 0 = Start, 1 = Close */
	private int choice = 0;
	private WelcomeScreenKeyHandler keyhandler = new WelcomeScreenKeyHandler();
	private BackgroundMusicManager backgroundMusicManager = new BackgroundMusicManager();

	public WelcomeScreen() {
		componentHandling();
		setLayout(null);
		setBounds(0, 0, 800, 600);
		setBackground(Color.black);
		setVisible(true);
		setFocusable(true);
		addKeyListener(keyhandler);
		repaint();
	}
	
	private void componentHandling() {
		JLabel note = new JLabel("Scope");
		note.setBounds(330, 100, 300, 50);
		note.setFont(new Font("Arial", Font.BOLD, 50));
		note.setForeground(Color.white);
		this.add(note);
		
		start_button = new JLabel("Start");
		start_button.setBounds(370, 250, 100, 50);
		start_button.setForeground(Color.red);
		start_button.setFont(new Font("Arial", Font.BOLD, 30));
		this.add(start_button);

		close = new JLabel("Close");
		close.setBounds(365, 310, 100, 50);
		close.setForeground(Color.white);
		close.setFont(new Font("Arial", Font.BOLD, 30));
		this.add(close);

        backgroundmusic = new JCheckBox("Background Music");
        backgroundmusic.setBounds(10, 10, 160, 15);
        backgroundmusic.setBackground(Color.black);
        backgroundmusic.setForeground(Color.white);
		backgroundMusicManager.backgroundMusicManagement(backgroundmusic);
		backgroundmusic.setSelected(true);
        this.add(backgroundmusic);

		info = new JLabel("Short game instructions: ESC = pause game | The higher your level, the faster you are");
		info.setBounds(160, 544, 600, 15);
		info.setForeground(Color.white);
		this.add(info);
	}

	public void setFocusOfButton(int choice) {
		GameInit.soundPlayer.play();
		if (choice == 0) {
			this.choice = 0;
			close.setForeground(Color.white);
			start_button.setForeground(Color.red);
		} else if (choice == 1) {
			this.choice = 1;
			close.setForeground(Color.red);
			start_button.setForeground(Color.white);
		}
	}

	public void runLogic() {
		if (choice == 0) {
			this.setVisible(false);
			GameInit.loadGame();
			removeKeyListener(keyhandler);
		} else if (choice == 1) {
			System.exit(0);
		}
	}

	public void updateKeyListener() {
		this.addKeyListener(keyhandler);
	}
}
