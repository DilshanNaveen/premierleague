package services;

import models.Match;
import models.SportsClub;
import java.io.IOException;
import java.time.LocalDate;

public interface LeagueManager {

    void addClub(SportsClub sportsClub);
    void deleteClubByName(String clubName);
    void deleteClubByID(String clubID);
    void displayStatisticsByClubID(String clubID);
    void displayStatisticsByClubName(String clubName);
    void displayStatistics(SportsClub club);
    void displayPremierLeagueTable(int option);
    void displayMatchStatisticTable();
    void displayStatisticsByDate(LocalDate date);
    void addPlayedMatch(Match match);
    void addRandomMatch();
    LocalDate generateRandomDate();
    int clubsListSize();
    void sortClubListByPoints();
    void sortClubListByGoals();
    SportsClub clubNameValidator();
    SportsClub clubNameValidator(SportsClub club);
    void loadData() throws IOException, ClassNotFoundException;
    void saveData() throws IOException;
}
