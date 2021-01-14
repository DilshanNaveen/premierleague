package services;

import models.FootballClub;
import models.SportsClub;
import java.util.Comparator;

public class ClubComparatorByGoals implements Comparator<SportsClub> {

    @Override
    public int compare(SportsClub club1, SportsClub club2) {

        if (((FootballClub) club1).getNoScoredGoals() == ((FootballClub) club2).getNoScoredGoals() ){
            return 0;
        }
        if (((FootballClub) club1).getNoScoredGoals() < ((FootballClub) club2).getNoScoredGoals()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
