package prog2.model;

public class BungalowPremium extends Allotjament{
    private String nom;
    String idAllotjament;
    String mida;
    int habitacions;
    int placesPersones;
    int placesParquing;
    boolean terrassa;
    boolean tv;
    boolean aireFred;
    boolean serveisExtra;
    String codiWifi;

    BungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                    boolean serveisExtra, String codiWifi){
        this.nom = nom_;
        this.idAllotjament = idAllotjament_;
        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.tv = tv;
        this.aireFred = aireFred;
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;

    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
