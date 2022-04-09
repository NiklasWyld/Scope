package de.wyldstudios.scope.UI.Logic;

import de.wyldstudios.scope.GameInit;
import de.wyldstudios.scope.UI.WelcomeScreen;

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
                GameInit.welcomeScreen.setFocusOfButton(0);
                break;
            case 40:
                GameInit.welcomeScreen.setFocusOfButton(1);
                break;
            case 10:
                GameInit.welcomeScreen.runLogic();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
