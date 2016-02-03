package com.cards;

import java.util.List;

public interface IHand {
    int getSize();

    List<ICard> getCards();

    ICard getCard(Rank rank, Suit suit);

    void addCard(ICard card);

    void discardCard(ICard card, IDeck deck);

    void discardCards(List<ICard> cards, IDeck deck);

    void discardHand(IDeck deck);

    boolean hasCard(ICard card);
}
