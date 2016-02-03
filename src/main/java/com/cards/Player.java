package com.cards;

public class Player implements IPlayer {

    private IHand hand;

    public Player(IHand hand) {
        this.hand = hand;
    }

    public Player() {
        this.hand = new Hand();
    }

    @Override
    public void giveCard(ICard card) {
        this.hand.addCard(card);
    }

    @Override
    public IHand getHand() {
        return this.hand;
    }
}
