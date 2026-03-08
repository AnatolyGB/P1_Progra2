package prog2.model;

public class Bungalow extends Casa{    // Tipus de casa i per tant d'allotjament.
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
             int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {   // Constructor de Bungalow

        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 4, 7);  // El super crida al constructor de casa.
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
    }

    public int getPlacesParquing() { return placesParquing; }      // Getters i Setters.

    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    } // Comprova que el bungalow tingui un correcte funcionament (compleix la condició necessària).
}
