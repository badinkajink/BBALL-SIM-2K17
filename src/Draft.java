import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by WilliamUSER on 5/23/2017.
 * simulates a basketball draft of 60 new players
 */
public class Draft {
    private static ArrayList<Player> rookies;
    private static int truePick; //keeping track of index of pick
    private static int year;
    private static ArrayList<Team> draftOrder = League.getDraftOrder();
    private MyGUI2 windowDraft;

    /**
     * constructor creates draft of 60 new (20 yrs old, 0 yrs experience) players
     * resets rookie player generators
     * @param y year of draft
     */
    public Draft(int y) {
        year = y;
        truePick = 1;
        rookies = new ArrayList<Player>();
        ProfileGenerator.rookieDraftReset();
        int count = 1;
        for (int i = 0; i < 60; i++) {
            Player p = new Player(0, 20);
            rookies.add(p);
            count++;
        }
    }

    /**
     * when invoked creates a new draft
     * opens window displaying draft players and team pick order
     * console scans for user input on whether to begin draft/begin picking or not
     * @throws InputMismatchException if client enters something besides "yes," i would really prefer it if you just entered "yes"
     */
    public void start() throws InputMismatchException {
        windowDraft = new MyGUI2();
        windowDraft.create("Draft", "Team Picks");

        windowDraft.printLogLeft("\nWelcome to the " + year + " Basketball Simulator 2K17 Draft! \n");
        windowDraft.printLogLeft("These are Chad Ford's draft rankings. You don't need to follow his order, but AI teams will." +
                "\nFord's rankings are maintained in the 'Position' portion of the player bar, which for now aligns with Player Index." +
                "\nHowever, when you are picking a player and inputting numbers, refer only to 'Player Index'." +
                "\n Below are the rankings. Enter 'yes' to begin picking.");
        //windowTrade.clearTextAreaLeft();
        //windowDraft.clearTextAreaLeft();
        windowDraft.printLogRight(League.printDraftOrder());
        windowDraft.printLogLeft(printDraft());
        try {
            System.out.println("\nBegin picking--Yes or No: ");
            Scanner reader = new Scanner(System.in);
            String input = reader.nextLine();
            input = input.toLowerCase();
            while (!(input.equals("yes") || input.equals("no"))) {
                if (!(input.equals("yes") || input.equals("no"))) {
                    System.out.println("Begin picking--Yes or No: ");
                    input = reader.nextLine();
                    input = input.toLowerCase();
                }
            }
            if (input.equals("yes")) {
                //System.out.println("The first pick of the draft: 1");
                windowDraft.clearTextAreaRight();
                windowDraft.printLogRight("The first pick of the draft: 1");
                nextPick();
            }
            if (input.equals("no")) {
                League.homeView();
            }

        }
        catch (InputMismatchException e) {
            System.out.println("You didn't say yes. \n ");
            League.homeView();
        }

    }


    /**
     * probably won't need to use anymore
     * @return ArrayList<PlayeR></PlayeR> list of rookies, not needed
     */
    public ArrayList<Player> getDraft() {
        return rookies;
    }

    /**
     * prints all players left in draft by mock rankings
     * @return list of all draft players by mock draft rankings
     */
    public static String printDraft() {
        String result = "";
        int count = 1;
        for (Player p: rookies){
            result += "\nPlayer Index: " + count + ": \n" + p.printPlayer() + "\n";
            count++;
        }
        return result;
    }

    /**
     * goes to next pick in draft
     * calls next team in team draft order to make a pick
     */
    public void nextPick() {
        while (truePick <=61) {
            //the next two if loops are for testing purposes and probably shouldnt stay
            windowDraft.clearTextAreaLeft();
            windowDraft.printLogLeft(printDraft());
            if (truePick == 31) {
                windowDraft.printLogRight("\n Welcome to the second round! ");
                windowDraft.printLogRight("The thirty-first pick of the draft: 31");
                //System.out.println("\n Welcome to the second round! ");
                //System.out.println(printDraft());
                //System.out.println("The thirty-first pick of the draft: 31");
                //truePick++;
                //nextPick();
            }
            if (truePick == 61) {
                windowDraft.printLogRight("\nThe draft is over!");
                //System.out.println("\nThe draft is over!");
                System.out.println(printDraft()); //should print nothing
                truePick++;
                League.setDraft();
                League.homeView();
                }
            if (truePick <= 30) {
                draftOrder.get(truePick - 1).draftPlayer(rookies);
                windowDraft.printLogRight(draftOrder.get(truePick - 1).getDraftMessage());
                truePick++;
                if (truePick < 31)
                    //System.out.println("\nNext up is pick: " + truePick);
                    windowDraft.printLogRight("\nNext up is pick: " + truePick);
                nextPick();
            }
            if (truePick > 30 && truePick <= 60) {
                draftOrder.get(truePick - 31).draftPlayer(rookies);
                windowDraft.printLogRight(draftOrder.get(truePick - 31).getDraftMessage());
                truePick++;
                if (truePick <61)
                    //System.out.println("\nNext up is pick: " + truePick);
                    windowDraft.printLogRight("\nNext up is pick: " + truePick);
                nextPick();
            }
            }
        }


    //JUST MAKE A DRAFTPICK CLASS

    /**
     * truepick allows teams to keep track of who is picking if going outside of mock rankings order
     * @return true index of picking sequence
     */
    public static int truePick() {
        return truePick;
    }
}
