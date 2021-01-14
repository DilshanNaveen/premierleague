package models;
import java.util.Objects;

public class UniversityClub extends FootballClub{

    private String nameOfUniversity;

    // default constructor
    public UniversityClub() {}

    public UniversityClub(String clubID, String sportClubName, String clubLocation, int noWinners, int noDraws, int noDefeats, int noScoredGoals, int noReceivedGoals, int difference, int currentPoints, int noPlayedMatches, String nameOfUniversity) {
        super(clubID, sportClubName, clubLocation, noWinners, noDraws, noDefeats, noScoredGoals, noReceivedGoals, difference, currentPoints, noPlayedMatches);
        this.nameOfUniversity = nameOfUniversity;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityClub that = (UniversityClub) o;
        return Objects.equals(nameOfUniversity, that.nameOfUniversity);
    }

    @Override
    public String toString() {
        return "UniversityClub{" +"nameOfUniversity='" + nameOfUniversity + '\'' +'}';
    }
}
