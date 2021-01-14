package services;

import models.FootballClub;
import models.Match;
import models.SportsClub;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MatchComparatorByDateTest {

    private static List<Match> testList = new ArrayList<>();
    private static List<Match> correctList = new ArrayList<>();

    @Test
    public void compare() {

        SportsClub club1 = new FootballClub("SC01", "Test Team 1", "Test Location 1");
        SportsClub club2 = new FootballClub("SC02", "Test Team 2", "Test Location 2");

        Match match1 = new Match(club1, 2, club2, 3, LocalDate.of(2020, 1, 4));
        Match match2 = new Match(club2, 6, club1, 2, LocalDate.of(2021, 5, 24));
        Match match3 = new Match(club2, 8, club1, 5, LocalDate.of(2022, 7, 24));

        testList.add(match1);
        testList.add(match3);
        testList.add(match2);

        correctList.add(match1);
        correctList.add(match2);
        correctList.add(match3);

        Collections.sort(testList, new MatchComparatorByDate());
        assertEquals(correctList, testList);
    }
}