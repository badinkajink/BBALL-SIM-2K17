/**
 * Created by William on 5/22/2017.
 * eric's voodoo magic
 * dont question it. i don't understand it either.
 * generates box scores
 */

import java.util.Random;

/**
 * gamescore class allows for game simulation
 * monstrosity of a class written entirely by eric xue
 * could easily have been made thousands of lines shorter with for loops but no
 * @author eric xue
 */
public class GameScore {

    //instance fields
    //lineups for both competing teams
    private Player[] lineup1;
    private Player[] lineup2;
    private Team team1;
    private Team team2;

    //offensive and defensive ratings for all 12 players on both teams
    private int oRating1;
    private int oRating2;
    private int oRating3;
    private int oRating4;
    private int oRating5;
    private int oRating6;
    private int oRating7;
    private int oRating8;
    private int oRating9;
    private int oRating10;
    private int oRating11;
    private int oRating13;
    private int dRating1;
    private int dRating2;
    private int dRating3;
    private int dRating4;
    private int dRating5;
    private int dRating6;
    private int dRating7;
    private int dRating8;
    private int dRating9;
    private int dRating10;
    private int dRating11;
    private int dRating13;
    private int oRating12;
    private int oRating22;
    private int oRating32;
    private int oRating42;
    private int oRating52;
    private int oRating62;
    private int oRating72;
    private int oRating82;
    private int oRating92;
    private int oRating102;
    private int oRating112;
    private int oRating122;
    private int dRating12;
    private int dRating22;
    private int dRating32;
    private int dRating42;
    private int dRating52;
    private int dRating62;
    private int dRating72;
    private int dRating82;
    private int dRating92;
    private int dRating102;
    private int dRating112;
    private int dRating122;

    //total points of both teams at end of game
    private int team1points = 0;
    private int team2points = 0;

    private int teamOnePoints;
    private int teamTwoPoints;

    /**
     *  simulates a game, determining the boxscore and how the game played out, assigning stats to players depending on their ratings
     */
    public void simGame(Team team1, Team team2) {
        teamOnePoints = 0;
        teamTwoPoints = 0;

        Random random = new Random();
        int randomChance = random.nextInt(100);

        this.team1 = team1;
        this.team2 = team2;

        //instantiates team arrays that store the players
        lineup1 = team1.getTeam().toArray(new Player[team1.getTeam().size()]);
        lineup2 = team2.getTeam().toArray(new Player[team2.getTeam().size()]);

        for (Player p:lineup1) {
            p.updateGames(1);
        }

        for (Player p:lineup2) {
            p.updateGames(1);
        }

        //instantiates offensive rating of all players on team 1
        oRating1 = lineup1[0].getPlayer().getPlayerRatings()[0];
        oRating2 = lineup1[1].getPlayer().getPlayerRatings()[0];
        oRating3 = lineup1[2].getPlayer().getPlayerRatings()[0];
        oRating4 = lineup1[3].getPlayer().getPlayerRatings()[0];
        oRating5 = lineup1[4].getPlayer().getPlayerRatings()[0];
        oRating6 = lineup1[5].getPlayer().getPlayerRatings()[0];
        oRating7 = lineup1[6].getPlayer().getPlayerRatings()[0];
        oRating8 = lineup1[7].getPlayer().getPlayerRatings()[0];
        oRating9 = lineup1[8].getPlayer().getPlayerRatings()[0];
        oRating10 = lineup1[9].getPlayer().getPlayerRatings()[0];
        oRating11 = lineup1[10].getPlayer().getPlayerRatings()[0];
        oRating13 = lineup1[11].getPlayer().getPlayerRatings()[0];

        //average of offensive ratings on team 1
        int oRatingTotal1 = (oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8 + oRating9 + oRating10 + oRating11 + oRating13) / 12;

        //instantiates defensive rating of all players on team 2
        dRating1 = lineup2[0].getPlayer().getPlayerRatings()[1];
        dRating2 = lineup2[1].getPlayer().getPlayerRatings()[1];
        dRating3 = lineup2[2].getPlayer().getPlayerRatings()[1];
        dRating4 = lineup2[3].getPlayer().getPlayerRatings()[1];
        dRating5 = lineup2[4].getPlayer().getPlayerRatings()[1];
        dRating6 = lineup2[5].getPlayer().getPlayerRatings()[1];
        dRating7 = lineup2[6].getPlayer().getPlayerRatings()[1];
        dRating8 = lineup2[7].getPlayer().getPlayerRatings()[1];
        dRating9 = lineup2[8].getPlayer().getPlayerRatings()[1];
        dRating10 = lineup2[9].getPlayer().getPlayerRatings()[1];
        dRating11 = lineup2[10].getPlayer().getPlayerRatings()[1];
        dRating13 = lineup2[11].getPlayer().getPlayerRatings()[1];

        //average of defensive ratings on team 1
        int dRatingTotal1 = (dRating1 + dRating2 + dRating3 + dRating4 + dRating5 + dRating6 + dRating7 + dRating8 + dRating9 + dRating10 + dRating11 + dRating13) / 12;

        //determines how many points team 1 scored
        int points1 = 0;
        for (int i = 0; i < 200; i++) {
            points1 = random.nextInt(oRatingTotal1 + dRatingTotal1);
            if (points1 <= oRatingTotal1) {
                team1points++;
            }
        }

        teamOnePoints = team1points;

        //instantiates offensive ratings of all players on team 2
        oRating12 = lineup1[0].getPlayer().getPlayerRatings()[0];
        oRating22 = lineup1[1].getPlayer().getPlayerRatings()[1];
        oRating32 = lineup1[2].getPlayer().getPlayerRatings()[1];
        oRating42 = lineup1[3].getPlayer().getPlayerRatings()[1];
        oRating52 = lineup1[4].getPlayer().getPlayerRatings()[1];
        oRating62 = lineup1[5].getPlayer().getPlayerRatings()[1];
        oRating72 = lineup1[6].getPlayer().getPlayerRatings()[1];
        oRating82 = lineup1[7].getPlayer().getPlayerRatings()[1];
        oRating92 = lineup1[8].getPlayer().getPlayerRatings()[1];
        oRating102 = lineup1[9].getPlayer().getPlayerRatings()[1];
        oRating112 = lineup1[10].getPlayer().getPlayerRatings()[1];
        oRating122 = lineup1[11].getPlayer().getPlayerRatings()[1];

        //average of all offensive ratings on team 2
        int oRatingTotal2 = (oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82 + oRating92 + oRating102 + oRating112 + oRating122) / 12;

        //intantiates defensive ratings of all players on team 2
        dRating12 = lineup2[0].getPlayer().getPlayerRatings()[0];
        dRating22 = lineup2[1].getPlayer().getPlayerRatings()[0];
        dRating32 = lineup2[2].getPlayer().getPlayerRatings()[0];
        dRating42 = lineup2[3].getPlayer().getPlayerRatings()[0];
        dRating52 = lineup2[4].getPlayer().getPlayerRatings()[0];
        dRating62 = lineup2[5].getPlayer().getPlayerRatings()[0];
        dRating72 = lineup2[6].getPlayer().getPlayerRatings()[0];
        dRating82 = lineup2[7].getPlayer().getPlayerRatings()[0];
        dRating92 = lineup2[8].getPlayer().getPlayerRatings()[0];
        dRating102 = lineup2[9].getPlayer().getPlayerRatings()[0];
        dRating112 = lineup2[10].getPlayer().getPlayerRatings()[0];
        dRating122 = lineup2[11].getPlayer().getPlayerRatings()[0];

        //average of all defensive ratings on team 2
        int dRatingTotal2 = (dRating12 + dRating22 + dRating32 + dRating42 + dRating52 + dRating62 + dRating72 + dRating82 + dRating92 + dRating102 + dRating112 + dRating122) / 12;

        //determines how many points team 2 scored
        int points2 = 0;
        for (int i = 0; i < 200; i++) {
            points2 = random.nextInt(oRatingTotal2 + dRatingTotal2);
            if (points2 <= oRatingTotal2) {
                team2points++;
            }
        }

        teamTwoPoints = team2points;

        //determines who won the game
        if (team1points > team2points) {
            team1.updateWins();
            team2.updateLosses();
        } else if (team2points > team1points) {
            team1.updateLosses();
            team2.updateWins();
        } else if (team1points == team2points) {
            double n = Math.random();
            if (n <= 0.5) {
                team1points++;
                team1.updateWins();
                team2.updateLosses();
            }
            else if (n  > .5 && n < 1.0) {
                team2points++;
                team1.updateLosses();
                team2.updateWins();
            }
        }

        //instantiates player values of all 12 players on team 1
        int t1p1pV = lineup1[0].getPlayer().getPV();
        int t1p2pV = lineup1[1].getPlayer().getPV();
        int t1p3pV = lineup1[2].getPlayer().getPV();
        int t1p4pV = lineup1[3].getPlayer().getPV();
        int t1p5pV = lineup1[4].getPlayer().getPV();
        int t1p6pV = lineup1[5].getPlayer().getPV();
        int t1p7pV = lineup1[6].getPlayer().getPV();
        int t1p8pV = lineup1[7].getPlayer().getPV();
        int t1p9pV = lineup1[8].getPlayer().getPV();
        int t1p10pV = lineup1[9].getPlayer().getPV();
        int t1p11pV = lineup1[10].getPlayer().getPV();
        int t1p12pV = lineup1[11].getPlayer().getPV();

        int pvTotal1 = t1p1pV + t1p2pV + t1p3pV + t1p4pV + t1p5pV + t1p6pV + t1p7pV + t1p8pV + t1p9pV + t1p10pV + t1p11pV + t1p12pV;

        //instantiates player values of all 12 players on team 2
        int t2p1pV = lineup2[0].getPlayer().getPV();
        int t2p2pV = lineup2[1].getPlayer().getPV();
        int t2p3pV = lineup2[2].getPlayer().getPV();
        int t2p4pV = lineup2[3].getPlayer().getPV();
        int t2p5pV = lineup2[4].getPlayer().getPV();
        int t2p6pV = lineup2[5].getPlayer().getPV();
        int t2p7pV = lineup2[6].getPlayer().getPV();
        int t2p8pV = lineup2[7].getPlayer().getPV();
        int t2p9pV = lineup2[8].getPlayer().getPV();
        int t2p10pV = lineup2[9].getPlayer().getPV();
        int t2p11pV = lineup2[10].getPlayer().getPV();
        int t2p12pV = lineup2[11].getPlayer().getPV();

        int pvTotal2 = t2p1pV + t2p2pV + t2p3pV + t2p4pV + t2p5pV + t2p6pV + t2p7pV + t2p8pV + t2p9pV + t2p10pV + t2p11pV + t2p12pV;

        //instantiates specific ratings of all players on team 1
        int t1p1layup = lineup1[0].getPlayer().getPlayerRatings()[7] * t1p1pV ;
        int t1p2layup = lineup1[1].getPlayer().getPlayerRatings()[7] * t1p2pV;
        int t1p3layup = lineup1[2].getPlayer().getPlayerRatings()[7] * t1p3pV;
        int t1p4layup = lineup1[3].getPlayer().getPlayerRatings()[7] * t1p4pV;
        int t1p5layup = lineup1[4].getPlayer().getPlayerRatings()[7] * t1p5pV;
        int t1p6layup = lineup1[5].getPlayer().getPlayerRatings()[7] * t1p6pV;
        int t1p7layup = lineup1[6].getPlayer().getPlayerRatings()[7] * t1p7pV;
        int t1p8layup = lineup1[7].getPlayer().getPlayerRatings()[7] * t1p8pV;
        int t1p9layup = lineup1[8].getPlayer().getPlayerRatings()[7] * t1p9pV;
        int t1p10layup = lineup1[9].getPlayer().getPlayerRatings()[7] * t1p10pV;
        int t1p11layup = lineup1[10].getPlayer().getPlayerRatings()[7] * t1p11pV;
        int t1p12layup = lineup1[11].getPlayer().getPlayerRatings()[7] * t1p12pV;
        int t1p1dunk = lineup1[0].getPlayer().getPlayerRatings()[8] * t1p1pV;
        int t1p2dunk = lineup1[1].getPlayer().getPlayerRatings()[8] * t1p2pV;
        int t1p3dunk = lineup1[2].getPlayer().getPlayerRatings()[8] * t1p3pV;
        int t1p4dunk = lineup1[3].getPlayer().getPlayerRatings()[8] * t1p4pV;
        int t1p5dunk = lineup1[4].getPlayer().getPlayerRatings()[8] * t1p5pV;
        int t1p6dunk = lineup1[5].getPlayer().getPlayerRatings()[8] * t1p6pV;
        int t1p7dunk = lineup1[6].getPlayer().getPlayerRatings()[8] * t1p7pV;
        int t1p8dunk = lineup1[7].getPlayer().getPlayerRatings()[8] * t1p8pV;
        int t1p9dunk = lineup1[8].getPlayer().getPlayerRatings()[8] * t1p9pV;
        int t1p10dunk = lineup1[9].getPlayer().getPlayerRatings()[8] * t1p10pV;
        int t1p11dunk = lineup1[10].getPlayer().getPlayerRatings()[8] * t1p11pV;
        int t1p12dunk = lineup1[11].getPlayer().getPlayerRatings()[8] * t1p12pV;
        int t1p1mid = lineup1[0].getPlayer().getPlayerRatings()[9] * t1p1pV;
        int t1p2mid = lineup1[1].getPlayer().getPlayerRatings()[9] * t1p2pV;
        int t1p3mid = lineup1[2].getPlayer().getPlayerRatings()[9] * t1p3pV;
        int t1p4mid = lineup1[3].getPlayer().getPlayerRatings()[9] * t1p4pV;
        int t1p5mid = lineup1[4].getPlayer().getPlayerRatings()[9] * t1p5pV;
        int t1p6mid = lineup1[5].getPlayer().getPlayerRatings()[9] * t1p6pV;
        int t1p7mid = lineup1[6].getPlayer().getPlayerRatings()[9] * t1p7pV;
        int t1p8mid = lineup1[7].getPlayer().getPlayerRatings()[9] * t1p8pV;
        int t1p9mid = lineup1[8].getPlayer().getPlayerRatings()[9] * t1p9pV;
        int t1p10mid = lineup1[9].getPlayer().getPlayerRatings()[9] * t1p10pV;
        int t1p11mid = lineup1[10].getPlayer().getPlayerRatings()[9] * t1p11pV;
        int t1p12mid = lineup1[11].getPlayer().getPlayerRatings()[9] * t1p12pV;
        int t1p1three = lineup1[0].getPlayer().getPlayerRatings()[10] * t1p1pV ;
        int t1p2three = lineup1[1].getPlayer().getPlayerRatings()[10] * t1p2pV;
        int t1p3three = lineup1[2].getPlayer().getPlayerRatings()[10] * t1p3pV;
        int t1p4three = lineup1[3].getPlayer().getPlayerRatings()[10] * t1p4pV;
        int t1p5three = lineup1[4].getPlayer().getPlayerRatings()[10] * t1p5pV;
        int t1p6three = lineup1[5].getPlayer().getPlayerRatings()[10] * t1p6pV;
        int t1p7three = lineup1[6].getPlayer().getPlayerRatings()[10] * t1p7pV;
        int t1p8three = lineup1[7].getPlayer().getPlayerRatings()[10] * t1p8pV;
        int t1p9three = lineup1[8].getPlayer().getPlayerRatings()[10] * t1p9pV;
        int t1p10three = lineup1[9].getPlayer().getPlayerRatings()[10] * t1p10pV;
        int t1p11three = lineup1[10].getPlayer().getPlayerRatings()[10] * t1p11pV;
        int t1p12three = lineup1[11].getPlayer().getPlayerRatings()[10] * t1p12pV;
        int t1p1post = lineup1[0].getPlayer().getPlayerRatings()[11] * t1p1pV ;
        int t1p2post = lineup1[1].getPlayer().getPlayerRatings()[11] * t1p2pV;
        int t1p3post = lineup1[2].getPlayer().getPlayerRatings()[11] * t1p3pV;
        int t1p4post = lineup1[3].getPlayer().getPlayerRatings()[11] * t1p4pV;
        int t1p5post = lineup1[4].getPlayer().getPlayerRatings()[11] * t1p5pV;
        int t1p6post = lineup1[5].getPlayer().getPlayerRatings()[11] * t1p6pV;
        int t1p7post = lineup1[6].getPlayer().getPlayerRatings()[11] * t1p7pV;
        int t1p8post = lineup1[7].getPlayer().getPlayerRatings()[11] * t1p8pV;
        int t1p9post = lineup1[8].getPlayer().getPlayerRatings()[11] * t1p9pV;
        int t1p10post = lineup1[9].getPlayer().getPlayerRatings()[11] * t1p10pV;
        int t1p11post = lineup1[10].getPlayer().getPlayerRatings()[11] * t1p11pV;
        int t1p12post = lineup1[11].getPlayer().getPlayerRatings()[11] * t1p12pV;
        int t1p1ft = lineup1[0].getPlayer().getPlayerRatings()[12] * t1p1pV ;
        int t1p2ft = lineup1[1].getPlayer().getPlayerRatings()[12] * t1p2pV;
        int t1p3ft = lineup1[2].getPlayer().getPlayerRatings()[12] * t1p3pV;
        int t1p4ft = lineup1[3].getPlayer().getPlayerRatings()[12] * t1p4pV;
        int t1p5ft = lineup1[4].getPlayer().getPlayerRatings()[12] * t1p5pV;
        int t1p6ft = lineup1[5].getPlayer().getPlayerRatings()[12] * t1p6pV;
        int t1p7ft = lineup1[6].getPlayer().getPlayerRatings()[12] * t1p7pV;
        int t1p8ft = lineup1[7].getPlayer().getPlayerRatings()[12] * t1p8pV;
        int t1p9ft = lineup1[8].getPlayer().getPlayerRatings()[12] * t1p9pV;
        int t1p10ft = lineup1[9].getPlayer().getPlayerRatings()[12] * t1p10pV;
        int t1p11ft = lineup1[10].getPlayer().getPlayerRatings()[12] * t1p11pV;
        int t1p12ft = lineup1[11].getPlayer().getPlayerRatings()[12] * t1p12pV;
        int t1p1pass = lineup1[0].getPlayer().getPlayerRatings()[13] * t1p1pV;
        int t1p2pass = lineup1[1].getPlayer().getPlayerRatings()[13] * t1p2pV;
        int t1p3pass = lineup1[2].getPlayer().getPlayerRatings()[13] * t1p3pV;
        int t1p4pass = lineup1[3].getPlayer().getPlayerRatings()[13] * t1p4pV;
        int t1p5pass = lineup1[4].getPlayer().getPlayerRatings()[13] * t1p5pV;
        int t1p6pass = lineup1[5].getPlayer().getPlayerRatings()[13] * t1p6pV;
        int t1p7pass = lineup1[6].getPlayer().getPlayerRatings()[13] * t1p7pV;
        int t1p8pass = lineup1[7].getPlayer().getPlayerRatings()[13] * t1p8pV;
        int t1p9pass = lineup1[8].getPlayer().getPlayerRatings()[13] * t1p9pV;
        int t1p10pass = lineup1[9].getPlayer().getPlayerRatings()[13] * t1p10pV;
        int t1p11pass = lineup1[10].getPlayer().getPlayerRatings()[13] * t1p11pV;
        int t1p12pass = lineup1[11].getPlayer().getPlayerRatings()[13] * t1p12pV;
        int t1p1hand = lineup1[0].getPlayer().getPlayerRatings()[14] * t1p1pV ;
        int t1p2hand = lineup1[1].getPlayer().getPlayerRatings()[14] * t1p2pV;
        int t1p3hand = lineup1[2].getPlayer().getPlayerRatings()[14] * t1p3pV;
        int t1p4hand = lineup1[3].getPlayer().getPlayerRatings()[14] * t1p4pV;
        int t1p5hand = lineup1[4].getPlayer().getPlayerRatings()[14] * t1p5pV;
        int t1p6hand = lineup1[5].getPlayer().getPlayerRatings()[14] * t1p6pV;
        int t1p7hand = lineup1[6].getPlayer().getPlayerRatings()[14] * t1p7pV;
        int t1p8hand = lineup1[7].getPlayer().getPlayerRatings()[14] * t1p8pV;
        int t1p9hand = lineup1[8].getPlayer().getPlayerRatings()[14] * t1p9pV;
        int t1p10hand = lineup1[9].getPlayer().getPlayerRatings()[14] * t1p10pV;
        int t1p11hand = lineup1[10].getPlayer().getPlayerRatings()[14] * t1p11pV;
        int t1p12hand = lineup1[11].getPlayer().getPlayerRatings()[14] * t1p12pV;
        int t1p1reb = lineup1[0].getPlayer().getPlayerRatings()[15] * t1p1pV ;
        int t1p2reb = lineup1[1].getPlayer().getPlayerRatings()[15] * t1p2pV;
        int t1p3reb = lineup1[2].getPlayer().getPlayerRatings()[15] * t1p3pV;
        int t1p4reb = lineup1[3].getPlayer().getPlayerRatings()[15] * t1p4pV;
        int t1p5reb = lineup1[4].getPlayer().getPlayerRatings()[15] * t1p5pV;
        int t1p6reb = lineup1[5].getPlayer().getPlayerRatings()[15] * t1p6pV;
        int t1p7reb = lineup1[6].getPlayer().getPlayerRatings()[15] * t1p7pV;
        int t1p8reb = lineup1[7].getPlayer().getPlayerRatings()[15] * t1p8pV;
        int t1p9reb = lineup1[8].getPlayer().getPlayerRatings()[15] * t1p9pV;
        int t1p10reb = lineup1[9].getPlayer().getPlayerRatings()[15] * t1p10pV;
        int t1p11reb = lineup1[10].getPlayer().getPlayerRatings()[15] * t1p11pV;
        int t1p12reb = lineup1[11].getPlayer().getPlayerRatings()[15] * t1p12pV;
        int t1p1steal = lineup1[0].getPlayer().getPlayerRatings()[16] * t1p1pV ;
        int t1p2steal = lineup1[1].getPlayer().getPlayerRatings()[16] * t1p2pV;
        int t1p3steal = lineup1[2].getPlayer().getPlayerRatings()[16] * t1p3pV;
        int t1p4steal = lineup1[3].getPlayer().getPlayerRatings()[16] * t1p4pV;
        int t1p5steal = lineup1[4].getPlayer().getPlayerRatings()[16] * t1p5pV;
        int t1p6steal = lineup1[5].getPlayer().getPlayerRatings()[16] * t1p6pV;
        int t1p7steal = lineup1[6].getPlayer().getPlayerRatings()[16] * t1p7pV;
        int t1p8steal = lineup1[7].getPlayer().getPlayerRatings()[16] * t1p8pV;
        int t1p9steal = lineup1[8].getPlayer().getPlayerRatings()[16] * t1p9pV;
        int t1p10steal = lineup1[9].getPlayer().getPlayerRatings()[16] * t1p10pV;
        int t1p11steal = lineup1[10].getPlayer().getPlayerRatings()[16] * t1p11pV;
        int t1p12steal = lineup1[11].getPlayer().getPlayerRatings()[16] * t1p12pV;
        int t1p1block = lineup1[0].getPlayer().getPlayerRatings()[17] * t1p1pV;
        int t1p2block = lineup1[1].getPlayer().getPlayerRatings()[17] * t1p2pV;
        int t1p3block = lineup1[2].getPlayer().getPlayerRatings()[17] * t1p3pV;
        int t1p4block = lineup1[3].getPlayer().getPlayerRatings()[17] * t1p4pV;
        int t1p5block = lineup1[4].getPlayer().getPlayerRatings()[17] * t1p5pV;
        int t1p6block = lineup1[5].getPlayer().getPlayerRatings()[17] * t1p6pV;
        int t1p7block = lineup1[6].getPlayer().getPlayerRatings()[17] * t1p7pV;
        int t1p8block = lineup1[7].getPlayer().getPlayerRatings()[17] * t1p8pV;
        int t1p9block = lineup1[8].getPlayer().getPlayerRatings()[17] * t1p9pV;
        int t1p10block = lineup1[9].getPlayer().getPlayerRatings()[17] * t1p10pV;
        int t1p11block = lineup1[10].getPlayer().getPlayerRatings()[17] * t1p11pV;
        int t1p12block = lineup1[11].getPlayer().getPlayerRatings()[17] * t1p12pV;
        int t1p1bbiq = lineup1[0].getPlayer().getPlayerRatings()[18] * t1p1pV ;
        int t1p2bbiq = lineup1[1].getPlayer().getPlayerRatings()[18] * t1p2pV;
        int t1p3bbiq = lineup1[2].getPlayer().getPlayerRatings()[18] * t1p3pV;
        int t1p4bbiq = lineup1[3].getPlayer().getPlayerRatings()[18] * t1p4pV;
        int t1p5bbiq = lineup1[4].getPlayer().getPlayerRatings()[18] * t1p5pV;
        int t1p6bbiq = lineup1[5].getPlayer().getPlayerRatings()[18] * t1p6pV;
        int t1p7bbiq = lineup1[6].getPlayer().getPlayerRatings()[18] * t1p7pV;
        int t1p8bbiq = lineup1[7].getPlayer().getPlayerRatings()[18] * t1p8pV;
        int t1p9bbiq = lineup1[8].getPlayer().getPlayerRatings()[18] * t1p9pV;
        int t1p10bbiq = lineup1[9].getPlayer().getPlayerRatings()[18] * t1p10pV;
        int t1p11bbiq = lineup1[10].getPlayer().getPlayerRatings()[18] * t1p11pV;
        int t1p12bbiq = lineup1[11].getPlayer().getPlayerRatings()[18] * t1p12pV;

        //instantiates specific ratings of all players on team 2
        int t2p1layup = lineup2[0].getPlayer().getPlayerRatings()[7] * t2p1pV ;
        int t2p2layup = lineup2[1].getPlayer().getPlayerRatings()[7] * t2p2pV;
        int t2p3layup = lineup2[2].getPlayer().getPlayerRatings()[7] * t2p3pV;
        int t2p4layup = lineup2[3].getPlayer().getPlayerRatings()[7] * t2p4pV;
        int t2p5layup = lineup2[4].getPlayer().getPlayerRatings()[7] * t2p5pV;
        int t2p6layup = lineup2[5].getPlayer().getPlayerRatings()[7] * t2p6pV;
        int t2p7layup = lineup2[6].getPlayer().getPlayerRatings()[7] * t2p7pV;
        int t2p8layup = lineup2[7].getPlayer().getPlayerRatings()[7] * t2p8pV;
        int t2p9layup = lineup2[8].getPlayer().getPlayerRatings()[7] * t2p9pV;
        int t2p10layup = lineup2[9].getPlayer().getPlayerRatings()[7] * t2p10pV;
        int t2p11layup = lineup2[10].getPlayer().getPlayerRatings()[7] * t2p11pV;
        int t2p12layup = lineup2[11].getPlayer().getPlayerRatings()[7] * t2p12pV;
        int t2p1dunk = lineup2[0].getPlayer().getPlayerRatings()[8] * t2p1pV;
        int t2p2dunk = lineup2[1].getPlayer().getPlayerRatings()[8] * t2p2pV;
        int t2p3dunk = lineup2[2].getPlayer().getPlayerRatings()[8] * t2p3pV;
        int t2p4dunk = lineup2[3].getPlayer().getPlayerRatings()[8] * t2p4pV;
        int t2p5dunk = lineup2[4].getPlayer().getPlayerRatings()[8] * t2p5pV;
        int t2p6dunk = lineup2[5].getPlayer().getPlayerRatings()[8] * t2p6pV;
        int t2p7dunk = lineup2[6].getPlayer().getPlayerRatings()[8] * t2p7pV;
        int t2p8dunk = lineup2[7].getPlayer().getPlayerRatings()[8] * t2p8pV;
        int t2p9dunk = lineup2[8].getPlayer().getPlayerRatings()[8] * t2p9pV;
        int t2p10dunk = lineup2[9].getPlayer().getPlayerRatings()[8] * t2p10pV;
        int t2p11dunk = lineup2[10].getPlayer().getPlayerRatings()[8] * t2p11pV;
        int t2p12dunk = lineup2[11].getPlayer().getPlayerRatings()[8] * t2p12pV;
        int t2p1mid = lineup2[0].getPlayer().getPlayerRatings()[9] * t2p1pV;
        int t2p2mid = lineup2[1].getPlayer().getPlayerRatings()[9] * t2p2pV;
        int t2p3mid = lineup2[2].getPlayer().getPlayerRatings()[9] * t2p3pV;
        int t2p4mid = lineup2[3].getPlayer().getPlayerRatings()[9] * t2p4pV;
        int t2p5mid = lineup2[4].getPlayer().getPlayerRatings()[9] * t2p5pV;
        int t2p6mid = lineup2[5].getPlayer().getPlayerRatings()[9] * t2p6pV;
        int t2p7mid = lineup2[6].getPlayer().getPlayerRatings()[9] * t2p7pV;
        int t2p8mid = lineup2[7].getPlayer().getPlayerRatings()[9] * t2p8pV;
        int t2p9mid = lineup2[8].getPlayer().getPlayerRatings()[9] * t2p9pV;
        int t2p10mid = lineup2[9].getPlayer().getPlayerRatings()[9] * t2p10pV;
        int t2p11mid = lineup2[10].getPlayer().getPlayerRatings()[9] * t2p11pV;
        int t2p12mid = lineup2[11].getPlayer().getPlayerRatings()[9] * t2p12pV;
        int t2p1three = lineup2[0].getPlayer().getPlayerRatings()[10] * t2p1pV;
        int t2p2three = lineup2[1].getPlayer().getPlayerRatings()[10] * t2p2pV;
        int t2p3three = lineup2[2].getPlayer().getPlayerRatings()[10] * t2p3pV;
        int t2p4three = lineup2[3].getPlayer().getPlayerRatings()[10] * t2p4pV;
        int t2p5three = lineup2[4].getPlayer().getPlayerRatings()[10] * t2p5pV;
        int t2p6three = lineup2[5].getPlayer().getPlayerRatings()[10] * t2p6pV;
        int t2p7three = lineup2[6].getPlayer().getPlayerRatings()[10] * t2p7pV;
        int t2p8three = lineup2[7].getPlayer().getPlayerRatings()[10] * t2p8pV;
        int t2p9three = lineup2[8].getPlayer().getPlayerRatings()[10] * t2p9pV;
        int t2p10three = lineup2[9].getPlayer().getPlayerRatings()[10] * t2p10pV;
        int t2p11three = lineup2[10].getPlayer().getPlayerRatings()[10] * t2p11pV;
        int t2p12three = lineup2[11].getPlayer().getPlayerRatings()[10] * t2p12pV;
        int t2p1post = lineup2[0].getPlayer().getPlayerRatings()[11] * t2p1pV;
        int t2p2post = lineup2[1].getPlayer().getPlayerRatings()[11] * t2p2pV;
        int t2p3post = lineup2[2].getPlayer().getPlayerRatings()[11] * t2p3pV;
        int t2p4post = lineup2[3].getPlayer().getPlayerRatings()[11] * t2p4pV;
        int t2p5post = lineup2[4].getPlayer().getPlayerRatings()[11] * t2p5pV;
        int t2p6post = lineup2[5].getPlayer().getPlayerRatings()[11] * t2p6pV;
        int t2p7post = lineup2[6].getPlayer().getPlayerRatings()[11] * t2p7pV;
        int t2p8post = lineup2[7].getPlayer().getPlayerRatings()[11] * t2p8pV;
        int t2p9post = lineup2[8].getPlayer().getPlayerRatings()[11] * t2p9pV;
        int t2p10post = lineup2[9].getPlayer().getPlayerRatings()[11] * t2p10pV;
        int t2p11post = lineup2[10].getPlayer().getPlayerRatings()[11] * t2p11pV;
        int t2p12post = lineup2[11].getPlayer().getPlayerRatings()[11] * t2p12pV;
        int t2p1ft = lineup2[0].getPlayer().getPlayerRatings()[12] * t2p1pV;
        int t2p2ft = lineup2[1].getPlayer().getPlayerRatings()[12] * t2p2pV;
        int t2p3ft = lineup2[2].getPlayer().getPlayerRatings()[12] * t2p3pV;
        int t2p4ft = lineup2[3].getPlayer().getPlayerRatings()[12] * t2p4pV;
        int t2p5ft = lineup2[4].getPlayer().getPlayerRatings()[12] * t2p5pV;
        int t2p6ft = lineup2[5].getPlayer().getPlayerRatings()[12] * t2p6pV;
        int t2p7ft = lineup2[6].getPlayer().getPlayerRatings()[12] * t2p7pV;
        int t2p8ft = lineup2[7].getPlayer().getPlayerRatings()[12] * t2p8pV;
        int t2p9ft = lineup2[8].getPlayer().getPlayerRatings()[12] * t2p9pV;
        int t2p10ft = lineup2[9].getPlayer().getPlayerRatings()[12] * t2p10pV;
        int t2p11ft = lineup2[10].getPlayer().getPlayerRatings()[12] * t2p11pV;
        int t2p12ft = lineup2[11].getPlayer().getPlayerRatings()[12] * t2p12pV;
        int t2p1pass = lineup2[0].getPlayer().getPlayerRatings()[13] * t2p1pV;
        int t2p2pass = lineup2[1].getPlayer().getPlayerRatings()[13] * t2p2pV;
        int t2p3pass = lineup2[2].getPlayer().getPlayerRatings()[13] * t2p3pV;
        int t2p4pass = lineup2[3].getPlayer().getPlayerRatings()[13] * t2p4pV;
        int t2p5pass = lineup2[4].getPlayer().getPlayerRatings()[13] * t2p5pV;
        int t2p6pass = lineup2[5].getPlayer().getPlayerRatings()[13] * t2p6pV;
        int t2p7pass = lineup2[6].getPlayer().getPlayerRatings()[13] * t2p7pV;
        int t2p8pass = lineup2[7].getPlayer().getPlayerRatings()[13] * t2p8pV;
        int t2p9pass = lineup2[8].getPlayer().getPlayerRatings()[13] * t2p9pV;
        int t2p10pass = lineup2[9].getPlayer().getPlayerRatings()[13] * t2p10pV;
        int t2p11pass = lineup2[10].getPlayer().getPlayerRatings()[13] * t2p11pV;
        int t2p12pass = lineup2[11].getPlayer().getPlayerRatings()[13] * t2p12pV;
        int t2p1hand = lineup2[0].getPlayer().getPlayerRatings()[14] * t2p1pV;
        int t2p2hand = lineup2[1].getPlayer().getPlayerRatings()[14] * t2p2pV;
        int t2p3hand = lineup2[2].getPlayer().getPlayerRatings()[14] * t2p3pV;
        int t2p4hand = lineup2[3].getPlayer().getPlayerRatings()[14] * t2p4pV;
        int t2p5hand = lineup2[4].getPlayer().getPlayerRatings()[14] * t2p5pV;
        int t2p6hand = lineup2[5].getPlayer().getPlayerRatings()[14] * t2p6pV;
        int t2p7hand = lineup2[6].getPlayer().getPlayerRatings()[14] * t2p7pV;
        int t2p8hand = lineup2[7].getPlayer().getPlayerRatings()[14] * t2p8pV;
        int t2p9hand = lineup2[8].getPlayer().getPlayerRatings()[14] * t2p9pV;
        int t2p10hand = lineup2[9].getPlayer().getPlayerRatings()[14] * t2p10pV;
        int t2p11hand = lineup2[10].getPlayer().getPlayerRatings()[14] * t2p11pV;
        int t2p12hand = lineup2[11].getPlayer().getPlayerRatings()[14] * t2p12pV;
        int t2p1reb = lineup2[0].getPlayer().getPlayerRatings()[15] * t2p1pV;
        int t2p2reb = lineup2[1].getPlayer().getPlayerRatings()[15] * t2p2pV;
        int t2p3reb = lineup2[2].getPlayer().getPlayerRatings()[15] * t2p3pV;
        int t2p4reb = lineup2[3].getPlayer().getPlayerRatings()[15] * t2p4pV;
        int t2p5reb = lineup2[4].getPlayer().getPlayerRatings()[15] * t2p5pV;
        int t2p6reb = lineup2[5].getPlayer().getPlayerRatings()[15] * t2p6pV;
        int t2p7reb = lineup2[6].getPlayer().getPlayerRatings()[15] * t2p7pV;
        int t2p8reb = lineup2[7].getPlayer().getPlayerRatings()[15] * t2p8pV;
        int t2p9reb = lineup2[8].getPlayer().getPlayerRatings()[15] * t2p9pV;
        int t2p10reb = lineup2[9].getPlayer().getPlayerRatings()[15] * t2p10pV;
        int t2p11reb = lineup2[10].getPlayer().getPlayerRatings()[15] * t2p11pV;
        int t2p12reb = lineup2[11].getPlayer().getPlayerRatings()[15] * t2p12pV;
        int t2p1steal = lineup2[0].getPlayer().getPlayerRatings()[16] * t2p1pV;
        int t2p2steal = lineup2[1].getPlayer().getPlayerRatings()[16] * t2p2pV;
        int t2p3steal = lineup2[2].getPlayer().getPlayerRatings()[16] * t2p3pV;
        int t2p4steal = lineup2[3].getPlayer().getPlayerRatings()[16] * t2p4pV;
        int t2p5steal = lineup2[4].getPlayer().getPlayerRatings()[16] * t2p5pV;
        int t2p6steal = lineup2[5].getPlayer().getPlayerRatings()[16] * t2p6pV;
        int t2p7steal = lineup2[6].getPlayer().getPlayerRatings()[16] * t2p7pV;
        int t2p8steal = lineup2[7].getPlayer().getPlayerRatings()[16] * t2p8pV;
        int t2p9steal = lineup2[8].getPlayer().getPlayerRatings()[16] * t2p9pV;
        int t2p10steal = lineup2[9].getPlayer().getPlayerRatings()[16] * t2p10pV;
        int t2p11steal = lineup2[10].getPlayer().getPlayerRatings()[16] * t2p11pV;
        int t2p12steal = lineup2[11].getPlayer().getPlayerRatings()[16] * t2p12pV;
        int t2p1block = lineup2[0].getPlayer().getPlayerRatings()[17] * t2p1pV;
        int t2p2block = lineup2[1].getPlayer().getPlayerRatings()[17] * t2p2pV;
        int t2p3block = lineup2[2].getPlayer().getPlayerRatings()[17] * t2p3pV;
        int t2p4block = lineup2[3].getPlayer().getPlayerRatings()[17] * t2p4pV;
        int t2p5block = lineup2[4].getPlayer().getPlayerRatings()[17] * t2p5pV;
        int t2p6block = lineup2[5].getPlayer().getPlayerRatings()[17] * t2p6pV;
        int t2p7block = lineup2[6].getPlayer().getPlayerRatings()[17] * t2p7pV;
        int t2p8block = lineup2[7].getPlayer().getPlayerRatings()[17] * t2p8pV;
        int t2p9block = lineup2[8].getPlayer().getPlayerRatings()[17] * t2p9pV;
        int t2p10block = lineup2[9].getPlayer().getPlayerRatings()[17] * t2p10pV;
        int t2p11block = lineup2[10].getPlayer().getPlayerRatings()[17] * t2p11pV;
        int t2p12block = lineup2[11].getPlayer().getPlayerRatings()[17] * t2p12pV;
        int t2p1bbiq = lineup2[0].getPlayer().getPlayerRatings()[18] * t2p1pV;
        int t2p2bbiq = lineup2[1].getPlayer().getPlayerRatings()[18] * t2p2pV;
        int t2p3bbiq = lineup2[2].getPlayer().getPlayerRatings()[18] * t2p3pV;
        int t2p4bbiq = lineup2[3].getPlayer().getPlayerRatings()[18] * t2p4pV;
        int t2p5bbiq = lineup2[4].getPlayer().getPlayerRatings()[18] * t2p5pV;
        int t2p6bbiq = lineup2[5].getPlayer().getPlayerRatings()[18] * t2p6pV;
        int t2p7bbiq = lineup2[6].getPlayer().getPlayerRatings()[18] * t2p7pV;
        int t2p8bbiq = lineup2[7].getPlayer().getPlayerRatings()[18] * t2p8pV;
        int t2p9bbiq = lineup2[8].getPlayer().getPlayerRatings()[18] * t2p9pV;
        int t2p10bbiq = lineup2[9].getPlayer().getPlayerRatings()[18] * t2p10pV;
        int t2p11bbiq = lineup2[10].getPlayer().getPlayerRatings()[18] * t2p11pV;
        int t2p12bbiq = lineup2[11].getPlayer().getPlayerRatings()[18] * t2p12pV;

        //finds totals of specific ratings for team 1
        int layupTotal1 = t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup + t1p9layup + t1p10layup + t1p11layup + t1p12layup;
        int dunkTotal1 = t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk + t1p9dunk + t1p10dunk + t1p11dunk + t1p12dunk;
        int midrangeTotal1 = t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid + t1p9mid + t1p10mid + t1p11mid + t1p12mid;
        int threePtTotal1 = t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three + t1p9three + t1p10three + t1p11three + t1p12three;
        int postupTotal1 = t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post + t1p9post + t1p10post + t1p11post + t1p12post;
        int freethrowTotal1 = t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft + t1p9ft + t1p10ft + t1p11ft + t1p12ft;
        int passTotal1 = t1p1pass + t1p12pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass + t1p9pass + t1p10pass + t1p11pass + t1p12pass;
        int handTotal1 = t1p1hand + t1p12hand + t1p3hand + t1p4hand + t1p5hand + t1p6hand + t1p7hand + t1p8hand + t1p9hand + t1p10hand + t1p11hand + t1p12hand;
        int reboundTotal1 = t1p1reb + t1p12reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb + t1p9reb + t1p10reb + t1p11reb + t1p12reb;
        int stealTotal1 = t1p1steal + t1p12steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal + t1p9steal + t1p10steal + t1p11steal + t1p12steal;
        int blockTotal1 = t1p1block + t1p12block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block + t1p9block + t1p10block + t1p11block + t1p12block;
        int bbiqTotal1 = t1p1bbiq + t1p12bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq + t1p9bbiq + t1p10bbiq + t1p11bbiq + t1p12bbiq;

        //finds totals of specific ratings for team 2
        int layupTotal2 = t2p1layup + t2p2layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup + t2p9layup + t2p10layup + t2p11layup + t2p12layup;
        int dunkTotal2 = t2p1dunk + t2p2dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk + t2p9dunk + t2p10dunk + t2p11dunk + t2p12dunk;
        int midrangeTotal2 = t2p1mid + t2p2mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid + t2p9mid + t2p10mid + t2p11mid + t2p12mid;
        int threePtTotal2 = t2p1three + t2p2three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three + t2p9three + t2p10three + t2p11three + t2p12three;
        int postupTotal2 = t2p1post + t2p2post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post + t2p9post + t2p10post + t2p11post + t2p12post;
        int freethrowTotal2 = t2p1ft + t2p2ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft + t2p9ft + t2p10ft + t2p11ft + t2p12ft;
        int passTotal2 = t2p1pass + t2p12pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass + t2p9pass + t2p10pass + t2p11pass + t2p12pass;
        int handTotal2 = t2p1hand + t2p12hand + t2p3hand + t2p4hand + t2p5hand + t2p6hand + t2p7hand + t2p8hand + t2p9hand + t2p10hand + t2p11hand + t2p12hand;
        int reboundTotal2 = t2p1reb + t2p12reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb + t2p12reb;
        int stealTotal2 = t2p1steal + t2p12steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal + t2p9steal + t2p10steal + t2p11steal + t2p12steal;
        int blockTotal2 = t2p1block + t2p12block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block + t2p9block + t2p10block + t2p11block + t2p12block;
        int bbiqTotal2 = t2p1bbiq + t2p12bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq + t2p9bbiq + t2p10bbiq + t2p11bbiq + t2p12bbiq;


        /**
         * determines if there is a field goal missed on team 1, and if so who gets the rebound on either team, with defensive rebound having a higher chance
         */
        for(int n = 0; n < 50; n++)
        {
            int determinant = random.nextInt(99 * 12);
            if(determinant >= oRatingTotal1)//determines if it is a fga
            {
                int determinant4 = random.nextInt(reboundTotal1 + reboundTotal2);//determines rebound

                if(determinant4 <= (int)(reboundTotal1)* 0.2)
                {
                    int determinant5 = random.nextInt(reboundTotal1);
                    if (determinant5 <= t1p1reb)
                    {
                        lineup1[0].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb)
                    {
                        lineup1[1].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb)
                    {
                        lineup1[2].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb)
                    {
                        lineup1[3].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb)
                    {
                        lineup1[4].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb)
                    {
                        lineup1[5].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb)
                    {
                        lineup1[6].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb)
                    {
                        lineup1[7].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb + t1p9reb)
                    {
                        lineup1[8].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb + t1p9reb + t1p10reb)
                    {
                        lineup1[9].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb + t1p9reb + t1p10reb + t1p11reb)
                    {
                        lineup1[10].updateRebounds(1);
                    }
                    else if(determinant5 <= t1p1reb + t1p2reb + t1p3reb + t1p4reb + t1p5reb + t1p6reb + t1p7reb + t1p8reb + t1p9reb + t1p10reb + t1p11reb + t1p12reb)
                    {
                        lineup1[11].updateRebounds(1);
                    }
                }
                else
                {
                    int determinant5 = random.nextInt(reboundTotal2);
                    if (determinant5 <= t2p1reb)
                    {
                        lineup2[0].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb)
                    {
                        lineup2[1].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb)
                    {
                        lineup2[2].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb)
                    {
                        lineup2[3].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb)
                    {
                        lineup2[4].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb)
                    {
                        lineup2[5].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb)
                    {
                        lineup2[6].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb)
                    {
                        lineup2[7].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb)
                    {
                        lineup2[8].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb)
                    {
                        lineup2[9].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb)
                    {
                        lineup2[10].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb + t2p12reb)
                    {
                        lineup2[11].updateRebounds(1);
                    }
                }

                int determinant2 = random.nextInt(oRatingTotal1);
                if(determinant2 <= oRating1)//determines who took the field goal
                {
                    lineup1[0].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p1layup + t1p1dunk + t1p1mid + t1p1post) / 2) + t1p1three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p1layup + t1p1dunk + t1p1mid + t1p1post) / 2))
                        {
                            lineup1[0].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[0].updateThreePtA(1);
                        }
                    }

                }
                else if(determinant2 <= oRating1 + oRating2)
                {
                    lineup1[1].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p2layup + t1p2dunk + t1p2mid + t1p2post) / 2) + t1p2three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p2layup + t1p2dunk + t1p2mid + t1p2post) / 2))
                        {
                            lineup1[1].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[1].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3)
                {
                    lineup1[2].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p3layup + t1p3dunk + t1p3mid + t1p3post) / 2) + t1p3three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p3layup + t1p3dunk + t1p3mid + t1p3post) / 2))
                        {
                            lineup1[2].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[2].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4)
                {
                    lineup1[3].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p4layup + t1p4dunk + t1p4mid + t1p4post) / 2) + t1p4three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p4layup + t1p4dunk + t1p4mid + t1p4post) / 2))
                        {
                            lineup1[3].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[3].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5)
                {
                    lineup1[4].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p5layup + t1p5dunk + t1p5mid + t1p5post) / 2) + t1p5three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p5layup + t1p5dunk + t1p5mid + t1p5post) / 2))
                        {
                            lineup1[4].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[4].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6)
                {
                    lineup1[5].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p6layup + t1p6dunk + t1p6mid + t1p6post) / 2) + t1p6three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p6layup + t1p6dunk + t1p6mid + t1p6post) / 2))
                        {
                            lineup1[5].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[5].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7)
                {
                    lineup1[6].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p7layup + t1p7dunk + t1p7mid + t1p7post) / 2) + t1p7three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p7layup + t1p7dunk + t1p7mid + t1p7post) / 2))
                        {
                            lineup1[6].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[6].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8)
                {
                    lineup1[7].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p8layup + t1p8dunk + t1p8mid + t1p8post) / 2) + t1p8three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p8layup + t1p8dunk + t1p8mid + t1p8post) / 2))
                        {
                            lineup1[7].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[7].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8 + oRating9)
                {
                    lineup1[8].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p9layup + t1p9dunk + t1p9mid + t1p9post) / 2) + t1p9three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p9layup + t1p9dunk + t1p9mid + t1p9post) / 2))
                        {
                            lineup1[8].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[8].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8 + oRating9 + oRating10)
                {
                    lineup1[9].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p10layup + t1p10dunk + t1p10mid + t1p10post) / 2) + t1p10three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p10layup + t1p10dunk + t1p10mid + t1p10post) / 2))
                        {
                            lineup1[9].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[9].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8 + oRating9 + oRating10 + oRating11)
                {
                    lineup1[10].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p11layup + t1p11dunk + t1p11mid + t1p11post) / 2) + t1p11three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p11layup + t1p11dunk + t1p11mid + t1p11post) / 2))
                        {
                            lineup1[10].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[10].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating1 + oRating2 + oRating3 + oRating4 + oRating5 + oRating6 + oRating7 + oRating8 + oRating9 + oRating10 + oRating11 + oRating13)
                {
                    lineup1[11].updateFgA(1);

                    int determinant3 = random.nextInt(((t1p12layup + t1p12dunk + t1p12mid + t1p12post) / 2) + t1p12three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t1p12layup + t1p12dunk + t1p12mid + t1p12post) / 2))
                        {
                            lineup1[11].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup1[11].updateThreePtA(1);
                        }
                    }
                }
            }
        }

        /**
         * determines assists for a player on team 1 randomly, because usage and player skill would assumedly even out
         */
        int determinant7 = (int)(30 * (0.01 * (passTotal1 / (12 * (pvTotal1/12)))));
        for(int x = 0; x < determinant7; x++)
        {
            int determinant2 = random.nextInt(passTotal1);
            if (determinant2 <= t1p1pass)
            {
                lineup1[0].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass)
            {
                lineup1[1].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass)
            {
                lineup1[2].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass)
            {
                lineup1[3].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass)
            {
                lineup1[4].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass)
            {
                lineup1[5].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass)
            {
                lineup1[6].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass)
            {
                lineup1[7].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass + t1p9pass)
            {
                lineup1[8].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass + t1p9pass + t1p10pass)
            {
                lineup1[9].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass + t1p9pass + t1p10pass + t1p11pass)
            {
                lineup1[10].updateAssists(1);
            }
            else if(determinant2 <= t1p1pass + t1p2pass + t1p3pass + t1p4pass + t1p5pass + t1p6pass + t1p7pass + t1p8pass + t1p9pass + t1p10pass + t1p11pass + t1p12pass)
            {
                lineup1[11].updateAssists(1);
            }
        }

        //determines if a player gets a steal and who gets a steal on team 1
        for (int i = 0; i < 15; i++)
        {
            int determinant6 = random.nextInt(99 * 12);
            if (determinant6 <= stealTotal1)
            {
                int determinant2 = random.nextInt(stealTotal1);
                if (determinant2 <= t1p1steal)
                {
                    lineup1[0].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal)
                {
                    lineup1[1].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal)
                {
                    lineup1[2].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal)
                {
                    lineup1[3].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal)
                {
                    lineup1[4].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal)
                {
                    lineup1[5].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal)
                {
                    lineup1[6].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal)
                {
                    lineup1[7].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal + t1p9steal)
                {
                    lineup1[8].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal + t1p9steal + t1p10steal)
                {
                    lineup1[9].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal + t1p9steal + t1p10steal + t1p11steal)
                {
                    lineup1[10].updateSteals(1);
                }
                else if(determinant2 <= t1p1steal + t1p2steal + t1p3steal + t1p4steal + t1p5steal + t1p6steal + t1p7steal + t1p8steal + t1p9steal + t1p10steal + t1p11steal + t1p12steal)
                {
                    lineup1[11].updateSteals(1);
                }
            }
        }

        //determines if a player gets a blcok and who gets it on team 1
        for (int j = 0; j < 15; j++)//for blocks
        {
            int determinant6 = random.nextInt(99 * 12);
            if (determinant6 <= blockTotal1)
            {
                int determinant2 = random.nextInt(blockTotal1);
                if (determinant2 <= t1p1block)
                {
                    lineup1[0].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block)
                {
                    lineup1[1].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block)
                {
                    lineup1[2].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block)
                {
                    lineup1[3].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block)
                {
                    lineup1[4].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block)
                {
                    lineup1[5].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block)
                {
                    lineup1[6].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block)
                {
                    lineup1[7].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block + t1p9block)
                {
                    lineup1[8].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block + t1p9block + t1p10block)
                {
                    lineup1[9].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block + t1p9block + t1p10block + t1p11block)
                {
                    lineup1[10].updateBlocks(1);
                }
                else if(determinant2 <= t1p1block + t1p2block + t1p3block + t1p4block + t1p5block + t1p6block + t1p7block + t1p8block + t1p9block + t1p10block + t1p11block + t1p12block)
                {
                    lineup1[11].updateBlocks(1);
                }
            }
        }

        //determines if a player gets a turnover and who gets it on team 1
        for (int k = 0; k < 15; k++)//for turnovers
        {
            int determinant6 = random.nextInt(99 * 24 * pvTotal1);
            if (determinant6 >= passTotal1 + handTotal1)
            {
                int determinant2 = random.nextInt(12);
                lineup1[determinant2].updateTurnovers(1);
            }
        }

        //determines if a player gets a foul and who gets it on team 1
        for (int t = 0; t < 15; t++)//for fouls
        {
            int determinant6 = random.nextInt(99 * 12 * pvTotal1);
            if (determinant6 >= bbiqTotal1)
            {
                int determinant2 = random.nextInt(bbiqTotal1);
                if (determinant2 <= t1p1bbiq)
                {
                    lineup1[0].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq)
                {
                    lineup1[1].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq)
                {
                    lineup1[2].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq)
                {
                    lineup1[3].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq)
                {
                    lineup1[4].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq)
                {
                    lineup1[5].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq)
                {
                    lineup1[6].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq)
                {
                    lineup1[7].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq + t1p9bbiq)
                {
                    lineup1[8].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq + t1p9bbiq + t1p10bbiq)
                {
                    lineup1[9].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq + t1p9bbiq + t1p10bbiq + t1p11bbiq)
                {
                    lineup1[10].updateFouls(1);
                }
                else if(determinant2 <= t1p1bbiq + t1p2bbiq + t1p3bbiq + t1p4bbiq + t1p5bbiq + t1p6bbiq + t1p7bbiq + t1p8bbiq + t1p9bbiq + t1p10bbiq + t1p11bbiq + t1p12bbiq)
                {
                    lineup1[11].updateFouls(1);
                }
            }
        }

        //determines distributiong of point scoring (how players scored and who scored them) throughout team 1, based on their total points and player specific ratings
        while (team1points > 0)
        {
            int pointScoring1 = random.nextInt(((layupTotal1 + dunkTotal1 + midrangeTotal1 + postupTotal1) / 4) + threePtTotal1 + (freethrowTotal1 / 2));
            if (pointScoring1 <= (layupTotal1 / 4))
            {
                int determinant6 = random.nextInt(layupTotal1);
                if((team1points - 2) < 0)
                {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                    team1points --;
                } else if (determinant6 <= t1p1layup) {
                    lineup1[0].updatePoints(2);
                    lineup1[0].updateTwoPtA(1);
                    lineup1[0].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6<= t1p1layup + t1p12layup) {
                    lineup1[1].updatePoints(2);
                    lineup1[1].updateTwoPtA(1);
                    lineup1[1].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup) {
                    lineup1[2].updatePoints(2);
                    lineup1[2].updateTwoPtA(1);
                    lineup1[2].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup) {
                    lineup1[3].updatePoints(2);
                    lineup1[3].updateTwoPtA(1);
                    lineup1[3].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup) {
                    lineup1[4].updatePoints(2);
                    lineup1[4].updateTwoPtA(1);
                    lineup1[4].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup) {
                    lineup1[5].updatePoints(2);
                    lineup1[5].updateTwoPtA(1);
                    lineup1[5].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup) {
                    lineup1[6].updatePoints(2);
                    lineup1[6].updateTwoPtA(1);
                    lineup1[6].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup) {
                    lineup1[7].updatePoints(2);
                    lineup1[7].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup + t1p9layup) {
                    lineup1[8].updatePoints(2);
                    lineup1[8].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup + t1p9layup + t1p10layup) {
                    lineup1[9].updatePoints(2);
                    lineup1[9].updateTwoPtA(1);
                    lineup1[9].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup + t1p9layup + t1p10layup + t1p11layup) {
                    lineup1[10].updatePoints(2);
                    lineup1[10].updateTwoPtA(1);
                    lineup1[10].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1layup + t1p12layup + t1p3layup + t1p4layup + t1p5layup + t1p6layup + t1p7layup + t1p8layup + t1p9layup + t1p10layup + t1p11layup + t1p12layup) {
                    lineup1[11].updatePoints(2);
                    lineup1[11].updateTwoPtA(1);
                    lineup1[11].updateTwoPtM(1);
                    team1points -= 2;
                }
            }
            else if (pointScoring1 <= ((layupTotal1 + dunkTotal1) / 4))
            {
                int determinant6 = random.nextInt(dunkTotal1);
                if((team1points - 2) < 0)
                {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                    team1points --;
                } else if (determinant6 <= t1p1dunk) {
                    lineup1[0].updatePoints(2);
                    lineup1[0].updateTwoPtA(1);
                    lineup1[0].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk) {
                    lineup1[1].updatePoints(2);
                    lineup1[1].updateTwoPtA(1);
                    lineup1[1].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk) {
                    lineup1[2].updatePoints(2);
                    lineup1[2].updateTwoPtA(1);
                    lineup1[2].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk) {
                    lineup1[3].updatePoints(2);
                    lineup1[3].updateTwoPtA(1);
                    lineup1[3].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk) {
                    lineup1[4].updatePoints(2);
                    lineup1[4].updateTwoPtA(1);
                    lineup1[4].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk) {
                    lineup1[5].updatePoints(2);
                    lineup1[5].updateTwoPtA(1);
                    lineup1[5].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk) {
                    lineup1[6].updatePoints(2);
                    lineup1[6].updateTwoPtA(1);
                    lineup1[6].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk) {
                    lineup1[7].updatePoints(2);
                    lineup1[7].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk + t1p9dunk) {
                    lineup1[8].updatePoints(2);
                    lineup1[8].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk + t1p9dunk + t1p10dunk) {
                    lineup1[9].updatePoints(2);
                    lineup1[9].updateTwoPtA(1);
                    lineup1[9].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk + t1p9dunk + t1p10dunk + t1p11dunk) {
                    lineup1[10].updatePoints(2);
                    lineup1[10].updateTwoPtA(1);
                    lineup1[10].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1dunk + t1p12dunk + t1p3dunk + t1p4dunk + t1p5dunk + t1p6dunk + t1p7dunk + t1p8dunk + t1p9dunk + t1p10dunk + t1p11dunk + t1p12dunk) {
                    lineup1[11].updatePoints(2);
                    lineup1[11].updateTwoPtA(1);
                    lineup1[11].updateTwoPtM(1);
                    team1points -= 2;
                }
            }
            else if (pointScoring1 <= ((layupTotal1 + dunkTotal1 + midrangeTotal1) / 4))
            {
                int determinant6 = random.nextInt(midrangeTotal1);
                if((team1points - 2) < 0)
                {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                    team1points --;
                } else if (determinant6 <= t1p1mid) {
                    lineup1[0].updatePoints(2);
                    lineup1[0].updateTwoPtA(1);
                    lineup1[0].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid) {
                    lineup1[1].updatePoints(2);
                    lineup1[1].updateTwoPtA(1);
                    lineup1[1].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid) {
                    lineup1[2].updatePoints(2);
                    lineup1[2].updateTwoPtA(1);
                    lineup1[2].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid) {
                    lineup1[3].updatePoints(2);
                    lineup1[3].updateTwoPtA(1);
                    lineup1[3].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid) {
                    lineup1[4].updatePoints(2);
                    lineup1[4].updateTwoPtA(1);
                    lineup1[4].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid) {
                    lineup1[5].updatePoints(2);
                    lineup1[5].updateTwoPtA(1);
                    lineup1[5].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid) {
                    lineup1[6].updatePoints(2);
                    lineup1[6].updateTwoPtA(1);
                    lineup1[6].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid) {
                    lineup1[7].updatePoints(2);
                    lineup1[7].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid + t1p9mid) {
                    lineup1[8].updatePoints(2);
                    lineup1[8].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid + t1p9mid + t1p10mid) {
                    lineup1[9].updatePoints(2);
                    lineup1[9].updateTwoPtA(1);
                    lineup1[9].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid + t1p9mid + t1p10mid + t1p11mid) {
                    lineup1[10].updatePoints(2);
                    lineup1[10].updateTwoPtA(1);
                    lineup1[10].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1mid + t1p12mid + t1p3mid + t1p4mid + t1p5mid + t1p6mid + t1p7mid + t1p8mid + t1p9mid + t1p10mid + t1p11mid + t1p12mid) {
                    lineup1[11].updatePoints(2);
                    lineup1[11].updateTwoPtA(1);
                    lineup1[11].updateTwoPtM(1);
                    team1points -= 2;
                }
            }
            else if (pointScoring1 <= ((layupTotal1 + dunkTotal1 + midrangeTotal1 + postupTotal1) / 4))
            {
                int determinant6 = random.nextInt(postupTotal1);
                if((team1points - 2) < 0)
                {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                    team1points --;
                } else if (determinant6 <= t1p1post) {
                    lineup1[0].updatePoints(2);
                    lineup1[0].updateTwoPtA(1);
                    lineup1[0].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post) {
                    lineup1[1].updatePoints(2);
                    lineup1[1].updateTwoPtA(1);
                    lineup1[1].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post) {
                    lineup1[2].updatePoints(2);
                    lineup1[2].updateTwoPtA(1);
                    lineup1[2].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post) {
                    lineup1[3].updatePoints(2);
                    lineup1[3].updateTwoPtA(1);
                    lineup1[3].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post) {
                    lineup1[4].updatePoints(2);
                    lineup1[4].updateTwoPtA(1);
                    lineup1[4].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post) {
                    lineup1[5].updatePoints(2);
                    lineup1[5].updateTwoPtA(1);
                    lineup1[5].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post) {
                    lineup1[6].updatePoints(2);
                    lineup1[6].updateTwoPtA(1);
                    lineup1[6].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post) {
                    lineup1[7].updatePoints(2);
                    lineup1[7].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post + t1p9post) {
                    lineup1[8].updatePoints(2);
                    lineup1[8].updateTwoPtA(1);
                    lineup1[8].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post + t1p9post + t1p10post) {
                    lineup1[9].updatePoints(2);
                    lineup1[9].updateTwoPtA(1);
                    lineup1[9].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post + t1p9post + t1p10post + t1p11post) {
                    lineup1[10].updatePoints(2);
                    lineup1[10].updateTwoPtA(1);
                    lineup1[10].updateTwoPtM(1);
                    team1points -= 2;
                } else if (determinant6 <= t1p1post + t1p12post + t1p3post + t1p4post + t1p5post + t1p6post + t1p7post + t1p8post + t1p9post + t1p10post + t1p11post + t1p12post) {
                    lineup1[11].updatePoints(2);
                    lineup1[11].updateTwoPtA(1);
                    lineup1[11].updateTwoPtM(1);
                    team1points -= 2;
                }
            }
            else if (pointScoring1 <= ((layupTotal1 + dunkTotal1 + midrangeTotal1 + postupTotal1) / 4) + threePtTotal1)
            {
                int determinant6 = random.nextInt(threePtTotal1);
                if((team1points - 3) < 0)
                {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                    team1points --;
                }else if (determinant6 <= t1p1three) {
                    lineup1[0].updatePoints(3);
                    lineup1[0].updateThreePtA(1);
                    lineup1[0].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three) {
                    lineup1[1].updatePoints(3);
                    lineup1[1].updateThreePtA(1);
                    lineup1[1].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three) {
                    lineup1[2].updatePoints(3);
                    lineup1[2].updateThreePtA(1);
                    lineup1[2].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three) {
                    lineup1[3].updatePoints(3);
                    lineup1[3].updateThreePtA(1);
                    lineup1[3].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three) {
                    lineup1[4].updatePoints(3);
                    lineup1[4].updateThreePtA(1);
                    lineup1[4].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three) {
                    lineup1[5].updatePoints(3);
                    lineup1[5].updateThreePtA(1);
                    lineup1[5].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three) {
                    lineup1[6].updatePoints(3);
                    lineup1[6].updateThreePtA(1);
                    lineup1[6].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three) {
                    lineup1[7].updatePoints(3);
                    lineup1[7].updateThreePtA(1);
                    lineup1[8].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three + t1p9three) {
                    lineup1[8].updatePoints(3);
                    lineup1[8].updateThreePtA(1);
                    lineup1[8].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three + t1p9three + t1p10three) {
                    lineup1[9].updatePoints(3);
                    lineup1[9].updateThreePtA(1);
                    lineup1[9].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three + t1p9three + t1p10three + t1p11three) {
                    lineup1[10].updatePoints(3);
                    lineup1[10].updateThreePtA(1);
                    lineup1[10].updateThreePtM(1);
                    team1points -= 3;
                } else if (determinant6 <= t1p1three + t1p12three + t1p3three + t1p4three + t1p5three + t1p6three + t1p7three + t1p8three + t1p9three + t1p10three + t1p11three + t1p12three) {
                    lineup1[11].updatePoints(3);
                    lineup1[11].updateThreePtA(1);
                    lineup1[11].updateThreePtM(1);
                    team1points -= 3;
                }
            }
            else if (pointScoring1 <= ((layupTotal1 + dunkTotal1 + midrangeTotal1 + postupTotal1) / 4) + threePtTotal1 + (freethrowTotal1 / 2))
            {
                team1points -= 1;
                int determinant6 = random.nextInt(freethrowTotal1);

                if (determinant6 <= t1p1ft) {
                    lineup1[0].updatePoints(1);
                    lineup1[0].updateFreeThrowA(1);
                    lineup1[0].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft) {
                    lineup1[1].updatePoints(1);
                    lineup1[1].updateFreeThrowA(1);
                    lineup1[1].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft) {
                    lineup1[2].updatePoints(1);
                    lineup1[2].updateFreeThrowA(1);
                    lineup1[2].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft) {
                    lineup1[3].updatePoints(1);
                    lineup1[3].updateFreeThrowA(1);
                    lineup1[3].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft) {
                    lineup1[4].updatePoints(1);
                    lineup1[4].updateFreeThrowA(1);
                    lineup1[4].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft) {
                    lineup1[5].updatePoints(1);
                    lineup1[5].updateFreeThrowA(1);
                    lineup1[5].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft) {
                    lineup1[6].updatePoints(1);
                    lineup1[6].updateFreeThrowA(1);
                    lineup1[6].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft) {
                    lineup1[7].updatePoints(1);
                    lineup1[7].updateFreeThrowA(1);
                    lineup1[8].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft + t1p9ft) {
                    lineup1[8].updatePoints(1);
                    lineup1[8].updateFreeThrowA(1);
                    lineup1[8].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft + t1p9ft + t1p10ft) {
                    lineup1[9].updatePoints(1);
                    lineup1[9].updateFreeThrowA(1);
                    lineup1[9].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft + t1p9ft + t1p10ft + t1p11ft) {
                    lineup1[10].updatePoints(1);
                    lineup1[10].updateFreeThrowA(1);
                    lineup1[10].updateFreeThrowM(1);
                } else if (determinant6 <= t1p1ft + t1p12ft + t1p3ft + t1p4ft + t1p5ft + t1p6ft + t1p7ft + t1p8ft + t1p9ft + t1p10ft + t1p11ft + t1p12ft) {
                    lineup1[11].updatePoints(1);
                    lineup1[11].updateFreeThrowA(1);
                    lineup1[11].updateFreeThrowM(1);
                }
            }
        }

        //team 2 stats
        //simulates everything like in previous code for team 1, except now applying team 2's player specific stats and their total points scored

        for(int n = 0; n < 50; n++)
        {
            int determinant = random.nextInt(99 * 12);
            if(determinant >= oRatingTotal2)//determines if it is a fga
            {
                int determinant4 = random.nextInt(reboundTotal1 + reboundTotal2);//determines rebound

                if(determinant4 <= (int)(reboundTotal2)* 0.2)
                {
                    int determinant5 = random.nextInt(reboundTotal1);
                    if (determinant5 <= t2p1reb)
                    {
                        lineup2[0].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb)
                    {
                        lineup2[1].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb)
                    {
                        lineup2[2].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb)
                    {
                        lineup2[3].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb)
                    {
                        lineup2[4].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb)
                    {
                        lineup2[5].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb)
                    {
                        lineup2[6].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb)
                    {
                        lineup2[7].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb)
                    {
                        lineup2[8].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb)
                    {
                        lineup2[9].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb)
                    {
                        lineup2[10].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb + t2p12reb)
                    {
                        lineup2[11].updateRebounds(1);
                    }
                }
                else
                {
                    int determinant5 = random.nextInt(reboundTotal1);
                    if (determinant5 <= t2p1reb)
                    {
                        lineup1[0].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb)
                    {
                        lineup1[1].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb)
                    {
                        lineup1[2].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb)
                    {
                        lineup1[3].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb)
                    {
                        lineup1[4].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb)
                    {
                        lineup1[5].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb)
                    {
                        lineup1[6].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb)
                    {
                        lineup1[7].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb)
                    {
                        lineup1[8].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb)
                    {
                        lineup1[9].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb)
                    {
                        lineup1[10].updateRebounds(1);
                    }
                    else if(determinant5 <= t2p1reb + t2p2reb + t2p3reb + t2p4reb + t2p5reb + t2p6reb + t2p7reb + t2p8reb + t2p9reb + t2p10reb + t2p11reb + t2p12reb)
                    {
                        lineup1[11].updateRebounds(1);
                    }
                }

                int determinant2 = random.nextInt(oRatingTotal2);
                if(determinant2 <= oRating12)//determines who took the field goal
                {
                    lineup2[0].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p1layup + t2p1dunk + t2p1mid + t2p1post) / 2) + t2p1three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p1layup + t2p1dunk + t2p1mid + t2p1post) / 2))
                        {
                            lineup2[0].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[0].updateThreePtA(1);
                        }
                    }

                }
                else if(determinant2 <= oRating12 + oRating22)
                {
                    lineup2[1].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p2layup + t2p2dunk + t2p2mid + t2p2post) / 2) + t2p2three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p2layup + t2p2dunk + t2p2mid + t2p2post) / 2))
                        {
                            lineup2[1].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[1].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32)
                {
                    lineup2[2].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p3layup + t2p3dunk + t2p3mid + t2p3post) / 2) + t2p3three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p3layup + t2p3dunk + t2p3mid + t2p3post) / 2))
                        {
                            lineup2[2].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[2].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42)
                {
                    lineup2[3].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p4layup + t2p4dunk + t2p4mid + t2p4post) / 2) + t2p4three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p4layup + t2p4dunk + t2p4mid + t2p4post) / 2))
                        {
                            lineup2[3].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[3].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52)
                {
                    lineup2[4].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p5layup + t2p5dunk + t2p5mid + t2p5post) / 2) + t2p5three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p5layup + t2p5dunk + t2p5mid + t2p5post) / 2))
                        {
                            lineup2[4].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[4].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62)
                {
                    lineup2[5].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p6layup + t2p6dunk + t2p6mid + t2p6post) / 2) + t2p6three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p6layup + t2p6dunk + t2p6mid + t2p6post) / 2))
                        {
                            lineup2[5].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[5].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72)
                {
                    lineup2[6].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p7layup + t2p7dunk + t2p7mid + t2p7post) / 2) + t2p7three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p7layup + t2p7dunk + t2p7mid + t2p7post) / 2))
                        {
                            lineup2[6].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[6].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82)
                {
                    lineup2[7].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p8layup + t2p8dunk + t2p8mid + t2p8post) / 2) + t2p8three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p8layup + t2p8dunk + t2p8mid + t2p8post) / 2))
                        {
                            lineup2[7].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[7].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82 + oRating92)
                {
                    lineup2[8].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p9layup + t2p9dunk + t2p9mid + t2p9post) / 2) + t2p9three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p9layup + t2p9dunk + t2p9mid + t2p9post) / 2))
                        {
                            lineup2[8].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[8].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82 + oRating92 + oRating102)
                {
                    lineup2[9].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p10layup + t2p10dunk + t2p10mid + t2p10post) / 2) + t2p10three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p10layup + t2p10dunk + t2p10mid + t2p10post) / 2))
                        {
                            lineup2[9].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[9].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82 + oRating92 + oRating102 + oRating112)
                {
                    lineup2[10].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p11layup + t2p11dunk + t2p11mid + t2p11post) / 2) + t2p11three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p11layup + t2p11dunk + t2p11mid + t2p11post) / 2))
                        {
                            lineup2[10].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[10].updateThreePtA(1);
                        }
                    }
                }
                else if(determinant2 <= oRating12 + oRating22 + oRating32 + oRating42 + oRating52 + oRating62 + oRating72 + oRating82 + oRating92 + oRating102 + oRating112 + oRating122)
                {
                    lineup2[11].updateFgA(1);

                    int determinant3 = random.nextInt(((t2p12layup + t2p12dunk + t2p12mid + t2p12post) / 2) + t2p12three);//determines what kind of shot
                    {
                        if(determinant3 <= ((t2p12layup + t2p12dunk + t2p12mid + t2p12post) / 2))
                        {
                            lineup2[11].updateTwoPtA(1);
                        }
                        else
                        {
                            lineup2[11].updateThreePtA(1);
                        }
                    }
                }
            }
        }

        int determinant8 = (int)(25 * (0.01 * passTotal2 / (12 * (pvTotal2/12))));
        for(int x = 0; x < determinant7; x++)
        {
            int determinant2 = random.nextInt(passTotal2);
            if (determinant2 <= t2p1pass)
            {
                lineup2[0].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass)
            {
                lineup2[1].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass)
            {
                lineup2[2].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass)
            {
                lineup2[3].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass)
            {
                lineup2[4].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass)
            {
                lineup2[5].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass)
            {
                lineup2[6].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass)
            {
                lineup2[7].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass + t2p9pass)
            {
                lineup2[8].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass + t2p9pass + t2p10pass)
            {
                lineup2[9].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass + t2p9pass + t2p10pass + t2p11pass)
            {
                lineup2[10].updateAssists(1);
            }
            else if(determinant2 <= t2p1pass + t2p2pass + t2p3pass + t2p4pass + t2p5pass + t2p6pass + t2p7pass + t2p8pass + t2p9pass + t2p10pass + t2p11pass + t2p12pass)
            {
                lineup2[11].updateAssists(1);
            }
        }

        for (int i = 0; i < 15; i++)//for steals
        {
            int determinant6 = random.nextInt(99 * 12);
            if (determinant6 <= stealTotal2)
            {
                int determinant2 = random.nextInt(stealTotal2);
                if (determinant2 <= t2p1steal)
                {
                    lineup2[0].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal)
                {
                    lineup2[1].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal)
                {
                    lineup2[2].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal)
                {
                    lineup2[3].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal)
                {
                    lineup2[4].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal)
                {
                    lineup2[5].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal)
                {
                    lineup2[6].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal)
                {
                    lineup2[7].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal + t2p9steal)
                {
                    lineup2[8].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal + t2p9steal + t2p10steal)
                {
                    lineup2[9].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal + t2p9steal + t2p10steal + t2p11steal)
                {
                    lineup2[10].updateSteals(1);
                }
                else if(determinant2 <= t2p1steal + t2p2steal + t2p3steal + t2p4steal + t2p5steal + t2p6steal + t2p7steal + t2p8steal + t2p9steal + t2p10steal + t2p11steal + t2p12steal)
                {
                    lineup2[11].updateSteals(1);
                }
            }
        }

        for (int j = 0; j < 15; j++)//for blocks
        {
            int determinant6 = random.nextInt(99 * 12);
            if (determinant6 <= blockTotal2)
            {
                int determinant2 = random.nextInt(blockTotal2);
                if (determinant2 <= t2p1block)
                {
                    lineup2[0].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block)
                {
                    lineup2[1].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block)
                {
                    lineup2[2].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block)
                {
                    lineup2[3].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block)
                {
                    lineup2[4].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block)
                {
                    lineup2[5].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block)
                {
                    lineup2[6].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block)
                {
                    lineup2[7].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block + t2p9block)
                {
                    lineup2[8].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block + t2p9block + t2p10block)
                {
                    lineup2[9].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block + t2p9block + t2p10block + t2p11block)
                {
                    lineup2[10].updateBlocks(1);
                }
                else if(determinant2 <= t2p1block + t2p2block + t2p3block + t2p4block + t2p5block + t2p6block + t2p7block + t2p8block + t2p9block + t2p10block + t2p11block + t2p12block)
                {
                    lineup2[11].updateBlocks(1);
                }
            }
        }

        for (int k = 0; k <15; k++)//for turnovers
        {
            int determinant6 = random.nextInt(99 * 24 * pvTotal2);
            if (determinant6 >= passTotal2 + handTotal2)
            {
                int determinant2 = random.nextInt(12);
                lineup2[determinant2].updateTurnovers(1);
            }
        }

        for (int t = 0; t < 15; t++)//for fouls
        {
            int determinant6 = random.nextInt(99 * 12 * pvTotal2);
            if (determinant6 >= bbiqTotal2)
            {
                int determinant2 = random.nextInt(bbiqTotal2);
                if (determinant2 <= t2p1bbiq)
                {
                    lineup2[0].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq)
                {
                    lineup2[1].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq)
                {
                    lineup2[2].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq)
                {
                    lineup2[3].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq)
                {
                    lineup2[4].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq)
                {
                    lineup2[5].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq)
                {
                    lineup2[6].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq)
                {
                    lineup2[7].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq + t2p9bbiq)
                {
                    lineup2[8].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq + t2p9bbiq + t2p10bbiq)
                {
                    lineup2[9].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq + t2p9bbiq + t2p10bbiq + t2p11bbiq)
                {
                    lineup2[10].updateFouls(1);
                }
                else if(determinant2 <= t2p1bbiq + t2p2bbiq + t2p3bbiq + t2p4bbiq + t2p5bbiq + t2p6bbiq + t2p7bbiq + t2p8bbiq + t2p9bbiq + t2p10bbiq + t2p11bbiq + t2p12bbiq)
                {
                    lineup2[11].updateFouls(1);
                }
            }
        }

        while (team2points > 0)
        {
            int pointScoring2 = random.nextInt(((layupTotal2 + dunkTotal2 + midrangeTotal2 + postupTotal2) / 4) + threePtTotal2 + (freethrowTotal2 / 2));
            if (pointScoring2 <= (layupTotal2 / 4))
            {
                int determinant6 = random.nextInt(layupTotal2);
                if((team2points - 2) < 0)
                {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                    team2points --;
                } else if (determinant6 <= t2p1layup) {
                    lineup2[0].updatePoints(2);
                    lineup2[0].updateTwoPtA(1);
                    lineup2[0].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6<= t2p1layup + t2p12layup) {
                    lineup2[1].updatePoints(2);
                    lineup2[1].updateTwoPtA(1);
                    lineup2[1].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup) {
                    lineup2[2].updatePoints(2);
                    lineup2[2].updateTwoPtA(1);
                    lineup2[2].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup) {
                    lineup2[3].updatePoints(2);
                    lineup2[3].updateTwoPtA(1);
                    lineup2[3].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup) {
                    lineup2[4].updatePoints(2);
                    lineup2[4].updateTwoPtA(1);
                    lineup2[4].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup) {
                    lineup2[5].updatePoints(2);
                    lineup2[5].updateTwoPtA(1);
                    lineup2[5].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup) {
                    lineup2[6].updatePoints(2);
                    lineup2[6].updateTwoPtA(1);
                    lineup2[6].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup) {
                    lineup2[7].updatePoints(2);
                    lineup2[7].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup + t2p9layup) {
                    lineup2[8].updatePoints(2);
                    lineup2[8].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup + t2p9layup + t2p10layup) {
                    lineup2[9].updatePoints(2);
                    lineup2[9].updateTwoPtA(1);
                    lineup2[9].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup + t2p9layup + t2p10layup + t2p11layup) {
                    lineup2[10].updatePoints(2);
                    lineup2[10].updateTwoPtA(1);
                    lineup2[10].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1layup + t2p12layup + t2p3layup + t2p4layup + t2p5layup + t2p6layup + t2p7layup + t2p8layup + t2p9layup + t2p10layup + t2p11layup + t2p12layup) {
                    lineup2[11].updatePoints(2);
                    lineup2[11].updateTwoPtA(1);
                    lineup2[11].updateTwoPtM(1);
                    team2points -= 2;
                }
            }
            else if (pointScoring2 <= ((layupTotal2 + dunkTotal2) / 4))
            {
                int determinant6 = random.nextInt(dunkTotal2);
                if((team2points - 2) < 0)
                {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                    team2points --;
                } else if (determinant6 <= t2p1dunk) {
                    lineup2[0].updatePoints(2);
                    lineup2[0].updateTwoPtA(1);
                    lineup2[0].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk) {
                    lineup2[1].updatePoints(2);
                    lineup2[1].updateTwoPtA(1);
                    lineup2[1].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk) {
                    lineup2[2].updatePoints(2);
                    lineup2[2].updateTwoPtA(1);
                    lineup2[2].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk) {
                    lineup2[3].updatePoints(2);
                    lineup2[3].updateTwoPtA(1);
                    lineup2[3].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk) {
                    lineup2[4].updatePoints(2);
                    lineup2[4].updateTwoPtA(1);
                    lineup2[4].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk) {
                    lineup2[5].updatePoints(2);
                    lineup2[5].updateTwoPtA(1);
                    lineup2[5].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk) {
                    lineup2[6].updatePoints(2);
                    lineup2[6].updateTwoPtA(1);
                    lineup2[6].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk) {
                    lineup2[7].updatePoints(2);
                    lineup2[7].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk + t2p9dunk) {
                    lineup2[8].updatePoints(2);
                    lineup2[8].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk + t2p9dunk + t2p10dunk) {
                    lineup2[9].updatePoints(2);
                    lineup2[9].updateTwoPtA(1);
                    lineup2[9].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk + t2p9dunk + t2p10dunk + t2p11dunk) {
                    lineup2[10].updatePoints(2);
                    lineup2[10].updateTwoPtA(1);
                    lineup2[10].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1dunk + t2p12dunk + t2p3dunk + t2p4dunk + t2p5dunk + t2p6dunk + t2p7dunk + t2p8dunk + t2p9dunk + t2p10dunk + t2p11dunk + t2p12dunk) {
                    lineup2[11].updatePoints(2);
                    lineup2[11].updateTwoPtA(1);
                    lineup2[11].updateTwoPtM(1);
                    team2points -= 2;
                }
            }
            else if (pointScoring2 <= ((layupTotal2 + dunkTotal2 + midrangeTotal2) / 4))
            {
                int determinant6 = random.nextInt(midrangeTotal2);
                if((team2points - 2) < 0)
                {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                    team2points --;
                } else if (determinant6 <= t2p1mid) {
                    lineup2[0].updatePoints(2);
                    lineup2[0].updateTwoPtA(1);
                    lineup2[0].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid) {
                    lineup2[1].updatePoints(2);
                    lineup2[1].updateTwoPtA(1);
                    lineup2[1].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid) {
                    lineup2[2].updatePoints(2);
                    lineup2[2].updateTwoPtA(1);
                    lineup2[2].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid) {
                    lineup2[3].updatePoints(2);
                    lineup2[3].updateTwoPtA(1);
                    lineup2[3].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid) {
                    lineup2[4].updatePoints(2);
                    lineup2[4].updateTwoPtA(1);
                    lineup2[4].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid) {
                    lineup2[5].updatePoints(2);
                    lineup2[5].updateTwoPtA(1);
                    lineup2[5].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid) {
                    lineup2[6].updatePoints(2);
                    lineup2[6].updateTwoPtA(1);
                    lineup2[6].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid) {
                    lineup2[7].updatePoints(2);
                    lineup2[7].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid + t2p9mid) {
                    lineup2[8].updatePoints(2);
                    lineup2[8].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid + t2p9mid + t2p10mid) {
                    lineup2[9].updatePoints(2);
                    lineup2[9].updateTwoPtA(1);
                    lineup2[9].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid + t2p9mid + t2p10mid + t2p11mid) {
                    lineup2[10].updatePoints(2);
                    lineup2[10].updateTwoPtA(1);
                    lineup2[10].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1mid + t2p12mid + t2p3mid + t2p4mid + t2p5mid + t2p6mid + t2p7mid + t2p8mid + t2p9mid + t2p10mid + t2p11mid + t2p12mid) {
                    lineup2[11].updatePoints(2);
                    lineup2[11].updateTwoPtA(1);
                    lineup2[11].updateTwoPtM(1);
                    team2points -= 2;
                }
            }
            else if (pointScoring2 <= ((layupTotal2 + dunkTotal2 + midrangeTotal2 + postupTotal2) / 4))
            {
                int determinant6 = random.nextInt(postupTotal2);
                if((team2points - 2) < 0)
                {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                    team2points --;
                } else if (determinant6 <= t2p1post) {
                    lineup2[0].updatePoints(2);
                    lineup2[0].updateTwoPtA(1);
                    lineup2[0].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post) {
                    lineup2[1].updatePoints(2);
                    lineup2[1].updateTwoPtA(1);
                    lineup2[1].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post) {
                    lineup2[2].updatePoints(2);
                    lineup2[2].updateTwoPtA(1);
                    lineup2[2].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post) {
                    lineup2[3].updatePoints(2);
                    lineup2[3].updateTwoPtA(1);
                    lineup2[3].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post) {
                    lineup2[4].updatePoints(2);
                    lineup2[4].updateTwoPtA(1);
                    lineup2[4].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post) {
                    lineup2[5].updatePoints(2);
                    lineup2[5].updateTwoPtA(1);
                    lineup2[5].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post) {
                    lineup2[6].updatePoints(2);
                    lineup2[6].updateTwoPtA(1);
                    lineup2[6].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post) {
                    lineup2[7].updatePoints(2);
                    lineup2[7].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post + t2p9post) {
                    lineup2[8].updatePoints(2);
                    lineup2[8].updateTwoPtA(1);
                    lineup2[8].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post + t2p9post + t2p10post) {
                    lineup2[9].updatePoints(2);
                    lineup2[9].updateTwoPtA(1);
                    lineup2[9].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post + t2p9post + t2p10post + t2p11post) {
                    lineup2[10].updatePoints(2);
                    lineup2[10].updateTwoPtA(1);
                    lineup2[10].updateTwoPtM(1);
                    team2points -= 2;
                } else if (determinant6 <= t2p1post + t2p12post + t2p3post + t2p4post + t2p5post + t2p6post + t2p7post + t2p8post + t2p9post + t2p10post + t2p11post + t2p12post) {
                    lineup2[11].updatePoints(2);
                    lineup2[11].updateTwoPtA(1);
                    lineup2[11].updateTwoPtM(1);
                    team2points -= 2;
                }
            }
            else if (pointScoring2 <= ((layupTotal2 + dunkTotal2 + midrangeTotal2 + postupTotal2) / 4) + threePtTotal2)
            {
                int determinant6 = random.nextInt(threePtTotal2);
                if((team2points - 3) < 0)
                {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                    team2points --;
                }else if (determinant6 <= t2p1three) {
                    lineup2[0].updatePoints(3);
                    lineup2[0].updateThreePtA(1);
                    lineup2[0].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three) {
                    lineup2[1].updatePoints(3);
                    lineup2[1].updateThreePtA(1);
                    lineup2[1].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three) {
                    lineup2[2].updatePoints(3);
                    lineup2[2].updateThreePtA(1);
                    lineup2[2].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three) {
                    lineup2[3].updatePoints(3);
                    lineup2[3].updateThreePtA(1);
                    lineup2[3].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three) {
                    lineup2[4].updatePoints(3);
                    lineup2[4].updateThreePtA(1);
                    lineup2[4].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three) {
                    lineup2[5].updatePoints(3);
                    lineup2[5].updateThreePtA(1);
                    lineup2[5].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three) {
                    lineup2[6].updatePoints(3);
                    lineup2[6].updateThreePtA(1);
                    lineup2[6].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three) {
                    lineup2[7].updatePoints(3);
                    lineup2[7].updateThreePtA(1);
                    lineup2[8].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three + t2p9three) {
                    lineup2[8].updatePoints(3);
                    lineup2[8].updateThreePtA(1);
                    lineup2[8].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three + t2p9three + t2p10three) {
                    lineup2[9].updatePoints(3);
                    lineup2[9].updateThreePtA(1);
                    lineup2[9].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three + t2p9three + t2p10three + t2p11three) {
                    lineup2[10].updatePoints(3);
                    lineup2[10].updateThreePtA(1);
                    lineup2[10].updateThreePtM(1);
                    team2points -= 3;
                } else if (determinant6 <= t2p1three + t2p12three + t2p3three + t2p4three + t2p5three + t2p6three + t2p7three + t2p8three + t2p9three + t2p10three + t2p11three + t2p12three) {
                    lineup2[11].updatePoints(3);
                    lineup2[11].updateThreePtA(1);
                    lineup2[11].updateThreePtM(1);
                    team2points -= 3;
                }
            }
            else if (pointScoring2 <= ((layupTotal2 + dunkTotal2 + midrangeTotal2 + postupTotal2) / 4) + threePtTotal2 + (freethrowTotal2 / 2))
            {
                team2points -= 1;
                int determinant6 = random.nextInt(freethrowTotal2);

                if (determinant6 <= t2p1ft) {
                    lineup2[0].updatePoints(1);
                    lineup2[0].updateFreeThrowA(1);
                    lineup2[0].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft) {
                    lineup2[1].updatePoints(1);
                    lineup2[1].updateFreeThrowA(1);
                    lineup2[1].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft) {
                    lineup2[2].updatePoints(1);
                    lineup2[2].updateFreeThrowA(1);
                    lineup2[2].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft) {
                    lineup2[3].updatePoints(1);
                    lineup2[3].updateFreeThrowA(1);
                    lineup2[3].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft) {
                    lineup2[4].updatePoints(1);
                    lineup2[4].updateFreeThrowA(1);
                    lineup2[4].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft) {
                    lineup2[5].updatePoints(1);
                    lineup2[5].updateFreeThrowA(1);
                    lineup2[5].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft) {
                    lineup2[6].updatePoints(1);
                    lineup2[6].updateFreeThrowA(1);
                    lineup2[6].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft) {
                    lineup2[7].updatePoints(1);
                    lineup2[7].updateFreeThrowA(1);
                    lineup2[8].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft + t2p9ft) {
                    lineup2[8].updatePoints(1);
                    lineup2[8].updateFreeThrowA(1);
                    lineup2[8].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft + t2p9ft + t2p10ft) {
                    lineup2[9].updatePoints(1);
                    lineup2[9].updateFreeThrowA(1);
                    lineup2[9].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft + t2p9ft + t2p10ft + t2p11ft) {
                    lineup2[10].updatePoints(1);
                    lineup2[10].updateFreeThrowA(1);
                    lineup2[10].updateFreeThrowM(1);
                } else if (determinant6 <= t2p1ft + t2p12ft + t2p3ft + t2p4ft + t2p5ft + t2p6ft + t2p7ft + t2p8ft + t2p9ft + t2p10ft + t2p11ft + t2p12ft) {
                    lineup2[11].updatePoints(1);
                    lineup2[11].updateFreeThrowA(1);
                    lineup2[11].updateFreeThrowM(1);
                }
            }
        }
    }

    /**
     *     //returns points scored by team 1
     * @return
     */
    public int getTeamOnePoints()
    {
        return teamOnePoints;
    }

    /**
     * returns points scored by team 2
     * @return
     */
    public int getTeamTwoPoints()
    {
        return teamTwoPoints;
    }
}






