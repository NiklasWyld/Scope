package de.wyldstudios.scope.Game;

import javax.swing.*;
import java.awt.geom.Area;

public class CollisionDetect {
    public boolean intersects(JLabel objecta, JLabel objectb){
        Area areaA = new Area(objecta.getBounds());
        Area areaB = new Area(objectb.getBounds());

        return areaA.intersects(areaB.getBounds2D());
    }
}
