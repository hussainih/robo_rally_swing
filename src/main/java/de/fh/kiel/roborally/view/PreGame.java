package de.fh.kiel.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moham on 10-Jun-17.
 */
public class PreGame extends JFrame{
    private JTextArea roboRallyTextArea;
    private JList listPlayer;
    private JPanel pnlMain;

    public JTextArea getRoboRallyTextArea() {
        return roboRallyTextArea;
    }

    public void setRoboRallyTextArea(JTextArea roboRallyTextArea) {
        this.roboRallyTextArea = roboRallyTextArea;
    }

    public JList getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(JList listPlayer) {
        this.listPlayer = listPlayer;
    }

    public PreGame(){
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(pnlMain);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
