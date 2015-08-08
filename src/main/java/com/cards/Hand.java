package com.cards;

import java.util.Set;
import java.util.TreeSet;

public class Hand {

    private Set<ICard> cards;

    public Hand() {
        this.cards = new TreeSet<ICard>();
    }

    public Hand(Set<ICard> cards) {
        this.cards = cards;
    }

    public int getSize() {
        return cards.size();
    }

    public Set<ICard> getCards() {
        return cards;
    }

    public ICard getCard(Value value, Suit suit) {
        ICard card = null;
        for (ICard currentCard : cards) {
            if (currentCard.getValue() == value && currentCard.getSuit() == suit) {
                card = currentCard;
                break;
            }
        }
        return card;
    }

    public void addCard(ICard card) {
        cards.add(card);

    }

    public void removeCard(ICard card) {
        cards.remove(card);
    }
}
