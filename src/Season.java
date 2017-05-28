/**
 * Created by WilliamUSER on 5/23/2017.
 */
import java.util.*;

public class Season {

    //for tracking team and player logs per season
    private static ArrayList<Team> teams;
    private int year;
    private ArrayList<Player> players;
    private static ArrayList<Team> playoffTeams = new ArrayList();
    private static ArrayList<Team> secondRTeams = new ArrayList();
    private static ArrayList<Team> semiRTeams = new ArrayList();
    private static ArrayList<Team> finalTeams = new ArrayList();
    private static ArrayList<Team> secondRoundTeams = new ArrayList();
    private static ArrayList<Team> semiTeams = new ArrayList();
    private static GameScore game;
    private static int gameCount;
    private static String simGameDayHeader;
    private static ArrayList<Team> rankings;
    private static int seed1wins;
    private static int seed2wins;
    private static int seed3wins;
    private static int seed4wins;
    private static int seed5wins;
    private static int seed6wins;
    private static int seed7wins;
    private static int seed8wins;
    private static int seed9wins;
    private static int seed10wins;
    private static int seed11wins;
    private static int seed12wins;
    private static int seed13wins;
    private static int seed14wins;
    private static int seed15wins;
    private static int seed16wins;
    private static int[] teamWins = {seed1wins, seed2wins, seed3wins, seed4wins, seed5wins, seed6wins, seed7wins, seed8wins,
            seed9wins, seed10wins, seed11wins, seed12wins, seed13wins, seed14wins, seed15wins};
    private static int[] secondRoundWins;
    private static int[] semiWins;
    private static int[] finalWins;
    private static String result = "";
    private static String firstRoundResults;
    private static String secondRoundResults;
    private static String semiResults;
    private static String finalResults;

    private int gamesToSim;
    private static MyGUI2 windowSimGame;

    public Season(ArrayList<Team> teams, int y) {
        year =y;
        windowSimGame = new MyGUI2();
        windowSimGame.create( "" + year + "Rankings", "Game Scores");
        gameCount = 0;
        game = new GameScore();
        this.teams = teams;
        rankings = teams;
        //only at the beginning of a new season are player totals reset
        for (Team t: teams){
            for (Player p: t.getTeam()) {
                p.resetTotals();
            }
        }
    }

    public static void simGame(Team t1, Team t2) {
        if (League.getActiveSeason()) {
            Team team1 = t1;
            Team team2 = t2;
            game.simGame(team1, team2);
            simGameDayHeader +=
                    "\nGAME: "+
                            team1.printGameHeader() + " vs. " +
                            team2.printGameHeader() +
                            "\nGAME SCORE: "+
                            team1.getShortName() + ": " + game.getTeamOnePoints() + " " +team2.getShortName() + ": " + game.getTeamTwoPoints() + "\n";
        }
    }

    public static ArrayList<Team> pairGenerator(ArrayList<Team> t) {
        ArrayList<Team> result = new ArrayList<>();
        if (League.getActiveSeason()) {
            result = new ArrayList<>();
        }
        return result;
    }

    //picks 15 pairings
    public static void simOneGameDay() {
        simGameDayHeader = "";
        //gameCount++;
        //if (gameCount > 81) {
            //simPlayoffs();
            //League.setDraft();
            //end();
        //}
        if (League.getActiveSeason())
        {
            int[] teamNumbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

            int index;
            Random random = new Random();
            for (int i = teamNumbers.length - 1; i > 0; i--)
            {
                index = random.nextInt(i + 1);
                if (index != i)
                {
                    teamNumbers[index] ^= teamNumbers[i];
                    teamNumbers[i] ^= teamNumbers[index];
                    teamNumbers[index] ^= teamNumbers[i];
                }
            }


            simGame(League.getTeams().get(teamNumbers[0]), League.getTeams().get(teamNumbers[1]));
            simGame(League.getTeams().get(teamNumbers[2]), League.getTeams().get(teamNumbers[3]));
            simGame(League.getTeams().get(teamNumbers[4]), League.getTeams().get(teamNumbers[5]));
            simGame(League.getTeams().get(teamNumbers[6]), League.getTeams().get(teamNumbers[7]));
            simGame(League.getTeams().get(teamNumbers[8]), League.getTeams().get(teamNumbers[9]));
            simGame(League.getTeams().get(teamNumbers[10]), League.getTeams().get(teamNumbers[11]));
            simGame(League.getTeams().get(teamNumbers[12]), League.getTeams().get(teamNumbers[13]));
            simGame(League.getTeams().get(teamNumbers[14]), League.getTeams().get(teamNumbers[15]));
            simGame(League.getTeams().get(teamNumbers[16]), League.getTeams().get(teamNumbers[17]));
            simGame(League.getTeams().get(teamNumbers[18]), League.getTeams().get(teamNumbers[19]));
            simGame(League.getTeams().get(teamNumbers[20]), League.getTeams().get(teamNumbers[21]));
            simGame(League.getTeams().get(teamNumbers[22]), League.getTeams().get(teamNumbers[23]));
            simGame(League.getTeams().get(teamNumbers[24]), League.getTeams().get(teamNumbers[25]));
            simGame(League.getTeams().get(teamNumbers[26]), League.getTeams().get(teamNumbers[27]));
            simGame(League.getTeams().get(teamNumbers[28]), League.getTeams().get(teamNumbers[29]));
            //if (gameCount > 81) {
                //simPlayoffs();
                //League.setDraft();
                //end();
            //}
        }
        else {
            System.out.println("Season is not active!");
        }
        if (gameCount > 60) {
            League.setTradeDeadline();
        }
/*        if (gameCount >= 82) {
            //simPlayoffs();
            League.setDraft();
            end();
        }*/
        //gameCount++;
        //gameCount++;
        setRankings(teams);
        viewSimGame();
        //if (gameCount > 81) {
            //simPlayoffs();
            //League.setDraft();
            //end();
        //}
    }

    public static String printSimGameDayHeader() {
        return simGameDayHeader;
    }
    //have to actually randomize

    public int getGameCount() {
        return gameCount;
    }

    public static void end() {
        League.endSeason();
    }

    public static void setRankings(ArrayList<Team> t) {
        ArrayList<Team> sorted = t;
        Collections.sort(sorted, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o2.getWins() - o1.getWins();
            }
        });
        rankings = sorted;
        //or sorted.sort(Comparator.comparingInt(Team::getWins());
    }

    public static ArrayList<Team> getRankings(ArrayList<Team> t) {
        setRankings(t);
        return rankings;
    }

    public void simGames(int result) {
        for (int i = 0; i < result; i++){
            League.cutOrSignPlayersLeague();
            //gameCount++;
            simOneGameDay();
            gameCount++;
            if (gameCount > 81) {
                //simPlayoffs();
                League.setDraft();
                end();
            }
        }
        if (gameCount > 81) {
            //simPlayoffs();
            //League.setDraft();
            end();
        }

    }

    public void simGameCount() {
        int result = 0;
        try {
            System.out.println("How many games do you want to simulate?");
            Scanner reader = new Scanner(System.in);
            int r = reader.nextInt();
            while (r > 83 - getGameCount() || r < 1) {
                if (r > 83 - getGameCount() || r < 1) {
                    int gamesLeft = 83 - getGameCount(); //could be broken during the playoffs but who cares
                    System.out.println("Pick between 1-" + gamesLeft + " games left in the regular season:");
                    r = reader.nextInt();
                }
            }
            result = r;
            simGames(result);
            //reader.close();
        }
        catch (InputMismatchException e) {
            System.out.println("That wasn't an int. \n ");
            League.homeView();
        }
        //gamesToSim = result;
    }

    /**
     * creates a new pop-up window
     * right side is ranking of teams from best to worst
     * left side is list of 15 games that were most recently played between 30 teams (15 pairings)
     */
    public static void viewSimGame() {
        windowSimGame.clearTextAreaLeft();
        windowSimGame.clearTextAreaRight();

        int count = 1;
        for (Team t: getRankings(teams)) {
            windowSimGame.printLogLeft(count + ": " + t.printGameHeader());
            count++;
        }
        windowSimGame.printLogRight(Season.printSimGameDayHeader());
    }

    /**
     * playoffs don't work
     */
    /*    public static void startPlayoffs() {
        setRankings(teams);
        playoffTeams = getRankings(teams);

        for(int i = 0; i < 16; i++)
        {
            playoffTeams.add(rankings.get(15-i));
        }

        for(int i =0; i < 30; i++)
        {
            League.getTeams().get(i).seasonReset();
        }
    }

    public static void simOneFirstRoundDay()
    {
        for(int n = 0; n < (playoffTeams.size()/2); n++)
        {
            game.simGame(playoffTeams.get(n), playoffTeams.get(15-n));
        }

        seed1wins = playoffTeams.get(0).getWins();
        seed2wins = playoffTeams.get(1).getWins();
        seed3wins = playoffTeams.get(2).getWins();
        seed4wins = playoffTeams.get(3).getWins();
        seed5wins = playoffTeams.get(4).getWins();
        seed6wins = playoffTeams.get(5).getWins();
        seed7wins = playoffTeams.get(6).getWins();
        seed8wins = playoffTeams.get(7).getWins();
        seed9wins = playoffTeams.get(8).getWins();
        seed10wins = playoffTeams.get(9).getWins();
        seed11wins = playoffTeams.get(10).getWins();
        seed12wins = playoffTeams.get(11).getWins();
        seed13wins = playoffTeams.get(12).getWins();
        seed14wins = playoffTeams.get(13).getWins();
        seed15wins = playoffTeams.get(14).getWins();
        seed16wins = playoffTeams.get(15).getWins();

        int numberOfSecondRound = 0;

        for(int k = 0; k < teamWins.length; k++)
        {
            if(teamWins[k] == 4)
            {
                numberOfSecondRound++;
                playoffTeams.remove(k);
                playoffTeams.remove(15-k);
                secondRTeams.add(playoffTeams.get(k));
                secondRoundWins[numberOfSecondRound - 1] = teamWins[k];
            }
        }
    }

    public static String getFirstRoundResults()
    {
        firstRoundResults = "PLAYOFF FIRST ROUND RESULTS" + "\n" + "Seed 1: " + playoffTeams.get(0).getName() + seed1wins + "W" + "\n" + "Seed 16: " + playoffTeams.get(15).getName() + seed16wins + "W" + "\n" + "\n" +
                "Seed 2: " + playoffTeams.get(1).getName() + seed2wins + "W" + "\n" + "Seed 15: " + playoffTeams.get(14).getName() + seed15wins + "W" + "\n" + "\n" + "Seed 3: " + playoffTeams.get(2).getName() + seed3wins + "W" + "\n" + "Seed 14: "
                + playoffTeams.get(13).getName() + seed14wins + "W" + "\n" + "\n" + "Seed 4: " + playoffTeams.get(3).getName() + seed4wins + "W" + "\n" + "Seed 13: " + playoffTeams.get(12).getName() + seed13wins + "W" + "\n" + "\n" + "Seed 5: "
                + playoffTeams.get(4).getName() + seed5wins + "W" + "\n" +"Seed 12: " + playoffTeams.get(11).getName() + seed12wins + "W" + "\n" + "\n" + "Seed 6: " + playoffTeams.get(5).getName() + seed6wins + "W" + "\n" + "Seed 11: "
                + playoffTeams.get(10).getName() + seed11wins + "W" + "\n" + "\n" + "Seed 7: " + playoffTeams.get(6).getName() + seed7wins + "W" + "\n" + "Seed 10: " + playoffTeams.get(9).getName() + seed10wins + "W" + "\n" + "\n" + "Seed 8: "
                + playoffTeams.get(7).getName() + seed8wins + "W" + "\n" + "Seed 9: " + playoffTeams.get(8).getName() + seed9wins + "W" + "\n" + "\n";

        return firstRoundResults;
    }

    public static void simOneSecondRoundDay()
    {
        setRankings(secondRTeams);
        secondRoundTeams = getRankings(secondRTeams);

        for(int n = 0; n < (secondRoundTeams.size()/2); n++)
        {
            game.simGame(secondRoundTeams.get(n), secondRoundTeams.get(7-n));
        }

        seed1wins = playoffTeams.get(0).getWins();
        seed2wins = playoffTeams.get(1).getWins();
        seed3wins = playoffTeams.get(2).getWins();
        seed4wins = playoffTeams.get(3).getWins();
        seed5wins = playoffTeams.get(4).getWins();
        seed6wins = playoffTeams.get(5).getWins();
        seed7wins = playoffTeams.get(6).getWins();
        seed8wins = playoffTeams.get(7).getWins();
        seed9wins = playoffTeams.get(8).getWins();
        seed10wins = playoffTeams.get(9).getWins();
        seed11wins = playoffTeams.get(10).getWins();
        seed12wins = playoffTeams.get(11).getWins();
        seed13wins = playoffTeams.get(12).getWins();
        seed14wins = playoffTeams.get(13).getWins();
        seed15wins = playoffTeams.get(14).getWins();
        seed16wins = playoffTeams.get(15).getWins();

        int numberOfSemi = 0;

        for(int k = 0; k < secondRoundWins.length; k++)
        {
            if(secondRoundWins[k] == 8)
            {
                numberOfSemi++;
                secondRoundTeams.remove(k);
                secondRoundTeams.remove(7-k);
                semiRTeams.add(secondRoundTeams.get(k));
                semiWins[numberOfSemi - 1] = secondRoundWins[k];
            }
        }
    }

    public static String getSecondRoundResults()
    {
        secondRoundResults = "PLAYOFF SECOND ROUND RESULTS" + "\n" + secondRoundTeams.get(0).getName() + secondRoundTeams.get(0).getWins() + "W" + "\n" + secondRoundTeams.get(7).getName() + secondRoundTeams.get(7).getWins() + "W" + "\n" +
                secondRoundTeams.get(1).getName() + secondRoundTeams.get(1).getWins() + "W" + "\n" +secondRoundTeams.get(6).getName() + secondRoundTeams.get(6).getWins() + "W" + "\n" +
                secondRoundTeams.get(2).getName() + secondRoundTeams.get(2).getWins() + "W" + "\n" +secondRoundTeams.get(5).getName() + secondRoundTeams.get(5).getWins() + "W" + "\n" +
                secondRoundTeams.get(3).getName() + secondRoundTeams.get(3).getWins() + "W" + "\n" +secondRoundTeams.get(4).getName() + secondRoundTeams.get(4).getWins() + "W" + "\n" + "\n";

        return secondRoundResults;
    }

    public static void simOneSemiDay()
    {
        setRankings(semiRTeams);
        semiTeams = getRankings(semiRTeams);

        for(int n = 0; n < (semiTeams.size()/2); n++)
        {
            game.simGame(semiTeams.get(n), semiTeams.get(3-n));
        }

        seed1wins = playoffTeams.get(0).getWins();
        seed2wins = playoffTeams.get(1).getWins();
        seed3wins = playoffTeams.get(2).getWins();
        seed4wins = playoffTeams.get(3).getWins();
        seed5wins = playoffTeams.get(4).getWins();
        seed6wins = playoffTeams.get(5).getWins();
        seed7wins = playoffTeams.get(6).getWins();
        seed8wins = playoffTeams.get(7).getWins();
        seed9wins = playoffTeams.get(8).getWins();
        seed10wins = playoffTeams.get(9).getWins();
        seed11wins = playoffTeams.get(10).getWins();
        seed12wins = playoffTeams.get(11).getWins();
        seed13wins = playoffTeams.get(12).getWins();
        seed14wins = playoffTeams.get(13).getWins();
        seed15wins = playoffTeams.get(14).getWins();
        seed16wins = playoffTeams.get(15).getWins();

        int numberOfFinal = 0;

        for(int k = 0; k < semiWins.length; k++)
        {
            if(semiWins[k] == 12)
            {
                numberOfFinal++;
                semiTeams.remove(k);
                semiTeams.remove(3-k);
                finalTeams.add(semiTeams.get(k));
                finalWins[numberOfFinal - 1] = semiWins[k];
            }
        }
    }

    public static String getSemiResults()
    {
        secondRoundResults = "PLAYOFF SEMINFINAL RESULTS" + "\n" + semiTeams.get(0).getName() + semiTeams.get(0).getWins() + "W" + "\n" + semiTeams.get(3).getName() + semiTeams.get(3).getWins() + "W" + "\n" +
                semiTeams.get(1).getName() + semiTeams.get(1).getWins() + "W" + "\n" +semiTeams.get(2).getName() + semiTeams.get(2).getWins() + "W" + "\n" + "\n";

        return semiResults;
    }

    public static void simOneFinalDay()
    {
        game.simGame(finalTeams.get(0), finalTeams.get(1));
        if(finalWins[0] == 16)
        {
            result = finalTeams.get(0).getName() + " has won the " + League.getYear() + " Basketball Simulator 2K17 Championship";
        }
        else if(finalWins[1] == 16)
        {
            result = finalTeams.get(1).getName() + " has won the " + League.getYear() + " Basketball Simulator 2K17 Championship";
        }
    }

    public static String getChampion()
    {
        return result;
    }

    public static void simPlayoffs()
    {
        startPlayoffs();

        while(secondRTeams.size() < 8)
        {
            simOneFirstRoundDay();
            end();
        }
        System.out.println(getFirstRoundResults());
        while(secondRTeams.size() == 8 && semiRTeams.size() < 4)
        {
            simOneSecondRoundDay();
        }
        System.out.println(getSecondRoundResults());
        while(secondRTeams.size() == 8 && semiRTeams.size() == 4 && finalTeams.size() < 2)
        {
            simOneSemiDay();
        }
        System.out.println(getSemiResults());
        while(secondRTeams.size() == 8 && semiRTeams.size() == 4 && finalTeams.size() == 2 && result.equals(""))
        {
            simOneFinalDay();
        }
        System.out.println(getChampion());
    }*/
}
