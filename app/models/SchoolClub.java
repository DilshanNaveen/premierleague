package models;
import java.io.Serializable;
import java.util.Objects;

public class SchoolClub extends FootballClub implements Serializable {

    private String nameOfSchool;

    // default constructor
    public SchoolClub() {
    }

    public SchoolClub(String clubID, String sportClubName, String clubLocation, int noWinners, int noDraws, int noDefeats, int noScoredGoals, int noReceivedGoals, int difference, int currentPoints, int noPlayedMatches, String nameOfSchool) {
        super(clubID, sportClubName, clubLocation, noWinners, noDraws, noDefeats, noScoredGoals, noReceivedGoals, difference, currentPoints, noPlayedMatches);
        this.nameOfSchool = nameOfSchool;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolClub that = (SchoolClub) o;
        return Objects.equals(nameOfSchool, that.nameOfSchool);
    }

    @Override
    public String toString() {
        return "SchoolClub{" + "nameOfSchool='" + nameOfSchool + '\'' +'}';
    }
}
