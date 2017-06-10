package de.fh.kiel.roborally.controller;

import de.fh.kiel.roborally.Runner;
import de.fh.kiel.roborally.view.PreGame;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;

/**
 * Created by moham on 10-Jun-17.
 */
public class PreGameController {
    private PreGame preGame;
    private JTextArea roboRallyTextArea;
    private JList listPlayer;
    private Runner runner;

    public PreGameController(){
        initComponent();
    }

    private void initComponent() {
        preGame = new PreGame();
        runner = new Runner();

        listPlayer = preGame.getListPlayer();

        final String uri = String.format("http://localhost:8080/games/%s/list", runner.getGameView().getId());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        DefaultListModel newList = new DefaultListModel();
        String result = restTemplate.getForObject(uri, String.class);
        newList.addElement(result);
        listPlayer.setModel(newList);

    }

    public void show(){
        preGame.setVisible(true);
    }
}
