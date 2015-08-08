package com.cards;

public class Card implements ICard {

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    // sorting by value first
    public int compareTo(ICard card) {
        int valueComparison = this.value.compareTo(card.getValue());
        return valueComparison == 0 ? this.suit.compareTo(card.getSuit()) : valueComparison;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", value, suit);
    }
}
