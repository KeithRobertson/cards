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
        player = new Player("Player 1");
    }

    @Test
    public void testPlayerStartsWithAnEmptyHand() {
        assertEquals(player.getHand().getSize(), 0);
    }

    @Test
    public void testPlayerCanBeInstantiatedWithAHand() {
        IHand hand = mock(IHand.class);
        player = new Player("Player 1", hand);
        assertEquals(hand, player.getHand());
    }

    @Test
    public void testPlayerCanBeGivenACard() {
        ICard card = mock(ICard.class);
        player.giveCard(card);
        assertTrue(player.getHand().hasCard(card));
    }

    @Test
    public void testPlayerHasDefaultName() {
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void testSecondPlayerHasADifferentName() {
        IPlayer playerTwo = new Player("Player 2");
        assertEquals("Player 2", playerTwo.getName());
    }

    @Test
    public void testPlayerCanBeCreatedWithAName() {
        player = new Player("Keith");
        assertEquals("Keith", player.getName());
    }

    @Test
    public void testPlayerCanChangeTheirName() {
        player.setName("Keith");
        assertEquals("Keith", player.getName());
    }

}
