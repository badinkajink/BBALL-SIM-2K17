/**
 * Created by WilliamUSER on 5/20/2017.
 * done by eric, mostly determines player values to determine the player's actualy basketball ratings and skill
 */
import java.util.ArrayList;
import java.util.Random;
public class PlayerValue {

    private static final int MAX_GROWTH = 5;//max possible growth after a season
    private static final int MAX_LOSS = 2;//max possible decrease after a season
    private double pv; //need some logic that caps at 99
    private double alg; //incremental
    private double decrease; //decremental derived from luck and alg
    private double luck;//determines generation and update of player value
    private double pot;//determines generation and update of player value
    private ArrayList<Double> playerValues;


    //constructs player values based on draft position, luck, poential, and experience playing in the nba
    //as they're still young and growing up they're getting better, during their peak they have a chance to shine, as they're getting older their value and skill decreases
    public PlayerValue (int draftPos, double luck, double potential, int exp) {
        playerValues = new ArrayList<Double>();
        this.luck = luck;
        pot = potential;
        alg = (luck * (potential + 1 / draftPos) * MAX_GROWTH);
        decrease = (0- (1-this.luck)*((1-this.luck)+(MAX_LOSS*(1/(1+alg)))))*MAX_LOSS; //decrease quotient, WX: i made a change from 1-luck to alg

        if (exp == 0) //for rookie players
        {
            pv = 80 - ((double) draftPos / 2);
            double temp = pv;
            playerValues.add(temp);
        }
        else
        {
            pv = 80 - draftPos / 2;
            if (exp <= 5 && pv < 99) {
                for (int i = exp; i > 0; i--) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                }
            }
            else if (exp <= 12 && pv < 99) {
                int count = 5;
                while (count > 0 && pv < 99) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                    count--;
                }
                if (luck*potential > 0.75) { //does a player make a "leap" before entering their prime?
                    int nCount = 6; //need to make better names for all of these counts
                    while (nCount > 0 && pv < 99) {
                        pv += alg;
                        double temp = pv;
                        playerValues.add(temp);
                        nCount--;
                    }
                } else if (luck*potential > 0.60) { //does a player make a "leap" before entering their prime?
                    int nCount = 3; //need to make better names for all of these counts
                    while (nCount > 0 && pv < 99) {
                        pv += alg;
                        double temp = pv;
                        playerValues.add(temp);
                        nCount--;
                    }
                } else if (luck*potential > 0.5) {
                    int nCount = 2; //need to make better names for all of these counts
                    while (nCount > 0 && pv < 99) {
                        pv += alg;
                        double temp = pv;
                        playerValues.add(temp);
                        nCount--;
                    }
                }
            }
            else if (exp <= 20 && pv < 99) {
                int newCount = 5;
                while (newCount > 0 && pv < 99) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                    newCount--;
                }
                int otherCount = exp - (exp - 12);
                {
                    if (luck*potential > .5) {
                        for (int i = otherCount; i > 6; i--) {
                            double temp = pv;
                            playerValues.add(temp);
                        }
                    }
                    else{
                        for (int i = otherCount; i > 5; i--) {
                            double temp = pv;
                            playerValues.add(temp);
                        }
                    }
                }

                for (int i = exp; i > 12; i--) {
                    pv += decrease;
                    double temp = pv;
                    playerValues.add(temp);
                }
            }
        }
    }

    //updates to account for an increase in age
    //follow same principle as previous constructor, young players grow while older players become weaker
    public void pVUpdate(int exp) {
        if (exp <= 5 && pv < 99) {
            pv += alg;
            double temp = pv;
            playerValues.add(temp);
        }
        if (exp <= 20 && exp > 12 && pv < 99) {
            pv += decrease;
            double temp = pv;
            playerValues.add(temp);
        }

        if (exp == 6 && pv < 99) {
            if (luck*pot > 0.75) { //does a player make a "leap" before entering their prime?
                int nCount = 5; //need to make better names for all of these counts
                while (nCount > 0 && pv < 99) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                    nCount--;
                }
            }else if (luck * pot > 0.60) { //does a player make a "leap" before entering their prime?
                int nCount = 3; //need to make better names for all of these counts
                while (nCount > 0 && pv < 99) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                    nCount--;
                }
            } else if (luck > 0.50) {
                int nCount = 2;
                while (nCount >0 && pv < 99) {
                    pv += alg;
                    double temp = pv;
                    playerValues.add(temp);
                    nCount--;
                }
            }
        }

    }

    //returns player value in a double
    public double getPV() {
        if (pv > 99) {
            pv = 99;
        }
        return pv;
    }

    //returns the algorithm that determines player value increase per year
    public double getAlg() {
        return alg;
    }

    //returns the decrease of player value after a year for aging players
    public double getDecrease()
    {
        return decrease;
    }

    //prints out player values for tester classes
    public ArrayList<Double> getPlayerValues() {
        return playerValues;
    }
}
