package com.cards;

public interface ICard extends Comparable<ICard> {
    Rank getRank();

    Suit getSuit();
}
