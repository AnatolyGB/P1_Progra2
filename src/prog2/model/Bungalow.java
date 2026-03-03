package prog2.model;

public class Bungalow extends Allotjament{
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

        this.nom = nom_;
        this.idAllotjament = idAllotjament_;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;

    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
