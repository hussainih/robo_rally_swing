package de.fh.kiel.roborally.controller;

import de.fh.kiel.roborally.Runner;
import de.fh.kiel.roborally.model.GameView;
import de.fh.kiel.roborally.model.PlayerView;
import de.fh.kiel.roborally.view.JoinGame;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by moham on 11-Jun-17.
 */
public class JoinGameController {
    JoinGame joinGame;
    private JTable tblGames;
    private JButton btnJoin;
    private Runner runner;
    private GameView[] gameViews;

    public JoinGameController(){
        initComponent();
        initListeners();
    }

    public void show(){
        joinGame.setVisible(true);
    }

    private void initComponent() {
        joinGame = new JoinGame();
        runner = new Runner();

        tblGames = joinGame.getTblGames();
        btnJoin = joinGame.getBtnJoin();

        final String uri = "http://localhost:8080/games/list";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        DefaultTableModel newTable = new DefaultTableModel();
        gameViews = restTemplate.getForObject(uri, GameView[].class);

//        newTable.addColumn(gameViews[0]);
        newTable.addColumn("NAME");
        newTable.addColumn("CURRENT ROBOTS");
        newTable.addColumn("MAX ROBOTS");
        newTable.addColumn("ID");
        for (GameView g: gameViews) {
            System.out.println(g.getId());
            Object[] obj = {g.getName(), g.getCurrentRobotCount(), g.getMaxRobotCount(), g.getId()};
            newTable.addRow(obj);
        }
        tblGames.setModel(newTable);
        tblGames.removeColumn(tblGames.getColumnModel().getColumn(3));
    }

    public void initListeners(){
        btnJoin.addActionListener(new JoinGameButtonListener());
    }

    private class JoinGameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameView gameView = GameView.createGameView();
            gameView.setGameView(
                    tblGames.getModel().getValueAt(tblGames.getSelectedRow(),3).toString(),
                    tblGames.getModel().getValueAt(tblGames.getSelectedRow(),0).toString(),
                    Integer.parseInt(tblGames.getModel().getValueAt(tblGames.getSelectedRow(),1).toString()),
                    Integer.parseInt(tblGames.getModel().getValueAt(tblGames.getSelectedRow(),2).toString())
            );
            runner.setGameView(gameView);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

            PlayerView playerView = PlayerView.createPlayerView();
            playerView.setPlayerView("", "CRAZZZZZZy", "secret", "", "");
            String uri = String.format("http://localhost:8080/games/%s/join", runner.getGameView().getId());
            System.out.print(uri);
            System.out.print("^^^^^");
            runner.setPlayerView(restTemplate.postForObject(uri, playerView, PlayerView.class));

            joinGame.dispose();
            PreGameController preGameController = new PreGameController();
            preGameController.show();
        }
    }
}
