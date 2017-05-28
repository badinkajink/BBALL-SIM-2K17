import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by William on 5/23/2017.
 * utility class that proposes and then either rejects, suggests, or executes trades
 */
public final class Trade {

    private static final int TRADE_DIFF = 1000;
    private static boolean validTrade = false;
    private static String reason;
    //never used
    public Trade() {}

    /**
     *
     * @return trade reason
     */
    public static String getReason() {return reason;}
    /**
     * //calculates overall tradeValue of a player in general
     * @param p player
     * @return
     */
    public static double tradeValue(Player p) {
        PlayerProfile player = p.getPlayer();
        int tradeValue = player.getPV();
        if (player.getAge() < 26)
        {
            tradeValue += player.getAge() - 20;
        }
        if (player.getAge() >= 26 && player.getAge() <= 32)
        {
            tradeValue += (player.getAge() - 20)/2;
        }
        if (player.getAge() > 32){
            tradeValue -= (player.getAge()-20)/2;
        }
        return Math.pow(tradeValue,2);
    }

    /**
     * calculates overall tradeValue of a player to a team
     * @param p player
     * @param t team being proposed to
     * @return tradevalue (slightly adjusted player value^2)
     */
    public static double tradeValue(Player p, Team t) {
        PlayerProfile player = p.getPlayer();
        int tradeValue = player.getPV();
        if (player.getAge() < 26)
        {
            tradeValue += player.getAge() - 20;
        }
        if (player.getAge() >= 26 && player.getAge() <= 32)
        {
            tradeValue += (player.getAge() - 20)/2;
        }
        if (player.getAge() > 32){
            tradeValue -= (player.getAge()-20)/2;
        }

        String position = player.getPos();
        int countG = 0;
        int countF = 0;
        int countC = 0;
        for (Player p1: t.getTeam()) {
            String pos = p1.getPlayer().getPos();
            if (pos.equals("G") || pos.equals("PG") || pos.equals("SG") || pos.equals("GF")) countG++;
            if (pos.equals("F") || pos.equals("SF") || pos.equals("PF")) countF++;
            if (pos.equals("C") || pos.equals("FC")) countC++;
            }
        //g = 5 f = 4 c = 3
        if (countG <= 5 && position.equals("G") || position.equals("PG") || position.equals("SG") || position.equals("GF")) tradeValue += 5;
        if (countF <= 4 && position.equals("F") || position.equals("SF") || position.equals("PF")) tradeValue += 7;
        if (countC <= 3 && position.equals("C") || position.equals("FC")) tradeValue += 10;
        return Math.pow(tradeValue,2);
    }

    /**
     * proposes and if valid executes trade
     * @param p1
     * @param team1
     * @param p2
     * @param team2
     * @return doesnt do anything w boolean but too afraid to change to void
     */
    public static boolean proposeTrade(ArrayList<Player> p1, Team team1, ArrayList<Player> p2, Team team2, MyGUI2 windowTrade) {
        boolean result = true;
        reason = null;
        double p1sum = 0.0;
        double p2sum = 0.0;
        for (Player p: p1) {
            p1sum += tradeValue(p, team2);
        }
        for (Player p: p2) {
            p2sum += tradeValue(p, team1);
        }

        double difference = Player.round((p1sum-p2sum),1);
        double absDifference =  Player.round(Math.abs(difference), 1);

        if (!team1.getIsClient() && difference >= TRADE_DIFF){
            result = false;
            reason = "Team: " + team1.getName() + " rejects the trade. It has from these trade a higher tradeValue of: " + difference;
        } else if (difference >= TRADE_DIFF) {
            reason = "Team: " + team1.getName() + " (You) should reject the trade. You have from this trade a higher tradeValue of: " + difference;
        }
        if (!team2.getIsClient() && difference <= 0-TRADE_DIFF){
            result = false;
            reason = "Team: " + team2.getName() + " rejects the trade. It has from this trade a higher tradeValue of: " + Math.abs(difference);
        } else if (difference <= 0-TRADE_DIFF) {
            reason = "Team: " + team2.getName() + " (You) should reject the trade. You have from this trade a higher tradeValue of: " + Math.abs(difference);
        }

        if (difference >= 0 && difference < TRADE_DIFF )
        {
            reason = "Trade works! Team: " + team1.getName() + " loses the trade. It has from this trade a higher tradeValue of: " + difference;
        }
        if (difference < 0 && difference > 0-TRADE_DIFF) {
            reason = "Trade works! Team: " + team2.getName() + " loses the trade. It has from this trade a higher tradeValue of: " + absDifference;
        }

        String proposeResult = reason;

        System.out.println("\n" + reason);

        System.out.println("Team 1: " + team1.getName() + " Total TradeValue: " + p1sum);
        proposeResult += "\n" + "Team 1: " + team1.getName() + " Total TradeValue: " + p1sum;
        for (Player p: p1) {
            System.out.println("Player: " + p.getName() + ": Trade Value: " + Player.round(tradeValue(p, team2),1));
            proposeResult += "\nPlayer: " + p.getName() + ": Trade Value: " + Player.round(tradeValue(p, team2),1);
        }

        System.out.println("Team 2: " + team2.getName() + " Total TradeValue: " + p2sum);
        proposeResult += "\nTeam 2: " + team2.getName() + " Total TradeValue: " + p2sum;
        for (Player p: p2) {
            System.out.println("Player: " + p.getName() + ": Trade Value: " + Player.round(tradeValue(p, team2),1));
            proposeResult += "\nPlayer: " + p.getName() + ": Trade Value: " + Player.round(tradeValue(p, team2),1);
        }

        windowTrade.clearTextAreaBottom();
        windowTrade.printLogBottom(proposeResult);

        if (result) {
            System.out.println("\nExecute trade--Yes or No: ");
            windowTrade.printLogBottom("\nExecute trade--Yes or No: ");
            Scanner reader = new Scanner(System.in);
            try {
                String input = reader.nextLine();
                input = input.toLowerCase();
                while (!(input.equals("yes") || input.equals("no"))) {
                    if (!(input.equals("yes") || input.equals("no"))) {
                        System.out.println("Execute--Yes or No: ");
                        input = reader.nextLine();
                        input = input.toLowerCase();
                    }
                }
                if (input.equals("yes")) {
                    windowTrade.printLogBottom(
                            "\n0.Instructions  1.Start Season  2.Sim Games  3.Trade  4.View Teams/Player Info  5.View Teams/Roster Stats  6.Cut Player  " +
                                    "7.Sign Player  8.Begin Draft  9.Exit Game (NO SAVES)");
                    Trade.trade(p1, team1, p2, team2);
                }
                if (input.equals("no")) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("You didn't say yes. \n ");
            }
        }
        League.homeView();
        return result;
    }

    /**
     * only takes from proposeTrade()
     * executes trade between teams
     * @param p1
     * @param team1
     * @param p2
     * @param team2
     */
    public static void trade(ArrayList<Player> p1, Team team1, ArrayList<Player> p2, Team team2) {
            ArrayList<Player> roster1 = team1.getTeam();
            ArrayList<String> names1 = new ArrayList<>();

            ArrayList<String> names2 = new ArrayList<>();
            ArrayList<Player> roster2 = team2.getTeam();

            MyGUI2 windowTradeResult = new MyGUI2();
            windowTradeResult.create("Trade Result: " + team1.getName(), "Trade Result: " + team2.getName(), "Trade Result");
            for (Player p : p1) {
                names1.add(p.getName());
            }
            for (Player p : p2) {
                names2.add(p.getName());
            }
            //trades players in p1 to team2

            System.out.println(p1.size());

            for (Player p : p1) {
                team2.add(roster1.remove(roster1.indexOf(p)));
                p.changeTeam(team2.getName());
            }

            //trades players in p2 to team1

            for (Player p : p2) {
                team1.add(roster2.remove(roster2.indexOf(p)));
                p.changeTeam(team1.getName());
            }


        windowTradeResult.printLogLeft(team1.printTeam());
        windowTradeResult.printLogRight(team2.printTeam());

        String tradeResult = "\nTrade Result:";

        System.out.println("\n \n \n TRADE RESULT ");
            //System.out.println(team1.printTeam());
            //System.out.println(team2.printTeam());
            for (Player p : p1) {
                tradeResult += ("\nPlayer: " + p.getName() + " was traded from the: " + team1.getName() + " to the: " + team2.getName());
                System.out.println("Player: " + p.getName() + " was traded from the: " + team1.getName() + " to the: " + team2.getName());
            }
            for (Player p : p2) {
                tradeResult += "\n \nPlayer: " + p.getName() + " was traded from the: " + team2.getName() + " to the: " + team1.getName();
                System.out.println("Player: " + p.getName() + " was traded from the: " + team2.getName() + " to the: " + team1.getName());
            }
        windowTradeResult.printLogBottom("\nClose this window when done viewing." + tradeResult + "\nClose this window when done viewing.");
        League.homeView();
    }

    //UPDATE: NO TRADING DRAFT PICKS AND FUNCTIONALITY OF 3 TEAM TRADE CAN BE DONE WITH MULTIPLE 2 TEAM TRADES
    /*    //smallest unit of trade between 2 teams
    public static boolean propose2Trade(Team t1, Team t2) {
        Scanner players1 = new Scanner(System.in);
        int player1 = players1.nextInt();
        Scanner players2 = new Scanner(System.in);

    return false;
    }*/

/*    public static double tradeValue(DraftPick d) {
        double tradeValue = 0.0;
        if (d.getRd()) tradeValue = 80;
        else
            tradeValue = 55;
        return tradeValue;
    }

    //only allowing functionality for 3 team trades
    public static boolean propose3Trade(Team t1, Team t2, Team t3) { return false;

    }*/
    //UPDATE: NEVER WORKED, DRAFTPICKS NEVER MADE, TRADE METHOD IS POWERFUL ENOUGH TO FACILITATE AI-TO-AI TRADES AS WELL AS DRAFTED PLAYERS
    /*public static int tradeDraftPick() {//how tf is this going to work
        //heres how i envision it: go to Draft and see commented out parts of nextPick()
        //if truePick < 30, tradeValue = 70, if truePick > 30, tradeValue = 55
        }
        */

    //UPDATE: SOMEHOW I BROKE IT, NO LONGER NEEDED, AND SHOULD BE LEFT UNTOUCHED
    //probably will make int pIndex a different param, maybe player name
    /*public static void trade(Player p, Team originalTeam, Team newTeam) {
        ArrayList<Player> origRoster = originalTeam.getTeam();
        String name = p.getName();
        newTeam.add(origRoster.remove(origRoster.indexOf(p)));

        ArrayList<Player> roster = newTeam.getTeam();
        roster.get(roster.size() - 1).changeTeam(newTeam.getName());

        System.out.println("\n \n \n TRADE RESULT ");
        System.out.println(originalTeam.printTeam());
        System.out.println(newTeam.printTeam());

        System.out.println("Player: " + name + " was traded from the: " + originalTeam.getName() + " to the: " + newTeam.getName());
    }*/
}

