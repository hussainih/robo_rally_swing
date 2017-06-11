package de.fh.kiel.roborally;

import de.fh.kiel.roborally.controller.MainController;
import de.fh.kiel.roborally.model.GameView;
import de.fh.kiel.roborally.model.PlayerView;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class Runner extends JFrame{

    /**
     * Storing globally the GAME which this client is a part of
     */
    private GameView game = GameView.createGameView();
    @Getter
    public GameView getGameView(){
        return this.game;
    }
    @Setter
    public void setGameView(GameView game){
        this.game.setGameView(game.getId(), game.getName(), game.getMaxRobotCount(), game.getCurrentRobotCount());
    }

    private PlayerView player = PlayerView.createPlayerView();

    @Getter
    public PlayerView getPlayerView(){
        return player;
    }

    @Setter
    public void setPlayerView(PlayerView playerView){
        this.player.setPlayerView(playerView.getId(), playerView.getName(), playerView.getSecret(), playerView.getClientUri(), playerView.getRobotName());
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        //SpringApplication.run(Runner.class, args);
        mainController.show();


        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Runner.class)
                .headless(false).run(args);


//        UIManager.getLookAndFeelDefaults()
//                .put("defaultFont", new Font("Segoe UI", Font.BOLD, 14));
    }
}
