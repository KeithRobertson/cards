package com.cards;

public interface IPlayer {
    void giveCard(ICard card);

    IHand getHand();

    String getName();

    void setName(String name);

}
