package de.fh.kiel.roborally.controller;

import de.fh.kiel.roborally.Runner;
import de.fh.kiel.roborally.model.GameView;
import de.fh.kiel.roborally.model.PlayerView;
import de.fh.kiel.roborally.view.CreateGame;
//import org.springframework.http.converter.FormHttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGameController {
    private CreateGame createGame;
    private JTextField gameNameTextField;
    private JTextArea gameNameTextArea;
    private JTextField playerNameTextField;
    private JComboBox maxRobotsComboBox;
    private JButton createGameButton;
    private Runner runner;

    public CreateGameController() {
        initComponent();
        initListeners();
    }

    public void show(){
        createGame.setVisible(true);
    }

    private void initComponent() {
        createGame = new CreateGame();
        runner = new Runner();

        gameNameTextField = createGame.getGameNameTextField();
        gameNameTextArea = createGame.getGameNameTextArea();
        playerNameTextField = createGame.getPlayerNameTextField();
        maxRobotsComboBox = createGame.getMaxRobotsComboBox();
        createGameButton = createGame.getCreateGameButton();
    }

    private void initListeners(){
        createGameButton.addActionListener(new CreateGameButtonListener());
    }

    private class CreateGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            String uri = "http://localhost:8080/games/create";

//            restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

            GameView gameView = GameView.createGameView();
            gameView.setGameView("",gameNameTextField.getText(),(Integer)maxRobotsComboBox.getSelectedItem(), 1);

            PlayerView playerView = PlayerView.createPlayerView();
            playerView.setPlayerView("", playerNameTextField.getText(), "secret", "", "");

           try {
               runner.setGameView(restTemplate.postForObject(uri, gameView, GameView.class));
               uri = String.format("http://localhost:8080/games/%s/join", runner.getGameView().getId());
               runner.setPlayerView(restTemplate.postForObject(uri, playerView, PlayerView.class));
           }catch(NoClassDefFoundError ex){

           }

            System.out.println(runner.getGameView().getId());

            //LOAD NEXT PAGE
            createGame.dispose();
            PreGameController preGameController = new PreGameController();
            preGameController.show();
        }
    }
}
