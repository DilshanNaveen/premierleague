package services;

import models.FootballClub;
import models.SportsClub;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ClubComparatorByPointsTest {

    @Test
    public void compare() {
        List<SportsClub> correctList = new ArrayList<>();
        List<SportsClub> testList = new ArrayList<>();

        FootballClub club1 = new FootballClub("SC01", "Test Team 1", "Test Location 1");
        club1.setCurrentPoints(3);
        FootballClub club2 = new FootballClub("SC02", "Test Team 2", "Test Location 2");
        club2.setCurrentPoints(12);
        FootballClub club3 = new FootballClub("SC03", "Test Team 3", "Test Location 3");
        club3.setCurrentPoints(9);

        testList.add(club1);
        testList.add(club2);
        testList.add(club3);

        correctList.add(club2);
        correctList.add(club3);
        correctList.add(club1);
        Collections.sort(testList, new ClubComparatorByPoints());

        assertEquals(correctList, testList);
    }
}