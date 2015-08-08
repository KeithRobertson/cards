package com.cards;

import java.util.Objects;

public class Card implements ICard {

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public Value getValue() {
        return value;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    // sorting by value first
    @Override
    public int compareTo(ICard card) {
        int valueComparison = this.value.compareTo(card.getValue());
        return valueComparison == 0 ? this.suit.compareTo(card.getSuit()) : valueComparison;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", value, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(value, card.value) &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }
}
