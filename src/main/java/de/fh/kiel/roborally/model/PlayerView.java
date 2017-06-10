package de.fh.kiel.roborally.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PlayerView {
    private String id;
    private String name;
    private String clientUri;
    private String robotName;
    private String secret;
    private static PlayerView instance = null;


    /**
     * Creates a new PlayerView.
     *
     * @param name      the name a PlayerView has given themselves
     * @param secret    the secret provided by the game server in order to verify the identity of this playerView; for
     *                  security reasons only a hash should be provided
     * @param clientUri the URI where the playerView can be reached via http; for example http://localhost:8081/
     * @param robotName the name of the Robot, for example Smash Bot
     */
    public void setPlayerView(String id, String name,String secret,String clientUri,String robotName) {
        this.id = id;
        this.name = name;
        this.secret = secret;
        this.clientUri = clientUri;
        this.robotName = robotName;
    }

    private PlayerView(){

    }

    public static PlayerView createPlayerView(){
        if(instance == null){
            instance = new PlayerView();
        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClientUri() {
        return clientUri;
    }

    public String getRobotName() {
        return robotName;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof PlayerView)) {
            return false;
        }

        PlayerView playerView = (PlayerView) o;

        return new EqualsBuilder().append(id, playerView.id).append(name, playerView.name).append(clientUri, playerView.clientUri).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(clientUri).toHashCode();
    }
}
