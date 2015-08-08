package com.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand implements IHand {

    private List<ICard> cards;
    private IDeck deck;

    public Hand(IDeck deck) {
        this(deck, new ArrayList<>());
    }

    public Hand(IDeck deck, List<ICard> cards) {
        this.cards = cards;
        this.deck = deck;
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public List<ICard> getCards() {
        return cards;
    }

    @Override
    public ICard getCard(Rank rank, Suit suit) {
        ICard card = null;
        for (ICard currentCard : cards) {
            if (currentCard.getRank() == rank && currentCard.getSuit() == suit) {
                card = currentCard;
                break;
            }
        }
        return card;
    }

    @Override
    public void addCard(ICard card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    @Override
    public void discardCard(ICard card) {
    discardCards(new ArrayList<>(Arrays.asList(card)));
    }

    @Override
    public void discardCards(List<ICard> cards) {
        this.cards.removeAll(cards);
        deck.addCardsToDiscardPile(cards);
    }

    @Override
    public void discardHand() {
        discardCards(cards);
    }
}
