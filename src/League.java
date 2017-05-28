/**
 * Created by WilliamUSER on 5/23/2017.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
League class, only created once, all operations originate from League
 */
public final class League {

    //most of these methods should be in the season class
    private String name;
    private static ArrayList<Team> teams;
    private static ArrayList<Team> draftOrder = new ArrayList<>();
    private static ArrayList<Player> playerPool;
    private static ArrayList<Season> seasons;
    private static boolean activeSeason;
    private static boolean activeTrade;
    //private static MyGUI2 windowSimGame;
    private static int gamesToSim;
    private static boolean timeForDraft = false;
    private static String instructions = "\nInstructions:" +
            "\nWelcome to Basketball Simulator 2K17! " +
            "\nBy: William Xie and Eric Xue " +
            "\nFor: Mr. Young's AP Computer Science A Class" +
            "\nGithub: https://github.com/badinkajink/APCS_FinalProject" +
            "\nControl the team through console input. Delete the first two windows with just one text panel that pop up." +
            "\nEnter '0' for more in-depth instructions. Afterwards, minimize the console to fit ~4-5 lines so that you can view pop-up windows and enter input on the same screen" +
            "\nEXCEPT WHILE DRAFTING PLAYERS, at any point in time, enter a string into the console to return to the User Manual." +
            "\nEntering actions via console will open up new windows on the GUI. You'll end up with a lot of windows open." +
            "\nYou could choose to be cheeky and enter in Strings for ints or ints for Strings. Or you could choose not to. Only God can judge you.\n" +

            "\nThe whole point of the game is to build a team through trades and drafts that play games in order to win a championship." +
            "\nUnfortunately we couldn't quite get the whole 'simulate playoffs and win championships' part, but you can play in games and seasons!" +
            "\nBefore you simulate any games(Enter '2'), you have to start a season (Enter '1'). " +
            "\nThere are 82 games in a season. You can view the League rankings and Box Scores of the most recent 15 games in a window." +
            "\nThere are some bugs regarding playing all 82 games and then initiating the next draft. If you can't finish a season, restart and sim games by 82\n" +

            "\nUntil 60 games into the season and while the season is over, you may trade players (Enter '3')." +
            "\nTrades are proposed by you and can be between any two teams (not necessarily you and another team)." +
            "\nPlayers have generated PlayerValues (and hidden, slightly modified TradeValues) that determine their 0-99 attributes, roster stats, and team trades." +
            "\nA team will reject a trade if the sum of squares of the offered Players' TradeValues is 2000 less or 2000 more than the other team's sum." +
            "\nAs a client, you will not be forced to reject, but will be encouraged not to accept if given a poor offer." +
            "\nIf a proposed trade is valid, you will have the chance to view the composite TradeValues and execute the trade or not.\n" +

            "\nTo view the 0-99 player attributes and PlayerValues of each team (Enter '4' to see all teams), enter '1' through '30' to view an individual team." +
            "\nTo view the roster stats of each team in a season (Enter '5' to see all teams), enter '1' through '30' to view an individual team." +
            "\nTeam order will change frequently when selecting teams. Be very aware of this! This is due to static variables and bad game design." +
            "\nPlayers gain PlayerValue rapidly from age 20-25. If lucky (you can't know this) they'll improve a little, a lot, or really a lot in year 6." +
            "\nPlayerValues don't change from ages 27-32, and decrease by a consistently decremental amount until age 40, when they immediately retire.\n" +

            "\nThe PlayerPool is a collection of free agent players. You will be forced to cut or sign players from the pool if you have less/more than 12 players." +
            "\nIf you want to remove a player on your team, enter '6'. If you want to sign a player from the pool, enter '7'." +
            "\nUnlike other actions, when forced to cut players, team actions will output information to console, not a window." +
            "\nYou will still be able to view PlayerPool and perform cuts/signings whenever you choose to do so.\n"+

            "\nAfter a season ends, a draft of 60 new players occurs. Depending on how you performed in the season, you pick at two certain points." +
            "\nAs will be told to you, mock draft rankings (done by PlayerValues) for those 60 players and the team pick order are outputted." +
            "\nBut you don't need to pick in that order. AI teams will, however. Players are differentiated by generated PlayerValue, but may have different desirable 0-99 attributes" +
            "\nPlayerValues also improve by a generated and hidden amount each year. You won't get to see it, but don't be immediately dissuaded by a low PlayerValue" +
            "\nIf you exit a draft mid-pick or decline to immediately begin the draft, you should be able to enter '8' to resume the draft at where you were. High chance you'll crash.\n" +

            "\nEnter '9' to terminate the game. Your data won't be saved, but the dozens of windows cluttering your screen will close.\n" +

            "\nMiscellaneous facts and features that weren't implemented: "+
            "\nWe implemented a merge search (aka Collections.sort()) to get rankings and draft orders. It works but it's the reason why the rankings are messed up." +
            "\nSome things we meant to do that completely failed/needed more time: random name generation, live game viewing (i.e. game generation possession by possession), salary caps, trading DraftPicks" +
            "\nThanks to Vellia Zhou for creating our awesome game logo!! Also thanks to Mr. Young for being the only reason I go to school.--William\n";

    private static final String[] TEAM_NAMES = {"Boston Celtics", "Brooklyn Nets", "New York Knicks", "Philadelphia 76ers", "Toronto Raptors",
            "Chicago Bulls", "Cleveland Cavaliers", "Detroit Pistons", "Indiana Pacers", "Milwaukee Bucks",
            "Atlanta Hawks", "Charlotte Hornets", "Miami Heat", "Orlando Magic", "Washington Wizards",
            "Denver Nuggets", "Minnesota Timberwolves", "Oklahoma City Thunder", "Portland Trail Blazers", "Utah Jazz",
            "Golden State Warriors", "Los Angeles Clippers", "Los Angeles Lakers", "Phoenix Suns", "Sacramento Kings",
            "Dallas Mavericks", "Houston Rockets", "Memphis Grizzlies", "New Orleans Pelicans", "San Antonio Spurs"};

    public static int year; //public because it makes things easier probably will change

    private static Season s;

    private static Draft newDraft;

    /**
     * year = currentYear = 2017
     * constructs a league object
     * creates 30 teams with 12 randomized players
     * creates original playerpool of 30 players
     * keeps track of whether trades are allowed
     * creates a client
     */
    public League() {
        activeTrade = true;
        year = 2017;
        teams = new ArrayList<Team>();
        playerPool = new ArrayList<>();
        for (int i = 0; i < 30; i++)
        {
            teams.add(new Team(TEAM_NAMES[i], i+1));
        }
        for (int i = 0; i < 30; i++)
        {
            playerPool.add(new Player());
        }
        createClient();
/*        windowSimGame = new MyGUI2();
        windowSimGame.create("Game Scores", "Rankings");*/
    }

    /**
     * Team Names
     * @return NBA team names
     */
    public static String[] getTEAM_NAMES() {
        return TEAM_NAMES;
    }

    /**
     * not ever used
     * @return instructions
     */
    public static String getInstructions() {return instructions;}

    /**
     * 0-99 attributes of each player of each team
     * not used anymore, was for testing purposes
     * @return teams
     */
    public static String printTeams() {
        String result = "";
        for (Team t: teams) result += "\n" + t.printTeam();
        return result;
    }

    /**
     * constantly changes because rankings constantly change
     * @return rankings of teams, rank+teamname
     */
    public static String printTeamNames() {
        String result = "";
        int count = 1;
        for (Team t: teams) {
            result += "\n" + count + ": " + t.getName();
            if (t.getIsClient()) {
                result += " (You)";
            }
            count++;
        }
        return result;
    }

    /**
     * source of all game actions
     * console outputs instructions for game actions and scans in inputs
     * takes inputs and calls game action based on input
     * a client can always return to homeView() by returning a string and forcing an InputMismatchException
     * everything goes back to homeView() it's like Rome
     * @throws RuntimeException if the client doesn't follow input instructions, always a recursive call to homeView()
     */
    public static void homeView() throws RuntimeException {
        //if (s.getGameCount() >= 81)
        System.out.println("User Manual: Enter the corresponding number to call the action: \n" +
                "0.Instructions  1.Start Season  2.Sim Games  3.Trade  4.View Teams/Player Info  5.View Teams/Roster Stats  6.Cut Player  " +
                "7.Sign Player  8.Begin Draft  9.Exit Game (NO SAVES)");
        try {
            Scanner reader = new Scanner(System.in);
            int r = reader.nextInt();
            while (r > 9 || r < 0) {
                if (r > 9 || r < 0) {
                    System.out.println("Enter a command within the index");
                    homeView();
                }
            }
            if (r == 0)
            {
                System.out.println(instructions);
                League.homeView();
            }
            else if (r == 1) {
                League.start();
            }
            else if (r == 2 ) {
                if (activeSeason) {
                    s.simGameCount();
                    homeView();
                }
                else {
                   System.out.println("Start a season first!");
                   homeView();
                }

            }
            else  if (r == 3) {
                if (activeTrade) {
                    Client.proposeTrade();
                }
                else {
                    System.out.println("Trades aren't allowed now.");
                    homeView();
                }
            }
            else if (r == 4) {
                viewTeams();
            }
            else if (r == 5) {
                viewTeamStats();
            }
            else if (r == 6) {
                Client.cutPlayers();
            }
            else if (r==7) {
                Client.signPlayers();
            }
            else  if (r == 8) {
                if (timeForDraft) {
                    beginDraft();
                }
                else {
                    System.out.println("The draft hasn't started yet.");
                    homeView();
                }
            }
            else if (r==9) {
                System.exit(0);
            }
            else { homeView(); }
        }
        catch (RuntimeException e) {
            System.out.println("You entered a string. Please enter a command, 0-9. \n ");
            homeView();
        }
    }

/*    public static void simGameCount() {
        try {
            System.out.println("How many games do you want to simulate?");
            Scanner reader = new Scanner(System.in);
            int r = reader.nextInt();
            while (r > 82 - s.getGameCount() || r < 0) {
                if (r > 82 - s.getGameCount() || r < 0) {
                    int gamesLeft = 82 - s.getGameCount(); //could be broken during the playoffs but who cares
                    System.out.println("You have " + gamesLeft + " left in the regular season.");
                    r = reader.nextInt();
                }
            }
            gamesToSim = r;
        }
        catch (InputMismatchException e) {
            System.out.println("That wasn't an int. \n ");
            homeView();
        }
    }*/

    /**
     * creates a client with console output asking for input, based on 1-30 input assigns a team to client
     * the very first thing a player sees, before any instruction
     * @throws RuntimeException
     */
    public static void createClient() throws RuntimeException{
        MyGUI1 windowClient = new MyGUI1();
        windowClient.create("League");

        try {
            int t = 0;
            Scanner team = new Scanner(System.in);

            //System.out.println("Pick a team number 1-30!");
            windowClient.printLog("Pick a team number 1-30!");

            for (int i = 1; i <= TEAM_NAMES.length; i++) {
                windowClient.printLog("Team: " + i + " " + TEAM_NAMES[i - 1]);
                //System.out.println("Team: " + i + " " + TEAM_NAMES[i - 1]);
            }
            System.out.println("Pick a team number 1-30: ");
            t = team.nextInt();
            while (t > 30 || t < 1) {
                if (t > 30 || t < 1) {
                    System.out.println("Please pick a team number 1-30: ");
                    t = team.nextInt();
                }
            }
            new Client(teams.get(t-1));
            MyGUI1 windowLeague = new MyGUI1();
            windowLeague.create("Client");
            windowLeague.printLog(Client.printTeam());
        }
        catch (InputMismatchException e) {
            System.out.println("You entered a string. Please pick a team number. \n ");
            createClient();
        }
    }

    /**
     * creates a new window for viewing roster stats
     * console input for viewing specific team
     * one text area for a list of team rankings, the other for showing user specified team
     * @throws RuntimeException if a user inputs a string
     */
    public static void viewTeamStats() throws RuntimeException {
        MyGUI2 windowOV = new MyGUI2();
        //League.printTeamNames(); //prints 1-30 list of teams
        windowOV.create("League Overview", "Team");
        windowOV.printLogLeft(League.printTeamNames());
        boolean flag = true;
        while (flag) {
            int teamLeagueIndex = League.getTeams().indexOf(Client.getTeam()) + 1;
            Scanner reader = new Scanner(System.in);
            System.out.println("Pick a team to view: (You) " + teamLeagueIndex + ": " + Client.getTeam().getName() + ": ");

            try {
                int teamIndex2 = reader.nextInt() - 1;
                windowOV.clearTextAreaRight();
                //System.out.println(League.printTeamNames());
                Team team;

                while (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {
                    if (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {
                        System.out.println("Pick a team to view: (You) " + teamLeagueIndex + ": " + Client.getTeam().getName() + ": ");
                        teamIndex2 = reader.nextInt() - 1;
                    }
                }

                team = League.getTeams().get(teamIndex2);
                windowOV.printLogRight(team.printTeamStats() + "\n");

            } catch (InputMismatchException e) {
                System.out.println("You entered a string. \nTeam stat viewing is done.");
                flag = false;
            }
        }
        homeView();
    }

    /**
     * creates a new window for viewing 0-99 player attributes of each team's players
     * console input for viewing specific team
     * one text area for a list of team rankings, the other for showing user specified team
     * @throws RuntimeException if a user inputs a string
     */
    public static void viewTeams() throws RuntimeException{
        MyGUI2 windowOV = new MyGUI2();
        //League.printTeamNames(); //prints 1-30 list of teams
        windowOV.create("League Overview", "Team");
        windowOV.printLogLeft(League.printTeamNames());
        boolean flag = true;
        while (flag) {
            int teamLeagueIndex = League.getTeams().indexOf(Client.getTeam()) + 1;
            Scanner reader = new Scanner(System.in);
            System.out.println("Pick a team to view: (You) " + teamLeagueIndex + ": " + Client.getTeam().getName() + ": ");

            try {
                int teamIndex2 = reader.nextInt() - 1;
                windowOV.clearTextAreaRight();
                //System.out.println(League.printTeamNames());
                Team team;

                while (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {
                    if (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {

                        System.out.println("Pick a team to view: (You) " + teamLeagueIndex + ": " + Client.getTeam().getName() + ": ");
                        teamIndex2 = reader.nextInt() - 1;
                    }
                }

                team = League.getTeams().get(teamIndex2);
                windowOV.printLogRight(team.printTeam());

            } catch (InputMismatchException e) {
                System.out.println("You entered a string. \nTeam viewing is done.");
                flag = false;
            }
        }
        homeView();
    }

    /**
     * takes teams, which is ranked from best to worst by end of season, and inverts it for draftOrder, from worst to last
     */
    public static void setDraftOrder() {
        for (int i = 29; i >= 0; i--)
        {
            draftOrder.add(teams.get(i));
        }
    }

    /**
     * draft order
     * @return draft order, worst to best
     */
    public static ArrayList<Team> getDraftOrder() {return draftOrder;}

    /**
     * teams in league
     * @return teams in league
     */
    public static ArrayList<Team> getTeams() {return teams;}

    /**
     * returns the team at index n
     * @param n index of team
     * @return team at index n
     */
    public static Team getTeam(int n) {
        Team result = null;
        n--;
        for (Team t: teams) {
            if (n == teams.indexOf(t)) {
                result = t;
            }
        }
        return result;
    }

    /**
     * starts a new season if draft is done and season isnt active
     * updates league
     */
    public static void start() {
        if (!activeSeason && !timeForDraft) {
            //updateLeague();
            for (Team t: teams) {
                t.seasonReset();
            }
            for (Team t: teams) {
                t.cutPlayers();
                t.signPlayers();
            }
            startSeason();
        }
        else {
            System.out.println("Either the season is still active or you did not complete the " + year + " draft.");
            homeView();
        }
    }

    /**
     * called by start()
     * takes console input to start a season or not
     */
    public static void startSeason() {
        System.out.println("Start " +year+ " season--Yes or No: ");
        Scanner reader = new Scanner(System.in);
        try {
            String input = reader.nextLine();
            input = input.toLowerCase();
            while (!(input.equals("yes") || input.equals("no"))) {
                if (!(input.equals("yes") || input.equals("no"))) {
                    System.out.println("Start season--Yes or No: ");
                    input = reader.nextLine();
                    input = input.toLowerCase();
                }
            }
            if (input.equals("yes")) {
                activeSeason = true;
                //updateTeams();
                s = new Season(teams, year);; //first season starts
                homeView();
            }
            if (input.equals("no")) {
                homeView();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("You entered an integer. \n ");
            homeView();
        }
        //UPDATE: all it does is cause a new error. reader.close(); //potentially gamebreaking
    }

    /**
     * if games played > 60, no more trades, meant to lock in playoffs but playoffs wasn't finished
     */
    public static void setTradeDeadline() {
        activeTrade = false;
    }

    //below method never properly implemented
    /*public static void startPlayoffs() {
    }*/

    /**
     * ends a season and increments every player in every team/playerpool
     * cuts
     */
    public static void endSeason() {
        year++;
        activeSeason = false;
        activeTrade = true;
        timeForDraft = true;
        updateTeams(); //increases age of everyone here
        setDraftOrder();
        //should sort by ranking, w-l record

        newDraft = new Draft(year);
        int place = teams.indexOf(Client.getTeam())+1;
        System.out.println("The " +year+ " regular and playoff (lol) games are over! (You) " + Client.getTeam().getName() + " were ranked " + place+ " out of 30! Congratulations");
        beginDraft();
        for (Player p: playerPool) {
            p.getPlayer().updateProfile();
            if (p.getPlayer().getAge() > 39) {
                playerPool.remove(playerPool.indexOf(p));
            }
        }
        //not actually how it's supposed to work
    }

    /**
     * calls beginning of draft
     * console input scans for beginning
     * @throws RuntimeException if a user says no. please say yes.
     */
    public static void beginDraft() throws RuntimeException {
        if (timeForDraft) {
            System.out.println("\nBegin " + year + " draft--Yes or No: ");
            Scanner reader = new Scanner(System.in);
            try {
                String input = reader.nextLine();
                input = input.toLowerCase();
                while (!(input.equals("yes") || input.equals("no"))) {
                    if (!(input.equals("yes") || input.equals("no"))) {
                        System.out.println("Begin draft--Yes or No: ");
                        input = reader.nextLine();
                        input = input.toLowerCase();
                    }
                }
                if (input.equals("yes")) {
                    //System.out.println("The first pick of the draft: 1");
                    newDraft.start();
                }
                if (input.equals("no")) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("You didn't say yes. \n ");
                homeView();
            }
            reader.close(); //potentially game breaking
        }
    }

    /**
     * flag to make sure client starts draft after season ends
     */
    public static void setDraft() {
        timeForDraft = false;
    }

    /**
     * updates players in all teams so that if excess they are cut, or if more needed they are signed
     */
    public static void updateLeague() {
        for (Team t: teams) {
            t.seasonReset();
            t.cutOrSignPlayers();
        }
    }

    /**
     * increases age and updates hidden inherent statistics (by extension 0-99 attributes) for each player
     */
    public static void updateTeams() {
        for (Team t: teams){
            t.updatePlayers();
        }
    }

    /**
     * no longer used
     * called by updateLeague() cuts or signs players based on need, every team must have exactly 12 players on roster
     */

    public static void cutOrSignPlayersLeague() {
            for(Team t: teams){
                t.cutOrSignPlayers();
            }

    }


    /**
     * increments year
     */
    public static void updateYear() {
        year++;
    }

    /**
     * current year
     * @return year
     */
    public static int getYear() {
        return year;
    }

    /**
     * active season
     * @return flag for active season
     */
    public static boolean getActiveSeason() {
        return activeSeason;
    }

    /**
     * trade allowed? or not
     * @return trade flag
     */
    public static boolean getActiveTrade() {
        return activeTrade;
    }

    /**
     * trade reactivator
     */
    public static void setActiveTrade() {
         activeTrade = false;
    }

    /**
     * player pool
     * @return player pool
     */
    public static ArrayList<Player> getPlayerPool() {
        return playerPool;
    }

    /**
     * for ai teams, picks best player from player pool for them to autosign
     * @return best player from player pool
     */
    public static Player getBestPlayerPool() {
        Player best = null;
        for (int i = 0; i < playerPool.size(); i++) {
            if (i == 0 ||  playerPool.get(i).getPlayer().getPV() > playerPool.get(i-1).getPlayer().getPV()) {
                best = playerPool.get(i);
            }
        }
        return best;
    }

    /**
     * player pool
     * @return string output of player pool
     */
    public static String printPlayerPool() {
        String result = "Player Pool: ";
        int count = 1;
        for (Player p: playerPool) {
            result += "\nPlayer: " + count + "\n" + p.printPlayer() + "\n";
            count++;
        }
        return result;
    }

    /**
     * draft order
     * @return string output of team draft order
     */
    public static String printDraftOrder() {
        String result = year + " Draft Order: \n";
        for (Team t: draftOrder) {
            result += "\n" + t.printGameHeader();
        }
        for (Team t: draftOrder) {
            result += "\n" + t.printGameHeader();
        }
        return result;
    }

    //probably only used for testing purposes
}
