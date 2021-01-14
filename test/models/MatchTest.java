package models;

import org.junit.Test;

import javax.xml.crypto.Data;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MatchTest {

    SportsClub club1 = new FootballClub("SC01", "Test Team 1", "Test Location 1");
    SportsClub club2 = new FootballClub("SC02", "Test Team 2", "Test Location 2");
    SportsClub club3 = new FootballClub("SC03", "Test Team 3", "Test Location 3");

    Match newMatch = new Match(club1, 2, club2, 3, LocalDate.of(2020, 1, 4));

    @Test
    public void getFirstClub() {
        assertEquals(club1, newMatch.getFirstClub());
    }

    @Test
    public void setFirstClub() {
        newMatch.setFirstClub(club3);
        assertEquals(club3, newMatch.getFirstClub());
    }

    @Test
    public void getFirstClubsScoredGoals() {
        assertEquals(2, newMatch.getFirstClubsScoredGoals());
    }

    @Test
    public void setFirstClubsScoredGoals() {
        newMatch.setFirstClubsScoredGoals(4);
        assertEquals(4, newMatch.getFirstClubsScoredGoals());
    }

    @Test
    public void getSecondClub() {
        assertEquals(club2, newMatch.getSecondClub());
    }

    @Test
    public void setSecondClub() {
        newMatch.setSecondClub(club3);
        assertEquals(club3, newMatch.getSecondClub());
    }

    @Test
    public void getSecondClubsScoredGoals() {
        assertEquals(3, newMatch.getSecondClubsScoredGoals());
    }

    @Test
    public void setSecondClubsScoredGoals() {
        newMatch.setSecondClubsScoredGoals(5);
        assertEquals(5, newMatch.getSecondClubsScoredGoals());
    }

    @Test
    public void getPlayedDate() {
        assertEquals(LocalDate.of(2020, 1, 4), newMatch.getPlayedDate());
    }

    @Test
    public void setPlayedDate() {
        newMatch.setPlayedDate(LocalDate.of(2021, 1, 1));
        assertEquals(LocalDate.of(2021, 1, 1), newMatch.getPlayedDate());
    }

    @Test
    public void testEquals() {
        assertEquals(newMatch, new Match(club1, 2, club2, 3, LocalDate.of(2020, 1, 4)));
    }
}