import java.util.ArrayList;

/**
 * Created by William on 5/23/2017.
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

    public void setClient() {
        isClient = true;
    }

    public void updateWins() {
        wins++;
    }

    public void updateLosses() {
        losses++;
    }

    public int getWins() { return wins;}

    public void updatePlayers(){
        for (Player p: roster) {
            p.updatePlayer();
        }
    }

    public ArrayList<Player> getTeam()
    {
        return roster;
    }

    public String printTeam() {
        String result = "\n" + "\n" + getName() + " " + getName() + " " + getName() + "\n" + "\n";
        int count = 1;
        for (Player p: roster){
            result += "\nPlayer " + count + ": \n" + p.printPlayer() + "\n";
            count++;
        }
        return result;
    }

    public void add(Player p) {
        roster.add(p);
    }

    public String getName() {
        return name;
    }

    public String getShortName() { return name.substring(name.lastIndexOf(" ") + 1);}

    //ai commands

    //drafts first player available, highest playerValue, according to mysterious game engine and Chad Ford
    //pick local field is cosmetic
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

    public String getDraftMessage() { return draftMessage;}
    public void setDraftMessage(String d) { draftMessage = d;}

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

    public String printGameHeader() {
        return name + ": W/L: " + wins + "-" + losses;
    }

    public void seasonReset() {
        for (Player p: roster) { p.resetTotals(); }
        wins = 0;
        losses = 0;
    }

    //
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

    public Player getWorst() {
        Player worst = null;
        for (int i = 0; i < roster.size(); i++) {
            if (i == 0 || roster.get(i).getPlayer().getPV() < roster.get(i-1).getPlayer().getPV()) {
                worst = roster.get(i);
            }
        }
        return worst;
    }

    public void retirePlayers() {
        for (Player p: roster) {
            if (p.getPlayer().getAge() > 39) {
                System.out.println(name + ": " + p.getName() + " retired.");
                roster.remove(roster.indexOf(p)); //ethered
            }
        }
    }

    public void cutPlayers() {
        while (roster.size() > 12)
        {
            retirePlayers();
            if (isClient){
                Client.cutPlayers();
            }
            else {
                System.out.println("\n" + name + " cut Player: " + getWorst().getName() + "PlayerValue: " + getWorst().getPlayer().getPV());
                System.out.println(getWorst().getName() + " is now in the PlayerPool.\n");
                getWorst().changeTeam("PlayerPool");
                League.getPlayerPool().add(roster.remove(roster.indexOf(getWorst())));
            }
        }

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
