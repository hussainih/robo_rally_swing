package de.fh.kiel.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by moham on 11-Jun-17.
 */
public class JoinGame extends JFrame{
    private JPanel pnlMain;

    private JTextArea roboRallyTextArea;
    private JTable tblGames;
    private JButton btnJoin;

    public JButton getBtnJoin() {
        return btnJoin;
    }

    public void setBtnJoin(JButton btnJoin) {
        this.btnJoin = btnJoin;
    }

    public JTable getTblGames() {
        return tblGames;
    }

    public void setTblGames(JTable tblGames) {
        this.tblGames = tblGames;
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

    public void setPnlMain(JPanel pnlMain) {
        this.pnlMain = pnlMain;
    }

    public JTextArea getRoboRallyTextArea() {
        return roboRallyTextArea;
    }

    public void setRoboRallyTextArea(JTextArea roboRallyTextArea) {
        this.roboRallyTextArea = roboRallyTextArea;
    }

    public JoinGame(){
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(pnlMain);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


}
