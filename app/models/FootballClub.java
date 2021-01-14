package models;

public class FootballClub extends SportsClub{
    private int noWins;
    private int noDraws;
    private int noDefeats;
    private int noScoredGoals;
    private int goalAgainst;
    private int difference;
    private int currentPoints;
    private int noPlayedMatches;

    // default constructor
    public FootballClub() {
    }

    public FootballClub(String clubID, String sportClubName, String clubLocation) {
        super(clubID, sportClubName, clubLocation);
    }

    public FootballClub(String clubID, String sportClubName, String clubLocation, int noWins, int noDraws, int noDefeats, int noScoredGoals, int goalAgainst, int difference, int currentPoints, int noPlayedMatches) {
        super(clubID, sportClubName, clubLocation);
        this.noWins = noWins;
        this.noDraws = noDraws;
        this.noDefeats = noDefeats;
        this.noScoredGoals = noScoredGoals;
        this.goalAgainst = goalAgainst;
        this.difference = difference;
        this.currentPoints = currentPoints;
        this.noPlayedMatches = noPlayedMatches;
    }

    public int getNoWins() {
        return noWins;
    }

    public void setNoWins(int noWins) {
        this.noWins = noWins;
    }

    public int getNoDraws() {
        return noDraws;
    }

    public void setNoDraws(int noDraws) {
        this.noDraws = noDraws;
    }

    public int getNoDefeats() {
        return noDefeats;
    }

    public void setNoDefeats(int noDefeats) {
        this.noDefeats = noDefeats;
    }

    public int getNoScoredGoals() {
        return noScoredGoals;
    }

    public void setNoScoredGoals(int noScoredGoals) {
        this.noScoredGoals = noScoredGoals;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }

    public int getDifference() {
        return difference;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getNoPlayedMatches() {
        return noPlayedMatches;
    }

    public void setNoPlayedMatches(int noPlayedMatches) {
        this.noPlayedMatches = noPlayedMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return noWins == that.noWins &&
                noDraws == that.noDraws &&
                noDefeats == that.noDefeats &&
                noScoredGoals == that.noScoredGoals &&
                goalAgainst == that.goalAgainst &&
                difference == that.difference &&
                currentPoints == that.currentPoints &&
                noPlayedMatches == that.noPlayedMatches;
    }

    @Override
    public String toString() {
        return "FootballClub{" +"noWins=" + noWins +", noDraws=" + noDraws +", noDefeats=" + noDefeats +", noScoredGoals=" + noScoredGoals +", noReceivedGoals=" + goalAgainst +", difference=" + difference +", currentPoints=" + currentPoints +", noPlayedMatches=" + noPlayedMatches +'}';
    }
}
