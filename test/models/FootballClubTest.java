package models;

import org.junit.Test;

import static org.junit.Assert.*;


public class FootballClubTest {

    private FootballClub club1 = new FootballClub("clubID", "sportClubName", "clubLocation", 5, 3, 6, 8, 3, 5, 15, 5);

    @Test
    public void getNoWins() {
        assertEquals(5, club1.getNoWins());
    }

    @Test
    public void setNoWins() {
        club1.setNoWins(3);
        assertEquals(3, club1.getNoWins());
    }

    @Test
    public void getNoDraws() {
        assertEquals(3, club1.getNoDraws());
    }

    @Test
    public void setNoDraws() {
        club1.setNoDraws(6);
        assertEquals(6, club1.getNoDraws());
    }

    @Test
    public void getNoDefeats() {
        assertEquals(6, club1.getNoDefeats());
    }

    @Test
    public void setNoDefeats() {
        club1.setNoDefeats(3);
        assertEquals(3, club1.getNoDefeats());
    }

    @Test
    public void getNoScoredGoals() {
        assertEquals(8, club1.getNoScoredGoals());
    }

    @Test
    public void setNoScoredGoals() {
        club1.setNoScoredGoals(3);
        assertEquals(3, club1.getNoScoredGoals());
    }

    @Test
    public void getGoalAgainst() {
        assertEquals(3, club1.getGoalAgainst());
    }

    @Test
    public void setGoalAgainst() {
        club1.setGoalAgainst(8);
        assertEquals(8, club1.getGoalAgainst());
    }

    @Test
    public void getDifference() {
        assertEquals(5, club1.getDifference());
    }

    @Test
    public void setDifference() {
        club1.setDifference(-3);
        assertEquals(-3, club1.getDifference());
    }

    @Test
    public void getCurrentPoints() {
        assertEquals(15, club1.getCurrentPoints());
    }

    @Test
    public void setCurrentPoints() {
        club1.setCurrentPoints(0);
        assertEquals(0, club1.getCurrentPoints());
    }

    @Test
    public void getNoPlayedMatches() {
        assertEquals(5, club1.getNoPlayedMatches());
    }

    @Test
    public void setNoPlayedMatches() {
        club1.setNoPlayedMatches(10);
        assertEquals(10, club1.getNoPlayedMatches());
    }

    @Test
    public void testEquals() {
        assertTrue(club1.equals(club1));
    }

}