package com.cards;

public class Player implements IPlayer {

    private IHand hand;
    private String name;

    public Player(String name) {
        this(name, new Hand());
    }

    public Player(String name, IHand hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public void giveCard(ICard card) {
        this.hand.addCard(card);
    }

    @Override
    public IHand getHand() {
        return this.hand;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
