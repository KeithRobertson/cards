package com.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements IDeck {

    private List<ICard> cards;

    public StandardDeck() {
        cards = new ArrayList<ICard>();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public int getSize() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ICard deal() {
        return cards.remove(0);
    }

    public boolean contains(ICard card) {
        return cards.contains(card);
    }
}
