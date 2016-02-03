package com.cards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HandTest {
    IHand hand;

    @Before
    public void setUp() {
        this.hand = new Hand();
    }

    @Test
    public void testDefaultHandIsEmpty() {
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testSizeOfHandWithOneCard() {
        List<ICard> cards = new ArrayList<>();
        cards.add(mock(ICard.class));
        IHand hand = new Hand(cards);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testGetCardsWhenHandIsEmpty() {
        List<ICard> cards = hand.getCards();
        assertEquals(0, cards.size());
    }

    @Test
    public void testGetCardsWhenHandIsPopulated() {
        List<ICard> startingCards = new ArrayList<>();
        startingCards.add(mock(ICard.class));
        IHand hand = new Hand(startingCards);
        List<ICard> returnedCards = hand.getCards();
        assertEquals(startingCards, returnedCards);
    }

    @Test
    public void testGetCard_CardNotInHand() {
        ICard card = hand.getCard(Rank.ACE, Suit.SPADES);
        assertNull(card);
    }

    @Test
    public void testGetCard_CardInHand() {
        ICard startingCard = new Card(Rank.ACE, Suit.CLUBS);
        List<ICard> cards = new ArrayList<>();
        cards.add(startingCard);
        IHand hand = new Hand(cards);
        ICard returnedCard = hand.getCard(Rank.ACE, Suit.CLUBS);
        assertEquals(startingCard, returnedCard);
    }

    @Test
    public void testAddCardToHand() {
        ICard card = mock(ICard.class);
        hand.addCard(card);
        assertEquals(1, hand.getSize());

    }

    @Test
    public void testAddCardToHandRetainsValueAndSuit() {
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        hand.addCard(card);
        assertTrue(hand.getCards().contains(card));
    }

    @Test
    public void testAddingDuplicateCardDoesNothing() {
        ICard firstCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard secondCard = new Card(Rank.ACE, Suit.CLUBS);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testDiscardCard() {
        ICard card = mock(ICard.class);
        IDeck deck = mock(IDeck.class);
        hand.addCard(card);
        hand.discardCard(card, deck);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardingCardFromEmptyHandDoesNothing() {
        ICard card = mock(ICard.class);
        IDeck deck = mock(IDeck.class);
        hand.discardCard(card, deck);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardingCardNotInHandDoesNothing() {
        IDeck deck = mock(IDeck.class);
        ICard card = new Card(Rank.ACE, Suit.CLUBS);
        ICard unheldCard = new Card(Rank.TEN, Suit.DIAMONDS);
        hand.addCard(card);
        hand.discardCard(unheldCard, deck);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testDiscardHand() {
        IDeck deck = mock(IDeck.class);
        ICard firstCard = new Card(Rank.ACE, Suit.CLUBS);
        ICard secondCard = new Card(Rank.KING, Suit.DIAMONDS);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        hand.discardHand(deck);
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testDiscardEmptyHand() {
        IDeck deck = mock(IDeck.class);
        hand.discardHand(deck);
        assertEquals(0, hand.getSize());
    }

    /**
     * I'm not sure how I feel about this test, or what it tells me
     * I'm using two separate objects here, and they are both important - I need to verify that when hand "discards",
     * the card is not lost, but instead does interact with the deck
     * This test doesn't seem to belong in Deck - as I can check its method works, but not that anyone ever uses it
     */
    @Test
    public void discardingCardAddsItToDeck() {
        IDeck deck = mock(IDeck.class);
        ICard card = mock(ICard.class);
        List<ICard> cardList = Arrays.asList(card);
        hand.addCard(card);
        hand.discardCard(card, deck);
        verify(deck).addCardsToDiscardPile(cardList);
    }

    @Test
    public void discardingMultipleCardsAddsThemAllToDeck() {
        IDeck deck = mock(IDeck.class);
        ICard firstCard = mock(ICard.class);
        ICard secondCard = mock(ICard.class);
        List<ICard> cardList = Arrays.asList(firstCard, secondCard);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        hand.discardCards(cardList, deck);
        verify(deck).addCardsToDiscardPile(cardList);
    }

    @Test
    public void discardingHandAddsThemAllToDeck() {
        IDeck deck = mock(IDeck.class);
        ICard firstCard = mock(ICard.class);
        ICard secondCard = mock(ICard.class);
        List<ICard> cardList = Arrays.asList(firstCard, secondCard);
        hand.addCard(firstCard);
        hand.addCard(secondCard);
        hand.discardHand(deck);
        verify(deck).addCardsToDiscardPile(cardList);
    }

    @Test
    public void testHandsCanBeCheckedForSpecificCards() {
        ICard card = mock(ICard.class);
        hand.addCard(card);
        assertTrue(hand.hasCard(card));
    }
}
