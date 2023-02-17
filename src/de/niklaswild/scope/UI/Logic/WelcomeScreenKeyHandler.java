package de.niklaswild.scope.UI.Logic;

import de.niklaswild.scope.GameInit;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WelcomeScreenKeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 38 = up | 40 = down | 10 = enter
        switch (e.getKeyCode()) {
            case 38:
                GameInit.soundPlayer.play();
                if(GameInit.welcomeScreen.choice == 0) {

                } else if(GameInit.welcomeScreen.choice == 1) {
                    GameInit.welcomeScreen.settings.setForeground(Color.white);
                    GameInit.welcomeScreen.start_button.setForeground(Color.red);
                    GameInit.welcomeScreen.choice = 0;
                } else if(GameInit.welcomeScreen.choice == 2) {
                    GameInit.welcomeScreen.close.setForeground(Color.white);
                    GameInit.welcomeScreen.settings.setForeground(Color.red);
                    GameInit.welcomeScreen.choice = 1;
                }
                break;
            case 40:
                GameInit.soundPlayer.play();
                if(GameInit.welcomeScreen.choice == 0) {
                    GameInit.welcomeScreen.choice = 1;
                    GameInit.welcomeScreen.start_button.setForeground(Color.white);
                    GameInit.welcomeScreen.settings.setForeground(Color.red);
                } else if(GameInit.welcomeScreen.choice == 1) {
                    GameInit.welcomeScreen.choice = 2;
                    GameInit.welcomeScreen.settings.setForeground(Color.white);
                    GameInit.welcomeScreen.close.setForeground(Color.red);
                } else if(GameInit.welcomeScreen.choice == 2) {
                    GameInit.welcomeScreen.close.setForeground(Color.red);
                }
                break;
            case 10:
                GameInit.welcomeScreen.runLogic();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
