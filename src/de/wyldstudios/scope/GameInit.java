package de.wyldstudios.scope;

/*
ToDo:
- || Labyrinth ||
- || Ungerade Richtungen ||
 */

import javax.swing.*;

import de.wyldstudios.scope.Music.MusicPlayer;
import de.wyldstudios.scope.Music.SoundPlayer;
import de.wyldstudios.scope.UI.*;
import de.wyldstudios.scope.UI.Logic.WelcomeScreenKeyHandler;
import de.wyldstudios.scope.Game.*;

import java.awt.*;

public class GameInit extends JFrame {
	public static GameInit gameInit = new GameInit();
	public static WelcomeScreen welcomeScreen = new WelcomeScreen();
	public static MusicPlayer musicPlayer = new MusicPlayer("musik.wav");
	public static SoundPlayer soundPlayer = new SoundPlayer("click.wav");
	public static SoundPlayer levelUpPlayer = new SoundPlayer("levelup.wav");
	public static Game game = new Game();
	public static Settings settings = new Settings();

	public GameInit() {
		setSize(800, 600);
		setTitle("Scope");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.jpeg"));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		gameInit.add(welcomeScreen);
		welcomeScreen.repaint();
		welcomeScreen.grabFocus();

		game.setVisible(false);

		musicPlayer.loop();
	}

	public static void loadGame() {
		gameInit.add(game);
		game.setVisible(true);
		game.repaint();
		game.grabFocus();
	}

	public static void loadWelcomeScreen() {
		welcomeScreen.setVisible(true);
		welcomeScreen.repaint();
		welcomeScreen.grabFocus();
	}

	public static void loadSettings() {
		gameInit.add(settings);
		settings.setVisible(true);
		settings.repaint();
		settings.grabFocus();
	}
}
