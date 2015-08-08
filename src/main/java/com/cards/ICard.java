package com.cards;

public interface ICard extends Comparable<ICard> {
    Value getValue();

    Suit getSuit();
}
