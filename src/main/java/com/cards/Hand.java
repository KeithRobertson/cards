package com.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand implements IHand {

    private List<ICard> cards;

    public Hand() {
        this(new ArrayList<>());
    }

    public Hand(List<ICard> cards) {
        this.cards = cards;
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
        ICard targetCard = new Card(rank, suit);
        for (ICard currentCard : cards) {
            if (currentCard.equals(targetCard)) {
                return currentCard;
            }
        }
        return null;
    }

    @Override
    public void addCard(ICard card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    @Override
    public void discardCard(ICard card, IDeck deck) {
    discardCards(new ArrayList<>(Arrays.asList(card)), deck);
    }

    @Override
    public void discardCards(List<ICard> cards, IDeck deck) {
        this.cards.removeAll(cards);
        deck.addCardsToDiscardPile(cards);
    }

    @Override
    public void discardHand(IDeck deck) {
        discardCards(new ArrayList<>(cards), deck);
    }
}
