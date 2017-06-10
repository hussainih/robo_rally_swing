package de.fh.kiel.roborally.controller;

import de.fh.kiel.roborally.view.CreateGame;
import de.fh.kiel.roborally.view.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private Main main;
    private JButton createGameButton;
    private JTextPane roboRallyTextPane;
    private JButton joinGameButton;
    private JButton exitButton;

    public MainController() {
        initComponent();
        initListeners();
    }

    public void show(){
        main.setVisible(true);
    }

    private void initComponent() {
        main = new Main();

        createGameButton = main.getCreateGameButton();
        roboRallyTextPane = main.getRoboRallyTextPane();
        joinGameButton = main.getJoinGameButton();
        exitButton = main.getExitButton();
    }

    private void initListeners(){
        exitButton.addActionListener(new ExitButtonListener());
        createGameButton.addActionListener(new CreateGameButtonListener());
        joinGameButton.addActionListener(new JoinGameButtonListener());
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class CreateGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.dispose();
            CreateGameController createGameController = new CreateGameController();
            createGameController.show();
        }
    }

    private class JoinGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            main.dispose();
            JoinGameController joinGameController = new JoinGameController();
            joinGameController.show();
        }
    }
}
