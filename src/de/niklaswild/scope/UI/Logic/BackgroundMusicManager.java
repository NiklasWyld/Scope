package de.niklaswild.scope.UI.Logic;

import de.niklaswild.scope.GameInit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundMusicManager {
    public void backgroundMusicManagement(JCheckBox c) {
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameInit.settings.grabFocus();
                if(GameInit.musicPlayer.getCurrentState()) {
                    GameInit.musicPlayer.stop();
                } else {
                    GameInit.musicPlayer.loop();
                }
            }
        });
    }
}
