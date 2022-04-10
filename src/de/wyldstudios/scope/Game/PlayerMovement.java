package de.wyldstudios.scope.Game;

import de.wyldstudios.scope.GameInit;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMovement implements KeyListener {
    public int speed = 10;

    @Override
    public void keyTyped(KeyEvent e) {
        GameInit.game.proveForPlayerCollisionOnWall();
        GameInit.game.proveForUpgradeCollision();

        switch (e.getKeyChar()) {
            case 'w':
                Game.player.setLocation(Game.player.getX(), Game.player.getY()-speed);
                break;
            case 's':
                Game.player.setLocation(Game.player.getX(), Game.player.getY()+speed);
                break;
            case 'a':
                Game.player.setLocation(Game.player.getX()-speed, Game.player.getY());
                break;
            case 'd':
                Game.player.setLocation(Game.player.getX()+speed, Game.player.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 27) {
            GameInit.game.loadMenu();
        }

        /* CheatCodes
        if(e.isAltDown() && e.getKeyCode() == 71) {
            if(speed == 10) {
                speed = 5;
            } else if(speed == 5) {
                speed = 10;
            }
        }

        if(e.isAltDown() && e.getKeyCode() == 85) {
            if(speed == 10) {
                speed = 20;
            } else if(speed == 20) {
                speed = 10;
            }
        }
         */
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
