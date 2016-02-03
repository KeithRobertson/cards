package com.cards;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerManagerTest {

    PlayerManager playerManager;

    @Before
    public void setUp() {
        playerManager = new PlayerManager();
    }
    @Test
    public void testCanAddAPlayer() {
        playerManager.addPlayer();
        assertEquals(1, playerManager.getNumberOfPlayers());
    }

    @Test
    public void testCanAddMultiplePlayers() {
        playerManager.addPlayer();
        playerManager.addPlayer();
        assertEquals(2, playerManager.getNumberOfPlayers());
    }

    @Test
    public void canAddAPlayerWithASetHand() {
        IHand hand = mock(IHand.class);
        playerManager.addPlayer(hand);
        assertEquals(hand, playerManager.getPlayers().get(0).getHand());
    }

    @Test
    public void canAddAPlayerWithAName() {
        playerManager.addPlayer("Keith");
        assertEquals("Keith", playerManager.getPlayers().get(0).getName());
    }

    @Test
    public void canAddAPlayerWithBothHandAndName() {
        IHand hand = mock(IHand.class);
        playerManager.addPlayer("Keith", hand);
        assertEquals("Keith", playerManager.getPlayers().get(0).getName());
        assertEquals(hand, playerManager.getPlayers().get(0).getHand());
    }

    @Test
    public void addingAPlayerShouldReturnThePlayerToTheCaller() {
        IPlayer player = playerManager.addPlayer("Keith");
        assertEquals("Keith", player.getName());
    }
}
