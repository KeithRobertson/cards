package com.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testCompareTo_LowerValue() {
        ICard lowerCard = new Card(Value.ACE, Suit.SPADES);
        ICard higherCard = new Card(Value.KING, Suit.SPADES);
        assertTrue(lowerCard.compareTo(higherCard) < 0);
    }

    @Test
    public void testCompareTo_HigherValue() {
        ICard higherCard = new Card(Value.KING, Suit.SPADES);
        ICard lowerCard = new Card(Value.ACE, Suit.SPADES);
        assertTrue(higherCard.compareTo(lowerCard) > 0);
    }

    @Test
    public void testCompareTo_SameValueAndSuit() {
        ICard firstCard = new Card(Value.EIGHT, Suit.CLUBS);
        ICard secondCard = new Card(Value.EIGHT, Suit.CLUBS);
        assertEquals(0, firstCard.compareTo(secondCard));
    }

    @Test
    public void testCompareTo_SameValueLowerSuit() {
        ICard lowerCard = new Card(Value.ACE, Suit.CLUBS);
        ICard higherCard = new Card(Value.ACE, Suit.SPADES);
        assertTrue(lowerCard.compareTo(higherCard) < 0);
    }

    @Test
    public void testCompareTo_SameValueHigherSuit() {
        ICard higherCard = new Card(Value.ACE, Suit.SPADES);
        ICard lowerCard = new Card(Value.ACE, Suit.CLUBS);
        assertTrue(higherCard.compareTo(lowerCard) > 0);
    }

    @Test
    public void testToString() {
        ICard card = new Card(Value.ACE, Suit.SPADES);
        assertEquals("ACE of SPADES", card.toString());
    }

}
