package models;
import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable{

    private int clubPosition;
    private String clubID;
    private String sportClubName;
    private String clubLocation;

    // default constructor
    public SportsClub() {
    }

    public SportsClub(String clubID, String sportClubName, String clubLocation) {
        this.clubID = clubID;
        this.sportClubName = sportClubName;
        this.clubLocation = clubLocation;
    }

    public int getClubPosition() {
        return clubPosition;
    }

    public void setClubPosition(int clubPosition) {
        this.clubPosition = clubPosition;
    }

    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    public String getSportClubName() {
        return sportClubName;
    }

    public void setSportClubName(String sportClubName) {
        this.sportClubName = sportClubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return clubPosition == that.clubPosition &&
                Objects.equals(clubID, that.clubID) &&
                Objects.equals(sportClubName, that.sportClubName) &&
                Objects.equals(clubLocation, that.clubLocation);
    }


    @Override
    public String toString() {
        return "SportsClub{" +
                "clubPosition=" + clubPosition +
                ", clubID='" + clubID + '\'' +
                ", sportClubName='" + sportClubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                '}';
    }
}
