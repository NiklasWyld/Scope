package de.wyldstudios.scope.UI.Logic;

import de.wyldstudios.scope.Game.Game;
import de.wyldstudios.scope.GameInit;
import de.wyldstudios.scope.UI.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UILogic {
	public static void closeCommand(JButton button) {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}

	public static void returnToHome(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameInit.loadWelcomeScreen();
				GameInit.settings.setVisible(false);
			}
		});
	}

	public static void resetGameAction(JButton button) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameInit.welcomeScreen.resetGame();
			}
		});
	}
}
