/**
 * Created by WilliamUSER on 5/21/2017.
 * unused class, not enough time to implement
 * meant to be part of player contracts, to limit teams by money and contract times
 * @author WilliamUSER 5/23/17
 */
public class Contract {
    private double capHit;
    private int length;
    private int value;
    public Contract() {

    }

    public Contract(int l, int v) {
        length = l;
        value = v;
        capHit = (double) v / l;
    }

    public static boolean contractValue(Contract c, Player p){
        return false;
    }

    public static boolean contractValue(Contract c, Player p, Team t) {
        return false;
    }

    public double getCapHit() {
        return capHit;
    }

    public int getLength() {
        return length;
    }

    public int getValue() {
        return value;
    }

}
