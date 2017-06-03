package com.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {

    @Test
    public void testGetValue() {
        ICard card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void testGetSuit() {
        ICard card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void testCompareTo_LowerValue() {
        ICard lowerCard = new Card(Rank.ACE, Suit.SPADES);
        ICard higherCard = new Card(Rank.KING, Suit.SPADES);
        assertTrue(lowerCard.compareTo(higherCard) < 0);
    }

    @Test
    public void testCompareTo_HigherValue() {
        ICard higherCard = new Card(Rank.KING, Suit.SPADES);
        ICard lowerCard = new Card(Rank.ACE, Suit.SPADES);
        assertTrue(higherCard.compareTo(lowerCard) > 0);
    }

    @Test
    public void testCompareTo_SameValueAndSuit() {
        ICard firstCard = new Card(Rank.EIGHT, Suit.CLUBS);
        ICard secondCard = new Card(Rank.EIGHT, Suit.CLUBS);
        assertEquals(0, firstCard.compareTo(secondCard));
    }

    @Test
    public void testCompareTo_SameValueLowerSuit() {
        ICard lowerCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard higherCard = new Card(Rank.ACE, Suit.SPADES);
        assertTrue(lowerCard.compareTo(higherCard) < 0);
    }

    @Test
    public void testCompareTo_SameValueHigherSuit() {
        ICard higherCard = new Card(Rank.ACE, Suit.SPADES);
        ICard lowerCard = new Card(Rank.ACE, Suit.CLUBS);
        assertTrue(higherCard.compareTo(lowerCard) > 0);
    }

    @Test
    public void testToString() {
        ICard card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals("ACE of SPADES", card.toString());
    }

    @Test
    public void testCardsAreEqual() {
        ICard firstCard = new Card(Rank.ACE, Suit.SPADES);
        ICard secondCard = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(firstCard, secondCard);
    }

    @Test
    public void testCardsAreNotEqualWhenValueDiffers() {
        ICard firstCard = new Card(Rank.ACE, Suit.SPADES);
        ICard secondCard = new Card(Rank.KING, Suit.SPADES);
        assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void testCardsAreNotEqualWhenSuitDiffers() {
        ICard firstCard = new Card(Rank.ACE, Suit.HEARTS);
        ICard secondCard = new Card(Rank.ACE, Suit.SPADES);
        assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void testCardsAreNotEqualWhenSecondIsNull() {
        ICard firstCard = new Card(Rank.ACE, Suit.HEARTS);
        assertNotEquals(firstCard, null);
    }

    @Test
    public void testCardsAreNotEqualWhenClassesDiffer() {
        ICard firstCard = new Card(Rank.ACE, Suit.DIAMONDS);
        Object secondObject = "Ace of Diamonds";
        assertNotEquals(firstCard, secondObject);
    }

    @Test
    public void testEqualCardsHaveAnEqualHashcode() {
        ICard firstCard = new Card(Rank.ACE, Suit.SPADES);
        ICard secondCard = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(firstCard.hashCode(), secondCard.hashCode());
    }

    @Test
    public void testDifferentCardsHaveADifferentHashcode() {
        ICard firstCard = new Card(Rank.ACE, Suit.SPADES);
        ICard secondCard = new Card(Rank.FIVE, Suit.HEARTS);
        assertNotEquals(firstCard.hashCode(), secondCard.hashCode());
    }
}
