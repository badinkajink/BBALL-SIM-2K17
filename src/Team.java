import java.util.ArrayList;

/**
 * Created by William on 5/23/2017.
 * team class
 */

public class Team {

    private String name;
    private boolean isClient;
    private ArrayList<Player> roster;
    /*private ArrayList<Contract> contracts;
    private ArrayList<DraftPick> tradedPicks = new ArrayList<DraftPick>();*/
    private int index;

    private double cap;

    private int wins;
    private int losses;

    private String draftMessage = "";


    /**
     * constructs team with 12 players
     * @param n
     * @param index
     */
    //also a placeholder constructor until i can get random name generator
    public Team(String n, int index)
    {
        this.index = index;
        name = n;
        roster  = new ArrayList<Player>();
        for(int i = 0; i < 12; i++)
        {
            Player p = new Player(name);
            roster.add(p);
            //contracts.add(p.getContract());
        }
    }

    /**
     * tester team constructor, not used
     */
    //super placeholder constructor
    public Team()
    {
        name = "placeholder";
        roster  = new ArrayList<Player>();
        for(int i = 0; i < 12; i++)
        {
            roster.add(new Player(name));
        }
    }

    //UPDATE: NOT MAKING DRAFTPICKS OR CONTRACTS/SALARYCAPS
/*    public void addDraftPick(DraftPick dP) {
        tradedPicks.add(dP);
    }

    public DraftPick getDraftPick(int year, boolean round) {
        DraftPick dPick = new DraftPick(year, round);
        return dPick;
    }

    public void proposeSign(Player p, Contract c) {

    }*/

    /**
     * sets a team to be a client
     */
    public void setClient() {
        isClient = true;
    }

    /**
     * increments wins
     */
    public void updateWins() {
        wins++;
    }

    /**
     * increments losses
     */
    public void updateLosses() {
        losses++;
    }

    /**
     *
     * @return wins
     */
    public int getWins() { return wins;}

    /**
     * updates players with one more year of experience
     */
    public void updatePlayers(){
        for (Player p: roster) {
            p.updatePlayer();
        }
    }

    /**
     *
     * @return arraylist of players in a team
     */
    public ArrayList<Player> getTeam()
    {
        return roster;
    }

    /**
     *
     * @return 0-99 attributes of each player on a team
     */
    public String printTeam() {
        String result = getName() + " " + getName() + " " + getName() + "\n";
        int count = 1;
        for (Player p: roster){
            result += "\nPlayer " + count + ": \n" + p.printPlayer() + "\n";
            count++;
        }
        return result;
    }

    /**
     * adds a player to the team
     * @param p
     */
    public void add(Player p) {
        roster.add(p);
    }

    /**
     * returns name of a team
     * @return team name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return short team name
     */
    public String getShortName() { return name.substring(name.lastIndexOf(" ") + 1);}

    //ai commands

    /**
     *drafts first player available, highest playerValue, according to mysterious game engine and Chad Ford
     * if client, redirects to console input
     * @param d
     */
    public void draftPlayer(ArrayList<Player> d) {
        if (isClient) {
            Client.draftPlayer(d);
        }
        else {
            draftMessage = ("\n" + getName() + " picked: " + d.get(0).getName() + " at pick: " + Draft.truePick());
            //System.out.println(getName() + " picked: " + d.get(0).getName() + " at pick: " + Draft.truePick());
            roster.add(d.remove(0));
            roster.get(roster.size() - 1).getPlayer().changePos(Draft.truePick());
            roster.get(roster.size() - 1).changeTeam(name);
        }
    }

    /**
     *
     * @return header in for window output displaying which team has picked which playet with which pick
     */
    public String getDraftMessage() { return draftMessage;}

    /**
     * not really sure why i need this
     * @param d
     */
    public void setDraftMessage(String d) { draftMessage = d;}

    /**
     *
     * @return roster stats (stats per game in a season
     */
    public String printTeamStats() {
        String result = "TEAM STATS: " + name + " W/L: " + wins + "-" + losses + "\n";
        int count = 1;
        for (Player p: roster) {
            result += count + ": " + p.getName() + " Games: " + p.getGames() + " PPG: "
                    + p.getPointPerGame() + " RPG: " + p.getReboundPerGame() +
                    " APG: " + p.getAssistPerGame() + " SPG: " + p.getStealPerGame() + " BPG: "
                    + p.getBlockPerGame() + " TPG: " + p.getTurnoverPerGame() +
                    "  FPG: " + p.getFoulPerGame()  + " \n";
                    //"  FT%: " + p.getFTPCT() + "  FG%: " + p.getFGPCT() + "  2G%: " + p.get2GPCT() + "  3G%: " + p.get3GPCT() +
            count++;
        }
        return result;
    }

    /**
     *
     * @return game header for game simulations
     */
    public String printGameHeader() {
        return name + ": W/L: " + wins + "-" + losses;
    }

    public void seasonReset() {
        wins = 0;
        losses = 0;
    }

    /**
     * automates player signings if players < 12
     */
    public void signPlayers() {
        while (roster.size() < 12)
        {
            if (isClient){
                Client.signPlayers();
            }
            else{
                System.out.println("\n" + name + " signed Player: " + League.getBestPlayerPool().getName() + "\n");
                League.getBestPlayerPool().changeTeam(name);
                roster.add(League.getPlayerPool().remove(League.getPlayerPool().indexOf(League.getBestPlayerPool())));
            }
        }
    }

    /**
     * gets worst player in team by playervalue
     * @return
     */
    public Player getWorst() {
        Player worst = null;
        for (int i = 0; i < roster.size(); i++) {
            if (i == 0 || roster.get(i).getPlayer().getPV() < roster.get(i-1).getPlayer().getPV()) {
                worst = roster.get(i);
            }
        }
        return worst;
    }

    /**
     * removes (kills) players older than 39
     */
    public void retirePlayers() {
        for (Player p: roster) {
            if (p.getPlayer().getAge() > 39) {
                System.out.println(name + ": " + p.getName() + " retired.");
                roster.remove(roster.indexOf(p)); //ethered
            }
        }
    }

    /**
     * cuts worst player if > 12 players
     */
    public void cutPlayers() {
        while (roster.size() > 12)
        {
            retirePlayers();
            if (isClient){
                Client.cutPlayers();
            }
            else {
                System.out.println("\n" + name + " cut Player: " + getWorst().getName() + " PlayerValue: " + getWorst().getPlayer().getPV());
                System.out.println(getWorst().getName() + " is now in the PlayerPool.\n");
                getWorst().changeTeam("PlayerPool");
                League.getPlayerPool().add(roster.remove(roster.indexOf(getWorst())));
            }
        }
    }

    /**
     * calls cut and sign. not needed, was troubleshooting things and wanted more convenient method
     */
    public void cutOrSignPlayers() {
        while(lessMore12Players())
        {
            cutPlayers();
            signPlayers();
        }
    }

    public boolean lessMore12Players() {
        return roster.size() > 12 || roster.size() < 12;
    }

    public boolean getIsClient() {
        return isClient;
    }
    // you have to make a DraftPick class
    /*public boolean pickTraded(boolean traded, Team t, int year) {
        return traded;
    }

    public Team pickTradedTo()
*/

}
