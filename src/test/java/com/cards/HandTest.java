package com.cards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class HandTest {

    private IDeck deck;

    @Before
    public void setUp() {
        deck = mock(IDeck.class);
    }

    @Test
    public void testDefaultHandIsEmpty() {
        IHand hand = new Hand(deck);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testSizeOfHandWithOneCard() {
        List<ICard> cards = new ArrayList<>();
        cards.add(mock(ICard.class));
        IHand hand = new Hand(deck, cards);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testGetCardsWhenHandIsEmpty() {
        IHand hand = new Hand(deck);
        List<ICard> cards = hand.getCards();
        assertEquals(0, cards.size());
    }

    @Test
    public void testGetCardsWhenHandIsPopulated() {
        List<ICard> startingCards = new ArrayList<>();
        startingCards.add(mock(ICard.class));
        IHand hand = new Hand(deck, startingCards);
        List<ICard> returnedCards = hand.getCards();
        assertEquals(startingCards, returnedCards);
    }

    @Test
    public void testGetCard_CardNotInHand() {
        IHand hand = new Hand(deck);
        ICard card = hand.getCard(Rank.ACE, Suit.SPADES);
        assertNull(card);
    }

    @Test
    public void testGetCard_CardInHand() {
        ICard startingCard = new Card(Rank.ACE, Suit.CLUBS);
        List<ICard> cards = new ArrayList<>();
        cards.add(startingCard);
        IHand hand = new Hand(deck, cards);
        ICard returnedCard = hand.getCard(Rank.ACE, Suit.CLUBS);
        assertEquals(startingCard, returnedCard);
    }

    @Test
    public void testAddCardToHand() {
        ICard card = mock(ICard.class);
        IHand hand = new Hand(deck);
        hand.addCard(card);
        assertEquals(1, hand.getSize());

    }

    @Test
    public void testAddCardToHandRetainsValueAndSuit() {
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        IHand hand = new Hand(deck);
        hand.addCard(card);
        assertTrue(hand.getCards().contains(card));
    }

    @Test
    public void testAddingDuplicateCardDoesNothing() {
        ICard firstCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard secondCard = new Card(Rank.ACE, Suit.CLUBS);
        IHand hand = new Hand(deck);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testDiscardCard() {
        ICard card = mock(ICard.class);
        IHand hand = new Hand(deck);
        hand.addCard(card);
        hand.discardCard(card);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardingCardFromEmptyHandDoesNothing() {
        ICard card = mock(ICard.class);
        IHand hand = new Hand(deck);
        hand.discardCard(card);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardingCardNotInHandDoesNothing() {
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        ICard unheldCard = new Card(Rank.TEN, Suit.DIAMONDS);
        IHand hand = new Hand(deck);
        hand.addCard(card);
        hand.discardCard(unheldCard);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testDiscardHand() {
        ICard firstCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard secondCard = new Card(Rank.KING, Suit.DIAMONDS);
        IHand hand = new Hand(deck);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        hand.discardHand();
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardEmptyHand() {
        IHand hand = new Hand(deck);
        hand.discardHand();
        assertEquals(0, hand.getSize());
    }
}
