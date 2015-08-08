package com.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<ICard> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<ICard> cards) {
        this.cards = cards;
    }

    public int getSize() {
        return cards.size();
    }

    public List<ICard> getCards() {
        return cards;
    }

    public ICard getCard(Rank rank, Suit suit) {
        ICard card = null;
        for (ICard currentCard : cards) {
            if (currentCard.getRank() == rank && currentCard.getSuit() == suit) {
                card = currentCard;
                break;
            }
        }
        return card;
    }

    public void addCard(ICard card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    public void removeCard(ICard card) {
        cards.remove(card);
    }
}
