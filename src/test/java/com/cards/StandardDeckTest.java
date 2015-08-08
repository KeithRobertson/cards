package com.cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class StandardDeckTest {

    @Test
    public void testStandardDeckHas52Cards() {
        IDeck deck = new StandardDeck();
        assertEquals(52, deck.getSize());
    }

    @Test
    public void testFirstDealtCardFromStandardDeck() {
        ICard expectedCard = new Card(Rank.ACE, Suit.CLUBS);
        IDeck deck = new StandardDeck();
        ICard drawnCard = deck.deal();
        assertEquals(expectedCard, drawnCard);
    }

    @Test
    public void testDealCardReducesDeckSize() {
        IDeck deck = new StandardDeck();
        deck.deal();
        assertEquals(51, deck.getSize());
    }

    @Test
    public void testDealCardRemovesFromDeck() {
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        IDeck deck = new StandardDeck();
        deck.deal();
        assertFalse(deck.contains(card));
    }

    @Test
    public void testContains() {
        ICard card = new Card(Rank.ACE, Suit.SPADES);
        IDeck deck = new StandardDeck();
        assertTrue(deck.contains(card));
    }
}
