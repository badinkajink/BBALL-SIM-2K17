/**
 * Created by WilliamUSER on 5/20/2017.
 */
import java.util.ArrayList;
import java.util.Random;

public class PlayerProfile {

    //player info
    private String name;
    private String position;
    private int height; //inches
    private int weight; // pounds
    private int age; // years
    private int experience; //years
    private double luck; // just Math.random
    private double potential; //determines stat growth @ end of season
    private int draftPos; //


    //overall ratings
    private int offense; //0
    private int defense; //1

    //physical attributes
    private int strength; //2
    private int speed; //3
    private int vertical; //4
    private int durability; //5 to determine injuries
    private int emotion; //6 to generate technical fouls

    //shooting attributes
    private int layup;//7
    private int dunk;//8
    private int postup; //9
    private int midrange; //10
    private int threePt; //11
    private int freethrow; //12

    //skills
    private int passing; //13 to calculate turnovers/assists
    private int rebounding;//14
    private int steal;//15
    private int block; //16
    private int handling; //17 to calculate turnovers
    private int basketballiq; //18 to calculate efficiency and advanced metrics

    //collection of attributes
    /*ratings = new int[]{offense, defense, strength, speed, vertical, durability, emotion, //0,1,2,3,4,5,6 indices for physical
                layup, dunk, postup, midrange, threePt, freethrow, //7,8,9,10,11,12 indices for shooting
                passing, rebounding, steal, block, handling, basketballiq}; //13,14,15,16,17,18 indices for skills
       somehow broken
       */

    //super secret sauce
    private PlayerValue pV;
    private int tradeValue;
    private ProfileGenerator profile;
    private double alg;
    private double decrease;
    private int[] ratings;

    /**
     * creates player profile with randomized luck/age/experience/potential
     */
    public PlayerProfile() {
        profile = new ProfileGenerator();
        Random rand = new Random();
        int h = rand.nextInt(8);
        int w = rand.nextInt(20);

        name = profile.getName();
        position = profile.getPosition();
        switch (position) {
            case "PG":
                height = 72 + h;
                weight = 190 + w;
                break;
            case "SG":
                height = 74 + h;
                weight = 190 + w;
                break;
            case "G":
                height = 72 + h;
                weight = 190 + w;
                break;
            case "SF":
                height = 77 + h / 2;
                weight = 230 + w;
                break;
            case "PF":
                height = 79 + h / 2;
                weight = 230 + w;
                break;
            case "F":
                height = 77 + (h / 2 + 2);
                weight = 230 + w;
                break;
            case "GF":
                height = 76 + h / 2;
                weight = 210 + w;
                break;
            case "C":
                height = 82 + h / 2;
                weight = 260 + 2 * w;
                break;
            case "FC":
                height = 80 + h / 2;
                weight = 240 + 2 * w;
                break;
        }
        luck = Math.random();
        potential = Math.random();
        draftPos = profile.getDraftPosition();
        age = profile.getAge();
        experience = profile.getExperience();
        pV = new PlayerValue(draftPos, luck, potential, experience);

        alg = pV.getAlg();
        decrease = pV.getDecrease();

        ratings();
        ratings = new int[]{offense, defense, strength, speed, vertical, durability, emotion, //0,1,2,3,4,5,6 indices for physical
                layup, dunk, postup, midrange, threePt, freethrow, //7,8,9,10,11,12 indices for shooting
                passing, rebounding, steal, block, handling, basketballiq}; //13,14,15,16,17,18 indices for skills

    }

    /**
     * creates rookie player
     * documenting this now i realized i wrote this constructor incorrectly
     * @param exp should be 0 anyway
     * @param age should be 20 regardless
     */
    public PlayerProfile(int exp, int age) {
        profile = new ProfileGenerator(0, 20);
        Random rand = new Random();
        int h = rand.nextInt(8);
        int w = rand.nextInt(20);

        name = profile.getName();
        position = profile.getPosition();
        switch (position) {
            case "PG":
                height = 70 + h;
                weight = 190 + w;
                break;
            case "SG":
                height = 72 + h;
                weight = 190 + w;
                break;
            case "G":
                height = 70 + h;
                weight = 190 + w;
                break;
            case "SF":
                height = 76 + h / 2;
                weight = 230 + w;
                break;
            case "PF":
                height = 78 + h / 2;
                weight = 230 + w;
                break;
            case "F":
                height = 76 + h / 2;
                weight = 230 + w;
                break;
            case "GF":
                height = 76 + h / 2;
                weight = 210 + w;
                break;
            case "C":
                height = 82 + h / 2;
                weight = 260 + 2 * w;
                break;
            case "FC":
                height = 80 + h / 2;
                weight = 240 + 2 * w;
                break;
        }
        luck = Math.random();//
        potential = Math.random();//
        draftPos = profile.getDraftPosition();
        this.age = profile.getAge();
        experience = profile.getExperience();

        pV = new PlayerValue(draftPos, luck, potential, experience);

        alg = pV.getAlg();
        decrease = pV.getDecrease();

        ratings();
        ratings = new int[]{offense, defense, strength, speed, vertical, durability, emotion, //0,1,2,3,4,5,6 indices for physical
                layup, dunk, postup, midrange, threePt, freethrow, //7,8,9,10,11,12 indices for shooting
                passing, rebounding, steal, block, handling, basketballiq}; //13,14,15,16,17,18 indices for skills
    }

    /**
     * poor nomenclature returns 0-99 attributes of profile
     * @return  0-99 attributes of profile
     */
    public String getPlayer() {
        return ("Name: " + name + " Position: " + position + " Age: " + this.age + "\n" + "Experience: " + experience + " Draft Position: " + draftPos +
                " Height: " + height / 12 + "'" + (height - (height / 12) * 12) + "\"" + " Weight: " + weight +
                 "\n" + "PlayerValue: " + getPV() + "\n");
    }

    //old getPlayer with alg, pot, luck printed, supposed to be kept secret from client

    /**
     * super secret getPlayer()
     * @return secret!!
     */
    public String getPlayerSecret() {
        return ("Name: " + name + " Position: " + position + " Age: " + this.age + "\n" + "Experience: " + experience + " Draft Position: " + draftPos +
                " Height: " + height / 12 + "'" + (height - (height / 12) * 12) + "\"" + " Weight: " + weight +
                "\n" + "Luck: " + luck + "\n" + "Potential: " + potential + "\n" + "PlayerValue: " + getPV() + "\n" + "Alg: " + pV.getAlg());
    }

    /**
     * player name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * playing positino
     * @return position
     */
    public String getPos() {
        return position;
    }

    /**
     * poor nomenclature too
     * only for rookies and establishing truePick, cosmetic thing as initial playerValue is unchangeable
     * @param truePick
     */
    public void changePos(int truePick) { draftPos = truePick;}

    /**
     * player age
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * player experience
     * @return experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * player draft position
     * @return draft position
     */
    public int getDraftPos() {
        return draftPos;
    }

    //below two methods aren't used i'm pretty sure
    /**
     * player height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * player weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * this is used a lot
     * returns player value
     * @return player value
     */
    public int getPV() {
        return (int) pV.getPV();
    }

    /**
     * only called when year is incremented, thus experience is too
     * updates all the ratings according to incremental improvement/
     */
    public void updateProfile() {
        experience++;
        age++;
        pV.pVUpdate(experience);
        updateRatings();
    }

    /**
     * updates ratings dependent on age
     * increment or decrement
     * the many many assignments in each loop are just for consistency
     * arraylist of ratings is update by instance fields aren't without calling all 18 assignments
     */
    public void updateRatings() {
        for (int i = 0; i < getPlayerRatings().length; i++) {
            if (experience <= 5) {
                getPlayerRatings()[i] += alg;
                offense+=alg; defense+=alg; strength+=alg; speed+=alg; vertical+=alg; durability+=alg; emotion+=alg; //0,1,2,3,4,5,6 indices for physical
                        layup+=alg; dunk+=alg; postup+=alg; midrange+=alg; threePt+=alg; freethrow+=alg; //7,8,9,10,11,12 indices for shooting
                        passing+=alg; rebounding+=alg; steal+=alg; block+=alg; handling+=alg; basketballiq+=alg;
            }
            if (experience == 6) {
                if (luck * potential > .75) {
                    getPlayerRatings()[i] += 3 * alg;
                    for (int j =5; j > 0; j--) {
                        offense+=alg; defense+=alg; strength+=alg; speed+=alg; vertical+=alg; durability+=alg; emotion+=alg; //0,1,2,3,4,5,6 indices for physical
                        layup+=alg; dunk+=alg; postup+=alg; midrange+=alg; threePt+=alg; freethrow+=alg; //7,8,9,10,11,12 indices for shooting
                        passing+=alg; rebounding+=alg; steal+=alg; block+=alg; handling+=alg; basketballiq+=alg;
                    }
                }
                if (luck * potential > .6) {
                    getPlayerRatings()[i] += 2 * alg;
                    for (int j =2; j > 0; j--) {
                        offense+=alg; defense+=alg; strength+=alg; speed+=alg; vertical+=alg; durability+=alg; emotion+=alg; //0,1,2,3,4,5,6 indices for physical
                        layup+=alg; dunk+=alg; postup+=alg; midrange+=alg; threePt+=alg; freethrow+=alg; //7,8,9,10,11,12 indices for shooting
                        passing+=alg; rebounding+=alg; steal+=alg; block+=alg; handling+=alg; basketballiq+=alg;
                    }
                }
                if (luck * potential > .5) {
                    getPlayerRatings()[i] += alg;
                    offense+=alg; defense+=alg; strength+=alg; speed+=alg; vertical+=alg; durability+=alg; emotion+=alg; //0,1,2,3,4,5,6 indices for physical
                    layup+=alg; dunk+=alg; postup+=alg; midrange+=alg; threePt+=alg; freethrow+=alg; //7,8,9,10,11,12 indices for shooting
                    passing+=alg; rebounding+=alg; steal+=alg; block+=alg; handling+=alg; basketballiq+=alg;
                }
            }
            if (experience > 12) {
                getPlayerRatings()[i] += decrease;
                offense+=decrease; defense+=decrease; strength+=decrease; speed+=decrease; vertical+=decrease; durability+=decrease; emotion+=decrease; //0,1,2,3,4,5,6 indices for physical
                layup+=decrease; dunk+=decrease; postup+=decrease; midrange+=decrease; threePt+=decrease; freethrow+=decrease; //7,8,9,10,11,12 indices for shooting
                passing+=decrease; rebounding+=decrease; steal+=decrease; block+=decrease; handling+=decrease; basketballiq+=decrease;
            }
        }
        checkRatings();
    }

    /**
     * makes sure ratings can't be less than 1 or greater than 99
     */
    public void checkRatings() {
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] > 99) ratings[i] = 99;
            if (ratings[i] < 1) ratings[i] = 1;
        }
    }

    /**
     * tester method to print out history or player ratings
     * @return players' PlayerValue history
     */
    public ArrayList<Double> getPlayerValues() {
        return pV.getPlayerValues();
    }

    /**
     * i don't really know what this is for
     * @return presumably player ratings
     */
    public int[] getPlayerRatings() {
        return ratings;
    }


    /**
     * it says it's defunct so
     * @return print out ratings
     */
    public String printRatingsDefunct() {
        checkRatings();
        return ("Offense: " + ratings[0] + "\n" + "Defense: " + ratings[1] + "\n" + "Strength: " + ratings[2] + "\n" + "Speed: " + ratings[3]+ "\n"
                + "Vertical: " + ratings[4] + "\n" + "Durability: " + ratings[5]+ "\n" + "Emotion: " + ratings[6]
                + "\n" + "Layup: " + ratings[7] + "\n" + "Dunk: " + ratings[8] + "\n" + "Midrange: " + ratings[9] + "\n" + "Three Pt: " + ratings[10] + "\n"
                + "Postup: " + ratings[11] + "\n" + "Free Throw: " + ratings[12] + "\n" + "Passing: " + ratings[13] + "\n"
                + "Handling: " + ratings[14] + "\n" + "Rebounding: " + ratings[15] + "\n" + "Steal: " + ratings[16] + "\n" + "Block: " + ratings[17] + "\n" + "BBIQ: " + ratings[18]);
    }

    /**
     * printed ratings but properly formatted
     * @return player 0-99 ratings
     */
    public String printRatings() {
        checkRatings();
        return ("Offense: " + ratings[0] + "   Defense: " + ratings[1] +
                "\n" + "Strength: " + ratings[2] + "  Speed: " + ratings[3]+ "   Vertical: " + ratings[4] + "    Durability: " + ratings[5]+ " Emotion: " + ratings[6]
                + "\n" + "Layup: " + ratings[7] + "     Dunk: " + ratings[8] + "    Midrange: " + ratings[9] + "    Three Pt: " + ratings[10] + "   Postup: " + ratings[11] + "   Free Throw: " + ratings[12]
                + "\n" + "Passing: " + ratings[13] + "   Handle: " + ratings[14] + "  Rebounding: " + ratings[15] + "  Steal: " + ratings[16] + "      Block: " + ratings[17] + "    BBIQ: " + ratings[18]);
    }

    /**
     * assigns ratings for every player
     */
    public void ratings() {
        int pV = getPV();
        int VARIANT = 30;

        if (getPos().equals("PG") || getPos().equals("G")) {

            strength = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 20;

            speed = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 20;

            vertical = pV + (((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))));

            durability = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            emotion = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            layup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            dunk = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            postup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 20;

            midrange = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            threePt = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 20;

            freethrow = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            passing = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 25;

            rebounding = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 25;

            handling = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 25;

            steal = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            block = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 30;

            basketballiq = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            offense = (layup + dunk + postup + midrange + threePt + freethrow + passing + rebounding + handling + basketballiq) / 10;
            defense = (rebounding + steal + block + basketballiq + handling) / 5;
        }

        if (getPos().equals("SG") || getPos().equals("GF")) {

            strength = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            speed = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            vertical = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            durability = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            emotion = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            layup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            dunk = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            postup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            midrange = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            threePt = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 20;

            freethrow = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            passing = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            rebounding = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            handling = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 20;

            steal = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            block = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 20;

            basketballiq = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            offense = (layup + dunk + postup + midrange + threePt + freethrow + passing + rebounding + handling + basketballiq) / 10;
            defense = (rebounding + steal + block + basketballiq + handling) / 5;
        }

        if (getPos().equals("SF") || getPos().equals("F")) {

            strength = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            speed = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 5;

            vertical = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            durability = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            emotion = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            layup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            dunk = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            postup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            midrange = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            threePt = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            freethrow = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            passing = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 5;

            rebounding = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            handling = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 5;

            steal = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            block = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 5;

            basketballiq = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            offense = (layup + dunk + postup + midrange + threePt + freethrow + passing + rebounding + handling + basketballiq) / 10;
            defense = (rebounding + steal + block + basketballiq + handling) / 5;
        }

        if (getPos().equals("PF") || getPos().equals("FC")) {
            strength = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            speed = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            vertical = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            durability = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            emotion = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            layup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            dunk = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            postup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 20;

            midrange = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 5;

            threePt = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 5;

            freethrow = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            passing = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            rebounding = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            handling = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            steal = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 5;

            block = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 15;

            basketballiq = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            offense = (layup + dunk + postup + midrange + threePt + freethrow + passing + rebounding + handling + basketballiq) / 10;
            defense = (rebounding + steal + block + basketballiq + handling) / 5;
        }

        if (getPos().equals("C")) {

            strength = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 25;

            speed = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 25;

            vertical = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            durability = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            emotion = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            layup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            dunk = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 25;

            postup = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 10;

            midrange = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            threePt = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 30;

            freethrow = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 20;

            passing = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 15;

            rebounding = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 30;

            handling = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 25;

            steal = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) - 10;

            block = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT)))) + 30;

            basketballiq = pV + ((int) ((((VARIANT / 2) * ((1+luck)/1.5)) - (Math.random() * VARIANT))));

            offense = (layup + dunk + postup + midrange + threePt + freethrow + passing + rebounding + handling + basketballiq) / 10;
            defense = (rebounding + steal + block + basketballiq + handling) / 5;
        }
    }
}
