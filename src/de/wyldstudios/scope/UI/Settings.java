package de.wyldstudios.scope.UI;

import de.wyldstudios.scope.UI.Logic.BackgroundMusicManager;
import de.wyldstudios.scope.UI.Logic.UILogic;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    public JCheckBox backgroundmusic;
    private BackgroundMusicManager backgroundMusicManager = new BackgroundMusicManager();

    public Settings() {
        setLayout(null);
        setBounds(0, 0, 800, 600);
        setBackground(Color.black);
        setVisible(true);
        setFocusable(true);
        componentSetting();
        repaint();
    }

    private void componentSetting() {
        JButton home = new JButton("<-");
        home.setBounds(10, 10, 50, 50);
        UILogic.returnToHome(home);
        this.add(home);

        JButton reset_game = new JButton("Reset Game");
        reset_game.setBounds(325, 230, 200, 30);
        UILogic.resetGameAction(reset_game);
        this.add(reset_game);

        backgroundmusic = new JCheckBox("Background Music");
        backgroundmusic.setBounds(350, 200, 160, 15);
        backgroundmusic.setBackground(Color.black);
        backgroundmusic.setForeground(Color.white);
        backgroundMusicManager.backgroundMusicManagement(backgroundmusic);
        backgroundmusic.setSelected(true);
        this.add(backgroundmusic);
    }


}
