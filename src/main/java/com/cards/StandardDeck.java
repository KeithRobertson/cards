package com.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements IDeck {

    private List<ICard> cards;

    public StandardDeck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public ICard deal() {
        return cards.remove(0);
    }

    @Override
    public boolean contains(ICard card) {
        return cards.contains(card);
    }
}
