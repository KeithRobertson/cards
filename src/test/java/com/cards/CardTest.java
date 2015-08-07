package com.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void testGetValue() {
        ICard card = new Card(Value.ACE, Suit.SPADES);
        assertEquals(Value.ACE, card.getValue());
    }

    @Test
    public void testGetSuit() {
        ICard card = new Card(Value.ACE, Suit.SPADES);
        assertEquals(Suit.SPADES, card.getSuit());
    }

}
