import java.util.ArrayList;

/**
 * Created by William on 5/19/2017.
 * keeps track of contracts/teams throughout career, only keeps track of player stats per season
 */

public class Player {

    private PlayerProfile player;
    //private Contract contract; //no longer using Contracts
    private String team;

    //contracts/money
    public double playerWorth;

    //gametracker, resets each season
    private int games;
    private int points;
    private int rebounds;
    private int fouls;
    private int assists;
    private int blocks;
    private int steals;
    private int turnovers;

    private int freethrowA;
    private int freethrowM;
    private int threePtA;
    private int threePtM;
    private int twoPtA;
    private int twoPtM;
    private int fgA;
    private int fgM;
    //private int minutes; not using

    /* not using
    private double per;
    private double offrtg;
    private double defrtg;
    private double winshares;
    private double efg;
    private double trueshooting; */

    private ArrayList<ArrayList<Double>> playerStats;

    public Player(String t)
    {
        playerStats = new ArrayList<ArrayList<Double>>();
        team = t;
        player = new PlayerProfile();
    }

    public Player (int exp, int age) {
        playerStats = new ArrayList<ArrayList<Double>>();
        player = new PlayerProfile(exp, age);
    }

    public Player()
    {
        playerStats = new ArrayList<ArrayList<Double>>();
        player = new PlayerProfile();
    }

    /*
    not my code
    https://stackoverflow.com/questions/22186778/using-math-round-to-round-to-one-decimal-place
    @return double
     */
    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    //now defunct, not doing contracts
   /* public Contract getContract() { return contract;}
   *     public double getContractPerYear() {
        return contract.getCapHit();
    }
    public double getPlayerWorth() {
        return playerWorth;
    }*/

    public PlayerProfile getPlayer()
    {
        return player;
    }

    public String getName() {
        return player.getName();
    }

    public void updatePlayer() {
        player.updateProfile();
    }

    public String getTeam() {
        return team;
    }

    public String printPlayer() { return "Team: " + team + "\n" + player.getPlayer() + player.printRatings();}

    public void changeTeam(String n) {
        team = n;
    }

    public int getGames() {return games;}
    public int getPoints(){return points;}
    public int getRebounds(){return rebounds;}
    public int getFouls(){return fouls;}
    public int getAssists(){return assists;}
    public int getBlocks(){return blocks;}
    public int getSteals(){return steals;}
    public int getTurnovers(){return turnovers;}

    public int getFreeThrowA(){return freethrowA;}
    public int getFreeThrowM(){return freethrowM;}
    public int getThreePtA(){return threePtA;}
    public int getThreePtM(){return threePtM;}
    public int getTwoPtA(){return twoPtA;}
    public int getTwoPtM(){return twoPtM;}
    public int getFgA(){return fgA;}
    public int getFgM(){return fgM;}

    public void updateGames(int i){games+=i;}
    public void updatePoints(int i){ points +=i;}
    public void updateRebounds(int i){ rebounds += i;}
    public void updateFouls(int i){ fouls += i;}
    public void updateAssists(int i){ assists += i;}
    public void updateBlocks(int i){ blocks += i;}
    public void updateSteals(int i){ steals += i;}
    public void updateTurnovers(int i){ turnovers += i;}

    public void updateFreeThrowA(int i){ freethrowA += i;}
    public void updateFreeThrowM(int i){ freethrowM += i;}
    public void updateThreePtA(int i){ threePtA += i;}
    public void updateThreePtM(int i){ threePtM += i;}
    public void updateTwoPtA(int i){ twoPtA += i;}
    public void updateTwoPtM(int i){ twoPtM += i;}
    public void updateFgA(int i){ fgA += i;}
    public void updateFgM(int i){ fgM += i;}

    public double getPointPerGame(){return round((double) points/ games, 1);}
    public double getReboundPerGame(){return round((double) rebounds/ games, 1);}
    public double getFoulPerGame(){return round((double) fouls/ games, 1);}
    public double getAssistPerGame(){return round((double) assists/ games, 1);}
    public double getBlockPerGame(){return round((double) blocks/ games, 1);}
    public double getStealPerGame(){return round((double) steals/ games, 1);}
    public double getTurnoverPerGame(){return round((double) turnovers/ games, 1);}

    public double getFreeThrowAPerGame(){return round((double) freethrowA/ games, 1);}
    public double getFreeThrowMPerGame(){return round((double) freethrowM/ games, 1);}
    public double getThreePtAPerGame(){return round((double) threePtA/ games, 1);}
    public double getThreePtMPerGame(){return round((double) threePtM/ games, 1);}
    public double getTwoPtAPerGame(){return round((double) twoPtA/ games, 1);}
    public double getTwoPtMPerGame(){return round((double) twoPtM/ games, 1);}
    public double getFgAPerGame(){return round((double) fgA/ games, 1);}
    public double getFgMPerGame(){return round((double) fgM/ games, 1);}

    public double getFTPCT() {return round((double) freethrowA/ freethrowM, 3);}
    public double getFGPCT() {return round((double) fgA/ fgM, 3);}
    public double get2GPCT() {return round((double) twoPtA/ twoPtM, 3);}
    public double get3GPCT() {return round((double) threePtA/ threePtM, 3);}

    public void updatePlayerStats() {
        double[] seasonStats = {getPointPerGame(),
                getReboundPerGame(),
                getFoulPerGame(),
                getAssistPerGame(),
                getBlockPerGame(),
                getStealPerGame(),
                getTurnoverPerGame(),

                getFreeThrowAPerGame(),
                getFreeThrowMPerGame(),
                getThreePtAPerGame(),
                getThreePtMPerGame(),
                getTwoPtAPerGame(),
                getTwoPtMPerGame(),
                getFgAPerGame(),
                getFgMPerGame()};
        for (double d: seasonStats) {
            d = round(d, 2);
        }
        //doesn't compile, idk why asList(List<T>) isn't working
        //ArrayList<Double> stats = Arrays.asList(seasonStats);
        //playerStats.add(stats);
    }

    public void resetTotals() {
        games = 0;
        points = 0;
        rebounds = 0;
        fouls = 0;
        assists = 0;
        blocks = 0;
        steals = 0;
        turnovers = 0;

        freethrowA = 0;
        freethrowM = 0;
        threePtA = 0;
        threePtM = 0;
        twoPtA = 0;
        twoPtM = 0;
        fgA = 0;
        fgM = 0;
    }







}