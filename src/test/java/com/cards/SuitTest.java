package com.cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class SuitTest {

    /**
     * I Don't think these valueof tests are useful... implementing them for the purpose of 100% code coverage
     * Which I'm not sure is a valid reason, but it's not much effort in this instance
     */

    @Test
    public void testClubsValueOf() {
        assertEquals(Suit.CLUBS, Suit.valueOf("CLUBS"));
    }

    @Test
    public void testSpadesValueOf() {
        assertEquals(Suit.SPADES, Suit.valueOf("SPADES"));
    }

    @Test
    public void testHeartsValueOf() {
        assertEquals(Suit.HEARTS, Suit.valueOf("HEARTS"));
    }

    @Test
    public void testDiamondsValueOf() {
        assertEquals(Suit.DIAMONDS, Suit.valueOf("DIAMONDS"));
    }
}