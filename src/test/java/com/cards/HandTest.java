package com.cards;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class HandTest {

    @Test
    public void testDefaultHandIsEmpty() {
        Hand hand = new Hand();
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testSizeOfHandWithOneCard() {
        List<ICard> cards = new ArrayList<>();
        cards.add(mock(ICard.class));
        Hand hand = new Hand(cards);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testGetCardsWhenHandIsEmpty() {
        Hand hand = new Hand();
        List<ICard> cards = hand.getCards();
        assertEquals(0, cards.size());
    }

    @Test
    public void testGetCardsWhenHandIsPopulated() {
        List<ICard> startingCards = new ArrayList<>();
        startingCards.add(mock(ICard.class));
        Hand hand = new Hand(startingCards);
        List<ICard> returnedCards = hand.getCards();
        assertEquals(startingCards, returnedCards);
    }

    @Test
    public void testGetCard_CardNotInHand() {
        Hand hand = new Hand();
        ICard card = hand.getCard(Value.ACE, Suit.SPADES);
        assertNull(card);
    }

    @Test
    public void testGetCard_CardInHand() {
        ICard startingCard = new Card(Value.ACE, Suit.CLUBS);
        List<ICard> cards = new ArrayList<>();
        cards.add(startingCard);
        Hand hand = new Hand(cards);
        ICard returnedCard = hand.getCard(Value.ACE, Suit.CLUBS);
        assertEquals(startingCard, returnedCard);
    }

    @Test
    public void testAddCardToHand() {
        ICard card = mock(ICard.class);
        Hand hand = new Hand();
        hand.addCard(card);
        assertEquals(1, hand.getSize());

    }

    @Test
    public void testAddCardToHandRetainsValueAndSuit() {
        ICard card = new Card(Value.ACE, Suit.CLUBS);
        Hand hand = new Hand();
        hand.addCard(card);
        assertTrue(hand.getCards().contains(card));
    }

    @Test
    public void testAddingDuplicateCardDoesNothing() {
        ICard firstCard = new Card(Value.ACE, Suit.CLUBS);
        ICard secondCard = new Card(Value.ACE, Suit.CLUBS);
        Hand hand = new Hand();
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testRemoveCard() {
        ICard card = mock(ICard.class);
        Hand hand = new Hand();
        hand.addCard(card);
        hand.removeCard(card);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testRemovingCardFromEmptyHandDoesNothing() {
        ICard card = mock(ICard.class);
        Hand hand = new Hand();
        hand.removeCard(card);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testRemovingCardNotInHandDoesNothing() {
        ICard card = new Card(Value.ACE, Suit.CLUBS);
        ICard unheldCard = new Card(Value.TEN, Suit.DIAMONDS);
        Hand hand = new Hand();
        hand.addCard(card);
        hand.removeCard(unheldCard);
        assertEquals(1, hand.getSize());
    }
}
