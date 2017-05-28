import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by WilliamUSER on 5/23/2017.
 * @author William
 * Client class takes possession of a League-generated team and allows for human player input
 */
public class Client {

    //instance fields
    private static Team team;
    private static ArrayList<Player> roster;

/*    public Client() {
        team = new Team("client");
        roster = team.getTeam();
    }*/

    /**
     * creates a team and tells the team object that it is now controlled by a client
     * @param t client is created from League input (createClient())
     */
    public Client(Team t) {
        team = t;
        roster = team.getTeam();
        team.setClient();
    }

    /**
     * called by Draft object, method nextPick()
     * @param d nextPick() provides an arraylist of available players to pick
     * @throws RuntimeException if someone enters a string for a player
     */
    public static void draftPlayer(ArrayList<Player> d) throws RuntimeException {
        //System.out.println(Draft.printDraft());
        System.out.println("Pick a player number: ");
        Scanner draft = new Scanner(System.in);
        int draftee = draft.nextInt() - 1;
        try {
            while (draftee >= d.size()) {
                if (draftee >= d.size()) {
                    System.out.println("Please pick a number from within the index, 1-" + d.size() + ": ");
                    draftee = draft.nextInt() - 1;
                }
            }
            team.setDraftMessage("\n" + team.getName() + " (You) picked: " + d.get(draftee).getName() + " at pick: " + Draft.truePick());
            //System.out.println(team.getName() + " (You) picked: " + d.get(draftee).getName() + " at pick: " + Draft.truePick());
            team.add(d.remove(draftee));
            //System.out.println(printTeam());
            roster.get(roster.size() - 1).getPlayer().changePos(Draft.truePick());
            roster.get(roster.size() - 1).changeTeam(team.getName());
        } catch (InputMismatchException e) {
            System.out.println("You entered a string. Please pick a number within the player index. \n ");
            draftPlayer(d);
        }

    }

    /**
     * calls native team method
     * @return all the 0-99 player attributes for each team player
     */
    public static String printTeam() {
        return team.printTeam();
    }

    /**
     * returns client team
     * @return returns client team
     */
    public static Team getTeam() {return team;}
    //completely copied over from team, needs heavy modifications

    /**
     * signs a player from the player pool with client input
     * pops up window showing player pool and own team
     * console outputs sign results
     * @throws RuntimeException if client enters a string
     */
    public static void signPlayers() throws RuntimeException {
        MyGUI2 windowTrade = new MyGUI2();
        windowTrade.create("PlayerPool", team.getName() + " (You):");

        try {
            int neededPlayers = 12 - roster.size();
            System.out.println("You currently have " + team.getTeam().size() + " players. You need to sign " + neededPlayers + " to have 12 players on a roster");
            //System.out.println(League.printPlayerPool());
            windowTrade.printLogLeft(League.printPlayerPool());
            windowTrade.printLogRight(team.printTeam());
            System.out.println("Enter a string to restart signing. \n ");
            System.out.println("Sign a player from the PlayerPool, 1- " + League.getPlayerPool().size() + ": ");
            Scanner reader = new Scanner(System.in);
            int pIndex = reader.nextInt() - 1;
            while (pIndex > League.getPlayerPool().size() || pIndex < 0) {
                if (pIndex > League.getPlayerPool().size() || pIndex < 0) {
                    System.out.println("Pick a player from the PlayerPool, 1- " + League.getPlayerPool().size() + ": ");
                    pIndex = reader.nextInt() - 1;
                }
            }
            Player p = League.getPlayerPool().get(pIndex);
            p.changeTeam(team.getName());
            team.getTeam().add(League.getPlayerPool().remove(pIndex));
            windowTrade.clearTextAreaLeft();
            windowTrade.clearTextAreaRight();
            windowTrade.printLogLeft(League.printPlayerPool());
            windowTrade.printLogRight(team.printTeam());
        } catch (InputMismatchException e) {
            System.out.println("You entered a string. Sign a player within your team's index. \n ");
            League.homeView();
        }
        League.homeView();
    }

    /**
     * cuts a player to the player pool with client input
     * pops up window showing player pool and own team
     * console outputs cut results
     * @throws RuntimeException if client enters a string
     */
    public static void cutPlayers() {
        team.retirePlayers();
        MyGUI2 windowTrade = new MyGUI2();
        windowTrade.create("PlayerPool", team.getName() + " (You):");
        try {
            int neededPlayers = roster.size() - 12;
            System.out.println("You currently have " + team.getTeam().size() + " players. You need to cut " + neededPlayers + " players to have 12 players on a roster");
            windowTrade.printLogLeft(League.printPlayerPool());
            windowTrade.printLogRight(team.printTeam());
            //System.out.println(League.printPlayerPool());
            System.out.println("Enter a string to restart cutting. \n ");
            //printTeam();
            System.out.println("Cut a player from your team, 1- " + roster.size() + ": ");
            Scanner reader = new Scanner(System.in);
            int pIndex = reader.nextInt() - 1;
            while (pIndex > roster.size() || pIndex < 0) {
                if (pIndex > roster.size() || pIndex < 0) {
                    System.out.println("Pick a player from the team, 1- " + roster.size() + ": ");
                    pIndex = reader.nextInt() - 1;
                }
            }

            Player p = roster.get(pIndex);
            System.out.println("\n" + team.getName() + " (You) cut Player: " + p.getName() + "PlayerValue: " + p.getPlayer().getPV());
            System.out.println(p.getName() + " is now in the PlayerPool.\n");
            p.changeTeam("PlayerPool");
            League.getPlayerPool().add(roster.remove(roster.indexOf(p)));
            windowTrade.clearTextAreaLeft();
            windowTrade.clearTextAreaRight();
            windowTrade.printLogLeft(League.printPlayerPool());
            windowTrade.printLogRight(team.printTeam());
        } catch (InputMismatchException e) {
            System.out.println("You entered a string. \n ");
            League.homeView();
        }
        League.homeView();
    }

    /**
     * propose a trade with client input
     * between two teams with two sets of players
     * pops up window showing teams trading with each other, players being traded
     * outputs in console proposal/trade results
     * @throws RuntimeException if client enters a string
     */
    public static void proposeTrade() throws RuntimeException {
        MyGUI2 windowTrade = new MyGUI2();
        windowTrade.create("Propose Trade From:", "Propose Trade To:");

        Scanner reader = new Scanner(System.in);
        //these System.out.println statements will be broken up into console input and console outputs, i.e. two different console windows
        try {
            Team t1;
            Team t2;
            ArrayList<Player> players1 = new ArrayList<>();
            ArrayList<Player> players2 = new ArrayList<>();

            //copy pasted, some needs to be kept, some not
            //proposing from t1
            windowTrade.printLogLeft(League.printTeamNames());
            System.out.println("Enter a string to restart the proposed trade. Which team do you want to propose from: ");
            int teamIndex1 = reader.nextInt() - 1;

            while (teamIndex1 > League.getTeams().size() || teamIndex1 < 0) {
                if (teamIndex1 > League.getTeams().size() || teamIndex1 < 0) {
                    int teamLeagueIndex = League.getTeams().indexOf(team) + 1;
                    System.out.println("Pick the index of the team you want to trade from, 1-30. You are team: " + teamLeagueIndex + ": " + team.getName() + ": ");
                    teamIndex1 = reader.nextInt() - 1;
                }
            }
            t1 = League.getTeams().get(teamIndex1);

            windowTrade.clearTextAreaLeft();
            windowTrade.printLogLeft(t1.printTeam());
            //System.out.println(t1.printTeam());
            System.out.println("Enter a string to restart the trade. How many players do you want to trade: ");
            int playerLength1 = reader.nextInt();

            while (playerLength1 > t1.getTeam().size() || playerLength1 < 0) {
                if (playerLength1 > t1.getTeam().size()) {
                    System.out.println("Pick between 0 and " + t1.getTeam().size() + " players: ");
                    playerLength1 = reader.nextInt();
                }
            }

            while (playerLength1 > 0) {
                //System.out.println(t1.printTeam());
                System.out.println("Pick the index of the player you want to trade: ");
                int pIndex = reader.nextInt() - 1;
                while (pIndex > team.getTeam().size()) {
                    if (pIndex > team.getTeam().size()) {
                        System.out.println("Pick the index of the player you want to trade, 1-" + t1.getTeam().size() + ": ");
                        pIndex = reader.nextInt() - 1;
                    }
                }
                Player p1 = t1.getTeam().get(pIndex);
                if (players1.indexOf(p1) < 0) {
                    players1.add(p1);
                }
                playerLength1--;
            }

            windowTrade.clearTextAreaLeft();
            windowTrade.printLogLeft("\n You are currently proposing a trade from the " + t1.getName() + ": ");
            //System.out.println("\nYou are currently proposing a trade from the " + t1.getName() + ": ");
            for (Player p : players1) {
                windowTrade.printLogLeft("\n" + p.printPlayer());
            }

            //Trading from t2
            windowTrade.printLogRight(League.printTeamNames());
            System.out.println("Which team do you want to trade to: ");
            int teamIndex2 = reader.nextInt() - 1;

            while (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {
                if (teamIndex2 > League.getTeams().size() || teamIndex2 < 0) {
                    int teamLeagueIndex = League.getTeams().indexOf(team) + 1;
                    System.out.println("Pick the index of the team you want to trade from, 1-30. You are team: " + teamLeagueIndex + ": " + team.getName() + ": ");
                    teamIndex2 = reader.nextInt() - 1;
                }
            }
            t2 = League.getTeams().get(teamIndex2);

            windowTrade.clearTextAreaRight();
            windowTrade.printLogRight(t2.printTeam());
            //System.out.println(t2.printTeam());
            System.out.println("How many players do you want to trade for: ");
            int playerLength2 = reader.nextInt();

            while (playerLength2 > t2.getTeam().size() || playerLength2 < 0) {
                if (playerLength2 > t2.getTeam().size()) {
                    System.out.println("Pick between 0 and " + t2.getTeam().size() + " players: ");
                    playerLength2 = reader.nextInt();
                }
            }

            while (playerLength2 > 0) {
                //System.out.println(t2.printTeam());
                System.out.println("Pick the index of the player you want to trade: ");
                int pIndex = reader.nextInt() - 1;
                while (pIndex > team.getTeam().size()) {
                    if (pIndex > team.getTeam().size()) {
                        System.out.println("Pick the index of the player you want to trade, 1-" + t2.getTeam().size() + ": ");
                        pIndex = reader.nextInt() - 1;
                    }
                }
                Player p2 = t2.getTeam().get(pIndex);
                if (players2.indexOf(p2) < 0) {
                    players2.add(p2);
                }
                playerLength2--;
            }

/*            System.out.println("\nYou are currently proposing a trade from the " + t1.getName() + ": ");
            for (Player p : players1) {
                System.out.println("\n" + p.printPlayer());
            }
            System.out.println("\nTo the " + t2.getName() + ": ");
            for (Player p : players2) {
                System.out.println("\n" + p.printPlayer());
            }*/

            windowTrade.clearTextAreaRight();
            windowTrade.printLogRight("\nYou are currently proposing a trade to the " + t2.getName() + ": ");
            for (Player p: players2) {
                windowTrade.printLogRight("\n" + p.printPlayer());
                //System.out.println(p.printPlayer());
            }

            Trade.proposeTrade(players1, t1, players2, t2);
        }
        catch (InputMismatchException e) {
            System.out.println("You entered a string. \n ");
            League.homeView();
        }

}


//no longer using
    /*public static void trade() throws RuntimeException {
        MyGUI2 windowTrade = new MyGUI2();
        windowTrade.create("Trade From:", "Trade To:");

        Scanner reader = new Scanner(System.in);
        //these System.out.println statements will be broken up into console input and console outputs, i.e. two different console windows
        try {
            Team t1;
            Team t2;
            ArrayList<Player> players1 = new ArrayList<>();
            ArrayList<Player> players2 = new ArrayList<>();

            //Trading from t1
            windowTrade.printLogLeft(League.printTeamNames());
            System.out.println("Enter a string to restart the trade. Which team do you want to trade from: ");
            int teamIndex1 = reader.nextInt()-1;

            while (teamIndex1> League.getTeams().size() || teamIndex1 <  0) {
                if (teamIndex1 > League.getTeams().size() || teamIndex1 <  0) {
                    int teamLeagueIndex = League.getTeams().indexOf(team) + 1;
                    System.out.println("Pick the index of the team you want to trade from, 1-30. You are team: " + teamLeagueIndex + ": " + team.getName() + ": ");
                    teamIndex1 = reader.nextInt() - 1;
                }
            }
            t1 = League.getTeams().get(teamIndex1);

            windowTrade.clearTextAreaLeft();
            windowTrade.printLogLeft(t1.printTeam());
            //System.out.println(t1.printTeam());
            System.out.println("Enter a string to restart the trade. How many players do you want to trade: ");
            int playerLength1 = reader.nextInt();

            while (playerLength1 > t1.getTeam().size() || playerLength1 < 0) {
                if (playerLength1 > t1.getTeam().size() || playerLength1 < 0) {
                    System.out.println("Pick between 0 and " + t1.getTeam().size() + " players: ");
                    playerLength1 = reader.nextInt();
                }
            }

            while (playerLength1 > 0) {
                //System.out.println(t1.printTeam());
                System.out.println("Pick the index of the player you want to trade: ");
                int pIndex = reader.nextInt() - 1;
                while (pIndex > t1.getTeam().size() || pIndex < 0) {
                    if (pIndex > t1.getTeam().size() || pIndex < 0) {
                        pIndex = reader.nextInt() - 1;
                        System.out.println("Pick the index of the player you want to trade, 1-" + t1.getTeam().size() + ": ");
                    }
                }
                Player p1 = t1.getTeam().get(pIndex);
                if (players1.indexOf(p1) < 0) {
                    players1.add(p1);
                }
                playerLength1--;
            }

            windowTrade.clearTextAreaLeft();
            windowTrade.printLogLeft("\n You are currently trading from the " + t1.getName() + ": ");
            //System.out.println("\nYou are currently trading from the " + t1.getName() + ": ");
            for (Player p: players1) {
                windowTrade.printLogLeft("\n" + p.printPlayer());
            }

            //Trading from t2
            windowTrade.printLogRight(League.printTeamNames());
            System.out.println("Which team do you want to trade to: ");
            int teamIndex2 = reader.nextInt()-1;

            while (teamIndex2> League.getTeams().size() || teamIndex2 <  0) {
                if (teamIndex2 > League.getTeams().size() || teamIndex2 <  0) {
                    int teamLeagueIndex = League.getTeams().indexOf(t1) + 1;
                    System.out.println("Pick the index of the team you want to trade from, 1-30. You are team: " + teamLeagueIndex + ": " + t1.getName() + ": ");
                    teamIndex2 = reader.nextInt() - 1;
                }
            }
            t2 = League.getTeams().get(teamIndex2);

            windowTrade.clearTextAreaRight();
            windowTrade.printLogRight(t2.printTeam());
            //System.out.println(t2.printTeam());
            System.out.println("How many players do you want to trade for: ");
            int playerLength2 = reader.nextInt();

            while (playerLength2 > t2.getTeam().size()) {
                if (playerLength2 > t2.getTeam().size()) {
                    System.out.println("Pick between 0 and " + t2.getTeam().size() + " players: ");
                    playerLength2 = reader.nextInt();
                }
            }

            while (playerLength2 > 0) {
                //System.out.println(t2.printTeam());
                System.out.println("Pick the index of the player you want to trade: ");
                int pIndex = reader.nextInt() - 1;
                while (pIndex > t2.getTeam().size() || pIndex < 0) {
                    if (pIndex > t2.getTeam().size() || pIndex < 0) {
                        System.out.println("Pick the index of the player you want to trade, 1-" + t2.getTeam().size() + ": ");
                        pIndex = reader.nextInt() - 1;
                    }
                }
                Player p2 = t2.getTeam().get(pIndex);
                if (players2.indexOf(p2) < 0){
                    players2.add(p2);
                }
                playerLength2--;
            }

*//*            System.out.println("\nYou are currently trading from the " + t1.getName() + ": ");
            for (Player p: players1) {
                System.out.println("\n" + p.printPlayer());
            }
            System.out.println("\n To the " + t2.getName() + " for: ");
            for (Player p: players2) {
                System.out.println("\n" + p.printPlayer());
            }*//*

            windowTrade.clearTextAreaRight();
            windowTrade.printLogRight("\nYou are currently trading to the " + t2.getName() + ": ");
            for (Player p: players2) {
                windowTrade.printLogRight("\n" + p.printPlayer());
                //System.out.println(p.printPlayer());
            }

            Trade.trade(players1, t1, players2, t2);
        }
        catch (InputMismatchException e) {
            System.out.println("You entered a string. \n ");
            trade();
        }
        }*/

        //UPDATE: IT USED TO WORK BUT THEN I BROKE IT
        //NO LONGER NEEDED
/*    public static void tradeOneWay() throws RuntimeException {
*//*        Scanner reader = new Scanner(System.in);
        System.out.println("Pick the index of the player you want to trade: ");
        int pIndex = reader.nextInt()-1;
        System.out.println(League.printTeamNames());
        System.out.println("Pick the team number you want to trade the player to: ");
        int newTeam = reader.nextInt();
        reader.close();
        Trade.trade(pIndex, team, League.getTeam(newTeam));*//*

        Scanner reader = new Scanner(System.in);

        try {
            Team team1;
            System.out.println(League.printTeamNames());
            System.out.println("Pick the team you want to trade the player from: ");
            int origTeam = reader.nextInt()-1;
            while (origTeam > League.getTeams().size() || origTeam < 0) {
                if (origTeam > League.getTeams().size() || origTeam < 0) {
                    System.out.println("Pick the index of the team you want to trade, 1-30: ");
                    origTeam = reader.nextInt() - 1;
                }
            }
            team1 = League.getTeam(origTeam);

            System.out.println(team1.printTeam());
            System.out.println("Pick the index of the player you want to trade: ");
            int pIndex = reader.nextInt() - 1;
            Player p;
            while (pIndex > team1.getTeam().size()) {
                if (pIndex > team1.getTeam().size()) {
                    System.out.println("Pick the index of the player you want to trade, 1-30: ");
                    pIndex = reader.nextInt() - 1;
                }
            }
            p = team1.getTeam().get(pIndex);


            System.out.println(League.printTeamNames());
            System.out.println("Pick the team you want to trade the player to: ");
            int newTeam = reader.nextInt()-1;
            while (newTeam > League.getTeams().size() || origTeam < 0) {
                if (newTeam > League.getTeams().size() || origTeam < 0) {
                    System.out.println("Pick the index of the team you want to trade, 1-30: ");
                    newTeam = reader.nextInt() - 1;
                }
            }
            Trade.trade(p, League.getTeam(origTeam), League.getTeam(newTeam));
        }
        catch (InputMismatchException e) {
            System.out.println("You entered a string. \n ");
            tradeOneWay();
        }


    }*/
            /*System.out.println(Draft.printDraft());
        Scanner draft = new Scanner(System.in);
        System.out.println("Pick a player number: ");
        int draftee = draft.nextInt()-1;
        System.out.println(team.getName() + " (You) picked: " + d.get(draftee).getName() + " at pick: " + Draft.truePick());
        team.add(d.remove(draftee));
        roster.get(roster.size()-1).getPlayer().changePos(Draft.truePick());
        roster.get(roster.size() - 1).changeTeam(team.getName());*/

}
