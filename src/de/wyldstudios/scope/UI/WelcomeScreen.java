package de.wyldstudios.scope.UI;

import java.awt.*;
import javax.swing.*;

import de.wyldstudios.scope.GameInit;
import de.wyldstudios.scope.UI.Logic.*;

public class WelcomeScreen extends JPanel {
	public JLabel start_button;
	public JLabel settings;
	public JLabel close;
	public JLabel info;

	public int choice = 0;
	private WelcomeScreenKeyHandler keyhandler = new WelcomeScreenKeyHandler();

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

		settings = new JLabel("Settings");
		settings.setBounds(350, 310, 200, 50);
		settings.setForeground(Color.white);
		settings.setFont(new Font("Arial", Font.BOLD, 30));
		this.add(settings);

		close = new JLabel("Close");
		close.setBounds(365, 370, 100, 50);
		close.setForeground(Color.white);
		close.setFont(new Font("Arial", Font.BOLD, 30));
		this.add(close);

		info = new JLabel("Short game instructions: ESC = pause game | The higher your level, the faster you are | Check out settings");
		info.setBounds(60, 544, 700, 15);
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

	public void resetGame() {
		GameInit.game.player.setLocation(370, 250);
		GameInit.game.level = 0;
		GameInit.game.level_display.setText("Score: " + GameInit.game.level);
		GameInit.welcomeScreen.choice = 0;
		GameInit.welcomeScreen.settings.setForeground(Color.white);
		GameInit.welcomeScreen.start_button.setForeground(Color.red);
		GameInit.game.level_display.setForeground(Color.white);
		this.grabFocus();
	}

	public void runLogic() {
		if (choice == 0) {
			this.setVisible(false);
			GameInit.loadGame();
		} else if (choice == 1) {
			this.setVisible(false);
			GameInit.loadSettings();
		} else if (choice == 2) {
			System.exit(0);
		}
	}
}
