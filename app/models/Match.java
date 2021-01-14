package models;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Match implements Serializable {

    private SportsClub firstClub;
    private int firstClubsScoredGoals;
    private SportsClub secondClub;
    private int secondClubsScoredGoals;
    private LocalDate playedDate;

    public Match() {
    }

    public Match(SportsClub firstClub, int firstClubsScoredGoals, SportsClub secondClub, int secondClubsScoredGoals, LocalDate playedDate) {
        this.firstClub = firstClub;
        this.firstClubsScoredGoals = firstClubsScoredGoals;
        this.secondClub = secondClub;
        this.secondClubsScoredGoals = secondClubsScoredGoals;
        this.playedDate = playedDate;
    }

    public SportsClub getFirstClub() {
        return firstClub;
    }

    public void setFirstClub(SportsClub firstClub) {
        this.firstClub = firstClub;
    }

    public int getFirstClubsScoredGoals() {
        return firstClubsScoredGoals;
    }

    public void setFirstClubsScoredGoals(int firstClubsScoredGoals) {
        this.firstClubsScoredGoals = firstClubsScoredGoals;
    }

    public SportsClub getSecondClub() {
        return secondClub;
    }

    public void setSecondClub(SportsClub secondClub) {
        this.secondClub = secondClub;
    }

    public int getSecondClubsScoredGoals() {
        return secondClubsScoredGoals;
    }

    public void setSecondClubsScoredGoals(int secondClubsScoredGoals) {
        this.secondClubsScoredGoals = secondClubsScoredGoals;
    }

    public LocalDate getPlayedDate() {
        return playedDate;
    }

    public void setPlayedDate(LocalDate playedDate) {
        this.playedDate = playedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return firstClubsScoredGoals == match.firstClubsScoredGoals && secondClubsScoredGoals == match.secondClubsScoredGoals && Objects.equals(firstClub, match.firstClub) && Objects.equals(secondClub, match.secondClub) && Objects.equals(playedDate, match.playedDate);
    }

    @Override
    public String toString() {
        return "Match{" +"firstClub=" + firstClub +", firstClubsScoredGoals=" + firstClubsScoredGoals +", secondClub=" + secondClub +", secondClubsScoredGoals=" + secondClubsScoredGoals +", playedDate=" + playedDate +'}';
    }
}