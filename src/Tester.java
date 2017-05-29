import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by WilliamUSER on 5/20/2017.
 * THIS RUNS THE GAME
 *
 */
public class Tester {
    public static void main (String[] args) throws FileNotFoundException, IOException{

        //DRAFT DRAFT DRAFT TESTER DEFINITELY DOESNT WORK NOW
        League league = new League();
        System.out.println("\nWelcome to Basketball Simulator 2K17! " +
                "\nBy: William Xie and Eric Xue (Logo by Vellia Zhou)" +
                "\nFor: Mr. Young's AP Computer Science A Class" +
                "\nGithub: https://github.com/badinkajink/BBALL-SIM-2K17" +
                "\nControl the team through console input. You will have to delete a lot of windows." +
                "\nPick a team to control, 1-30, and minimize the console to 4-5 rows.");
        league.homeView();
/*        League.start();

        Season.simOneGameDay();
        System.out.println(Season.printSimGameDayHeader());

        League.endSeason();

        for(int i = 1; i<31; i++)
        {
            System.out.println("\n"+"TEAM " + i +" STATS" + "\n");
            System.out.println(league.getTeams().get(i-1).printTeamStats());
        }

        Client.proposeTrade();
        League.viewTeams();*/

        /*
        Draft draftTest = new Draft();
        draftTest.start();
        System.out.println("These are Chad Ford's draft rankings. You don't need to follow his order, but AI teams will.");
        System.out.println(draftTest.printDraft());

        t.draftPlayer(draftTest);
        System.out.println(t.printTeam());
        System.out.println(draftTest.printDraft());

        c.draftPlayer(draftTest);
        System.out.println(c.printTeam());*/


        //for (Player p : draftTest.getDraft()) {
        //    System.out.println(p.printPlayer());
        //}

/*        //GUI GUI GUI CLIENT CLIENT CLIENT TRADE TRADE TRADE TEAMVIEWER TEAMVIEWER TEAMVIEWER TESTER
        League league = new League();
        League.createClient();

        MyGUI1 windowLeague = new MyGUI1();
        windowLeague.create("Client");

        windowLeague.printLog(Client.printTeam());

        //System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        //System.out.println(Client.printTeam());

        Client.proposeTrade();
        //Client.trade();

        League.viewTeams();*/

        //TRADE TRADE TRADE TESTER
        //League league = new League();

        /*System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        System.out.println(Client.printTeam());*/

        //Client.proposeTrade();

        /*
        //TRADE TRADE TRADE TESTER
        League league = new League();
        League.createClient();
        System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        System.out.println(Client.printTeam());

        League.start();

        for(int i = 0; i<82; i++)
        {
            Season.simOneGameDay();
        }
        for(int i = 0; i<30; i++)
        {
            System.out.println("\n"+"TEAM " + (i+1) +" STATS" + "\n");
            System.out.println(league.getTeams().get(i).printTeamStats());
        }
*/

        /*        League league = new League();
        League.createClient();

        System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        System.out.println(Client.printTeam());

        League.start();

        for(int i = 0; i<82; i++)
        {
            Season.simOneGameDay();
        }
        for(int i = 0; i<30; i++)
        {
            System.out.println("\n"+"TEAM " + i+1 +" STATS" + "\n");
            System.out.println(league.getTeams().get(i).printTeamStats());
        }*/

        //LEAGUE LEAGUE LEAGUE TESTER

        //League league = new League();
/*        System.out.println(Client.printTeam());
        //SEASON SEASON SEASON
        League.start();

        for (int i = 0; i < 82; i++) {
            Season.simGame();
        }
        //GAMESCORE GAMESCORE GAMESCORE TESTER
        System.out.println("\n"+"TEAM 1 STATS" + "\n");
        System.out.println(league.getTeams().get(0).printTeamStats());
        System.out.println("\n"+"TEAM 2 STATS" + "\n");
        System.out.println(league.getTeams().get(1).printTeamStats());*/

/*
        //TRADEVALUE TRADEVALUE TRADEVALUE TESTER
        Team t1 = new Team();
        Team t2 = new Team();

        System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        System.out.println(t1.printTeam());

        System.out.println("Pick a player index to find the player's tradeValue: ");
        Scanner reader = new Scanner(System.in);
        int pIndex = reader.nextInt()-1;
        Player p = t1.getTeam().get(pIndex);

        System.out.println("\n \n \n TEAM TEAM TEAM ");
        System.out.println(t2.printTeam());

        System.out.println(p.getPlayer().getPlayerValues());
        System.out.println(p.getPlayer().getAge());
        System.out.println(p.getPlayer().getPos());
        System.out.println(Trade.tradeValue(p));
        System.out.println(Trade.tradeValue(p, t2));
*/


/*        GameScore game = new GameScore();
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));

        ArrayList<Player> players = new ArrayList<Player>(league.getTeams().get(0).getTeam());*/
        //Also have an arraylist of opposing team called team2

     /*   System.out.println("Player 1 Stats" + " Points: " + players.get(0).getPoints() + " Rebounds: " + players.get(0).getRebounds() +
                " Assists: " + players.get(0).getAssists() + "\n" +" Games: " + players.get(0).getGames() + " PPG: "
                + players.get(0).getPointPerGame() + " RPG: " + players.get(0).getReboundPerGame() +
                " APG: " + players.get(0).getAssistPerGame() + " SPG: " + players.get(0).getStealPerGame() + " BPG: "
                + players.get(0).getBlockPerGame() + " TPG: " + players.get(0).getTurnoverPerGame() +
                "  FPG: " + players.get(0).getFoulPerGame() + " \n");

        System.out.println("Player 2 Stats" + " Points: " + players.get(1).getPoints() + " Rebounds: " + players.get(1).getRebounds() +
                " Assists: " + players.get(1).getAssists() + "\n" + " Games: " + players.get(1).getGames() + " PPG: "
                + players.get(1).getPointPerGame() + " RPG: " + players.get(1).getReboundPerGame() +
                " APG: " + players.get(1).getAssistPerGame() + " SPG: " + players.get(1).getStealPerGame() + " BPG: "
                + players.get(1).getBlockPerGame() + " TPG: " + players.get(1).getTurnoverPerGame() +
                "  FPG: " + players.get(1).getFoulPerGame() + " \n");

        System.out.println("Player 3 Stats" + " Points: " + players.get(2).getPoints() + " Rebounds: " + players.get(2).getRebounds() +
                " Assists: " + players.get(2).getAssists() + "\n" + " Games: " + players.get(2).getGames() + " PPG: "
                + players.get(2).getPointPerGame() + " RPG: " + players.get(2).getReboundPerGame() +
                " APG: " + players.get(2).getAssistPerGame() + " SPG: " + players.get(2).getStealPerGame() + " BPG: "
                + players.get(2).getBlockPerGame() + " TPG: " + players.get(2).getTurnoverPerGame() +
                "  FPG: " + players.get(2).getFoulPerGame() + " \n");

        System.out.println("Player 4 Stats" + " Points: " + players.get(3).getPoints() + " Rebounds: " + players.get(3).getRebounds() +
                " Assists: " + players.get(3).getAssists() + "\n" + " Games: " + players.get(3).getGames() + " PPG: "
                + players.get(3).getPointPerGame() + " RPG: " + players.get(3).getReboundPerGame() +
                " APG: " + players.get(3).getAssistPerGame() + " SPG: " + players.get(3).getStealPerGame() + " BPG: "
                + players.get(3).getBlockPerGame() + " TPG: " + players.get(3).getTurnoverPerGame() +
                "  FPG: " + players.get(3).getFoulPerGame() + " \n");

        System.out.println("Player 5 Stats" + " Points: " + players.get(4).getPoints() + " Rebounds: " + players.get(4).getRebounds() +
                " Assists: " + players.get(4).getAssists() + "\n" + " Games: " + players.get(4).getGames() + " PPG: "
                + players.get(4).getPointPerGame() + " RPG: " + players.get(4).getReboundPerGame() +
                " APG: " + players.get(4).getAssistPerGame() + " SPG: " + players.get(4).getStealPerGame() + " BPG: "
                + players.get(4).getBlockPerGame() + " TPG: " + players.get(4).getTurnoverPerGame() +
                "  FPG: " + players.get(4).getFoulPerGame() + " \n");

        System.out.println("Player 6 Stats" + " Points: " + players.get(5).getPoints() + " Rebounds: " + players.get(5).getRebounds() +
                " Assists: " + players.get(5).getAssists() + "\n" + " Games: " + players.get(5).getGames() + " PPG: "
                + players.get(5).getPointPerGame() + " RPG: " + players.get(5).getReboundPerGame() +
                " APG: " + players.get(5).getAssistPerGame() + " SPG: " + players.get(5).getStealPerGame() + " BPG: "
                + players.get(5).getBlockPerGame() + " TPG: " + players.get(5).getTurnoverPerGame() +
                "  FPG: " + players.get(5).getFoulPerGame() + " \n");

        System.out.println("Player 7 Stats" + " Points: " + players.get(6).getPoints() + " Rebounds: " + players.get(6).getRebounds() +
                " Assists: " + players.get(6).getAssists() + "\n" + " Games: " + players.get(6).getGames() + " PPG: "
                + players.get(6).getPointPerGame() + " RPG: " + players.get(6).getReboundPerGame() +
                " APG: " + players.get(6).getAssistPerGame() + " SPG: " + players.get(6).getStealPerGame() + " BPG: "
                + players.get(6).getBlockPerGame() + " TPG: " + players.get(6).getTurnoverPerGame() +
                "  FPG: " + players.get(6).getFoulPerGame() + " \n");

        System.out.println("Player 8 Stats" + " Points: " + players.get(7).getPoints() + " Rebounds: " + players.get(7).getRebounds() +
                " Assists: " + players.get(7).getAssists() + "\n" + " Games: " + players.get(7).getGames() + " PPG: "
                + players.get(7).getPointPerGame() + " RPG: " + players.get(7).getReboundPerGame() +
                " APG: " + players.get(7).getAssistPerGame() + " SPG: " + players.get(7).getStealPerGame() + " BPG: "
                + players.get(7).getBlockPerGame() + " TPG: " + players.get(7).getTurnoverPerGame() +
                "  FPG: " + players.get(7).getFoulPerGame() + " \n");

        System.out.println("Player 9 Stats" + " Points: " + players.get(8).getPoints() + " Rebounds: " + players.get(8).getRebounds() +
                 " Assists: " + players.get(8).getAssists() + "\n" + " Games: " + players.get(8).getGames() + " PPG: "
                + players.get(8).getPointPerGame() + " RPG: " + players.get(8).getReboundPerGame() +
                " APG: " + players.get(8).getAssistPerGame() + " SPG: " + players.get(8).getStealPerGame() + " BPG: "
                + players.get(8).getBlockPerGame() + " TPG: " + players.get(8).getTurnoverPerGame() +
                "  FPG: " + players.get(8).getFoulPerGame() + " \n");

        System.out.println("Player 10 Stats" + " Points: " + players.get(9).getPoints() + " Rebounds: " + players.get(9).getRebounds() + " Assists: " + players.get(9).getAssists() +
                "\n" + " Games: " + players.get(9).getGames() + " PPG: "
                + players.get(9).getPointPerGame() + " RPG: " + players.get(9).getReboundPerGame() +
                " APG: " + players.get(9).getAssistPerGame() + " SPG: " + players.get(9).getStealPerGame() + " BPG: "
                + players.get(9).getBlockPerGame() + " TPG: " + players.get(9).getTurnoverPerGame() +
                "  FPG: " + players.get(9).getFoulPerGame() + " \n");

        System.out.println("Player 11 Stats" + " Points: " + players.get(10).getPoints() + " Rebounds: " + players.get(10).getRebounds() +
                " Assists: " + players.get(10).getAssists() + "\n" + " Games: " + players.get(10).getGames() + " PPG: "
                + players.get(10).getPointPerGame() + " RPG: " + players.get(10).getReboundPerGame() +
                " APG: " + players.get(10).getAssistPerGame() + " SPG: " + players.get(10).getStealPerGame() + " BPG: "
                + players.get(10).getBlockPerGame() + " TPG: " + players.get(10).getTurnoverPerGame() +
                "  FPG: " + players.get(10).getFoulPerGame() + " \n");

        System.out.println("Player 12 Stats" + " Points: " + players.get(11).getPoints() + " Rebounds: " + players.get(11).getRebounds() +
                " Assists: " + players.get(11).getAssists() + "\n" + " Games: " + players.get(11).getGames() + " PPG: "
                + players.get(11).getPointPerGame() + " RPG: " + players.get(11).getReboundPerGame() +
                " APG: " + players.get(11).getAssistPerGame() + " SPG: " + players.get(11).getStealPerGame() + " BPG: "
                + players.get(11).getBlockPerGame() + " TPG: " + players.get(11).getTurnoverPerGame() +
                "  FPG: " + players.get(11).getFoulPerGame() + " \n");*/

       /* System.out.println("Team PPG: " + (int) (players.get(1).getPointPerGame() + players.get(2).getPointPerGame() + players.get(3).getPointPerGame() + players.get(4).getPointPerGame() + players.get(5).getPointPerGame() + players.get(6).getPointPerGame()
                + players.get(7).getPointPerGame() + players.get(8).getPointPerGame() + players.get(9).getPointPerGame() + players.get(10).getPointPerGame() + players.get(11).getPointPerGame() + players.get(0).getPointPerGame()) + " Team  APG: " +
                (int) (players.get(1).getAssistPerGame() + players.get(2).getAssistPerGame() + players.get(3).getAssistPerGame() + players.get(4).getAssistPerGame() + players.get(5).getAssistPerGame() + players.get(6).getAssistPerGame()
                        + players.get(7).getAssistPerGame() + players.get(8).getAssistPerGame() + players.get(9).getAssistPerGame() + players.get(10).getAssistPerGame() + players.get(11).getAssistPerGame() + players.get(0).getAssistPerGame()) + " Team RPG: "
                + (int) (players.get(1).getReboundPerGame() + players.get(2).getReboundPerGame() + players.get(3).getReboundPerGame() + players.get(4).getReboundPerGame() + players.get(5).getReboundPerGame() + players.get(6).getReboundPerGame()
                + players.get(7).getReboundPerGame() + players.get(8).getReboundPerGame() + players.get(9).getReboundPerGame() + players.get(10).getReboundPerGame() + players.get(11).getReboundPerGame() + players.get(0).getReboundPerGame()) + " \n");

*/

        /*//LEAGUE LEAGUE LEAGUE TESTER

        League league = new League();
        league.createClient();
        System.out.println(Client.printTeam());

        //GAMESCORE GAMESCORE GAMESCORE TESTER
        GameScore game = new GameScore();
        game.simGame(league.getTeams().get(0), league.getTeams().get(1));*/


        //NAMEGENERATOR NAMEGENERATOR NAMEGENERATOR TESTER
        /*NameGenerator myName = new NameGenerator();
        List<String> myList = mySampler.sampler(10);
        for(int index = 0;index<myList.size();index++){
            System.out.println(myList.get(index));*/



        //LEAGUE LEAGUE LEAGUE TESTER
/*
        League league = new League();
        league.createClient();
        System.out.println(Client.printTeam());

        //GAMESCORE GAMESCORE GAMESCORE TESTER
        //GameScore game = new GameScore();
        //game.simGame(league.getTeams().get(0), league.getTeams().get(1));

        league.endSeason();
        System.out.println (league.printTeams());
*/


        //NEW NEW NEW
        //DRAFT DRAFT DRAFT TESTER


        //TRADEVALUE TRADEVALUE TRADEVALUE TESTER
        /*Team t1 = new Team();
        Team t2 = new Team();

        System.out.println("\n \n \n CLIENT CLIENT CLIENT ");
        System.out.println(t1.printTeam());

        System.out.println("Pick a player index to find the player's tradeValue: ");
        Scanner reader = new Scanner(System.in);
        int pIndex = reader.nextInt()-1;
        Player p = t1.getTeam().get(pIndex);

        System.out.println("\n \n \n TEAM TEAM TEAM ");
        System.out.println(t2.printTeam());

        System.out.println(p.getPlayer().getPlayerValues());
        System.out.println(p.getPlayer().getAge());
        System.out.println(p.getPlayer().getPos());
        System.out.println(Trade.tradeValue(p));
        System.out.println(Trade.tradeValue(p, t2));
        */

        //DRAFT DRAFT DRAFT TESTER DEFINITELY DOESNT WORK NOW
       /* System.out.println("\n \n \n DRAFT DRAFT DRAFT ");

        Draft draftTest = new Draft();
        draftTest.start();
        System.out.println("These are Chad Ford's draft rankings. You don't need to follow his order, but AI teams will.");
        System.out.println(draftTest.printDraft());

        t.draftPlayer(draftTest);
        System.out.println(t.printTeam());
        System.out.println(draftTest.printDraft());

        c.draftPlayer(draftTest);
        System.out.println(c.printTeam());*/


        //for (Player p : draftTest.getDraft()) {
        //    System.out.println(p.printPlayer());
        //} */


        // PLAYERPROFILE PLAYERPROFILE PLAYERPROFILE TESTER
        /*
        PlayerProfile pP = new PlayerProfile();
        for (int k = 100; k > 0; k--) {
            PlayerProfile pP = new PlayerProfile();
            System.out.println(pP.getPlayer());
            ProfileGenerator.rookieDraftReset();
            System.out.println(pP.getPV());
            System.out.println(pP.printRatings());
            pP.updateProfile();
            System.out.println("\n new test \n");
            for (int i = 0; i < pP.getPlayerRatings().length; i++) {
                System.out.println(pP.getPlayerRatings()[i]);
            }
            System.out.println("\n new test \n");
            System.out.println(pP.getPV());
            //System.out.println(pP.printRatings());
            System.out.println("\n new test \n");
            pP.updateProfile();
            System.out.println(pP.getPV());
            System.out.println("\n new test \n");
            for (int i = 0; i < pP.getPlayerRatings().length; i++) {
                System.out.println(pP.getPlayerRatings()[i]);
            }
            System.out.println("\n new test \n");
            //System.out.println(pP.printRatings());
            System.out.println("\n new test \n");
            System.out.println(pP.getPlayerValues());


            PlayerProfile rookie = new PlayerProfile(0, 20);
            System.out.println(rookie.getPlayer());
            System.out.println(rookie.getPV());
            System.out.println(rookie.printRatings());
            rookie.updateProfile();
            System.out.println("\n new test \n");
            for (int i = 0; i < rookie.getPlayerRatings().length; i++) {
                System.out.println(rookie.getPlayerRatings()[i]);
            }
            System.out.println("\n new test \n");
            System.out.println(rookie.getPV());
            //System.out.println(rookie.printRatings());
            System.out.println("\n new test \n");
            rookie.updateProfile();
            System.out.println(rookie.getPV());
            System.out.println("\n new test \n");
            //System.out.println(rookie.printRatings());
            System.out.println("\n new test \n");
            for (int i = 0; i < rookie.getPlayerRatings().length; i++) {
                System.out.println(rookie.getPlayerRatings()[i]);
            }
            System.out.println(rookie.getPlayerValues());
        }
        */
    }
}
