package com.cards;

import java.util.Objects;

public class Card implements ICard {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    // sorting by rank first
    @Override
    public int compareTo(ICard card) {
        int valueComparison = this.rank.compareTo(card.getRank());
        return valueComparison == 0 ? this.suit.compareTo(card.getSuit()) : valueComparison;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank, suit);
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
        return Objects.equals(rank, card.rank) &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
