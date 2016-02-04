package com.cards;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private List<IPlayer> players;

    public PlayerManager() {
        players = new ArrayList<>();
    }

    public IPlayer addPlayer() {
        return addPlayer(getNextName());
    }

    public IPlayer addPlayer(IHand hand) {
        return addPlayer(getNextName(), hand);
    }

    public IPlayer addPlayer(String name) {
        IPlayer player = new Player(name);
        this.players.add(player);
        return player;
    }

    public IPlayer addPlayer(String name, IHand hand) {
        IPlayer player = new Player(name, hand);
        this.players.add(player);
        return player;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    private String getNextName() {
        return "Player " + (players.size() + 1);
    }
}
