package services;

import models.FootballClub;
import models.Match;
import models.SportsClub;
import org.junit.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PremierLeagueManagerTest {

    private static LeagueManager manager = new PremierLeagueManager();
    SportsClub club1 = new FootballClub("SC01", "Test Team 1", "Test Location 1");
    SportsClub club2 = new FootballClub("SC02", "Test Team 2", "Test Location 2");
    Match newMatch = new Match(club1, 2, club2, 3, LocalDate.of(2020, 1, 4));

    PremierLeagueManager leagueManager = new PremierLeagueManager();

    @Test
    public void addClub() {
        manager.addClub(club1);
        try {
            Field field = manager.getClass().getDeclaredField("clubsList");
            field.setAccessible(true);
            List<SportsClub> clubsList = (ArrayList<SportsClub>) field.get(manager);
            assertTrue(clubsList.contains(club1));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clubsListSize() {
        assertEquals(2, manager.clubsListSize());
    }

    @Test
    public void deleteClubByName() {
        manager.addClub(club1);
        try {
            Field field = manager.getClass().getDeclaredField("clubsList");
            field.setAccessible(true);
            List<SportsClub> clubsList = (ArrayList<SportsClub>) field.get(manager);
            manager.deleteClubByName("Team");
            assertTrue(clubsList.contains(club1));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteClubByID() {
        manager.addClub(club1);
        try {
            Field field = manager.getClass().getDeclaredField("clubsList");
            field.setAccessible(true);
            List<SportsClub> clubsList = (ArrayList<SportsClub>) field.get(manager);
            manager.deleteClubByID("SC01");
            assertFalse(clubsList.contains(club1));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sortClubListByPoints() {
        List<SportsClub> tempList = new ArrayList<>();
    }


    @Test
    public void analyzeMatchPoints() {
        int[] matchScoreData = {0,3};
        assertArrayEquals(matchScoreData, leagueManager.analyzeMatchPoints(newMatch));
    }

    @Test
    public void addPlayedMatch() {
        manager.addPlayedMatch(newMatch);
        try {
            Field field = manager.getClass().getDeclaredField("playedMatchesList");
            field.setAccessible(true);
            List<SportsClub> playedMatchesList = (ArrayList<SportsClub>) field.get(manager);
            assertTrue(playedMatchesList.contains(newMatch));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRandomMatch() {
        manager.addClub(club1);
        manager.addClub(club2);
        manager.addRandomMatch();
        try {
            Field field = manager.getClass().getDeclaredField("playedMatchesList");
            field.setAccessible(true);
            List<SportsClub> playedMatchesList = (ArrayList<SportsClub>) field.get(manager);
            assertFalse(playedMatchesList.isEmpty());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateRandomDate() {
        assertTrue(manager.generateRandomDate() instanceof LocalDate);
    }


}