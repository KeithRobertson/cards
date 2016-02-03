package com.cards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardDeckTest {

    IDeck deck;

    @Before
    public void setUp() {
        deck = new StandardDeck();
    }

    @Test
    public void testStandardDeckHas52Cards() {
        assertEquals(52, deck.getSize());
    }

    @Test
    public void testFirstDealtCardFromStandardDeck() {
        ICard expectedCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard drawnCard = deck.deal();
        assertEquals(expectedCard, drawnCard);
    }

    @Test
    public void testDealCardReducesDeckSize() {
        deck.deal();
        assertEquals(51, deck.getSize());
    }

    @Test
    public void testDealCardRemovesFromDeck() {
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        deck.deal();
        assertFalse(deck.contains(card));
    }

    @Test
    public void testContains() {
        ICard card = new Card(Rank.ACE, Suit.SPADES);
        assertTrue(deck.contains(card));
    }
}
