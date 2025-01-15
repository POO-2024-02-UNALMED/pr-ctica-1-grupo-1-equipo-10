package gestorAplicaciones.servicio;

import java.util.*;

public class Plan {
    private final ArrayList<Integer> BASIC;
    private final ArrayList<Integer> STANDARD;
    private final ArrayList<Integer> PREMIUM;

    public Plan(ArrayList<Integer> BASIC, ArrayList<Integer> STANDARD, ArrayList<Integer> PREMIUM){
        this.BASIC = BASIC;
        this.STANDARD = STANDARD;
        this.PREMIUM = PREMIUM;
    }

    public ArrayList<Integer> getBASIC() {
        return BASIC;
    }
    public ArrayList<Integer> getSTANDARD() {
        return STANDARD;
    }
    public ArrayList<Integer> getPREMIUM() {
        return PREMIUM;
    }
}
