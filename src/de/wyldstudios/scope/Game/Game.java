package de.wyldstudios.scope.Game;

import de.wyldstudios.scope.GameInit;
import de.wyldstudios.scope.Music.SoundPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends JPanel {
    private PlayerMovement keylistener = new PlayerMovement();
    private CollisionDetect collisiondetect = new CollisionDetect();
    public static JLabel player;
    public static JLabel upgrade = new JLabel();

    public int level = 0;
    private int deaths = 0;

    private JLabel level_display = new JLabel("Score: " + level);
    private JLabel death_display = new JLabel("Deaths: " + deaths);

    public Game() {
        setLayout(null);
        setBounds(0, 0, 800, 600);
        setBackground(Color.black);
        setVisible(true);
        setFocusable(true);
        grabFocus();
        addKeyListener(keylistener);
        playerSetting();
        levelSettings();
        deathSetting();
        generateUpgrade();
        repaint();
    }

    public void proveForPlayerCollisionOnWall() {
        if(GameInit.game.player.getY() >= 550 || GameInit.game.player.getX() >= 750 || GameInit.game.player.getY() < 0 || GameInit.game.player.getX() < 0) {
            GameInit.game.player.setLocation(370, 250);
            deaths++;
            death_display.setText("Deaths: " + deaths);
        }
    }

    public void proveForUpgradeCollision() {
        if(collisiondetect.intersects(player, upgrade)) {
            GameInit.levelUpPlayer.play();
            level++;
            level_display.setText("Score: " + level);
            generateUpgrade();
            updateSpeed();
        }
    }

    private void levelSettings() {
        level_display.setBounds(10, 10, 200, 20);
        level_display.setForeground(Color.white);
        this.add(level_display);
    }

    private void playerSetting() {
        player = new JLabel();
        player.setOpaque(true);
        player.setBackground(Color.red);
        player.setBounds(370, 250, 50, 50);
        this.add(player);
    }

    private void deathSetting() {
        death_display.setBounds(11, 30, 200, 20);
        death_display.setForeground(Color.white);
        this.add(death_display);
    }

    private void generateUpgrade() {
        int random_x = ThreadLocalRandom.current().nextInt(1, 750 + 1);
        int random_y = ThreadLocalRandom.current().nextInt(1, 550 + 1);

        upgrade.setOpaque(true);
        upgrade.setBackground(Color.green);
        upgrade.setBounds(random_x, random_y, 20, 20);
        this.add(upgrade);
    }

    private void updateSpeed() {
        if(level == 10) {
            keylistener.speed = 10;
            level_display.setForeground(Color.white);
        } else if(level == 50) {
            keylistener.speed = 20;
            level_display.setForeground(Color.green);
        } else if(level == 100) {
            keylistener.speed = 30;
            level_display.setForeground(Color.blue);
        } else if(level == 500) {
            keylistener.speed = 40;
            level_display.setForeground(Color.yellow);
        } else if(level == 1000) {
            keylistener.speed = 50;
            level_display.setForeground(Color.red);
        }
    }

    public void loadMenu() {
        this.setVisible(false);
        GameInit.welcomeScreen.setVisible(true);
        GameInit.welcomeScreen.updateKeyListener();
        GameInit.welcomeScreen.grabFocus();
        GameInit.welcomeScreen.updateKeyListener();
    }
}
