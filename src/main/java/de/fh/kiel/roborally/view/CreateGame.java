package de.fh.kiel.roborally.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CreateGame extends JFrame {
    private JPanel pnlMain;
    private JTextField gameNameTextField;
    private JTextArea gameNameTextArea;
    private JTextArea roboRallyTextArea;
    private JTextField playerNameTextField;
    private JComboBox maxRobotsComboBox;
    private JButton createGameButton;
    private JFrame preGame = new JFrame();
    public JComboBox getMaxRobotsComboBox() {
        return maxRobotsComboBox;
    }

    public void setMaxRobotsComboBox(JComboBox maxRobotsComboBox) {
        this.maxRobotsComboBox = maxRobotsComboBox;
    }

    public JButton getCreateGameButton() {
        return createGameButton;
    }

    public void setCreateGameButton(JButton createGameButton) {
        this.createGameButton = createGameButton;
    }

    public JTextArea getGameNameTextArea() {
        return gameNameTextArea;
    }

    public void setGameNameTextArea(JTextArea gameNameTextArea) {
        this.gameNameTextArea = gameNameTextArea;
    }

    public JTextArea getRoboRallyTextArea() {
        return roboRallyTextArea;
    }

    public void setRoboRallyTextArea(JTextArea roboRallyTextArea) {
        this.roboRallyTextArea = roboRallyTextArea;
    }

    public JTextField getPlayerNameTextField() {
        return playerNameTextField;
    }

    public void setPlayerNameTextField(JTextField playerNameTextField) {
        this.playerNameTextField = playerNameTextField;
    }

    public JTextField getGameNameTextField() {
        return gameNameTextField;
    }

    public void setGameNameTextField(JTextField gameNameTextField) {
        this.gameNameTextField = gameNameTextField;
    }

    public CreateGame() {
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setMaximumSize(DimMax);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(pnlMain);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for(int i = 2; i <= 6; i++){
            maxRobotsComboBox.addItem(i);
        }
    }
}
