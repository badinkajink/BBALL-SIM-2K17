/**
 * Created by WilliamUSER on 5/20/2017.
 */
import java.util.ArrayList;

public class PlayerValue {

    private static final int MAX_GROWTH = 5;
    private static final int MAX_LOSS = 2;
    private double pv; //need some logic that caps at 99
    private double alg; //incremental
    private double decrease; //decremental derived from luck and alg
    private double luck;
    private double pot;
    private ArrayList<Double> playerValues;


    public PlayerValue (int draftPos, double luck, double potential, int exp) {
        playerValues = new ArrayList<Double>();
        this.luck = luck;
        pot = potential;
        alg = (luck * (potential + 1 / draftPos) * MAX_GROWTH);
        decrease = (0- (1-this.luck)*((1-this.luck)+(MAX_LOSS*(1/(1+alg)))))*MAX_LOSS; //decrease quotient, WX: i made a change from 1-luck to alg

        if (exp == 0) {
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

    public double getPV() {
        if (pv > 99) {
            pv = 99;
        }
        return pv;
    }

    public double getAlg() {
        return alg;
    }

    public double getDecrease()
    {
        return decrease;
    }

    public ArrayList<Double> getPlayerValues() {
        return playerValues;
    }
    //algorithm: luck x potential x (experience quotient-- 1, 0, or decrement quotient) x max grwoth
}
