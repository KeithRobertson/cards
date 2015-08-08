package com.cards;

public interface IDeck {
    int getSize();
    void shuffle();
    ICard deal();
    boolean contains(ICard card);
}
