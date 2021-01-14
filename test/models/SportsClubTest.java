package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportsClubTest {
    SportsClub newClub = new SportsClub("SC01", "Team", "Test");

    @Test
    public void getClubPosition() {
        assertEquals(0, newClub.getClubPosition());
    }

    @Test
    public void setClubPosition() {
        newClub.setClubPosition(1);
        assertEquals(1, newClub.getClubPosition());
    }

    @Test
    public void getClubID() {
        assertEquals("SC01", newClub.getClubID());
    }

    @Test
    public void setClubID() {
        newClub.setClubID("SC02");
        assertEquals("SC02", newClub.getClubID());
    }

    @Test
    public void getSportClubName() {
        assertEquals("Team", newClub.getSportClubName());
    }

    @Test
    public void setSportClubName() {
        newClub.setSportClubName("Team2");
        assertEquals("Team2", newClub.getSportClubName());
    }

    @Test
    public void getClubLocation() {
        assertEquals("Test", newClub.getClubLocation());
    }

    @Test
    public void setClubLocation() {
        newClub.setClubLocation("TestLocation");
        assertEquals("TestLocation", newClub.getClubLocation());
    }

    @Test
    public void testEquals() {
        assertEquals(newClub, new SportsClub("SC01", "Team", "Test"));
    }
}