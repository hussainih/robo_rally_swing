package de.fh.kiel.roborally.view;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel pnlMain;
    private JButton createGameButton;
    private JTextPane roboRallyTextPane;
    private JButton joinGameButton;
    private JButton exitButton;

    public JTextPane getRoboRallyTextPane() {
        return roboRallyTextPane;
    }

    public void setRoboRallyTextPane(JTextPane roboRallyTextPane) {
        this.roboRallyTextPane = roboRallyTextPane;
    }

    public JButton getJoinGameButton() {
        return joinGameButton;
    }

    public void setJoinGameButton(JButton joinGameButton) {
        this.joinGameButton = joinGameButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

    public JPanel getPnlMain() {
        return pnlMain;
    }

    public void setPnlMain(JPanel pnlMain) {
        this.pnlMain = pnlMain;
    }

    public JButton getCreateGameButton() {
        return createGameButton;
    }

    public void setCreateGameButton(JButton createGameButton) {
        this.createGameButton = createGameButton;
    }

    public Main() {
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(pnlMain);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
