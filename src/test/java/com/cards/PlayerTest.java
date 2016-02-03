package com.cards;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    IPlayer player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testPlayerStartsWithAnEmptyHand() {
        assertEquals(player.getHand().getSize(), 0);
    }

    @Test
    public void testPlayerCanBeInstantiatedWithAHand() {
        IHand hand = mock(IHand.class);
        player = new Player(hand);
        assertEquals(hand, player.getHand());
    }

    @Test
    public void testPlayerCanBeGivenACard() {
        ICard card = mock(ICard.class);
        player.giveCard(card);
        assertTrue(player.getHand().hasCard(card));
    }

}
