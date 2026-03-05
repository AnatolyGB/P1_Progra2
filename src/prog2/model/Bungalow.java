package prog2.model;

public class Bungalow extends Casa{
    private String nom;
    private String idAllotjament;
    private String mida;
    private int habitacions;
    private int placesPersones;
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
             int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 4, 7);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    @Override
    public String toString(){
        return super.toString() + ". Bungalow{ Places de Parquing = " + placesParquing + " Terrassa = " + terrassa +
                " TV = " + tv + " Aire fred = " + aireFred + "}";
    }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }
}
