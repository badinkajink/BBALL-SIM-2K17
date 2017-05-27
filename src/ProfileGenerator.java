/**
 * Created by WilliamUSER on 5/20/2017.
 */

/**
 * Created by WilliamUSER on 5/20/2017.
 */

import java.util.ArrayList;
import java.util.Random;

public final class ProfileGenerator {

    // public PlayerProfile(String n, Position pos, int a, int e, int dp)
    private String name; //random name generator
    private String position; //randomized position picker
    private int age; //20-39
    private int experience; // 0-19
    private int draftPosition; //sstart in the draft of 2017. oldest possible draft is 1998. giant 2d int array, 19 rows, 60 columns int[19][60], roll random(60), experience determines which row to pick from, set cell to 0 once picked
    private int draftAge; //used to calculate age and experience

    // if rolled cell = 0, re roll
    private static int[][] draftPositions; //instantiated to new int[19][60], in each row iterate through so cells are 1 to 60
    //only meant for one time generation of players at beginning of sim
    //assuming start from draft of 2017 and going back to 1998

    //for new drafts post 2017
    private static int[] newDraftPositions;
    private static int pick;

    public ProfileGenerator(){
        setName();
        setDraftPosition();
        setAge();
        setExperience();
        setPosition();
    }

    public ProfileGenerator(int exp, int a) {
        experience = exp;
        age = a;
        setName();
        setPosition();
        setRookieDraftPosition();
    }

    public static void rookieDraftReset(){
        newDraftPositions = new int[60];
        pick = 0;
        int pos = 1;
        for (int i = 0; i < 60; i++) {
            newDraftPositions[i] = pos;
            pos++;
        }
    }

    public void setRookieDraftPosition(){
        int dPick = pick;
        draftPosition = newDraftPositions[dPick];
        newDraftPositions[dPick] = 0;
        pick++;
    }

    public void setName()
    {
        Random nameNumber = new Random();
        int nameN = nameNumber.nextInt(199);

        int first = (nameN/2);
        if (first < 10) first += 10;
        int last = nameN;
        if (last < 100) last +=100;
        ArrayList<String> firstNames = new ArrayList<String>();
        firstNames.add("Stephen" + first);
        //continues for 200 first names

        ArrayList<String> lastNames = new ArrayList <String>();
        lastNames.add("Young" + last);
        //continued for 200 last names

        //String name = firstNames.get(nameN) + " " + lastNames.get(nameN);
        name = firstNames.get(0) + " " + lastNames.get(0);
    }

    public void setPosition()
    {
        ArrayList<String> positionList = new ArrayList<String>();
        positionList.add(Position.PG);
        positionList.add(Position.SG);
        positionList.add(Position.SF);
        positionList.add(Position.PF);
        positionList.add(Position.C);
        positionList.add(Position.FC);
        positionList.add(Position.GF);
        positionList.add(Position.G);
        positionList.add(Position.F);

        Random positionPicker = new Random();
        position = positionList.get(positionPicker.nextInt(8));
    }

    public void setDraftPosition()
    {
        draftPositions = new int[19][60];
        for (int r = 0; r < 19; r++) {
            int i = 1;
            for (int c = 0; c < 60; c++){
                draftPositions[r][c] = i;
                i++;
            }

        }

        Random draftYear = new Random();
        Random draftPick = new Random();

        int dYear = draftYear.nextInt(18) + 1;
        int dPick = draftPick.nextInt(59) + 1;
        draftAge = dYear;
        //System.out.println(draftAge);

        while(draftPositions[dYear][dPick] == 0) {
            dYear = draftYear.nextInt(17) + 1;
            dPick = draftPick.nextInt(59) + 1;
        }

        draftPosition = draftPositions[dYear][dPick];
        draftPositions[dYear][dPick] = 0;
    }

    public void setAge()
    {
        age = 21 + draftAge;
    }

    public void setExperience()
    {
        experience = draftAge;
    }

    public String getName()
    {
        return name;
    }

    public String getPosition()
    {
        return position;
    }

    public int getDraftPosition()
    {
        return draftPosition;
    }


    public int getAge()
    {
        return age;
    }

    public int getExperience()
    {
        return experience;
    }
}


