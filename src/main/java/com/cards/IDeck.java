package com.cards;

import java.util.List;

public interface IDeck {
    int getSize();
    boolean isEmpty();
    void shuffleDeck();
    void shuffleInDiscards();
    ICard deal();
    boolean contains(ICard card);
    void addCardsToDiscardPile(List<ICard> card);
}
