package com.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<IPlayer> players;

    public PlayerManager() {
        players = new ArrayList<>();
    }

    public void addPlayer() {
        addPlayer(getNextName());
    }

    public void addPlayer(IHand hand) {
        addPlayer(getNextName(), hand);
    }

    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }

    public void addPlayer(String name, IHand hand) {
        this.players.add(new Player(name, hand));
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    private String getNextName() {
        return "Player " + players.size() + 1;
    }
}
