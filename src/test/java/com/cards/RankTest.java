package com.cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void testAceValueOf() {
        assertEquals(Rank.ACE, Rank.valueOf("ACE"));
    }

    @Test
    public void testTwoValueOf() {
        assertEquals(Rank.TWO, Rank.valueOf("TWO"));
    }
    @Test
    public void testThreeValueOf() {
        assertEquals(Rank.THREE, Rank.valueOf("THREE"));
    }
    @Test
    public void testFourValueOf() {
        assertEquals(Rank.FOUR, Rank.valueOf("FOUR"));
    }
    @Test
    public void testFiveValueOf() {
        assertEquals(Rank.FIVE, Rank.valueOf("FIVE"));
    }
    @Test
    public void testSixValueOf() {
        assertEquals(Rank.SIX, Rank.valueOf("SIX"));
    }
    @Test
    public void testSevenValueOf() {
        assertEquals(Rank.SEVEN, Rank.valueOf("SEVEN"));
    }
    @Test
    public void testEightValueOf() {
        assertEquals(Rank.EIGHT, Rank.valueOf("EIGHT"));
    }
    @Test
    public void testNineValueOf() {
        assertEquals(Rank.NINE, Rank.valueOf("NINE"));
    }
    @Test
    public void testTenValueOf() {
        assertEquals(Rank.TEN, Rank.valueOf("TEN"));
    }
    @Test
    public void testJackValueOf() {
        assertEquals(Rank.JACK, Rank.valueOf("JACK"));
    }
    @Test
    public void testQueenValueOf() {
        assertEquals(Rank.QUEEN, Rank.valueOf("QUEEN"));
    }
    @Test
    public void testKingValueOf() {
        assertEquals(Rank.KING, Rank.valueOf("KING"));
    }
}