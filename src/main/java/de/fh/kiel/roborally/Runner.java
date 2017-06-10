package de.fh.kiel.roborally;

import de.fh.kiel.roborally.controller.MainController;
import de.fh.kiel.roborally.model.GameView;
import de.fh.kiel.roborally.model.PlayerView;
import javafx.application.Application;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.Stand

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Runner {

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
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Runner.class).headless(false).run(args);
        MainController mainController = context.getBean(MainController.class);
        mainController.show();

        UIManager.getLookAndFeelDefaults()
                .put("defaultFont", new Font("Segoe UI", Font.BOLD, 14));
    }
}
